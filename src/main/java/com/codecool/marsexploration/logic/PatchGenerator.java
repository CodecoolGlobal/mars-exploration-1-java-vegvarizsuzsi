package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.MarsMap;
import com.codecool.marsexploration.data.TerrainElement;
import com.codecool.marsexploration.data.TerrainElementType;

import java.util.List;
import java.util.Random;

public class PatchGenerator {
    private TerrainElementType terrainElementType;
    private int numberOfTerrainElements;
    private MarsMap marsMap;
    Random random;

    public PatchGenerator(TerrainElementType terrainElementType, int numberOfTerrainElements, MarsMap marsMap) {
        this.terrainElementType = terrainElementType;
        this.numberOfTerrainElements = numberOfTerrainElements;
        this.marsMap = marsMap;
    }
    public void generateMountain(){
        putElementOnMap(pickFirstPosition());
    }
    public Coordinate pickFirstPosition(){
        int randomX = random.nextInt(marsMap.getWidth());
        int randomY = random.nextInt(marsMap.getHeight());
        return new Coordinate(randomX, randomY);
    }

    public void putElementOnMap(Coordinate coordinate){
        marsMap.putElementOnMap(coordinate, terrainElementType);
    }

    public List<Coordinate> potentialNextPositions(){
        for (int x = 0; x < marsMap.getWidth(); x++) {
            for (int y = 0; y < marsMap.getHeight(); y++) {
                if (marsMap.getTerrainElements()[x][y].getType() == TerrainElementType.EMPTY
                && )
                 ;
            }
        }
        return null;}

    public Coordinate randomCoordinate(List<Coordinate> potentialNextPositions){
        return null;
    }



}
