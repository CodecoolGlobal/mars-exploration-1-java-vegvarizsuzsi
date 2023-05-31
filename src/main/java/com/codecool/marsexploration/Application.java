package com.codecool.marsexploration;

import com.codecool.marsexploration.data.MarsMap;
import com.codecool.marsexploration.data.TerrainElementType;
import com.codecool.marsexploration.logic.PatchGenerator;

import java.util.Arrays;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        MarsMap marsMap = new MarsMap("Mars", 10, 10);
        PatchGenerator patchGenerator = new PatchGenerator(TerrainElementType.MOUNTAIN, 5, marsMap);
        patchGenerator.generatePatch();
        System.out.println(Arrays.deepToString(marsMap.getTerrainElements()));
    }
}
