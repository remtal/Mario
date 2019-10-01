package game.Listeners;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Objects.Egg;
import game.Objects.ShroomPlatform;
import game.Sprites.Bowser;
import game.Sprites.Mario;
import game.Sprites.Spike;
import game.Sprites.Wario;

/**
 * Collision listener that allows mario to collect things.
 */
public class Collision implements CollisionListener {
    private Mario mario;
    private Wario wario;
    private Bowser bowser;


    public Collision(Mario mario) {

        this.mario = mario;
    }

    /**
     * Collision class
     * @param e A reported collision
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getReportingBody() instanceof ShroomPlatform && e.getOtherBody() == mario) {
            ShroomPlatform.jumpSound.play();
            mario.jump(40);
        } else if (e.getReportingBody() instanceof Egg && e.getOtherBody() == mario) {
            e.getReportingBody().destroy();
            mario.incrementEggCount();
        } else if (e.getReportingBody() instanceof Spike && e.getOtherBody() == mario) {
            mario.doubleDecrementLC();
            e.getReportingBody().destroy();
        } else if (e.getReportingBody() instanceof Wario && e.getOtherBody() == mario) {
            e.getReportingBody().destroy();
        }
    }
}