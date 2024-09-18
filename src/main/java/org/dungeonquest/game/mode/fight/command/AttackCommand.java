package org.dungeonquest.game.mode.fight.command;

import org.dungeonquest.character.Character;
import org.dungeonquest.game.Game;
import org.dungeonquest.game.mode.Command;
import org.dungeonquest.character.Fightable;

import static org.dungeonquest.DungeonQuest.*;
import static org.dungeonquest.game.FightBalance.FIGHT_XP;
import static org.dungeonquest.game.Graphic.*;

public class AttackCommand implements Command {

    @Override
    public String getDescription() {
        return "to attack";
    }

    @Override
    public void execute(Game game, String input) {
        Character character = game.getCharacter();
        Fightable opponent = game.getOpponent();

        performAttack(ANSI_GREEN, character, opponent);

        if (opponent.isDead()) {
            System.out.printf("%s%s%s killed the %s and gained %dxp%n",
                    ANSI_GREEN, character.getName(), ANSI_WHITE, opponent.getName(), FIGHT_XP);
            handleOpponentDefeat(character, game);
        } else {
            performAttack(ANSI_RED, opponent, character);
        }

        if (character.isDead()) {
            handleCharacterDeath(game);
        }
    }

    private void performAttack(String color, Fightable attacker, Fightable defender) {
        int damage = defender.defend(attacker.attack());
        String attackerName = attacker.getName();

        if (damage <= 0) {
            System.out.printf("%s%s%s attacks: CRITICAL MISS%n", color, attackerName, ANSI_WHITE);
        } else {
            System.out.printf("%s%s%s attacks: damage %d%n", color, attackerName, ANSI_WHITE, damage);
        }
    }

    private void handleOpponentDefeat(Character character, Game game) {
        game.getMap().cleanPosition(character.getSegmentNumber(), character.getPosition());

        character.addExperience(FIGHT_XP);

        int experience = character.getExperience();
        int level = character.getLevel();

        if (game.getLevelsMap().containsKey(level + 1) && experience >= game.getLevelsMap().get(level + 1)) {
            game.switchTo(levelUpMode);
        } else game.switchTo(walkMode);

        game.setOpponent(null);
    }

    private void handleCharacterDeath(Game game) {
        game.switchTo(deathMode);
    }
}
