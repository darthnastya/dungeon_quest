package org.dungeonquest.game.map;

import lombok.Setter;

import static org.dungeonquest.game.Graphic.*;

@Setter
public class SimpleMap implements GameMap {

    private static final int GOLD = -1;
    private static final int ROAD = 0;
    private static final int SKELETON = 1;
    private static final int BOSS_SKELETON = 2;


    public int[][] map = {
            {ROAD, ROAD, ROAD, SKELETON, ROAD},
            {ROAD, SKELETON, ROAD, SKELETON, ROAD},
            {ROAD, ROAD, SKELETON, ROAD, ROAD},
            {ROAD, ROAD, BOSS_SKELETON, ROAD, GOLD}
    };

    @Override
    public MoveResult moveCharacter(int segment, int newPosition) {
        if (segment > 0 && newPosition < 0) {
            return MoveResult.PREVIOUS_SEGMENT;
        } else if (segment < map.length - 1 && newPosition > map[0].length - 1) {
            return MoveResult.NEXT_SEGMENT;
        }

        if ((segment == 0 && newPosition == -1) || (segment == map.length - 1 && newPosition > map[0].length - 1)) {
            return MoveResult.BLOCK;
        }

        int mapValue = map[segment][newPosition];
        if (mapValue == SKELETON || mapValue == BOSS_SKELETON) {
            return MoveResult.FIGHT;
        }
        if (mapValue == GOLD) {
            return MoveResult.GOLD;
        }

        return MoveResult.SUCCESS;
    }

    @Override
    public int getSegmentMaxPosition(int segment) {
        return map[0].length - 1;
    }

    @Override
    public int getObjectIdentifier(int segment, int position) {
        return map[segment][position];
    }

    @Override
    public void cleanPosition(int segment, int position) {
        map[segment][position] = ROAD;
    }

    @Override
    public void print(int segment, int characterPosition) {
        for (int y = 0; y < HEIGHT; y++) {
            for (int i = 0; i < map[segment].length; i++) {
                if (i == characterPosition) {
                    System.out.print(AVATAR_GRAPHIC[y]);
                } else
                    switch (map[segment][i]) {
                        case ROAD:
                            System.out.print(ROAD_GRAPHIC[y]);
                            break;
                        case SKELETON:
                            System.out.print(SKELETON_GRAPHIC[y]);
                            break;
                        case BOSS_SKELETON:
                            System.out.print(BOSS_SKELETON_GRAPHIC[y]);
                            break;
                        case GOLD:
                            System.out.print(GOLD_GRAPHIC[y]);
                            break;
                    }
            }
            System.out.println();
        }
    }
}
