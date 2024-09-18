package org.dungeonquest.character;

public interface Fightable {
    int attack();

    int defend(int damage);

    boolean isDead();

    void printStats();

    String getName();
}
