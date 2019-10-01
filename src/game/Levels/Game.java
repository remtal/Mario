package game.Levels;

import city.cs.engine.SoundClip;
import game.Setup.ControlPanel;
import game.Setup.Controller;
import game.Setup.GiveFocus;
import game.Setup.MyView;
import game.Sprites.Mario;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


/**
 * The computer game.
 */
public class Game {

    private static int level;
    private GameLevel world;
    private MyView view;
    private Controller controller;
    private JFrame nameFrame;
    private JFrame mainFrame;

    private SoundClip gameMusic;

    public Game() {


        /**
         * Implementing background Music which plays on a loop for the entirety of the game
         */
        try {
            gameMusic = new SoundClip("data/opening.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }


        /**
         Populates the level opened first
         */
        level = 1;
        world = new Level1();
        world.populate(this);

        view = new MyView(world, getPlayer(), 500, 500, this);
        MyView.background = world.levelBackground().getImage();

        // make a view
        // uncomment this to draw a 1-metre grid over the view
        //view.setGridResolution(1);

        // display the view in a frame
        JFrame frame = new JFrame("Mario");
        /**
         * Adds buttons in the same layout created in the ControlPanel form
         */
        Container buttons = new ControlPanel(this);
        frame.add(((ControlPanel) buttons).getMainPanel(), BorderLayout.NORTH);


        //frame.add(buttons, BorderLayout.EAST);
        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));
        //MyView.background = world.levelBackground().getImage();

        controller = new Controller(world.getPlayer());
        frame.addKeyListener(controller);

        // uncomment to make the view track the bird
        //world.addStepListener(new Tracker(view, world.getPlayer()));

        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 500, 500);

        // start!
        world.start();
    }

    public Mario getPlayer() {
        return world.getPlayer();
    }

    /**
     * Is the current level of the game finished?
     */
    public boolean isCurrentLevelCompleted() {

        return world.isCompleted();
    }

    /**
     * Advance to the next level of the game.
     */
    public void goNextLevel() {
        world.stop();

        switch (level) {
            case 0:
                level++;
                world = new Level1();
                world.populate(this);
                controller.setBody(world.getPlayer());
                view.setWorld(world);
                MyView.background = (world.levelBackground().getImage());
                world.start();
                break;

            case 1:
                level++;
                world = new Level2();
                world.populate(this);
                controller.setBody(world.getPlayer());
                view.setWorld(world);
                MyView.background = (world.levelBackground().getImage());
                world.start();
                break;
            case 2:
                level++;
                world = new Level3();
                world.populate(this);
                controller.setBody(world.getPlayer());
                view.setWorld(world);
                MyView.background = (world.levelBackground().getImage());
                world.start();
                break;

            case 3:
                level++;
                world = new Level4();
                world.populate(this);
                controller.setBody(world.getPlayer());
                view.setWorld(world);
                MyView.background = (world.levelBackground().getImage());
                world.start();

                break;

            case 4:
                level++;
                world = new Level5();
                world.populate(this);
                controller.setBody(world.getPlayer());
                view.setWorld(world);
                MyView.background = (world.levelBackground().getImage());
                world.start();
                break;
            default:
                System.out.println("Finished");
                System.exit(0);
                break;

        }
    }

    /**
     * Advance to next Level taking the level as a parameter so to be accessed by other classes,
     * such as Save and Load.
     * @param level The current level
     */
    public void levelUp(int level) {
        world.stop();
        Game.level = level;

        if (level == 1) {
            level++;
            world = new Level1();
            world.populate(this);
            controller.setBody(world.getPlayer());
            view.setWorld(world);
            MyView.background = (world.levelBackground().getImage());
            world.start();
        } else if (level == 2) {

            level++;
            world = new Level2();
            world.populate(this);
            controller.setBody(world.getPlayer());
            view.setWorld(world);
            MyView.background = (world.levelBackground().getImage());
            world.start();
        } else if (level == 3) {

            level++;
            world = new Level3();
            world.populate(this);
            controller.setBody(world.getPlayer());
            view.setWorld(world);
            MyView.background = (world.levelBackground().getImage());
            world.start();
        } else if (level == 4) {

            level++;
            world = new Level4();
            world.populate(this);
            controller.setBody(world.getPlayer());
            view.setWorld(world);
            MyView.background = (world.levelBackground().getImage());
            world.start();

        } else if (level == 5) {

            level++;
            world = new Level5();
            world.populate(this);
            controller.setBody(world.getPlayer());
            view.setWorld(world);
            MyView.background = (world.levelBackground().getImage());
            world.start();
        } else if (level == 6) {

            System.out.println("Finished");
            System.exit(0);
        }

    }

    /**
     * Go back a level, allows for the Previous Button to then call this method upon MouseClick
     */

    public void goPreviousLevel() {
        world.stop();
        switch (level) {

            case 1:
                System.exit(0);

            case 2:
                level--;
                world = new Level1();
                world.populate(this);
                controller.setBody(world.getPlayer());
                view.setWorld(world);
                MyView.background = (world.levelBackground().getImage());
                world.start();
                break;

            case 3:
                level--;
                world = new Level2();
                world.populate(this);
                controller.setBody(world.getPlayer());
                view.setWorld(world);
                MyView.background = (world.levelBackground().getImage());
                world.start();
                break;

            case 4:
                level--;
                world = new Level3();
                world.populate(this);
                controller.setBody(world.getPlayer());
                view.setWorld(world);
                MyView.background = (world.levelBackground().getImage());
                world.start();
                break;

            case 5:
                level--;
                world = new Level4();
                world.populate(this);
                controller.setBody(world.getPlayer());
                view.setWorld(world);
                MyView.background = (world.levelBackground().getImage());
                world.start();
                break;


        }
    }

    public void setLevel(int level) {

        Game.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void pause() {
        world.stop();

    }

    public void resume() {
        world.start();
    }


    public SoundClip getGameMusic() {
        return gameMusic;
    }


    /**
     * Run the game.
     */
    public static void main(String[] args) {
        new Game();
    }

    public GameLevel getWorld() {
        return world;
    }
}

