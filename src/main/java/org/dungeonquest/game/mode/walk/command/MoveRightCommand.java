package org.dungeonquest.game.mode.walk.command;


public class MoveRightCommand extends MoveCommand {
    @Override
    public String getDescription() {
        return "to move right";
    }

    @Override
    protected int getNewPosition(int currentPosition) {
        return currentPosition + 1;
    }
}
