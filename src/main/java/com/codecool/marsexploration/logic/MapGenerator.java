package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.MarsMap;
import com.codecool.marsexploration.data.TerrainElementType;
import com.codecool.marsexploration.logic.TerrainGenerators.PatchGenerator;
import com.codecool.marsexploration.logic.TerrainGenerators.PointGenerator;

public class MapGenerator {
    private MarsMap marsMap;
    private PatchGenerator patchGenerator;
    private PointGenerator pointGenerator;

    public MapGenerator(String fileName, int mapWidth, int mapHeight) {
        this.marsMap = new MarsMap(fileName, mapWidth, mapHeight);
    }

    public void generateMap(int numberOfMountainRegions, int numberOfMountains, int numberOfPitRegions, int numberOfPits, int numberOfMinerals, int numberOfWaters) {

        for (int i = 0; i < numberOfMountainRegions; i++) {
            patchGenerator = new PatchGenerator(TerrainElementType.MOUNTAIN, numberOfMountains, marsMap);
            patchGenerator.generatePatch();
        }


        for (int i = 0; i < numberOfPitRegions; i++) {
            patchGenerator = new PatchGenerator(TerrainElementType.PIT, numberOfPits, marsMap);
            patchGenerator.generatePatch();
        }

            pointGenerator = new PointGenerator(marsMap, TerrainElementType.MINERAL, TerrainElementType.MOUNTAIN, numberOfMinerals);
            pointGenerator.generatePoints();

            pointGenerator = new PointGenerator(marsMap, TerrainElementType.WATER, TerrainElementType.PIT, numberOfWaters);
            pointGenerator.generatePoints();


    }

    public MarsMap getMarsMap() {
        return marsMap;
    }

}
