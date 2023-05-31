package com.codecool.marsexploration.logic;

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
            if (isCoordinateEmpty(coordinate)) {
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
                if (isWithInBound(newX, newY) &&
                        checkNeighbourIsEmpty(newX, newY)) {
                    potentialPositions.add(new Coordinate(newX, newY));
                }
            }
        }
    }

    private boolean checkNeighbourIsEmpty(int x, int y) {
        return marsMap.getTerrainElements()[x][y].getType() == TerrainElementType.EMPTY;

    }

    private boolean checkNeighbourType(int x, int y, int dx, int dy) {
        return marsMap.getTerrainElements()[x + dx][y + dy].getType() == terrainElementType;

    }


    private boolean isWithInBound(int x, int y) {
        return x >= 0 && y >= 0 && x < marsMap.getWidth() && y < marsMap.getHeight();

    }

    public Coordinate randomCoordinate(List<Coordinate> potentialNextPositions) {
        int randomIndex = random.nextInt(potentialNextPositions.size());
        return potentialNextPositions.get(randomIndex);
    }

    private boolean isCoordinateEmpty(Coordinate coordinate) {
        return marsMap.getTerrainElements()[coordinate.x()][coordinate.y()].getType() == TerrainElementType.EMPTY;
    }

}
