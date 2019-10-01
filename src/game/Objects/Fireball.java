/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Objects;

import city.cs.engine.*;

import java.util.Timer;
import java.util.TimerTask;

public class Fireball extends Walker {

    private Timer timer;
    private static final float radius = 0.5f;
    private static final Shape ballShape = new CircleShape(radius);
    private static final BodyImage ballImage = new BodyImage("data/fireball.png");

    public Fireball(World world, float shapeX, float shapeY) {
        super(world, ballShape);
        addImage(ballImage);
        setBullet(true);
        /**
         Fireball is set on a Timer so is set to destroy after a certain Time
         */
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    Fireball.this.destroy();
                } catch (NullPointerException npe) {
                }
            }
        }, 1200, 1200);
    }
}

