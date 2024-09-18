package org.dungeonquest.game;


import lombok.Data;
import org.dungeonquest.character.Character;
import org.dungeonquest.game.map.GameMap;
import org.dungeonquest.game.map.SimpleMap;
import org.dungeonquest.game.mode.GameMode;
import org.dungeonquest.character.Fightable;

import java.io.*;
import java.util.HashMap;

@Data
public class Game {

    private GameMode mode;
    private Character character;
    private Fightable opponent;
    private GameMap map;
    private HashMap<Integer, Integer> levelsMap;

    public Game() {
        levelsMap = new HashMap<>();
        levelsMap.put(1, 0);
        levelsMap.put(2, 100);
        levelsMap.put(3, 150);
        levelsMap.put(4, 600);
        levelsMap.put(5, 1000);

        this.map = new SimpleMap();
        this.opponent = null;
    }

    public void save() {
        saveCharacter(character, "save.txt");
    }


    public boolean load() {
        Character loadedCharacter = loadCharacter("save.txt");
        if (loadedCharacter == null) {
            System.out.println("No saved game");
            return false;

        } else {
            character = loadedCharacter;
            map = new SimpleMap();
            map.cleanPosition(character.getSegmentNumber(), character.getPosition());
            return true;
        }
    }

    public static void saveCharacter(Character character, String filename) {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(character);
            System.out.println("Game saved");
        } catch (IOException e) {
            System.out.println("Could not save the game");
        }
    }

    public static Character loadCharacter(String filename) {
        Character character = null;
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            character = (Character) in.readObject();
            System.out.println("Character loaded from " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Could not load game");
        }
        return character;
    }

    public void handleCommand(String actionName) {
        mode.handleCommand(actionName, this);
    }

    public void switchTo(GameMode mode) {
        this.mode = mode;
        mode.onModeStart(this);
    }

    public void cleanMap() {
        map = new SimpleMap();
        character.setPosition(0);
        character.setSegmentNumber(0);
    }

    public void printCharacter() {
        map.print(character.getSegmentNumber(), character.getPosition());
    }
}

