/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.testing.pieces;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jéssica
 */
public class Bateau{
    protected final int nbCases;
    protected String name;
    protected int direction;
    protected List<String> casesTouches;//liste des cases qui on été touches
    protected final List<String> position;//liste des cles des cases occupées

    public Bateau(String name, int nbDeCases)
    {
        this.name = name;
        this.nbCases = nbDeCases;
        this.casesTouches = new ArrayList<>();
        this.position = new ArrayList<>();
        this.direction = 0;
    }

    public String getName(){
        return this.name;
    }
    /**
     * retourne le nombre de cases qui ocupe un bateau
     * @return int
     */
    public int getNbCases() {
        return this.nbCases;
    }

    /**
     *  retourne le nombre de cases qui on etait touches dans le bateau
     * @return int
     */
    public int getNbCasesTouches() {
        return this.casesTouches.size();
    }

    /**
     *
     * @param nvlCase
     */
    public void addCaseTouche(String nvlCase)
    {
        this.casesTouches.add(nvlCase);
    }
    /**
     * nous dis si le bateau a coulée ou pas
     * @return bool
     */
    public boolean aCoulee(){
        return casesTouches.size() == position.size();
    }

    /**
     * positione le bateau ou sinon repositione le bateau s'il est deja em place
     * @param position List<String>
     * @return bool
     */
    public boolean placerBateau(@NotNull List<String> position){
        if(!position.isEmpty())
            this.position.clear();
        return this.position.addAll(position);
    }

    /**
     * enleve la positio ai bateau qui a été retirée
     */
    public void removeBateau(){
        this.position.clear();
    }

}
