package com.codecool.marsexploration.ui;

import com.codecool.marsexploration.io.MapFileWriter;
import com.codecool.marsexploration.logic.MapGenerator;

import java.util.Arrays;

public class MarsMapUI {

    public void start() {
        UserInput scanner = new UserInput();
        String fileName = scanner.askFileName();
        int mapWidth = scanner.askMapWidth();
        int mapHeight = scanner.askMapHeight();
        int numberOfMountainRegions = scanner.askNumberOfMountainRegions();
        int numberOfMountains = scanner.askNumberOfMountains();
        int numberOfPitRegions = scanner.askNumberOfPitRegions();
        int numberOfPits = scanner.askNumberOfPits();
        int numberOfMineralPoints = scanner.askNumberOfMineralPoints();
        int numberOfWaterPoints = scanner.askNumberOfWaterPoints();

        MapGenerator mapGenerator = new MapGenerator(fileName, mapWidth, mapHeight);
        mapGenerator.generateMap(numberOfMountainRegions, numberOfMountains, numberOfPitRegions, numberOfPits, numberOfMineralPoints, numberOfWaterPoints);

        System.out.println(Arrays.deepToString(mapGenerator.getMarsMap().getTerrainElements()));

        MapFileWriter.saveMapToFile(mapGenerator.getMarsMap(), fileName);


    }


}
