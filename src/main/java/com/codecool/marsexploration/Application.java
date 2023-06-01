package com.codecool.marsexploration;

import com.codecool.marsexploration.data.MarsMap;
import com.codecool.marsexploration.data.TerrainElementType;
import com.codecool.marsexploration.io.MapFileWriter;
import com.codecool.marsexploration.logic.MapGenerator;
import com.codecool.marsexploration.logic.TerrainGenerators.PatchGenerator;
import com.codecool.marsexploration.logic.TerrainGenerators.PointGenerator;
import com.codecool.marsexploration.ui.MarsMapUI;

import java.util.Arrays;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        MarsMapUI marsMapUI = new MarsMapUI();
        String fileName = marsMapUI.askFileName();
        int mapWidth = marsMapUI.askMapWidth();
        int mapHeight = marsMapUI.askMapHeight();
        int numberOfMountainRegions = marsMapUI.askNumberOfMountainRegions();
        int numberOfMountains = marsMapUI.askNumberOfMountains();
        int numberOfPitRegions = marsMapUI.askNumberOfPitRegions();
        int numberOfPits = marsMapUI.askNumberOfPits();
        int numberOfMineralPoints = marsMapUI.askNumberOfMineralPoints();
        int numberOfWaterPoints = marsMapUI.askNumberOfWaterPoints();


        MapGenerator mapGenerator = new MapGenerator(fileName, mapWidth, mapHeight);
        mapGenerator.generateMap(numberOfMountainRegions, numberOfMountains, numberOfPitRegions, numberOfPits, numberOfMineralPoints, numberOfWaterPoints);


//
        System.out.println(Arrays.deepToString(mapGenerator.getMarsMap().getTerrainElements()));

        MapFileWriter.saveMapToFile(mapGenerator.getMarsMap(), fileName);
    }
}
