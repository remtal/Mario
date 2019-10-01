package game.Levels;

import city.cs.engine.Body;
import game.Listeners.Collision;
import game.Listeners.Pickup;
import game.Objects.Arrow;
import game.Objects.Egg;
import game.Objects.Platform;
import game.Objects.Token;
import game.Sprites.Mario;
import game.Sprites.Mushroom;
import org.jbox2d.common.Vec2;

import javax.swing.*;

/**
 * Level 3 of the game
 */
public class Level3 extends GameLevel {

    private Mushroom shroom;
    private Mario mario;
    private static final int NUM_TOKENS = 3;
    private Platform p1;
    private Platform p2;
    private Arrow arrow;
    private Platform p3;
    private Egg egg;
    private Platform p4;

    /*
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);


        shroom = new Mushroom(this);
        shroom.setPosition(new Vec2(-0, -7f));
        shroom.addCollisionListener(new Pickup(getPlayer()));

        p1 = new Platform(this);
        p1.setPosition(new Vec2(-4, 2));

        p3 = new Platform(this);
        p3.setPosition(new Vec2(-10, 5));

        p4 = new Platform(this);
        p4.setPosition(new Vec2(10, -4));

        arrow = new Arrow(this);
        arrow.setPosition(new Vec2(10, -3));
        arrow.addCollisionListener(new Pickup(getPlayer()));

        egg = new Egg(this);
        egg.setPosition(new Vec2(-10, 3));
        egg.addCollisionListener(new Collision(getPlayer()));


        for (int i = 0; i < 3; i++) {
            Body t = new Token(this);
            t.setPosition(new Vec2(i * 5 - 10, 10));
            t.addCollisionListener(new Pickup(getPlayer()));
        }
    }

    @Override
    public Vec2 startPosition() {

        return new Vec2(-9, -7);
    }

    @Override
    public Vec2 doorPosition() {

        return new Vec2(10f, -6.5f);
    }

    @Override
    public boolean isCompleted() {

        return getPlayer().getTokenCount() >= NUM_TOKENS;
    }

    @Override
    public ImageIcon levelBackground() {

        return new ImageIcon("data/level2.jpg");
    }
}