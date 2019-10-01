package game.Listeners;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Objects.*;
import game.Sprites.*;

/**
 * Collision listener that allows  mario to collect things.
 */
public class Pickup implements CollisionListener {
    private Mario mario;
    private Wario wario;
    private Block block;
    private Bowser bowser;
    private boolean boxCollision = true;
    private LeftWall leftWall;


    public Pickup(Mario mario) {

        this.mario = mario;


    }

    public Pickup(Mario mario, LeftWall leftWall) {

        this.mario = mario;
        this.leftWall = leftWall;
    }


    public void setBowser(Bowser bowser) {
        this.bowser = bowser;

    }

    public void setBlock(Block block) {

        this.block = block;
    }

    public void setLeftWall(LeftWall leftWall) {
        this.leftWall = leftWall;
    }

    @Override

    /**
     Class dealing with Pickups
     @param e Reported collision between objects and Mario
     */


    public void collide(CollisionEvent e) {

        if (e.getReportingBody() instanceof Token && e.getOtherBody() == mario) {
            mario.incrementTokenCount();
            Token.tokenSound.play();
            e.getReportingBody().destroy();

        } else if (e.getReportingBody() instanceof Goomba && e.getOtherBody() == mario) {
            mario.decrementLiveCount();

        } else if (e.getReportingBody() instanceof Mushroom && e.getOtherBody() == mario) {
            mario.incrementLiveCount();
            Mushroom.healthSound.play();
            e.getReportingBody().destroy();
        } else if (e.getReportingBody() instanceof Bomb && e.getOtherBody() == mario) {
            mario.decrementLiveCount();
            ((Bomb) e.getReportingBody()).startTimer();


        } else if (e.getReportingBody() instanceof Fireball && e.getOtherBody() == mario) {
            mario.decrementLiveCount();
            e.getReportingBody().destroy();

        } else if (e.getReportingBody() instanceof Bowser && e.getOtherBody() == mario) {
            mario.decrementBossHealth();
            if (mario.getBossHealth() == 0) {
                e.getReportingBody().destroy();

            }
        } else if (e.getReportingBody() instanceof Bullet && e.getOtherBody() == mario) {
            mario.decrementLiveCount();
        } else if (e.getReportingBody() instanceof Arrow && e.getOtherBody() == mario) {
            mario.setGravityScale(3);
            e.getReportingBody().destroy();
        }
        if (leftWall != null) {
            if (mario.getBossHealth() == 0) {
                leftWall.destroy();

            }
        } else if ((e.getReportingBody() instanceof Peach && e.getOtherBody() == mario) && (mario.getEggCount() == 5)) {
            System.exit(1);
        } else if ((e.getReportingBody() instanceof Block) && (e.getOtherBody() == mario) && (boxCollision == true)) {
            if (mario.getPosition().y < block.getPosition().y) {
                block.makeToken();
                block.createNewImage();
                boxCollision = false;
            }

        }

    }
}
