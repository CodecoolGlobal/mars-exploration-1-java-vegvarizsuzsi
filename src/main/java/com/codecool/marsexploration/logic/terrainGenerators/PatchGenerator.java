package com.codecool.marsexploration.logic.terrainGenerators;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.MarsMap;
import com.codecool.marsexploration.data.TerrainElementType;

import java.util.Random;

public class PatchGenerator extends TerrainGenerator {
    private int numberOfTerrainElements;

    public PatchGenerator(MarsMap marsMap, TerrainElementType terrainElementType, Random random, int numberOfTerrainElements) {
        super(marsMap, terrainElementType, random);
        this.numberOfTerrainElements = numberOfTerrainElements;
    }

    @Override
    public void generate() {
        Coordinate firstPosition = pickFirstPosition();
        putElementOnMap(firstPosition);
        potentialPositions(firstPosition);
        for (int i = 1; i < numberOfTerrainElements; i++) {
            Coordinate actualPositionToAdd = randomCoordinateFromPotentialPosition();
            putElementOnMap(actualPositionToAdd);
            potentialPositions.remove(actualPositionToAdd);
            potentialPositions(actualPositionToAdd);
        }
    }


    public Coordinate pickFirstPosition() {
        int mapWidth = marsMap.getWidth();
        int mapHeight = marsMap.getHeight();
        int maxAttempts = mapWidth * mapHeight;
        for (int i = 0; i < maxAttempts; i++) {
            Coordinate coordinate = generateRandomCoordinate(mapWidth, mapHeight);
            if (marsMap.isCoordinateEmpty(coordinate)) {
                return coordinate;
            }
        }
        throw new IllegalStateException("Unable to find an empty coordinate.");
    }


    private Coordinate generateRandomCoordinate(int mapWidth, int mapHeight) {
        int randomX = random.nextInt(mapWidth);
        int randomY = random.nextInt(mapHeight);
        return new Coordinate(randomX, randomY);
    }

}
