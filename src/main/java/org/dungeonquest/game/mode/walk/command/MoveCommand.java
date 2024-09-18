package org.dungeonquest.game.mode.walk.command;

import org.dungeonquest.character.Character;
import org.dungeonquest.game.Game;
import org.dungeonquest.game.map.GameMap;
import org.dungeonquest.game.map.MoveResult;
import org.dungeonquest.game.mode.Command;

import static org.dungeonquest.DungeonQuest.fightMode;
import static org.dungeonquest.DungeonQuest.mainMenuMode;
import static org.dungeonquest.game.Graphic.*;
import static org.dungeonquest.game.Script.FINISH_TEXT;

public abstract class MoveCommand implements Command {
    protected abstract int getNewPosition(int currentPosition);

    public void execute(Game game, String input) {
        Character character = game.getCharacter();
        GameMap map = game.getMap();

        int segmentNumber = character.getSegmentNumber();
        int position = character.getPosition();
        int newPosition = getNewPosition(position);

        MoveResult moveResult = map.moveCharacter(segmentNumber, newPosition);

        switch (moveResult) {
            case SUCCESS:
                character.setPosition(newPosition);
                game.printCharacter();
                break;

            case FIGHT:
                character.setPosition(newPosition);
                game.switchTo(fightMode);
                break;

            case BLOCK:
                System.out.println("There is no way to move");
                break;

            case NEXT_SEGMENT:
                character.setSegmentNumber(segmentNumber + 1);
                character.setPosition(0);
                game.printCharacter();
                break;

            case PREVIOUS_SEGMENT:
                character.setSegmentNumber(segmentNumber - 1);
                character.setPosition(map.getSegmentMaxPosition(segmentNumber - 1));
                game.printCharacter();
                break;
            case GOLD:
                map.cleanPosition(segmentNumber, newPosition);
                character.setPosition(newPosition);

                System.out.println(ANSI_YELLOW);
                System.out.println(FINISH);
                System.out.println(FINISH_TEXT);
                System.out.println(ANSI_WHITE);
                game.switchTo(mainMenuMode);
                break;
        }
    }
}
