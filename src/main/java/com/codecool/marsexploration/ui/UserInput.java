package com.codecool.marsexploration.ui;

import java.util.Scanner;

public class UserInput {

    private final Scanner scanner = new Scanner(System.in);

    public String askFileName() {
        System.out.print("Enter the file name: ");
        return scanner.nextLine();
    }
    public int askMapWidth() {
        System.out.print("Enter the width of the map: ");
        return scanner.nextInt();
    }

    public int askMapHeight() {
        System.out.print("Enter the height of the map: ");
        return scanner.nextInt();
    }

    public int askNumberOfMountainRegions() {
        System.out.print("Enter the number of mountain regions: ");
        return scanner.nextInt();
    }

    public int askNumberOfMountains() {
        System.out.print("Enter the number of mountains: ");
        return scanner.nextInt();
    }

    public int askNumberOfPitRegions() {
        System.out.print("Enter the number of pit regions: ");
        return scanner.nextInt();
    }

    public int askNumberOfPits() {
        System.out.print("Enter the number of pits: ");
        return scanner.nextInt();
    }

    public int askNumberOfMineralPoints() {
        System.out.print("Enter the number of mineral points: ");
        return scanner.nextInt();
    }

    public int askNumberOfWaterPoints() {
        System.out.print("Enter the number of water points: ");
        return scanner.nextInt();
    }

}
