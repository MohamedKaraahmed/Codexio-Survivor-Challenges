package org.example;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static Box box;
    private static Scanner scanner;

    public static void main(String[] args) {
        box = new Box();
        scanner = new Scanner(System.in);

        // input format - Color count
        System.out.println("Please, insert color and balls count in the format [Color ballsCount]!");

        String command = scanner.nextLine();
        while (!command.toLowerCase().equals("end")) {
            try {
                if (command.split("\\s+").length < 2) {
                    throw new ArrayIndexOutOfBoundsException("Please, insert color and balls count in the format [Color ballsCount]!");
                }
                String ballColor = command.split("\\s+")[0];
                int countBalls = Integer.parseInt(command.split("\\s+")[1]);

                Ball ball = new Ball(ballColor, countBalls);

                box.putTheBallsInTheBox(ball);
                command = scanner.nextLine();

            } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException ex) {
                System.out.println(ex.getMessage());
                command = scanner.nextLine();
            }
        }
        box.removeBalls();
    }
}


