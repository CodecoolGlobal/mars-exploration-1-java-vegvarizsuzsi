package com.codecool.marsexploration.data;

public class TerrainElement {

    private TerrainElementType type;

    public TerrainElement(TerrainElementType type) {
        this.type = type;
    }

    public TerrainElementType getType() {
        return type;
    }

    public void setType(TerrainElementType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TerrainElement{" +
                "type=" + type +
                '}';
    }
}
