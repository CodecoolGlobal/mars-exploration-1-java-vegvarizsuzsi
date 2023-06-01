package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.logic.TerrainGenerators.PatchGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PatchGeneratorTest {

    @Test
    public void testRandomCoordinate() {
        PatchGenerator patchGenerator = new PatchGenerator(null, 0, null);
        List<Coordinate> potentialNextPositions = new ArrayList<>();
        potentialNextPositions.add(new Coordinate(1, 2));
        potentialNextPositions.add(new Coordinate(3, 4));
        potentialNextPositions.add(new Coordinate(5, 6));

        Coordinate result = patchGenerator.randomCoordinateFromList(potentialNextPositions);
        System.out.println(result);
        Assertions.assertNotNull(result);
        Assertions.assertTrue(potentialNextPositions.contains(result));
    }

}