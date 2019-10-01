/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Objects;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


public class ShroomPlatform extends StaticBody {
    private static final BodyImage image = new BodyImage("data/platformMushroom.png", 3f);
    public static SoundClip jumpSound;
    private static final Shape shape = new PolygonShape(
            -1.47f, 0.5f, -0.44f, -1.49f, 0.44f, -1.48f, 1.47f, 0.62f, 1.48f, 1.1f, 1.0f, 1.48f, -1.01f, 1.48f, -1.42f, 1.24f);

    /**
     Sound is played upon the Player colliding with the Platform
     */

    static {
        try {
            jumpSound = new SoundClip("data/jump.wav");

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {

        }
    }

    public ShroomPlatform(World world) {
        super(world, shape);
        addImage(image);
    }


}
