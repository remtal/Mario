/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Sprites;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * @author tsami
 */

public class Mushroom extends Walker implements StepListener {

    public static SoundClip healthSound;

    static {
        try {
            healthSound = new SoundClip("data/health.wav");

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {

        }
    }


    private static final Shape shape = new PolygonShape(-0.168f, 0.772f, -0.868f, 0.392f,
            -0.808f, -0.956f, 0.548f, -0.972f, 0.944f, -0.252f, 0.724f, 0.38f, 0.168f, 0.736f);

    private static final BodyImage image
            = new BodyImage("data/shroom.png", 2.0f);

    private static float G1WALKING_SPEED = 4;


    public Mushroom(World world) {
        super(world, shape);
        addImage(image);
        this.startWalking(G1WALKING_SPEED);
        world.addStepListener(this);

    }

    /**
     * Step Listener used to make Mushroom move between two X coordinates
     */


    @Override
    public void preStep(StepEvent stepEvent) {

        if (this.getPosition().x > 2.3) {

            G1WALKING_SPEED = -4;
            this.startWalking(G1WALKING_SPEED);
        } else if (this.getPosition().x < -2.3) {
            G1WALKING_SPEED = 4;
            this.startWalking((G1WALKING_SPEED));
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
 