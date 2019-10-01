package game.Levels;

import city.cs.engine.Body;
import game.Listeners.Collision;
import game.Listeners.Pickup;
import game.Objects.*;
import game.Sprites.Goomba;
import org.jbox2d.common.Vec2;

import javax.swing.*;

/**
 * Level 1 of the game
 */
public class Level1 extends GameLevel {

    private static final int NUM_TOKENS = 4;
    private Goomba g;
    private Platform p1;
    private Platform p2;
    private Platform p3;
    private Platform p4;
    private Block block;
    private Egg egg;
    private ShroomPlatform sP;


    @Override
    public void populate(Game game) {
        super.populate(game);
        g = new Goomba(this);
        g.setPosition(new Vec2(0, -10));
        g.addCollisionListener(new Pickup(getPlayer()));


        p1 = new Platform(this);
        p1.setPosition(new Vec2(3, 2));


        p2 = new Platform(this);
        p2.setPosition(new Vec2(10, 6));

        p3 = new Platform(this);
        p3.setPosition(new Vec2(-4, -3));

        p4 = new Platform(this);
        p4.setPosition(new Vec2(9, -4));

        block = new Block(this, getPlayer());
        block.setPosition(new Vec2(-4, 3));
        Pickup pickup = new Pickup(getPlayer());
        pickup.setBlock(block);
        block.addCollisionListener(pickup);

        egg = new Egg(this);
        egg.setPosition(new Vec2(2, 7));
        egg.addCollisionListener(new Collision(getPlayer()));

        for (int i = 0; i < 3; i++) {
            Body t = new Token(this);
            t.setPosition(new Vec2(i * 8 - 8, 0));
            t.addCollisionListener(new Pickup(getPlayer()));
        }

    }


    @Override
    public Vec2 startPosition() {

        return new Vec2(-9, -8);
    }

    @Override
    public Vec2 doorPosition() {

        return new Vec2(11.5f, 8f);
    }

    @Override
    public boolean isCompleted() {

        return getPlayer().getTokenCount() >= NUM_TOKENS;
    }

    @Override
    public ImageIcon levelBackground() {
        return new ImageIcon("data/background.png");
    }
}



