package me.testing.pieces;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class GrilleTest {

    @Test
    public void getCase(){
        Grille g = new Grille(9);
        Case c = new Case(3,4);
        Assertions.assertEquals(c, g.getCase("E-3"));
    }

    @Test
    public void affiche(){
        Grille g = new Grille(3);
        Assertions.assertTrue(g.afiche().contains(" ~ ~ ~"));
    }

    @Test
    public void toucheCase(){
        Grille g = new Grille(3);
        Case c = new Case(1,1);
        c.modifEtat();
        g.toucheCase(1,1);
        Assertions.assertEquals(c, g.getCase("B-1"));
    }
    @Test
    public void addBateau(){
        Grille g = new Grille(3);
        Case c = new Case(1,1);
        c.remplire();
        g.addBateauCase(1,1);
        Assertions.assertEquals(c, g.getCase("B-1"));
    }

}
