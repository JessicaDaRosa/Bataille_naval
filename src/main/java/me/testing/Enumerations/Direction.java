package me.testing.Enumerations;

public enum Direction {
    HORIZONTAL(1), VERTICAL(2);

    private final int direction;
    Direction(int number) {
        this.direction = number;
    }

    public int getDirection(){
        return this.direction;
    }

}
