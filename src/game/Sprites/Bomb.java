/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Sprites;

import city.cs.engine.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author tsami
 */

public class Bomb extends Walker implements StepListener {

    private Fixture bombFixture;
    private Timer timer;
    private World world;

    //private static final Shape x = new PolygonShape(-0.18f,0.313f, -0.343f,0.123f, -0.249f,-0.22f, 0.173f,-0.244f, 0.367f,0.064f, 0.197f,0.24f, 0.062f,0.306f);
    private static final Shape shape = new PolygonShape(-0.12f, 0.996f, -0.944f, 0.968f, -0.996f, -0.268f, -0.832f, -0.992f, 0.56f, -0.984f, 1.0f, -0.436f, 1.0f, 0.452f, 0.332f, 0.96f);
    private static final BodyImage image
            = new BodyImage("data/bomb.gif", 2.0f);
    private static float G1WALKING_SPEED = -4;


    public Bomb(World world) {
        super(world, shape);
        addImage(image);
        this.startWalking(G1WALKING_SPEED);
        world.addStepListener(this);
        /**
         Timer for the Bomb set to explode after Contact
         */
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //addImage(explosion);
                destroy();
            }
        });

    }

    public void startTimer() {
        timer.start();
    }

    /**
     * Bomb moves between designated Coords
     */
    @Override
    public void preStep(StepEvent stepEvent) {
        if (this.getPosition().x > 1.3f) {

            G1WALKING_SPEED = -4;
            this.startWalking(G1WALKING_SPEED);
        } else if (this.getPosition().x < -5.3f) {
            G1WALKING_SPEED = 4;
            this.startWalking((G1WALKING_SPEED));
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }


}


 