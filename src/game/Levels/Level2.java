package game.Levels;


import city.cs.engine.Body;
import game.Listeners.Collision;
import game.Listeners.Pickup;
import game.Objects.Egg;
import game.Objects.Platform;
import game.Objects.ShroomPlatform;
import game.Objects.Token;
import game.Sprites.Bomb;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

/**
 * Level 2 of the game
 */
public class Level2 extends GameLevel {

    private static final int NUM_TOKENS = 5;
    private Image image;
    private Bomb bomb;
    private Bomb bomb2;
    private Platform p1;
    private Platform p2;
    private Platform p3;
    private Platform p4;
    private Platform p5;
    private ShroomPlatform sP;
    private Egg egg;
    private Egg egg2;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);
        bomb = new Bomb(this);
        bomb.setPosition(new Vec2(1.5f, -8f));
        bomb.addCollisionListener(new Pickup(getPlayer()));

        p1 = new Platform(this);
        p1.setPosition(new Vec2(-9.9f, 7));


        p2 = new Platform(this);
        p2.setPosition(new Vec2(-2, 3));

        p3 = new Platform(this);
        p3.setPosition(new Vec2(-8, -4));

        egg2 = new Egg(this);
        egg2.setPosition(new Vec2(-2.1f, -2));
        egg2.addCollisionListener(new Collision(getPlayer()));

        sP = new ShroomPlatform(this);
        sP.setPosition(new Vec2(7, -8.5f));
        sP.addCollisionListener(new Collision(getPlayer()));

        egg = new Egg(this);
        egg.setPosition(new Vec2(8, 8));
        egg.addCollisionListener(new Collision(getPlayer()));


        for (int i = 0; i < NUM_TOKENS; i++) {
            Body orange = new Token(this);
            orange.setPosition(new Vec2(i * 2 - 10, 10));
            orange.addCollisionListener(new Pickup(getPlayer()));
        }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(-9, -8);
    }

    @Override
    public Vec2 doorPosition() {

        return new Vec2(-11.7f, 8.85f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getTokenCount() == NUM_TOKENS;

    }

    @Override
    public ImageIcon levelBackground() {

        return new ImageIcon("data/level1.png");
    }

}
