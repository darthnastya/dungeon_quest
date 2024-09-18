package org.dungeonquest.game.mode.mainMenu;


import org.dungeonquest.game.Game;
import org.dungeonquest.game.mode.GameMode;
import org.dungeonquest.game.mode.mainMenu.command.ResumeLastGameCommand;
import org.dungeonquest.game.mode.mainMenu.command.CreateCharacterCommand;

import static org.dungeonquest.game.Graphic.*;

public class MainMenuMode extends GameMode {
    public MainMenuMode() {
        availableCommand.put("start", new CreateCharacterCommand());
        availableCommand.put("resume", new ResumeLastGameCommand());
    }

    @Override
    public void onModeStart(Game game) {
        System.out.println(ANSI_YELLOW + MAIN_MENU_INTRO + ANSI_WHITE);
        printAvailableCommands();
    }
}
