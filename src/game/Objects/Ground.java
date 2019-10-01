package game.Objects;

import city.cs.engine.*;

/**
 * The ground of the game, called in GameLevel as it is present in each Level
 */
public class Ground extends StaticBody {

    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance.
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            -14.56f, 2.22f, -14.61f, -2.29f, 11.11f, -2.35f, 11.17f, 2.22f


    );

    private static final BodyImage image =
            new BodyImage("data/grass.png", 15.5f);
    /**
     * Constructor for Ground
     */
    public Ground(World world) {
        super(world, shape);
        addImage(image);

    }

}