package me.testing;

import me.testing.pieces.Case;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Case c = new Case(3,4);
        System.out.println(c.getPosition()[0]);
    }
}