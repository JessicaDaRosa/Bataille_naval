/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.testing.pieces;

import java.util.ArrayList;

/**
 *
 * @author Jéssica
 */
public class Bateau{
    private final int nbCases;
    public String name;
    private ArrayList<String> casesTouches;
    private ArrayList<String> position;//liste des cles des cases touchées

    public Bateau(String name, int nbDeCases)
    {
        this.name = name;
        this.nbCases = nbDeCases;
        this.casesTouches = new ArrayList<>();
        this.position = new ArrayList<>();
    }

    //retourne le nombre de cases qui ocupe un bateau
    public int getNbCases() {
        return this.nbCases;
    } 

    // retournele nombre de cases qui on etait touches dans le bateau
    public int getNbCasesTouches() {
        return this.casesTouches.size();
    }

    public void setNbCasesTouches(ArrayList<String> nb) {
        this.casesTouches = nb;
    }

    public void addCaseTouche(String nvlCase)
    {
        this.casesTouches.add(nvlCase);
    }

}
