package org.dungeonquest.character.classes;

import org.dungeonquest.character.Fightable;

import static org.dungeonquest.DungeonQuest.random;
import static org.dungeonquest.game.FightBalance.*;
import static org.dungeonquest.game.Graphic.ANSI_WHITE;
import static org.dungeonquest.game.Graphic.ANSI_YELLOW;

public abstract class Warrior implements Fightable {

    public abstract int getAttackModifier();

    public abstract int getDefendModifier();

    public abstract int getHitPoints();

    public abstract int getMaxHitPoints();

    public abstract void setHitPoints(int hitPoints);

    @Override
    public int attack() {
        return getAttackModifier() - MEDIATOR + random.nextInt(ATTACK_MAX_ROLL);
    }

    @Override
    public int defend(int possibleDamage) {
        int actualDamage = possibleDamage - (getDefendModifier() - MEDIATOR + random.nextInt(DEFEND_MAX_ROLL));
        setHitPoints(getHitPoints() - actualDamage);
        return actualDamage;
    }


    @Override
    public boolean isDead() {
        return getHitPoints() <= 0;
    }

    @Override
    public void printStats() {
        System.out.println(ANSI_YELLOW);
        System.out.println(getName());
        System.out.println("+-------------------+-------------------+");
        System.out.printf("| %-17s | %-17s |%n", "Gender", "undefined");
        System.out.printf("| %-17s | %-17s |%n", "Age", "100-200");
        System.out.printf("| %-17s | %-17d |%n", "Attack", getAttackModifier());
        System.out.printf("| %-17s | %-17d |%n", "Defense", getDefendModifier());
        System.out.printf("| %-17s | %-17s |%n", "Hit Points", getHitPoints() + "/" + getMaxHitPoints());
        System.out.println("+-------------------+-------------------+");
        System.out.println();
        System.out.println(ANSI_WHITE);
    }
}
