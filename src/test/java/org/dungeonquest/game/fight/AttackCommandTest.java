package org.dungeonquest.game.fight;

import org.dungeonquest.character.Fightable;
import org.dungeonquest.game.Game;
import org.dungeonquest.game.mode.fight.command.AttackCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class AttackCommandTest {
    private Game game;
    private org.dungeonquest.character.Character character;
    private Fightable opponent;
    private AttackCommand attackCommand;


    @BeforeEach
    void setUp() {
        game = mock(Game.class);
        character = mock(org.dungeonquest.character.Character.class);
        opponent = mock(Fightable.class);
        attackCommand = new AttackCommand();

        when(game.getCharacter()).thenReturn(character);
        when(game.getOpponent()).thenReturn(opponent);
    }

    @Test
    void testExecuteAttackSuccess() {
        when(character.attack()).thenReturn(10);
        when(opponent.defend(10)).thenReturn(5);
        when(opponent.isDead()).thenReturn(false);
        when(character.isDead()).thenReturn(false);

        attackCommand.execute(game, "attack");

        verify(opponent).defend(10);
        verify(character).attack();
    }


    @Test
    void testHandleCharacterDeath() {
        // Setup for when character dies
        when(character.attack()).thenReturn(10);
        when(opponent.defend(10)).thenReturn(5);
        when(opponent.isDead()).thenReturn(false);
        when(character.isDead()).thenReturn(true);

        attackCommand.execute(game, "attack");

        verify(game).switchTo(any());
    }

    @Test
    void testCriticalMiss() {
        when(character.attack()).thenReturn(10);
        when(opponent.defend(10)).thenReturn(0); // Critical miss
        when(opponent.isDead()).thenReturn(false);

        attackCommand.execute(game, "attack");

        verify(opponent).defend(10);
    }
}
