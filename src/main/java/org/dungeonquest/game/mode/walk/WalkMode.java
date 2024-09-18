package org.dungeonquest.game.mode.walk;

import org.dungeonquest.character.Character;
import org.dungeonquest.game.Game;
import org.dungeonquest.game.mode.fight.command.ShowStatsCommand;
import org.dungeonquest.game.mode.walk.command.*;
import org.dungeonquest.game.mode.GameMode;


public class WalkMode extends GameMode {

    public WalkMode() {
        availableCommand.put("left", new MoveLeftCommand());
        availableCommand.put("right", new MoveRightCommand());
        availableCommand.put("map", new ShowMapCommand());
        availableCommand.put("stats", new ShowStatsCommand());
        availableCommand.put("menu", new MainMenuCommand());
        availableCommand.put("save", new SaveGameCommand());
    }

    @Override
    public void onModeStart(Game game) {
        Character character = game.getCharacter();
        game.getMap().print(character.getSegmentNumber(), character.getPosition());

        printAvailableCommands();
    }
}
