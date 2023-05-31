package com.codecool.marsexploration.logic.TerrainGenerators;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.MarsMap;
import com.codecool.marsexploration.data.TerrainElementType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PatchGenerator {
    private TerrainElementType terrainElementType;
    private int numberOfTerrainElements;
    private MarsMap marsMap;
    List<Coordinate> potentialPositions;
    Random random;

    public PatchGenerator(TerrainElementType terrainElementType, int numberOfTerrainElements, MarsMap marsMap) {
        this.terrainElementType = terrainElementType;
        this.numberOfTerrainElements = numberOfTerrainElements;
        this.marsMap = marsMap;
        this.potentialPositions = new ArrayList<>();
        this.random = new Random();
    }

    public void generatePatch() {
        Coordinate firstPosition = pickFirstPosition();
        putElementOnMap(firstPosition);
        potentialNextPositions(firstPosition);
        for (int i = 1; i < numberOfTerrainElements; i++) {
            Coordinate actualPositionToAdd = randomCoordinate(potentialPositions);
            putElementOnMap(actualPositionToAdd);
            potentialPositions.remove(actualPositionToAdd);
            potentialNextPositions(actualPositionToAdd);
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

    public void putElementOnMap(Coordinate coordinate) {
        marsMap.putElementOnMap(coordinate, terrainElementType);
    }

    public void potentialNextPositions(Coordinate previousCoordinate) {
        int previousX = previousCoordinate.x();
        int previousY = previousCoordinate.y();

        for (int dx = -1; dx <= 1; dx++) {
            int newX = previousX + dx;
            for (int dy = -1; dy <= 1; dy++) {
                int newY = previousY + dy;
                if (marsMap.isWithInBound(newX, newY) && marsMap.isCoordinateEmpty(new Coordinate(newX, newY))) {
                    potentialPositions.add(new Coordinate(newX, newY));
                }
            }
        }
    }

    public Coordinate randomCoordinate(List<Coordinate> potentialNextPositions) {
        int randomIndex = random.nextInt(potentialNextPositions.size());
        return potentialNextPositions.get(randomIndex);
    }


}
