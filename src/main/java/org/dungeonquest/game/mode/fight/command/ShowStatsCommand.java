package org.dungeonquest.game.mode.fight.command;

import org.dungeonquest.character.Character;
import org.dungeonquest.game.Game;
import org.dungeonquest.game.mode.Command;

public class ShowStatsCommand implements Command {
    @Override
    public String getDescription() {
        return "to check character statistic";
    }

    @Override
    public void execute(Game game, String input) {
        Character character = game.getCharacter();
        character.printStats();
    }
}
