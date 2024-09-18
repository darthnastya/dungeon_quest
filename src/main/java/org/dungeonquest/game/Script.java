package org.dungeonquest.game;

public interface Script {
    String CREATE_CHARACTER_INTRO =
            """

                    Welcome to the dungeon! Create your character to start the adventure.
                    To update your character's name, use the command like:
                    "name Marvin the Last".
                    
                    Good luck, brave adventurer!""";
    ;

    String START_GAME_INTRO =
            """
                    
                    A cold breeze brushes against your skin, reminding you that no one has ventured this far and returned alive. You are a lone adventurer,
                    driven by an unshakable need to prove your worth and uncover the ancient secrets buried deep within these cursed walls.
                    """;


    String FINISH_TEXT =
            """
                    
                    The final guardian lies defeated at your feet, its once fearsome form now reduced to mere shadows and dust.
                     Silence falls over the cursed walls that once echoed with the roars of ancient beasts and the cries of lost adventurers.
                     You have done what no one else could.
                    
                    With the artifact in hand and the dungeon's secrets laid bare, the world awaits your return.
                     A new dawn rises, and with it, the promise of untold power and glory.""";

}
