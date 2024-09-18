package org.dungeonquest.game.mode.fight.monsters;

import org.dungeonquest.character.classes.Warrior;


public class Skeleton extends Warrior {

    private int hitPoints = 10;


    @Override
    public int getAttackModifier() {
        return 7;
    }

    @Override
    public int getDefendModifier() {
        return 7;
    }

    @Override
    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public int getMaxHitPoints() {
        return 10;
    }

    @Override
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    @Override
    public String getName() {
        return "Undead Skeleton";
    }
}
