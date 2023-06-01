package com.codecool.marsexploration.logic.terrainGenerators;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.MarsMap;
import com.codecool.marsexploration.data.TerrainElementType;

import java.util.Random;

public class PointGenerator extends TerrainGenerator {
    private int numberOfResources;
    private TerrainElementType sourceType;

    public PointGenerator(MarsMap marsMap, TerrainElementType terrainElementType, Random random, int numberOfResources, TerrainElementType sourceType) {
        super(marsMap, terrainElementType, random);
        this.numberOfResources = numberOfResources;
        this.sourceType = sourceType;
    }

    @Override
    public void generate() {
        fillPotentialPositions();
        for (int i = 0; i < numberOfResources; i++) {
            Coordinate actual = randomCoordinateFromPotentialPosition();
            putElementOnMap(actual);
            potentialPositions.remove(actual);
        }
    }

    private void fillPotentialPositions() {
        for (int x = 0; x < marsMap.getWidth(); x++) {
            for (int y = 0; y < marsMap.getHeight(); y++) {
                if (marsMap.getTerrainElements()[x][y].getType() == sourceType) {
                    potentialPositions(new Coordinate(x, y));
                }
            }
        }
    }

}
