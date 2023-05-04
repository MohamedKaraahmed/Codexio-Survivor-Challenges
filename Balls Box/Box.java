package org.example;

import java.util.*;

public class Box {
    public int countBallsWeNeedToRemove;
    public int totalCountBallsInTheBox;
    private int hasOnlyOneColorInTheBox;
    private Map<String, Integer> box = new LinkedHashMap<>();

    public Box() {
        countBallsWeNeedToRemove = 0;
        totalCountBallsInTheBox = 0;
        hasOnlyOneColorInTheBox = 0;
    }

    public void putTheBallsInTheBox(Ball ball) {
        box.put(ball.getColor(), ball.getCount());
        hasOnlyOneColorInTheBox++;
    }

    public void removeBalls() {
        OptionalInt minCountBallsInTheBox = OptionalInt.of(0);
        totalCountBallsInTheBox = box.values()
                .stream()
                .mapToInt(ballCount -> ballCount)
                .sum();

        minCountBallsInTheBox = box.values()
                .stream()
                .mapToInt(integer -> integer)
                .min();

        countBallsWeNeedToRemove = totalCountBallsInTheBox - minCountBallsInTheBox.orElse(0);

        if (hasOnlyOneColorInTheBox == 1) {
            System.out.println("We don't need to remove any balls, because we have only one color in the box!");
        } else {
            System.out.printf("The number of balls we need to remove, to stay with one color is: %d%n", countBallsWeNeedToRemove);
        }


    }
}
