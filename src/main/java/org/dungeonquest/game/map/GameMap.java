package org.dungeonquest.game.map;

public interface GameMap {

    void print(int segment, int characterPosition);

    MoveResult moveCharacter(int segment, int newPosition);

    int getSegmentMaxPosition(int segment);

    int getObjectIdentifier(int segment, int position);

    void cleanPosition(int segmentNumber, int position);
}
