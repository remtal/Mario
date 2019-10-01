package game.Setup;

import game.Levels.Game;

import java.io.FileWriter;
import java.io.IOException;

public class Save {
    private String fileName;
    private Game game;

    public Save(String fileName, Game game) {
        this.fileName = fileName;
        this.game = game;
    }

    public void writeSave() throws IOException {
        FileWriter writer = null;

        /**
         Attributes that will be saved to a File, level, postion, health, tokenCount etc
         */

        try {
            writer = new FileWriter(fileName);
            writer.write(game.getLevel() + "," + game.getPlayer().getPosition().x + "," + game.getPlayer().getPosition().y + "," + game.getPlayer().getTokenCount() + "," + game.getPlayer().getLiveCount() + "," + game.getPlayer().getEggCount());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
