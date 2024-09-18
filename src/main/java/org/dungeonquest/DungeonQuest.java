package org.dungeonquest;

import org.dungeonquest.game.Game;
import org.dungeonquest.game.mode.characterCreation.CharacterCreationMode;
import org.dungeonquest.game.mode.death.DeathMode;
import org.dungeonquest.game.mode.fight.FightMode;
import org.dungeonquest.game.mode.levelUp.LevelUpMode;
import org.dungeonquest.game.mode.mainMenu.MainMenuMode;
import org.dungeonquest.game.mode.walk.WalkMode;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;
import java.util.Scanner;


@SpringBootApplication
public class DungeonQuest {

    public static Random random = new Random();

    public static MainMenuMode mainMenuMode = new MainMenuMode();
    public static CharacterCreationMode characterCreationMode = new CharacterCreationMode();
    public static WalkMode walkMode = new WalkMode();
    public static FightMode fightMode = new FightMode();
    public static LevelUpMode levelUpMode = new LevelUpMode();
    public static DeathMode deathMode = new DeathMode();


    public static void main(String[] args) {
        SpringApplication.run(DungeonQuest.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return _ -> start();
    }

    public void start() {
        Game game = new Game();
        game.switchTo(mainMenuMode);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();

            if ("exit".equalsIgnoreCase(command)) {
                System.out.println("Exiting...");
                break;
            }
            game.handleCommand(command);
        }
        scanner.close();
    }
}