package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.MarsMap;
import com.codecool.marsexploration.data.TerrainElementType;
import com.codecool.marsexploration.logic.terrainGenerators.PatchGenerator;
import com.codecool.marsexploration.logic.terrainGenerators.PointGenerator;

import java.util.Random;

public class MapGenerator {
    private MarsMap marsMap;
    private PatchGenerator patchGenerator;
    private PointGenerator pointGenerator;

    public MapGenerator(String fileName, int mapWidth, int mapHeight) {
        this.marsMap = new MarsMap(fileName, mapWidth, mapHeight);
    }

    public void generateMap(int numberOfMountainRegions, int numberOfMountains, int numberOfPitRegions, int numberOfPits, int numberOfMinerals, int numberOfWaters) {
        Random random = new Random();
        for (int i = 0; i < numberOfMountainRegions; i++) {
            patchGenerator = new PatchGenerator(marsMap, TerrainElementType.MOUNTAIN, random, numberOfMountains);
            patchGenerator.generate();
        }

        for (int i = 0; i < numberOfPitRegions; i++) {
            patchGenerator = new PatchGenerator(marsMap,TerrainElementType.PIT, random, numberOfPits);
            patchGenerator.generate();
        }

            pointGenerator = new PointGenerator(marsMap, TerrainElementType.MINERAL, random, numberOfMinerals, TerrainElementType.MOUNTAIN);
            pointGenerator.generate();

            pointGenerator = new PointGenerator(marsMap, TerrainElementType.WATER, random, numberOfWaters, TerrainElementType.PIT);
            pointGenerator.generate();

    }
    public MarsMap getMarsMap() {
        return marsMap;
    }
}
