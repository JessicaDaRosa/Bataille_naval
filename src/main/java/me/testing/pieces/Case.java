/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.testing.pieces;

/**
 *
 * @author Jéssica
 */
public class Case {
    private final int[] position = {0,0};
    private boolean etat;//touche ou pas touche
    private boolean aBateau;// appartient a un bateau ou pas
   
    public Case(int x, int y)
    {
        this.position[0] = x;
        this.position[1] = y;
        this.etat = false;
        this.aBateau = true;
    }
    /**
     * retourne la position de la case sous la forma [x,y]
     * */
    public int[] getPosition()
    {
        return position;
    }
    /**
     * retourne si la case est vide ou pas
     **/
    public boolean isEmpty()
    {
        return this.aBateau;
    }
    /**
     * retoune une cle a partir de la position
    */
    public String getKEy()
    {
        return Alphabet.values()[this.position[1]].toString()+"-"+this.position[0];
    }
    /**
     * change l'etat de la case
     * */
    public void modifEtat()
    {
        etat = !etat;
    }
    /**
     * change la valeur de la case aBateau si elle est a true elle passe a false et l'inverse aussi
    */
    public void remplire()
    {aBateau = !aBateau;
    }
    /**
     * case touche ou pas
     * */
    public boolean getEtat()
    {
        return this.etat;
    }
    
}
