package game.Setup;

import city.cs.engine.Walker;
import game.Sprites.Mario;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Key handler to control an Walker.
 */
public class Controller extends KeyAdapter {
    private static final float JUMPING_SPEED = 22;
    private static final float WALKING_SPEED = 4;

    private Walker body;

    public Controller(Walker body) {

        this.body = body;
    }

    /**
     * Handle key press events for walking and jumping.
     *
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_W) { // W = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
            }


        } else if (code == KeyEvent.VK_A) {
            body.startWalking(-WALKING_SPEED);
            body.removeAllImages();
            body.addImage(Mario.marioLeft);// A = walk left
        } else if (code == KeyEvent.VK_D) {

            body.startWalking(WALKING_SPEED);
            body.removeAllImages();
            body.addImage(Mario.marioRight); // D = walk right
        }
    }


    /**
     * Handle key release events (stop walking).
     *
     * @param e description of the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            body.stopWalking();
            body.removeAllImages();
            body.addImage(Mario.marioLefts);
        } else if (code == KeyEvent.VK_D) {
            body.stopWalking();
            body.removeAllImages();
            body.addImage(Mario.marioRights);
        }

    }

    public void setBody(Walker body) {
        this.body = body;

    }
}
