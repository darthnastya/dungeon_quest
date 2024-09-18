package org.dungeonquest.game.mode.walk.command;

import org.dungeonquest.game.Game;
import org.dungeonquest.game.mode.Command;


public class ShowMapCommand implements Command {

    @Override
    public String getDescription() {
        return "to see map";
    }

    @Override
    public void execute(Game game, String input) {
        game.printCharacter();
    }
}
