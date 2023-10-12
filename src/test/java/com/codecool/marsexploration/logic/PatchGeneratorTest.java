package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.logic.terrainGenerators.PatchGenerator;
import com.codecool.marsexploration.logic.terrainGenerators.TerrainGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PatchGeneratorTest {

    @Test
    public void testRandomCoordinate() {
        TerrainGenerator terrainGenerator = new PatchGenerator(null, 0, null);
        List<Coordinate> potentialNextPositions = new ArrayList<>();
        potentialNextPositions.add(new Coordinate(1, 2));
        potentialNextPositions.add(new Coordinate(3, 4));
        potentialNextPositions.add(new Coordinate(5, 6));
        Coordinate result = terrainGenerator.randomCoordinateFromPotentialPosition();
        System.out.println(result);
        Assertions.assertNotNull(result);
        Assertions.assertTrue(potentialNextPositions.contains(result));
    }

}