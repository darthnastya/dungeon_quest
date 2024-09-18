package org.dungeonquest.game.mode.characterCreation;


import org.dungeonquest.character.Character;
import org.dungeonquest.game.Game;
import org.dungeonquest.game.mode.GameMode;
import org.dungeonquest.game.mode.characterCreation.command.StartGameCommand;
import org.dungeonquest.game.mode.characterCreation.command.UpdateAgeCommand;
import org.dungeonquest.game.mode.characterCreation.command.UpdateGenderCommand;
import org.dungeonquest.game.mode.characterCreation.command.UpdateNameCommand;
import org.dungeonquest.game.mode.walk.command.MainMenuCommand;

import static org.dungeonquest.game.Script.CREATE_CHARACTER_INTRO;


public class CharacterCreationMode extends GameMode {
    public CharacterCreationMode() {
        availableCommand.put("name", new UpdateNameCommand());
        availableCommand.put("age", new UpdateAgeCommand());
        availableCommand.put("gender", new UpdateGenderCommand());

        availableCommand.put("start", new StartGameCommand());
        availableCommand.put("menu", new MainMenuCommand());
    }

    @Override
    public void onModeStart(Game game) {
        System.out.println(CREATE_CHARACTER_INTRO);
        game.setCharacter(Character.defaultCharacter());
        game.getCharacter().printData();
        printAvailableCommands();
    }
}
