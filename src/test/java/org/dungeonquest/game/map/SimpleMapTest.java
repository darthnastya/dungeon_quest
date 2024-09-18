package org.dungeonquest.game.map;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleMapTest {

    private SimpleMap simpleMap;
    public int[][] testMap = {
            {0, 0, 0, 1, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 2, 0, -1}
    };

    @BeforeEach
    void setUp() {
        simpleMap = new SimpleMap();
        simpleMap.setMap(testMap);
    }

    @Test
    void testMoveCharacterToRoad() {
        Assertions.assertEquals(MoveResult.SUCCESS, simpleMap.moveCharacter(0, 1)); // ROAD
    }

    @Test
    void testMoveCharacterToSkeleton() {
        assertEquals(MoveResult.FIGHT, simpleMap.moveCharacter(0, 3)); // SKELETON
    }

    @Test
    void testMoveCharacterToBossSkeleton() {
        assertEquals(MoveResult.FIGHT, simpleMap.moveCharacter(3, 2)); // BOSS_SKELETON
    }

    @Test
    void testMoveCharacterToGold() {
        assertEquals(MoveResult.GOLD, simpleMap.moveCharacter(3, 4)); // GOLD
    }

    @Test
    void testMoveCharacterToBlock() {
        assertEquals(MoveResult.PREVIOUS_SEGMENT, simpleMap.moveCharacter(1, -1));
    }

    @Test
    void testMoveCharacterToNextSegment() {
        assertEquals(MoveResult.NEXT_SEGMENT, simpleMap.moveCharacter(2, 5));
    }

    @Test
    void testMoveCharacterOutOfBoundsHigh() {
        assertEquals(MoveResult.BLOCK, simpleMap.moveCharacter(3, 5));
    }

    @Test
    void testMoveCharacterOutOfBoundsLow() {
        assertEquals(MoveResult.BLOCK, simpleMap.moveCharacter(0, -1));
    }

    @Test
    void testMoveCharacterOnSegmentBoundary() {
        // Test moving to the end of the segment within bounds
        assertEquals(MoveResult.SUCCESS, simpleMap.moveCharacter(0, 4)); // Last position in segment 0
        // Test moving to the next segment
        assertEquals(MoveResult.NEXT_SEGMENT, simpleMap.moveCharacter(0, 5));
    }
}