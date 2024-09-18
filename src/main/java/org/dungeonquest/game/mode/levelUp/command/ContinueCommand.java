package org.dungeonquest.game.mode.levelUp.command;

import org.dungeonquest.game.Game;
import org.dungeonquest.game.mode.Command;

import static org.dungeonquest.DungeonQuest.walkMode;

public class ContinueCommand implements Command {
    @Override
    public String getDescription() {
        return "to continue";
    }

    @Override
    public void execute(Game game, String input) {
        game.switchTo(walkMode);
    }
}