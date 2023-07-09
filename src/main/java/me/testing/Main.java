package me.testing;

import me.testing.pieces.Alphabet;

import me.testing.pieces.Grille;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String s = "X-203";
        String t = s.substring(0,s.indexOf("-"));
        System.out.println(s);
        System.out.println(s.substring(0,s.indexOf("-")).getClass().getName());
        System.out.println(t.getClass().getName());
        System.out.println(Alphabet.valueOf(t).ordinal());

        Grille g = new Grille(25);
        System.out.println(g.keyToPosition(s)[0]);
        System.out.println(g.afiche());
    }
}