/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

/**
 *
 * @author Nutzer
 */
public class Ware {
    String name;
    double gewicht;
    int einkaufspreis;
    int verkaufspreis;
    char typ;
    int menge;
    int interesse;
    
    public Ware(String name, double gewicht, int einkaufspreis, int verkaufspreis, char typ, int menge){
       this.name=name;
       this.gewicht=gewicht;
       this.einkaufspreis=einkaufspreis;
       this.verkaufspreis=verkaufspreis;
       this.typ=typ;
       this.menge=menge;
       interesse=1;
    }

    public String getName() {
        return name;
    }

    public double getGewicht() {
        return gewicht;
    }

    public int getEinkaufspreis() {
        return einkaufspreis;
    }

    public int getVerkaufspreis() {
        return verkaufspreis;
    }

    public char getTyp() {
        return typ;
    }

    public int getMenge() {
        return menge;
    }

    public int getInteresse() {
        return interesse;
    }

    public void setInteresse(int interesse) {
        this.interesse = interesse;
    }
    

    public void setName(String name) {
        this.name = name;
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }

    public void setEinkaufspreis(int einkaufspreis) {
        this.einkaufspreis = einkaufspreis;
    }

    public void setVerkaufspreis(int verkaufspreis) {
        this.verkaufspreis = verkaufspreis;
    }

    public void setTyp(char typ) {
        this.typ = typ;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }
    
    
}
