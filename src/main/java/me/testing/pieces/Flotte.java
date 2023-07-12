package me.testing.pieces;
import java.util.HashMap;

public class Flotte {
    private HashMap<Integer, Bateau> flotte;

    public Flotte() {
        this.flotte = new HashMap<Integer, Bateau>();
        Bateau temp = new PorteAvions();
        flotte.put(temp.hashCode(), temp);
        temp = new SousMarin();
        flotte.put(temp.hashCode(), temp);
        temp = new Cuirassee();
        flotte.put(temp.hashCode(), temp);
        temp = new Cuirassee();
        flotte.put(temp.hashCode(), temp);
        temp = new Zodiac();
        flotte.put(temp.hashCode(), temp);
    }

}
