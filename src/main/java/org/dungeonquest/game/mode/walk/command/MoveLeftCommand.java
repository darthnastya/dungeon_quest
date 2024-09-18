package org.dungeonquest.game.mode.walk.command;


public class MoveLeftCommand extends MoveCommand {
    @Override
    public String getDescription() {
        return "to move left";
    }

    @Override
    protected int getNewPosition(int currentPosition) {
        return currentPosition - 1;
    }
}
