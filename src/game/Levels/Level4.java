package game.Levels;

import city.cs.engine.Body;
import game.Listeners.Collision;
import game.Listeners.Pickup;
import game.Objects.Block;
import game.Objects.Egg;
import game.Objects.Platform;
import game.Objects.Token;
import game.Sprites.Goomba;
import game.Sprites.Wario;
import org.jbox2d.common.Vec2;

import javax.swing.*;

/**
 * Level 4 of the game
 */
public class Level4 extends GameLevel {

    private static final int NUM_TOKENS = 3;
    private Wario w;
    private Platform p1;
    private Platform p2;
    private Platform p3;
    private Goomba g;
    private Platform p4;
    private Block block;
    private Egg egg;

    @Override
    public void populate(Game game) {
        super.populate(game);

        w = new Wario(this, getPlayer());
        w.setPosition(new Vec2(-6.2f, -1.4f));
        w.addCollisionListener(new Pickup(getPlayer()));
        w.addCollisionListener(new Collision(getPlayer()));


        p1 = new Platform(this);
        p1.setPosition(new Vec2(-9.9f, 7));

        p2 = new Platform(this);
        p2.setPosition(new Vec2(10, -2));

        p3 = new Platform(this);
        p3.setPosition(new Vec2(-8f, -3));

        p4 = new Platform(this);
        p4.setPosition(new Vec2(3, 3));

        p4 = new Platform(this);
        p4.setPosition(new Vec2(-4, 4));

        g = new Goomba(this);
        g.setPosition(new Vec2(0, -8));
        g.addCollisionListener(new Pickup(getPlayer()));

        egg = new Egg(this);
        egg.setPosition(new Vec2(10, 1));
        egg.addCollisionListener(new Collision(getPlayer()));

        block = new Block(this, getPlayer());
        block.setPosition(new Vec2(-8, 1));
        Pickup pickup = new Pickup(getPlayer());
        pickup.setBlock(block);
        block.addCollisionListener(pickup);


//        for (int i = 0; i < 1; i++) {
//            Body fireball = new Fireball(this);
//            fireball.setPosition(new Vec2(-7,-2));
//            Pickup p = new Pickup(getPlayer());
//            p.setWario(w);
//
//            fireball.addCollisionListener(p);
//            ((Fireball) fireball).setGravityScale(0);
//        }


        for (int i = 0; i < 2; i++) {
            Body t = new Token(this);
            t.setPosition(new Vec2(i * 4 - 1, 0));
            t.addCollisionListener(new Pickup(getPlayer()));
        }
    }

    @Override
    public Vec2 startPosition() {

        return new Vec2(9, -8);
    }

    @Override
    public Vec2 doorPosition() {

        return new Vec2(-11f, 9);
    }

    @Override
    public boolean isCompleted() {

        return getPlayer().getTokenCount() >= NUM_TOKENS;
    }

    @Override
    public ImageIcon levelBackground() {

        return new ImageIcon("data/background3.png");
    }
}



