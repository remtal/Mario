package game.Sprites;

import city.cs.engine.*;

/**
 * Simple character
 */
public class Mario extends Walker {

    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance.
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            -0.07f, 0.85f, -0.65f, 0.68f, -0.64f, -1.47f,
            0.73f, -1.48f, 0.76f, -0.45f, 0.73f, 0.36f, 0.46f, 0.86f, 0.1f, 0.88f

    );


    /**
     * Multple different Images of Mario which are called in the Controller class
     */

    public static BodyImage marioRight =
            new BodyImage("data/marioRight.gif", 3.0f);

    public static BodyImage marioLeft =
            new BodyImage("data/marioLeft.gif", 3.0f);

    public static BodyImage marioRights =
            new BodyImage("data/marioRights.png", 3.0f);

    public static BodyImage marioLefts =
            new BodyImage("data/marioLefts.png", 3.0f);

    private static int tokenCount;
    private static int liveCount = 5;
    private int gravityScale = 0;
    private static int eggCount;
    private static int bossHealth = 5;
    private Bowser bowser;

    /**
     *  Constructor for Mario class
     */

    public Mario(World world) {
        super(world, shape);
        addImage(marioRight);
        tokenCount = 0;

    }
    /**
     * Returns tokenCount
     */

    public int getTokenCount() {

        return tokenCount;
    }

    /**
     * Returns GravityScale
     */
    public int setGravityScale() {

        return gravityScale;
    }

    /**
     * Increments Token Count
     */
    public void incrementTokenCount() {
        tokenCount = tokenCount + 1;
        System.out.println("Nice! Points: " + tokenCount);
    }

    public int getLiveCount() {

        return liveCount;
    }

    public int getEggCount() {
        return eggCount;
    }

    public int setEggCount() {
        return eggCount;
    }

    public int setLiveCount(int liveCount) {
        return Mario.liveCount;
    }

    public int setTokenCount(int tokenCount) {
        return Mario.tokenCount;
    }


    /**
     * Decrements the Live Count of Mario, additionally features an if Statement so the game is
     * programmed to close upon lose of all Mario's lives.
     */
    public void decrementLiveCount() {
        liveCount--;
        System.out.println("Number of lives remaining: " + liveCount);
        if (liveCount == 0) {
            System.out.println("Game Over!");
            System.exit(1);
        }
    }

    public void doubleDecrementLC() {
        liveCount = liveCount - 2;
    }

    public void incrementLiveCount() {
        liveCount++;
        System.out.println("Number of live remaining: " + liveCount);
    }

    public void incrementEggCount() {
        eggCount++;
        System.out.println("eggCount " + eggCount);
    }

    public int getBossHealth() {
        return bossHealth;
    }

    public void decrementBossHealth() {
        bossHealth--;

    }

}
