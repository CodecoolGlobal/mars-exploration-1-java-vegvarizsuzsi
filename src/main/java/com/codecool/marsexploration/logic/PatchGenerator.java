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
        putElementOnMap(pickFirstPosition());
        potentialPositions = potentialNextPositions(pickFirstPosition());
        for (int i = 1; i < numberOfTerrainElements; i++) {
            if (!potentialPositions.isEmpty()) {
                Coordinate actualPositionToAdd = randomCoordinate(potentialPositions);
                putElementOnMap(actualPositionToAdd);
                potentialPositions.remove(actualPositionToAdd);
            }
        }
    }

    public Coordinate pickFirstPosition() {
        int randomX = random.nextInt(marsMap.getWidth());
        int randomY = random.nextInt(marsMap.getHeight());
        return new Coordinate(randomX, randomY);
    }

    public void putElementOnMap(Coordinate coordinate) {
        marsMap.putElementOnMap(coordinate, terrainElementType);
    }

    public List<Coordinate> potentialNextPositions(Coordinate previousCoordinate) {
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (checkNeighbourIsEmpty(previousCoordinate.x(), previousCoordinate.y(), dx, dy) &&
                        checkNeighbourType(previousCoordinate.x(), previousCoordinate.y(), dx, dy) &&
                        isWithInBound(previousCoordinate.x(), previousCoordinate.y(), dx, dy)) {
                    potentialPositions.add(new Coordinate(previousCoordinate.x() + dx, previousCoordinate.y() + dy));
                }
            }
        }
        return potentialPositions;
    }

    private boolean checkNeighbourIsEmpty(int x, int y, int dx, int dy) {
        return marsMap.getTerrainElements()[x + dx][y + dy].getType() == TerrainElementType.EMPTY;

    }

    private boolean checkNeighbourType(int x, int y, int dx, int dy) {
        return marsMap.getTerrainElements()[x + dx][y + dy].getType() == terrainElementType;

    }


    private boolean isWithInBound(int x, int y, int dx, int dy) {
        return x + dx >= 0 && y + dy >= 0 && x + dx < marsMap.getWidth() && y + dy < marsMap.getHeight();

    }

    public Coordinate randomCoordinate(List<Coordinate> potentialNextPositions) {
        return potentialNextPositions.get(random.nextInt(potentialNextPositions.size()));
    }


}
