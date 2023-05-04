package org.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

public class Garden {
    private int gardenSize;
    private int countCarrotsInTheGarden;
    private String[][] garden;

    public Garden(int gardenSize) {
        setGardenSize(gardenSize);
    }

    private void setGardenSize(int gardenSize) {
        if (gardenSize <= 0) {
            throw new NullPointerException("Garden size cannot be less or equal to zero!");
        }
        this.garden = new String[gardenSize][gardenSize];
        for (int row = 0; row < garden.length; row++) {
            for (int cow = 0; cow < garden.length; cow++) {
                this.garden[row][cow] = "-";
            }
        }
        this.gardenSize = gardenSize;
    }

    public int getGardenSize() {
        return gardenSize;
    }

    public String[][] getGarden() {
        return garden;
    }

    public int getCountCarrotsInTheGarden() {
        return countCarrotsInTheGarden;
    }

    public void plantCarrots(int countCarrotsToBePlanted) {

        int maxGardenCapacity = garden.length * garden.length;

        if (countCarrotsToBePlanted > maxGardenCapacity) {
            throw new IllegalStateException("Count of carrots to be planted, cannot be more than the garden size!");
        }

        countCarrotsInTheGarden = countCarrotsToBePlanted;
        Random randomIndexToPlantCarrot = new Random();
        int plantedCarrots = 0;

        while (plantedCarrots != countCarrotsToBePlanted) {

            int randomRowToPlantCarrot = randomIndexToPlantCarrot.nextInt(garden.length);
            int randomColToPlantCarrot = randomIndexToPlantCarrot.nextInt(garden.length);


            if (garden[randomRowToPlantCarrot][randomColToPlantCarrot].equals("C")) {
                //if current index is filled we take another one
                randomRowToPlantCarrot = randomIndexToPlantCarrot.nextInt(garden.length);
                randomColToPlantCarrot = randomIndexToPlantCarrot.nextInt(garden.length);
                continue;
            }
            //we plant a carrot
            garden[randomRowToPlantCarrot][randomColToPlantCarrot] = "C";
            plantedCarrots++;
        }

    }

    public void printGarden() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < garden.length; row++) {
            for (int col = 0; col < garden[row].length; col++) {
                sb.append(garden[row][col]).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString().trim());

    }

}