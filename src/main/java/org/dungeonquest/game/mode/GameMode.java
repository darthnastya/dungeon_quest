package org.dungeonquest.game.mode;

import org.dungeonquest.game.Game;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class GameMode {

    protected Map<String, Command> availableCommand = new LinkedHashMap<>();

    public abstract void onModeStart(Game game);

    public void handleCommand(String commandLine, Game game) {
        String[] parsedCommands = splitAtFirstSpace(commandLine);

        Command command = availableCommand.get(parsedCommands[0]);

        if (command == null) {
            handleUnknownCommand(parsedCommands[0]);
            return;
        }
        command.execute(game, parsedCommands[1]);

    }

    public String[] splitAtFirstSpace(String input) {
        int spaceIndex = input.indexOf(' ');

        if (spaceIndex == -1) {
            return new String[]{input, ""};
        }
        String firstPart = input.substring(0, spaceIndex);
        String rest = input.substring(spaceIndex + 1);

        return new String[]{firstPart, rest};
    }

    private void handleUnknownCommand(String commandName) {
        System.out.println("Command \"" + commandName + "\" is not available.");
        printAvailableCommands();
    }

    protected void printAvailableCommands() {
        for (Map.Entry<String, Command> entry : availableCommand.entrySet()) {
            System.out.println("> type: '" + entry.getKey() + "' " + entry.getValue().getDescription());
        }
    }
}
