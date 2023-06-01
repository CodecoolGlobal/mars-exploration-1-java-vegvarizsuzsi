package com.codecool.marsexploration.data;

public enum TerrainElementType {

        EMPTY(" "),

        MOUNTAIN("^"),
        PIT("#"),
        WATER("~"),
        MINERAL("*");

        private final String symbol;

        TerrainElementType(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }


}
