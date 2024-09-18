package org.dungeonquest.game.mode.characterCreation.command;

import org.dungeonquest.game.Game;
import org.dungeonquest.game.mode.Command;

import static org.dungeonquest.DungeonQuest.walkMode;
import static org.dungeonquest.game.Graphic.*;
import static org.dungeonquest.game.Script.*;

public class StartGameCommand implements Command {
    @Override
    public String getDescription() {
        return "to start the game";
    }

    @Override
    public void execute(Game game, String input) {
        System.out.println(ANSI_YELLOW + START_SCREEN + ANSI_WHITE);
        System.out.println(START_GAME_INTRO);

        game.cleanMap();
        game.switchTo(walkMode);
    }
}
