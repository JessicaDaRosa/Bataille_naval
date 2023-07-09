/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.testing.pieces;

import java.util.Map;
import java.util.Objects;
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
                temp.put(x.getKEy(), x);
            }
        }
        return temp;
    }
    /**
     * retourne une case specifique si on lui donne la cle deja sur format string
     * @param key String
     * */
    public Case getCase(String key) {
        return this.mer.get(key);
    }
    /**
    *retourne deux coordenes [x,y] sous forme "Stirng-x" ou y est associe a une valeur alphabetique
    */
    public String toKey(int x, int y) {
        return Alphabet.values()[y].toString() + "-" + x;
    }
    /**retourne une cle pour le map a partir d'un String et d'un entier
     * @param x
     * @param y
     * */
    public String toKey(String y, int x) {
        return y + "-" + x;
    }

    public int[] keyToPosition(String key){
        int[] position = {0,0};
        if(key.contains("-")){
            String y = key.substring(0,key.indexOf("-"));
            if(y.length() > 1)
                return null;
            String x = key.substring(key.indexOf("-")+1, key.length());
            position[0] = Integer.parseInt(x);
            position[1] = Alphabet.valueOf(y).ordinal();
        }else{
            String y = key.substring(0,1);
            String x = key.substring(1, key.length());
            position[0] = Integer.parseInt(x);
            position[1] = Alphabet.valueOf(y).ordinal();
        }
        return position;
    }
    /**renvoi une representation en string du plateau
    * X si la case est vide et a etait touche 
    * ~ si la case est vide et n'a pas etait touche 
    * T si dans la case on a une piece de bateau et qu'il a etait touche
    * B si il y a un bateau
     * @return String
    */
    public String afiche() {
        StringBuilder afficher = new StringBuilder(" ");
        int lettre = 65;
        for (int i = -1; i < Math.sqrt(this.mer.size()); i++) {
            if (i == -1) {
                for (int n = 0; n < Math.sqrt(this.mer.size()); n++) {
                    afficher.append(" " + n);
                }
            } else {
                Case aCase;
                for (int n = -1; n < Math.sqrt(this.mer.size()); n++) {
                    //si on est a la case -1 on affiche la lettre sinon 
                    if (n == -1) {
                        afficher.append(String.valueOf((char) lettre));
                        lettre = lettre +1;
                    } else {
                        aCase = mer.get(toKey(i, n));
                        if(n>9){
                            if (!aCase.isEmpty())//there is no boat in this case
                            {
                                if (aCase.getEtat())//la case est vide et a etait touche
                                {
                                    afficher.append(" X ");
                                } else // la case est vide et n'a pas etait touche
                                {
                                    afficher.append(" ~~");
                                }
                            } else {
                                if (aCase.getEtat())//la case est ocupe et a etait touche
                                {
                                    afficher.append(" T ");
                                } else // la case est ocupe et n'a pas etait touche
                                {
                                    afficher.append(" B ");
                                }
                            }
                        }
                        else {
                            if (!aCase.isEmpty())//there is no boat in this case
                            {
                                if (aCase.getEtat())//la case est vide et a etait touche
                                {
                                    afficher.append(" X");
                                } else // la case est vide et n'a pas etait touche
                                {
                                    afficher.append(" ~");
                                }
                            } else {
                                if (aCase.getEtat())//la case est ocupe et a etait touche
                                {
                                    afficher.append(" T");
                                } else // la case est ocupe et n'a pas etait touche
                                {
                                    afficher.append(" B");
                                }
                            }
                        }
                    }
                }
            }
            afficher.append("\n");
        }
        return afficher.toString();
    }
    /**
     simule un tir sur une case
     une fois que la case a etait touche une fois la valeur n'est plus altere
     un changement de cette valeur est final
     @param x position x
     @param y position y
     */
    public void toucheCase(int x, int y)
    {
        String key = toKey(x,y);
        if(!this.mer.get(key).getEtat())
        {
            this.mer.get(key).modifEtat();
        }
    }
    /**
    * change la valeur de la case par apport a si on y a mis un bateau ou pas.
     * @param y
     * @param x
    */
    public boolean addBateauCase(int x,int y)
    {
        Case c = this.mer.get(toKey(x,y));
        if(c != null){
            this.mer.get(toKey(x,y)).remplire();
            c=null;
            return true;
        }
        return false;
    }

    public boolean removeBateau(int x, int y){
        Case c = this.mer.get(toKey(x,y));
        if(c != null){
            this.mer.get(toKey(x,y)).vider();
            c = null;
            return true;
        }
        return false;
    }
    
    /**
     *
     * @return
     */
    public Map<String,Case> getGrille()
    {
        return this.mer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grille grille)) return false;
        return Objects.equals(mer, grille.mer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mer);
    }
}
