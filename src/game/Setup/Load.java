package game.Setup;

import game.Levels.Game;
import game.Levels.GameLevel;
import org.jbox2d.common.Vec2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Load {
    private String fileName;
    private Game game;
    private GameLevel world;

    public Load(String fileName, Game game) {
        this.fileName = fileName;
        this.game = game;
    }
    /**
     * method to read the save.txt file and read stored attributes
     */

    public void readSave() throws GameLoadException {
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            System.out.println("Reading: " + fileName + "...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            reader = new BufferedReader(fr);
            String line = reader.readLine();
            if (line != null) {
                String[] strings = line.split(",");
                int level = 1;
                float posX = 0;
                float posY = 0;
                int liveCount = 5;
                int tokenCount = 0;
                try {
                    level = Integer.parseInt(strings[0]);
                    posX = Float.parseFloat(strings[1]);
                    posY = Float.parseFloat(strings[2]);
                    liveCount = Integer.parseInt(strings[3]);
                    tokenCount = Integer.parseInt(strings[4]);
                } catch (NumberFormatException e) {
                    game.levelUp(level);
                    throw new GameLoadException("Error loading player");
                }

                /**
                 Attributes of player that would be transferred from Save Files
                 */

                game.levelUp(level);
                world = game.getWorld();
                game.getPlayer().setPosition(new Vec2(posX, posY));
                game.getPlayer().setTokenCount(tokenCount);
                game.getPlayer().setLiveCount(liveCount);
                System.out.println("done");
            }
        } catch (FileNotFoundException e) {
            throw new GameLoadException("File does not Exist");
        } catch (IOException e) {
            throw new GameLoadException("Problem reading file");
        }


    }
}

