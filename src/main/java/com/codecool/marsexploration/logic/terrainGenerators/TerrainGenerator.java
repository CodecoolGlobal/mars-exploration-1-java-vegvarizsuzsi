package com.codecool.marsexploration.logic.terrainGenerators;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.MarsMap;
import com.codecool.marsexploration.data.TerrainElementType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class TerrainGenerator {

    protected MarsMap marsMap;
    protected TerrainElementType terrainElementType;
    protected List<Coordinate> potentialPositions;
    protected Random random;

    public TerrainGenerator(MarsMap marsMap, TerrainElementType terrainElementType) {
        this.marsMap = marsMap;
        this.terrainElementType = terrainElementType;
        this.potentialPositions = new ArrayList<>();
        this.random = new Random();
    }

    public abstract void generate();

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

    public Coordinate randomCoordinateFromList() {
        int randomIndex = random.nextInt(potentialPositions.size());
        return potentialPositions.get(randomIndex);
    }
}
