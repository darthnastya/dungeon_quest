package org.dungeonquest.game.mode.mainMenu.command;

import org.dungeonquest.game.Game;
import org.dungeonquest.game.mode.Command;

import static org.dungeonquest.DungeonQuest.characterCreationMode;

public class CreateCharacterCommand implements Command {

    @Override
    public String getDescription() {
        return "to create new character";
    }

    @Override
    public void execute(Game game, String input) {
        game.switchTo(characterCreationMode);
    }
}
