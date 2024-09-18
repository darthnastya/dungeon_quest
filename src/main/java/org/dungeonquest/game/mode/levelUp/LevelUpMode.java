package org.dungeonquest.game.mode.levelUp;


import org.dungeonquest.character.Character;
import org.dungeonquest.game.Game;
import org.dungeonquest.game.mode.GameMode;
import org.dungeonquest.game.mode.levelUp.command.ContinueCommand;

import static org.dungeonquest.game.Graphic.*;

public class LevelUpMode extends GameMode {
    public LevelUpMode() {
        availableCommand.put("continue", new ContinueCommand());
    }

    @Override
    public void onModeStart(Game game) {
        Character character = game.getCharacter();
        int nextLevel = character.getLevel() + 1;

        System.out.println(ANSI_YELLOW);
        System.out.printf("Congratulations! You've reached level %d%n", nextLevel);
        System.out.println(EXP_BOOK);

        int strength = character.getStrength();
        int dexterity = character.getDexterity();
        int constitution = character.getConstitution();

        character.setLevel(nextLevel);
        character.setStrength(strength + 1);
        character.setDexterity(dexterity + 1);
        character.setConstitution(constitution + 1);
        character.setHitPoints(character.getMaxHitPoints());

        System.out.println("Strength +1");
        System.out.println("Dexterity +1");
        System.out.println("Constitution +1");
        System.out.printf("Maximum HitPoints: %d%n", character.getMaxHitPoints());

        System.out.println(ANSI_WHITE);

        printAvailableCommands();
    }
}
