package org.dungeonquest.game.mode.characterCreation.command;

import org.dungeonquest.game.Game;
import org.dungeonquest.game.mode.Command;

public class UpdateAgeCommand implements Command {
    @Override
    public String getDescription() {
        return "to update character age";
    }

    @Override
    public void execute(Game game, String input) {
        try {
            int age = Integer.parseInt(input);
            game.getCharacter().setAge(age);
            game.getCharacter().printData();
        } catch (NumberFormatException e) {
            System.out.println("Invalid age");
        }
    }
}
