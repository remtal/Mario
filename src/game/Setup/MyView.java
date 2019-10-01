/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Setup;

import city.cs.engine.UserView;
import city.cs.engine.World;
import game.Levels.Game;
import game.Levels.GameLevel;
import game.Sprites.Bowser;
import game.Sprites.Mario;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/*
 * To c1hange this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author tsami
 */
public class MyView extends UserView {

    public static Image background;
    private GameLevel world;
    private int lives;
    private int score;
    private int eggCount;
    private Bowser bowser;
    private Game game;
    Font customfont;
    private static final Image heart = new ImageIcon("data/heart.png").getImage();
    private static final Image coin = new ImageIcon("data/coin1.png").getImage();
    private static final Image egg = new ImageIcon("data/yoshiegg.png").getImage();
    Mario mario;


    /**
     * Constructor for the MyView class
     */
    public MyView(World world, Mario mario, int width, int height, Game game) {
        super(world, width, height);
        this.mario = mario;
        this.game = game;
        //MyView.background = background;

    }

    /**
     * Extends UserView, paintBackground is called in Game and levelBackground
     * is an abstract Class in GameLevel which changes each level
     */
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, 500, 500, this);


    }

    @Override
    protected void paintForeground(Graphics2D g) {
        world = (GameLevel) this.getWorld();
        lives = world.getPlayer().getLiveCount();
        score =   world.getPlayer().getTokenCount();
        eggCount = world.getPlayer().getEggCount();

        /**
         Calls the custom font which then later is added to all in Game text foreground text such as the Score.
         */

        try {
            customfont = Font.createFont(Font.TRUETYPE_FONT, new File("data/mariofont.ttf")).deriveFont(15f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("data/mariofont.ttf")));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         Functions drawing the Foreground, draws Score, Egg Count, Health Count
         wiht the custom Mario font
         */

        //Font fnt0 = new Font("LucidaSans", Font.PLAIN, 10);
        g.drawImage(egg, 5, 40, 20, 20, this);
        g.setFont(customfont);
        g.drawString(" = " + mario.getEggCount(), 30, 55);
        g.drawString("Score: " + mario.getTokenCount(), 415, 20);
        for (int i = 0; i < lives; i++) {
            g.drawImage(heart, (i * 30), 0, 30, 30, this);
        }

        /**
          Adds another foreground text with an image which unlike the others
         is only implemented in Level 5
         */


        if (game.getLevel() > 4) {
            g.drawString(" = " + mario.getBossHealth(), 30, 95);

        }
    }


}



