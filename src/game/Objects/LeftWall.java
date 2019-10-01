package game.Objects;

import city.cs.engine.*;

public class LeftWall extends StaticBody {
    private LeftWall leftWall;
    private SolidFixture fixture;
    private static final Shape shape = new BoxShape(0.2f, 2.0f);
    /**
     * Constructor
     */
    public LeftWall(World world) {
        super(world);
        fixture = new SolidFixture(this, shape);

    }

    public void setFixture() {
        fixture.destroy();

    }
}
