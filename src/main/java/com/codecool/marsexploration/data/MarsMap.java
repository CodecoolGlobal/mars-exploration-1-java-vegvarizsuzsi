package com.codecool.marsexploration.data;

import java.util.Arrays;

public class MarsMap {
    private String fileName;
    private int width;
    private int height;
    private TerrainElement[][] terrainElements;

    public TerrainElement[][] getTerrainElements() {
        return terrainElements;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public MarsMap(String fileName, int width, int height) {
        this.fileName = fileName;
        this.width = width;
        this.height = height;
        terrainElements = new TerrainElement[width][height];
        initializeEmptyMap();

    }

    private void initializeEmptyMap() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                terrainElements[x][y] = new TerrainElement(TerrainElementType.EMPTY);
            }
        }
    }

    public void putElementOnMap(Coordinate coordinate, TerrainElementType terrainElementType){
        terrainElements[coordinate.x()][coordinate.y()].setType(terrainElementType);
    }

    public boolean isCoordinateEmpty(Coordinate coordinate) {
        return terrainElements[coordinate.x()][coordinate.y()].getType() == TerrainElementType.EMPTY;
    }

    public boolean isWithInBound(int x, int y) {
        return x >= 0 && y >= 0 && x < width && y < height;
    }

    @Override
    public String toString() {
        return "MarsMap{" +
                "fileName='" + fileName + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", terrainElements=" + Arrays.toString(terrainElements) +
                '}';
    }
}
