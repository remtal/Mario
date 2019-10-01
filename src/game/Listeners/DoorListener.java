package game.Listeners;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Levels.Game;
import game.Sprites.Mario;

/**
 * Listener for collision with a door.  When the player collides with a door,
 * if the current level is complete the game is advanced to the next level.
 */
public class DoorListener implements CollisionListener {
    private Game game;
    int level = 1;

    public DoorListener(Game game) {

        this.game = game;
    }
    /**
     * @param e Reported collision between Door and Player
     */
    @Override
    public void collide(CollisionEvent e) {

        Mario player = game.getPlayer();
        //boolean levelDone = game.isCurrentLevelCompleted();
        //System.out.println("Collision " +levelDone);
        if (e.getOtherBody() == player && game.isCurrentLevelCompleted()) {
            System.out.println("Going to next level...");
            game.goNextLevel();
        }
    }
}
