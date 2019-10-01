package game.Levels;

import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import game.Listeners.Collision;
import game.Listeners.Pickup;
import game.Objects.BossHealth;
import game.Objects.LeftWall;
import game.Sprites.Bowser;
import game.Sprites.Peach;
import game.Sprites.Spike;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

/**
 * Level 5 of the game
 */
public class Level5 extends GameLevel {

    private static final int NUM_TOKENS = 4;
    private Bowser bowser;
    private Peach peach;
    private BossHealth bossHealth;


    @Override
    public void populate(Game game) {
        super.populate(game);
        peach = new Peach(this);
        peach.setPosition(new Vec2(10, -6.7f));
        peach.addCollisionListener(new Pickup(getPlayer()));

        bowser = new Bowser(this, getPlayer());
        bowser.setPosition(new Vec2(11, 4));
        bowser.addCollisionListener(new Pickup(getPlayer()));

        Spike spike = new Spike(this, game);
        spike.setPosition(new Vec2(-4, -1));
        spike.addCollisionListener(new Collision(getPlayer()));

        bossHealth = new BossHealth(this);
        bossHealth.setPosition(new Vec2(-11.5f, 8));

        Shape shape = new BoxShape(3.2f, 0.2f);
        Body leftWallShape = new StaticBody(this, shape);
        leftWallShape.setFillColor(Color.blue);
        leftWallShape.setPosition(new Vec2(11, -4.2f));

        leftWall = new LeftWall(this);
        leftWall.setFillColor(Color.blue);
        leftWall.setPosition(new Vec2(8, -6.2f));
        leftWall.addCollisionListener(new Pickup(getPlayer(), leftWall));

        Shape shortPlatform = new BoxShape(2, 0.3f);
        Body platform1 = new StaticBody(this, shortPlatform);
        platform1.setFillColor(Color.RED);
        platform1.setPosition(new Vec2(-3, -3));

        Shape longPlatform = new BoxShape(8, 0.3f);
        Body platform2 = new StaticBody(this, longPlatform);
        platform2.setFillColor(Color.red);
        platform2.setPosition(new Vec2(9, 3));

        Shape verticalPlatform = new BoxShape(0.3f, 2);
        Body verticalPlatform1 = new StaticBody(this, verticalPlatform);
        verticalPlatform1.setFillColor(Color.red);
        verticalPlatform1.setPosition(new Vec2(12.2f, 5.3f));

        Shape topPlatform = new BoxShape(1, 0.3f);
        Body topPlatform1 = new StaticBody(this, topPlatform);
        topPlatform1.setFillColor(Color.RED);
        topPlatform1.setPosition(new Vec2(11f, 7));


    }


    @Override
    public Vec2 startPosition() {

        return new Vec2(-9, -8);
    }

    @Override
    public Vec2 doorPosition() {

        return new Vec2(100f, 100f);
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



