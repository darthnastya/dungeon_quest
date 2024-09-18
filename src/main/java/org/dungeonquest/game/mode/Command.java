package org.dungeonquest.game.mode;

import org.dungeonquest.game.Game;

public interface Command {
    String getDescription();

    void execute(Game game, String input);
}
