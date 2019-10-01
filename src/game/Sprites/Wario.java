/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Sprites;


import city.cs.engine.*;
import game.Levels.Game;
import game.Listeners.Pickup;
import game.Objects.Fireball;
import org.jbox2d.common.Vec2;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author tsami
 */

public class Wario extends StaticBody implements SensorListener {


    private final Mario mario;
    private World world;
    private Fireball fireball;
    private Timer timer;
    private Game game;
    private Sensor sensor;
    private Shape sensorShape;
    private static final Shape shape = new PolygonShape(-0.225f, 0.86f, -0.601f, 0.528f, -0.625f, -0.732f, 0.551f, -0.724f, 0.647f, 0.428f, 0.459f, 0.784f);
    private static final BodyImage image
            = new BodyImage("data/wario.png", 3.0f);


    public Wario(World world, Mario mario) {
        super(world, shape);
        addImage(image);
        this.mario = mario;
        this.world = world;
        sensorShape = new BoxShape(100f, 100f);
        sensor = new Sensor(this, sensorShape);
        sensor.addSensorListener(this);
    }

    /**
     * Method called to create new Fireballs in a certain interval
     */


    public void shootFireball() {
        fireball = new Fireball(world, 0.2f, 0.2f);
        fireball.setBullet(true);
        fireball.setPosition(new Vec2(getPosition().x + 0.5f, getPosition().y));
        fireball.setLinearVelocity(new Vec2(10, 0));
        fireball.setGravityScale(0);
        Pickup pickup = new Pickup(mario);
        fireball.addCollisionListener(pickup);
    }

    /**
     * Sensor Listener calls shoot method once Mario is within Sensor range
     */

    @Override
    public void beginContact(SensorEvent e) {
        if (e.getContactBody() == mario) {
            System.out.println("Contact");

            timer = new Timer();
            timer.schedule(new TimerTask() {
                               @Override
                               public void run() {
                                   shootFireball();

                               }
                           },
                    1200, 1200);
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
     * Timer is stopped once Wario is destroyed
     */
    @Override
    public void destroy() {
        super.destroy();
        timer.cancel();
    }
}


//    public void makeFireball(){
//        Body fireball = new Fireball(getWorld());
//        fireball.setPosition(new Vec2(-7,-2));
//        Pickup pickup = new Pickup(mario);
//        pickup.setWario(this);
//        fireball.addCollisionListener(pickup);
//        ((Fireball) fireball).setGravityScale(0);
//
//        }
//        }







