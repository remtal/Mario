package game.Objects;

import city.cs.engine.*;
import game.Levels.Game;


public class Egg extends StaticBody {


    private Game game;

    private static final Shape shape = new PolygonShape(-0.166f, 0.64f, -0.569f, 0.078f, -0.564f, -0.247f, -0.163f, -0.642f, 0.157f, -0.642f, 0.565f, -0.239f, 0.565f, 0.081f, 0.164f, 0.642f
    );

    private static final BodyImage image
            = new BodyImage("data/yoshiegg.png", 1.3f);


    public Egg(World world) {
        super(world, shape);
        addImage(image);


    }


}
