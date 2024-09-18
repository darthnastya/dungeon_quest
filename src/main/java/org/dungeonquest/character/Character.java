package org.dungeonquest.character;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.dungeonquest.character.classes.Warrior;


import java.io.Serializable;

import static org.dungeonquest.game.FightBalance.*;
import static org.dungeonquest.game.Graphic.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Character extends Warrior implements Serializable {
    private String name;

    private Gender gender;

    private int age;

    private int experience;

    private int strength;

    private int dexterity;

    private int constitution;

    private int hitPoints;

    private int level;

    private int segmentNumber;

    private int position;

    public void addExperience(int experiencePoints) {
        experience += experiencePoints;
    }

    public void nextLevel() {
        level += 1;
        strength += 1;
        dexterity += 1;
        constitution += 1;
        hitPoints = getMaxHitPoints();
    }

    public static Character defaultCharacter() {
        return new Character(
                "Unknown hero",
                Gender.MALE,
                31,
                START_XP,
                START_STRENGTH,
                START_DEXTERITY,
                START_CONSTITUTION,
                START_CONSTITUTION * 2,
                1,
                0,
                0
        );
    }


    @Override
    public void printStats() {
        System.out.println(ANSI_YELLOW);
        System.out.println(name + " Exp: " + experience + " Lvl: " + level);
        System.out.println("+-------------------+-------------------+");
        System.out.printf("| %-17s | %-17s |%n", "Gender", gender);
        System.out.printf("| %-17s | %-17d |%n", "Age", age);
        System.out.printf("| %-17s | %-17d |%n", "Experience", experience);
        System.out.printf("| %-17s | %-17d |%n", "Strength", strength);
        System.out.printf("| %-17s | %-17d |%n", "Dexterity", dexterity);
        System.out.printf("| %-17s | %-17d |%n", "Constitution", constitution);
        System.out.printf("| %-17s | %-17s |%n", "Hit Points", hitPoints + "/" + constitution * 2);
        System.out.println("+-------------------+-------------------+");
        System.out.println();
        System.out.println(ANSI_WHITE);
    }

    public void printData() {
        System.out.println(ANSI_YELLOW);
        System.out.println("\n+-------------------+-------------------+");
        System.out.printf("| %-17s | %-17s |%n", "Attribute", "Value");
        System.out.println("+-------------------+-------------------+");
        System.out.printf("| %-17s | %-17s |%n", "Name", name);
        System.out.printf("| %-17s | %-17s |%n", "Gender", gender);
        System.out.printf("| %-17s | %-17d |%n", "Age", age);
        System.out.println("+-------------------+-------------------+");
        System.out.println();
        System.out.println(ANSI_WHITE);
    }

    @Override
    public int getAttackModifier() {
        return strength;
    }

    @Override
    public int getDefendModifier() {
        return dexterity;
    }

    @Override
    public int getMaxHitPoints() {
        return constitution * 2;
    }

}
