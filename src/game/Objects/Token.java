package game.Objects;

import city.cs.engine.*;
import game.Levels.Game;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


public class Token extends Walker {

    public static SoundClip tokenSound;
    private Game game;

    /**
     Sound is played upon Mario colliding with Tokens
     */

    static {
        try {
            tokenSound = new SoundClip("data/coinSound.wav");

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {

        }
    }

    private static final Shape shape = new PolygonShape(0.0f, 0.498f, -0.36f, 0.442f, -0.386f, -0.314f, -0.128f, -0.494f,
            0.242f, -0.49f, 0.412f, -0.194f, 0.38f, 0.44f, 0.16f, 0.488f
    );

    private static final BodyImage image
            = new BodyImage("data/token.png", 1.0f);

    /**
     * Constructor for Token
     */
    public Token(World world) {
        super(world, shape);
        addImage(image);


    }


}
