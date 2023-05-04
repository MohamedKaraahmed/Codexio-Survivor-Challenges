package org.example;

public class Rabbit {
    private int collectedCarrots;
    private int totalJumps;

    public Rabbit() {

    }

    public int collectTheCarrots(Garden garden) {
        for (int i = 0; i < garden.getGarden().length; i++) {
            for (int j = 0; j < garden.getGarden().length; j++) {
                if (garden.getGarden()[i][j].equals("C")) {
                    jumpInGarden(garden.getGarden(), i, j);
                    totalJumps++;
                }
            }
        }
        collectedCarrots = garden.getCountCarrotsInTheGarden();
        return totalJumps;
    }

    private void jumpInGarden(String[][] garden, int row, int col) {

        if (row < 0 || row >= garden.length || col < 0 || col >= garden.length || !garden[row][col].equals("C")) {
            return;
        }
        garden[row][col] = "-";
        jumpInGarden(garden, row + 1, col);
        jumpInGarden(garden, row, col + 1);

    }

    public int getCollectedCarrots() {
        return collectedCarrots;
    }

    public int getTotalJumps() {
        return totalJumps;
    }
}