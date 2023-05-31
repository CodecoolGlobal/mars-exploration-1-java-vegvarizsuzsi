package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.MarsMap;
import com.codecool.marsexploration.data.TerrainElementType;

import java.util.List;

public class PatchGenerator {
    private TerrainElementType terrainElementType;
    private int numberOfTerrainElements;
    private MarsMap marsMap;

    public PatchGenerator(TerrainElementType terrainElementType, int numberOfTerrainElements, MarsMap marsMap) {
        this.terrainElementType = terrainElementType;
        this.numberOfTerrainElements = numberOfTerrainElements;
        this.marsMap = marsMap;
    }
    public void generateMountain(){}  //
    public Coordinate pickFirstPosition(){return null;}

    public void putElementOnMap(Coordinate coordinate){
        marsMap.putElementOnMap(coordinate, terrainElementType);
    }

    public List<Coordinate> potentialNextPositions(){
        return null;}

    public Coordinate randomCoordinate(List<Coordinate> potentialNextPositions){
        return null;
    }



}
