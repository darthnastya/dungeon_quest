package org.dungeonquest.game.mode.walk.command;

import org.dungeonquest.game.Game;
import org.dungeonquest.game.mode.Command;

import static org.dungeonquest.DungeonQuest.mainMenuMode;

public class MainMenuCommand implements Command {

    @Override
    public String getDescription() {
        return "to return to Main Menu (Progress will not be saved)";
    }

    @Override
    public void execute(Game game, String input) {
        game.switchTo(mainMenuMode);
    }
}
