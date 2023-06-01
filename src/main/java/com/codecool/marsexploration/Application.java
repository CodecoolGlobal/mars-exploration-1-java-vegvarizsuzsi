package com.codecool.marsexploration;

import com.codecool.marsexploration.data.MarsMap;
import com.codecool.marsexploration.data.TerrainElementType;
import com.codecool.marsexploration.io.MapFileWriter;
import com.codecool.marsexploration.logic.TerrainGenerators.PatchGenerator;
import com.codecool.marsexploration.logic.TerrainGenerators.PointGenerator;

import java.util.Arrays;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        MarsMap marsMap = new MarsMap("Mars", 10, 10);
        PatchGenerator patchGenerator = new PatchGenerator(TerrainElementType.MOUNTAIN, 5, marsMap);
        patchGenerator.generatePatch();
        PatchGenerator patchGenerator2 = new PatchGenerator(TerrainElementType.PIT, 5, marsMap);
        patchGenerator2.generatePatch();
        PointGenerator pointGenerator = new PointGenerator(marsMap, TerrainElementType.MINERAL, TerrainElementType.MOUNTAIN, 5);
        pointGenerator.generatePoints();
        PointGenerator pointGenerator2 = new PointGenerator(marsMap, TerrainElementType.WATER, TerrainElementType.PIT, 5);
        pointGenerator2.generatePoints();
        System.out.println(Arrays.deepToString(marsMap.getTerrainElements()));

        MapFileWriter.saveMapToFile(marsMap, "map.txt");
    }
}
