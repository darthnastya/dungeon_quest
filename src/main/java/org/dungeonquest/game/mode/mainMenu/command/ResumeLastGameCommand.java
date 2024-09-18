package org.dungeonquest.game.mode.mainMenu.command;

import org.dungeonquest.game.Game;
import org.dungeonquest.game.mode.Command;

import static org.dungeonquest.DungeonQuest.walkMode;

public class ResumeLastGameCommand implements Command {

    @Override
    public String getDescription() {
        return "to resume last game";
    }

    @Override
    public void execute(Game game, String input) {
        boolean isLoaded = game.load();
        if (isLoaded) {
            game.switchTo(walkMode);
        }
    }
}
