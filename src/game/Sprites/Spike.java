package game.Sprites;

import city.cs.engine.*;
import game.Levels.Game;
import org.jbox2d.common.Vec2;

public class Spike extends DynamicBody implements StepListener {
    private static final float radius = 1.0f;
    private static final Shape ballShape = new CircleShape(radius);
    private static final BodyImage ballImage =
            new BodyImage("data/spike.png", 2 * radius);

    /**
     * Different states that the SpikeBall exists in
     */

    private enum State {
        ROLL_LEFT, ROLL_RIGHT, STAND_STILL
    }

    private static final float RANGE = 100;
    private Game game;
    private State state;

    public Spike(World world, Game game) {
        super(world, ballShape);
        this.game = game;
        addImage(ballImage);
        state = State.STAND_STILL;
        getWorld().addStepListener(this);
    }

    /**
     * Step Listener listens for Position of player
     */

    public boolean inRangeLeft() {
        Body a = game.getPlayer();
        float gap = getPosition().x - a.getPosition().x;
        return gap < RANGE && gap > 0;
    }

    public boolean inRangeRight() {
        Body a = game.getPlayer();
        float gap = getPosition().x - a.getPosition().x;
        return gap > -RANGE && gap < 0;
    }

    // update state
    public void preStep(StepEvent e) {
        if (inRangeRight()) {
            if (state != State.ROLL_RIGHT) {
                state = State.ROLL_RIGHT;
            }
        } else if (inRangeLeft()) {
            if (state != State.ROLL_LEFT) {
                state = State.ROLL_LEFT;
            }
        } else {
            if (state != State.STAND_STILL) {
                state = State.STAND_STILL;
                setAngularVelocity(0);
                setLinearVelocity(new Vec2(0, 0));
            }
        }
        refreshRoll();
    }

    // use this to prevent the balls from slowing
    // down and stopping due to friction when they
    // should be rolling
    private void refreshRoll() {
        switch (state) {
            case ROLL_LEFT:
                setAngularVelocity(5);
                break;
            case ROLL_RIGHT:
                setAngularVelocity(-5);
                break;
            default: // nothing to do
        }
    }

    public void postStep(StepEvent e) {
    }

}
