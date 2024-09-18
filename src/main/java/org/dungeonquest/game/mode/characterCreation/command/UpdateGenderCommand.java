package org.dungeonquest.game.mode.characterCreation.command;

import org.dungeonquest.character.Gender;
import org.dungeonquest.game.Game;
import org.dungeonquest.game.mode.Command;

public class UpdateGenderCommand implements Command {
    @Override
    public String getDescription() {
        return "to update character gender (male/female/other)";
    }

    @Override
    public void execute(Game game, String input) {

        switch (input) {
            case "male":
                game.getCharacter().setGender(Gender.MALE);
                game.getCharacter().printData();
                break;
            case "female":
                game.getCharacter().setGender(Gender.FEMALE);
                game.getCharacter().printData();
                break;
            case "other":
                game.getCharacter().setGender(Gender.OTHER);
                game.getCharacter().printData();
                break;
            default:
                System.out.println("Invalid gender use male/female/other");
        }
    }
}
