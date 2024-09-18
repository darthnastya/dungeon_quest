package org.dungeonquest.game.mode.death;


import org.dungeonquest.game.Game;
import org.dungeonquest.game.mode.GameMode;
import org.dungeonquest.game.mode.mainMenu.command.ResumeLastGameCommand;
import org.dungeonquest.game.mode.walk.command.MainMenuCommand;

import static org.dungeonquest.game.Graphic.*;

public class DeathMode extends GameMode {

    public DeathMode() {
        availableCommand.put("menu", new MainMenuCommand());
        availableCommand.put("resume", new ResumeLastGameCommand());
    }

    @Override
    public void onModeStart(Game game) {
        System.out.println(DEATH_SCREEN);
        printAvailableCommands();
    }
}
