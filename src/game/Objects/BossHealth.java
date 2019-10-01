package game.Objects;

import city.cs.engine.*;


public class BossHealth extends StaticBody {


    private static final Shape shape = new PolygonShape(0.013f, 0.98f, -0.755f, 0.788f, -0.863f, -0.1f, -0.355f, -0.98f, 0.389f, -0.972f, 0.857f, -0.088f, 0.717f, 0.804f);

    private static final BodyImage image
            = new BodyImage("data/bowserhealth.png", 1.5f);


    public BossHealth(World world) {
        super(world, shape);
        addImage(image);


    }


}
