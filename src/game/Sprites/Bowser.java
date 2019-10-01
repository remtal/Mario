/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Sprites;

import city.cs.engine.Shape;
import city.cs.engine.*;
import game.Listeners.Pickup;
import game.Objects.Bullet;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author tsami
 */

public class Bowser extends Walker implements SensorListener {

    private static final Shape shape = new PolygonShape(-0.3f, 1.4f, -1.3f, 1.16f, -1.16f, -1.31f, 1.03f, -1.48f, 1.27f, 0.26f, 0.53f, 1.36f);
    private static BodyImage image = new BodyImage("data/bowser.gif", 3.0f);
    private Mario mario;
    private Timer timer;
    private World world;
    private Bullet bullet;
    private Vec2 bulletSpeed = new Vec2(15, 0);
    private Sensor sensor;
    private Shape sensorShape;
    private static int bossHealth = 5;

    public Bowser(World world, Mario mario) {
        super(world, shape);
        this.world = world;
        this.mario = mario;

        addImage(image);
        sensorShape = new BoxShape(15, 15);
        sensor = new Sensor(this, sensorShape);
        sensor.addSensorListener(this);


    }

    public void shoot() {
        bullet = new Bullet(world, 0.1f, 0.1f);
        bullet.setBullet(true);
        bullet.setFillColor(Color.RED);
        bullet.setPosition(new Vec2(getPosition().x - 0.5f, getPosition().y));
        bullet.setLinearVelocity(new Vec2(-bulletSpeed.x, bulletSpeed.y));
        bullet.setGravityScale(0);
        Pickup pickup = new Pickup(mario);
        bullet.addCollisionListener(pickup);
    }

    /**
     * Implement SensorListener so Bowser begins shooting once Mario is within the Sensors range.
     */
    @Override
    public void beginContact(SensorEvent e) {
        if (e.getContactBody() == mario) {
            System.out.println("Contact");

            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    shoot();

                }
            }, 1200, 1200);
        }
    }

    @Override
    public void endContact(SensorEvent e) {
        if (e.getContactBody() == mario) {
            try {
                timer.cancel();
                System.out.println(e.getContactBody());
            } catch (NullPointerException npe) {
            }
        }
    }

    /**
     * Cancel the Timer once Bowser is destroyed
     */
    @Override
    public void destroy() {
        super.destroy();
        timer.cancel();
    }
}
