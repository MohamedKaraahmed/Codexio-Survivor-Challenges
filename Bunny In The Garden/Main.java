package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // "C" - visualized as Carrot and "-" as empty spot
        // Carrots are planted randomly in the garden borders

        try {
            System.out.println("Please, insert the garden size greater than 0!");
            int gardenSize = Integer.parseInt(scanner.nextLine());

            Garden garden = new Garden(gardenSize);

            System.out.println("The maximum carrots, which can be planted in the garden are " + garden.getGardenSize() * garden.getGardenSize());
            System.out.println("Please, insert number of carrots to be planted in the garden, less or equal to " + gardenSize * gardenSize);
            int countCarrotsToBePlanted = Integer.parseInt(scanner.nextLine());

            garden.plantCarrots(countCarrotsToBePlanted);

            Rabbit rabbit = new Rabbit();

            System.out.println("The garden with planted carrots, before the Bunny jumps in");
            garden.printGarden();

            rabbit.collectTheCarrots(garden);
            System.out.println("The garden, after the Bunny has jumped inside and collected all the carrots");
            garden.printGarden();


            System.out.printf("%nBunny collected %d carrots, total jumps, needed to collect all the carrots are: %d", rabbit.getCollectedCarrots(), rabbit.getTotalJumps());
        } catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
