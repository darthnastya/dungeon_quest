package org.dungeonquest.game.mode.fight.command;

import org.dungeonquest.game.Game;
import org.dungeonquest.game.mode.Command;
import org.dungeonquest.character.Fightable;

public class ShowOpponentStatsCommand implements Command {
    @Override
    public String getDescription() {
        return "to check opponent statistic";
    }

    @Override
    public void execute(Game game, String input) {
        Fightable opponent = game.getOpponent();
        opponent.printStats();
    }
}
