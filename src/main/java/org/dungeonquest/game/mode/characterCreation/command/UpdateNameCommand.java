package org.dungeonquest.game.mode.characterCreation.command;

import org.dungeonquest.game.Game;
import org.dungeonquest.game.mode.Command;

public class UpdateNameCommand implements Command {
    @Override
    public String getDescription() {
        return "to update character name";
    }

    @Override
    public void execute(Game game, String input) {
        if (!input.isBlank()) {
            game.getCharacter().setName(input);
            game.getCharacter().printData();
        } else {
            System.out.println("Invalid name");
        }
    }
}
