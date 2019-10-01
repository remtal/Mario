package game.Setup;

import game.Levels.Game;
import game.Levels.GameLevel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends Container {
    public JPanel getMainPanel() {
        return mainPanel;
    }

    private JPanel mainPanel;
    private JButton pauseButton;
    private JButton stopButton;
    private JButton previousLevel;
    private JButton nextLevel;
    private JRadioButton music;
    private JComboBox saveBox;
    private JComboBox loadBox;
    private JPanel mainMenu;
    private Game game;
    private GameLevel world;
    private Font customFont;
    Boolean isPaused = false;

    public ControlPanel(Game game) {
        this.game = game;
        try {

            /**
             Implements Custom Mario font to all Buttons
             */
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("data/mariofont.ttf")).deriveFont(10f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("data/mariofont.ttf")));
            music.setFont(customFont);
            stopButton.setFont(customFont);
            previousLevel.setFont(customFont);
            nextLevel.setFont(customFont);
            music.setFont(customFont);
            pauseButton.setFont(customFont);
            saveBox.setFont(customFont);
            loadBox.setFont(customFont);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }


        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                /**
                 Pause button is changed to a Resume button upon mouseClick
                 */
                if (!isPaused) {
                    game.pause();
                    pauseButton.setText("Resume");
                    //game.getGameMusic().stop();
                } else {
                    game.resume();
                    pauseButton.setText("Pause");
                    //game.getGameMusic().resume();
                }
                isPaused = !isPaused;
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        previousLevel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.goPreviousLevel();
            }
        });
        nextLevel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.goNextLevel();
            }
        });

        music.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.getGameMusic().stop();
                if (music.isSelected()) {
                     game.getGameMusic().resume();

                } else {
                      game.getGameMusic().pause();
                }
            }
        });
        saveBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                /**
                 Save Box has multiple save Slots all of which can be rewritten
                 */
                try {
                    if (saveBox.getSelectedIndex() == 1) {
                        Save save = new Save("data/save1.txt", game);
                        save.writeSave();
                    }
                    if (saveBox.getSelectedIndex() == 2) {
                        Save save = new Save("data/save2.txt", game);
                        save.writeSave();
                    }
                    if (saveBox.getSelectedIndex() == 3) {
                        Save save = new Save("data/save3.txt", game);
                        save.writeSave();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        loadBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 Load Box, loads from Save Slots
                 */
                try {
                    if (loadBox.getSelectedIndex() == 1) {
                        Load load = new Load("data/save1.txt", game);
                        load.readSave();
                    }
                    if (loadBox.getSelectedIndex() == 2) {
                        Load load = new Load("data/save2.txt", game);
                        load.readSave();
                    }
                    if (loadBox.getSelectedIndex() == 3) {
                        Load load = new Load("data/save3.txt", game);
                        load.readSave();
                    }
                } catch (GameLoadException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }
}
