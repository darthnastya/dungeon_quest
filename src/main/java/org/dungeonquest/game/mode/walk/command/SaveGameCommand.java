package org.dungeonquest.game.mode.walk.command;

import org.dungeonquest.game.Game;
import org.dungeonquest.game.mode.Command;


public class SaveGameCommand implements Command {

    @Override
    public String getDescription() {
        return "to save progress";
    }

    @Override
    public void execute(Game game, String input) {
        game.save();
    }
}
