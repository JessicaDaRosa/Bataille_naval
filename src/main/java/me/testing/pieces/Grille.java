/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.testing.pieces;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Jéssica
 */
public class Grille {

    private final Map<String, Case> mer; //tableau avec tout les cases
   
    public Grille(int size) {
        this.mer = creaGrille(size);
    }
    /*genera la grille*/
    @org.jetbrains.annotations.NotNull
    private Map<String, Case> creaGrille(int taille) {
        Map<String, Case> temp = new TreeMap<>();
        for (int i = 0; i < taille; i++) {
            for (int n = 0; n < taille; n++) {
                Case x = new Case(n, i);
                String key = x.getKEy();
                temp.put(key, x);
            }
        }
        return temp;
    }
    /*retourne une case specifique si on lui donne la cle deja sur format string*/
    public Case getCase(String key) {
        return this.mer.get(key);
    }
    /*retourne deux coordenes [x,y] sous forme "Stirng-x" ou y est associe a une valeur alphabetique*/
    public String toKey(int x, int y) {
        String key = "";
        switch (y) {
            case 0:
                key = "A";
                break;
            case 1:
                key = "B";
                break;
            case 2:
                key = "C";
                break;
            case 3:
                key = "D";
                break;
            case 4:
                key = "E";
                break;
            case 5:
                key = "F";
                break;
            case 6:
                key = "G";
                break;
            case 7:
                key = "H";
                break;
            case 8:
                key = "I";
                break;
            case 9:
                key = "J";
                break;
            case 10:
                key = "K";
                break;
        }
        return key + "-" + x;
    }
    /*retourne une cle pour le map a partir d'un String et d'un entier*/
    public String toKey(String y, int x) {
        return y + "-" + x;
    }
    /**renvoi une representation en string du plateau
    * X si la case est vide et a etait touche 
    * ~ si la case est vide et n'a pas etait touche 
    * T si dans la case on a une piece de bateau et qu'il a etait touche
    * B si il y a un bateau
     * @return "(String)y-x"
    */
    public String Afiche() {
        String afficher = " ";
        int lettre = 65;
        for (int i = -1; i < Math.sqrt(this.mer.size()); i++) {
            if (i == -1) {
                for (int n = 0; n < Math.sqrt(this.mer.size()); n++) {
                    afficher = afficher + " " + n;
                }
            } else {
                for (int n = -1; n < Math.sqrt(this.mer.size()); n++) {
                    //si on est a la case -1 on affiche la lettre sinon 
                    if (n == -1) {
                        afficher = afficher + String.valueOf((char) lettre);
                        lettre = lettre +1;
                    } else {
                        Case thing = mer.get(toKey(i, n));
                        if (thing.isEmpty())//there is no boat in this case
                        {
                            if (thing.getEtat())//la case est vide et a etait touche
                            {
                                afficher = afficher + " X";
                            } else // la case est vide et n'a pas etait touche
                            {
                                afficher = afficher + " ~";
                            }
                        } else {
                            if (thing.getEtat())//la case est ocupe et a etait touche
                            {
                                afficher = afficher + " T";
                            } else // la case est ocupe et n'a pas etait touche
                            {
                                afficher = afficher + " B";
                            }
                        }
                    }
                }
            }
            afficher = afficher + "\n";
            
            
        }
        return afficher;
    }
    /*
        simule un tir sur une case
    une fois que la case a etait touche une fois la valeur n'est plus altere
    
    un changement de cette valeur est final
    */
    public void toucheCase(int x, int y)
    {
        String key = toKey(x,y);
        if(!this.mer.get(key).getEtat())
        {
            this.mer.get(key).modifEtat();
        }
    }
    /*
    change la valeur de la case par apport a si on y a mis un bateau ou pas.
    */
    public void addBateauCase(int x,int y)
    {
        String key = toKey(x,y);
        this.mer.get(key).remplire(); 
    }
    
    /**
     *
     * @return
     */
    public Map<String,Case> getGrille()
    {
        return this.mer;
    }
}
