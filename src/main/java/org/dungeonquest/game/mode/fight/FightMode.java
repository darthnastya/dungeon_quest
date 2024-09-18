package org.dungeonquest.game.mode.fight;


import org.dungeonquest.character.Fightable;
import org.dungeonquest.character.Character;
import org.dungeonquest.game.Game;
import org.dungeonquest.game.mode.GameMode;
import org.dungeonquest.game.mode.fight.command.AttackCommand;
import org.dungeonquest.game.mode.fight.command.ShowOpponentStatsCommand;
import org.dungeonquest.game.mode.fight.command.ShowStatsCommand;
import org.dungeonquest.game.mode.fight.monsters.BossSkeleton;
import org.dungeonquest.game.mode.fight.monsters.Skeleton;

import static org.dungeonquest.DungeonQuest.walkMode;
import static org.dungeonquest.game.Graphic.*;

public class FightMode extends GameMode {
    public FightMode() {
        availableCommand.put("attack", new AttackCommand());
        availableCommand.put("stats", new ShowStatsCommand());
        availableCommand.put("opponent", new ShowOpponentStatsCommand());
    }

    @Override
    public void onModeStart(Game game) {
        System.out.println(ANSI_RED + FIGHT + ANSI_WHITE);

        Character character = game.getCharacter();
        int objectIdentifier = game.getMap().getObjectIdentifier(character.getSegmentNumber(), character.getPosition());
        Fightable opponent = switch (objectIdentifier) {
            // TODO Improve logic, get enum instead of ObjectIdentifier
            case 1 -> new Skeleton();
            case 2 -> new BossSkeleton();
            default -> null;
        };

        if (opponent == null) {
            System.out.println("Today you are lucky, go from here!");
            game.switchTo(walkMode);
        } else {
            System.out.println("You start a fight with " + opponent.getName());
            game.setOpponent(opponent);
            printAvailableCommands();
        }
    }
}
