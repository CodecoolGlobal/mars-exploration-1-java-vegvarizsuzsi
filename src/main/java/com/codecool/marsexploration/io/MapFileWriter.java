package com.codecool.marsexploration.io;

import com.codecool.marsexploration.data.MarsMap;
import com.codecool.marsexploration.data.TerrainElement;
import com.codecool.marsexploration.data.TerrainElementType;

import java.io.FileWriter;
import java.io.IOException;

public class MapFileWriter {

    public static void saveMapToFile(MarsMap marsMap, String fileName) {

        try (FileWriter writer = new FileWriter(fileName)) {
            TerrainElement[][] terrainElements = marsMap.getTerrainElements();
            for (int x = 0; x < terrainElements.length; x++) {
                for (int y = 0; y < terrainElements[x].length; y++) {
                    TerrainElementType terrainElement = terrainElements[x][y].getType();
                    writer.write(terrainElement.getSymbol());
                }
                writer.write("\n");
            }
            System.out.println("Map saved to " + fileName);

        } catch (IOException e) {
            System.out.println("Failed to save map to file: " + e.getMessage());
        }
    }

}
