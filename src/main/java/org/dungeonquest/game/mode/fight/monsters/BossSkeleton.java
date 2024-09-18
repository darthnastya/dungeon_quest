package org.dungeonquest.game.mode.fight.monsters;

import org.dungeonquest.character.classes.Warrior;


public class BossSkeleton extends Warrior {

    private int hitPoints = 30;


    @Override
    public int getAttackModifier() {
        return 15;
    }

    @Override
    public int getDefendModifier() {
        return 6;
    }

    @Override
    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public int getMaxHitPoints() {
        return 30;
    }

    @Override
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    @Override
    public String getName() {
        return "Undead Skeleton King";
    }
}
