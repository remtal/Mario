package game.Levels;

import city.cs.engine.World;
import game.Listeners.DoorListener;
import game.Objects.Door;
import game.Objects.Ground;
import game.Objects.LeftWall;
import game.Sprites.Goomba;
import game.Sprites.Mario;
import game.Sprites.Mushroom;
import game.Sprites.Wario;
import org.jbox2d.common.Vec2;

import javax.swing.*;

/**
 * @author tsami
 */

/**
 * A world with some bodies.
 */
public abstract class GameLevel extends World {

    private Mario mario;
    private Goomba g;
    private Ground ground;
    private Mushroom shroom;
    private Game game;
    private Wario wario;
    private Goomba goomba;
    LeftWall leftWall;


    public Mario getPlayer() {

        return mario;
    }

    /**
     Populate method called in each Level
     @param game The game GameLevel is populating
     */
    public void populate(Game game) {

        this.game = game;
        mario = new Mario(this);
        mario.setPosition(startPosition());
        mario.setGravityScale(5);

        ground = new Ground(this);
        ground.setPosition(new Vec2(1.58f, -10.f));


        Door door = new Door(this);
        door.setPosition(doorPosition());
        door.addCollisionListener(new DoorListener(game));

    }

    public LeftWall leftWall() {
        return leftWall();
    }

    /** The initial position of the player. */
    public abstract Vec2 startPosition();

    /** The position of the exit door. */
    public abstract Vec2 doorPosition();

    /** Is this level complete? */
    public abstract boolean isCompleted();

    /**
     The background of the level
     */
    public abstract ImageIcon levelBackground();

}
