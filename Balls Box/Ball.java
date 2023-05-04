package org.example;

public class Ball {
    private String color;
    private int count;

    public Ball(String color, int countBalls) {
        setColor(color);
        setCount(countBalls);
    }

    public void setColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("Color cannot be null or empty!");
        }
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("Count balls cannot be less or equal to zero, please enter a new count!");
        }
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }


}
