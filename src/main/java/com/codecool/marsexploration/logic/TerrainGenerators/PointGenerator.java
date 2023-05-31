package com.codecool.marsexploration.logic.TerrainGenerators;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.MarsMap;
import com.codecool.marsexploration.data.TerrainElementType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PointGenerator {
    private MarsMap marsMap;
    private int numberOfResources;
    private TerrainElementType terrainElementType;
    private Random random;

    List<Coordinate> potentialPositions;

    public PointGenerator(MarsMap marsMap, TerrainElementType terrainElementType, TerrainElementType sourceType, int numberOfResources) {
        this.marsMap = marsMap;
        this.numberOfResources = numberOfResources;
        this.terrainElementType = terrainElementType;
        this.potentialPositions = new ArrayList<>();
        this.random = new Random();
    }

    public void generatePoints(){
        //TODO befejezni
        List<Coordinate> sourcePositions = getSourcePositions();
        for (int i = 1; i < numberOfResources; i++) {
            randomCoordinateFromList(sourcePositions);
        }
    }

    private List<Coordinate> getSourcePositions() {
        List<Coordinate> sourcePositions = new ArrayList<>();
        for (int x = 0; x < marsMap.getWidth(); x++) {
            for (int y = 0; y < marsMap.getHeight(); y++) {
                if (marsMap.getTerrainElements()[x][y].getType() == terrainElementType) {
                    sourcePositions.add(new Coordinate(x, y));
                }
            }
        }
        return sourcePositions;
    }

    public void putElementOnMap(Coordinate coordinate) {
        marsMap.putElementOnMap(coordinate, terrainElementType);
    }

    public void potentialPositions(Coordinate actualCoordinate) {
        int actualX = actualCoordinate.x();
        int actualY = actualCoordinate.y();

        for (int dx = -1; dx <= 1; dx++) {
            int newX = actualX + dx;
            for (int dy = -1; dy <= 1; dy++) {
                int newY = actualY + dy;
                if (marsMap.isWithInBound(newX, newY) && marsMap.isCoordinateEmpty(new Coordinate(newX, newY))) {
                    potentialPositions.add(new Coordinate(newX, newY));
                }
            }
        }
    }

    private Coordinate generateRandomCoordinate(int mapWidth, int mapHeight) {
        int randomX = random.nextInt(mapWidth);
        int randomY = random.nextInt(mapHeight);
        return new Coordinate(randomX, randomY);
    }

    public Coordinate randomCoordinateFromList(List<Coordinate> potentialNextPositions) {
        int randomIndex = random.nextInt(potentialNextPositions.size());
        return potentialNextPositions.get(randomIndex);
    }

}