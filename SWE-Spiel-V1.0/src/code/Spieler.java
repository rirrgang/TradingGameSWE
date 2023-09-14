/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Nutzer
 */
public class Spieler {
    Scanner read = new Scanner(System.in);
    Scanner readStr = new Scanner(System.in);
    public int gold;
    public int leben;
    public double tragelast;
    Ort standort;
    List<Ware>inventar;
    int letzteReisedauer;
    
    boolean verkaufGesperrt=false;
    boolean kaufGesperrt=false;
    boolean taetigkeitGesperrt=false;
    
    public Spieler(int gold, int leben, double tragelast, Ort standort, List<Ware>inventar){
        this.gold=gold;
        this.leben=leben;
        this.tragelast=tragelast;
        this.inventar=inventar;
        this.standort=standort;
    }

    public void incLeben(){
        leben+=20;
    }
    public void decLeben(){
        leben-=20;
    }
    public void essenInventar(int anzahl){
        if (inventar.get(0).getMenge()>=anzahl) {
            for (int i = 0; i<anzahl; i++){
                inventar.get(0).setMenge(inventar.get(0).getMenge() - 1);
                incLeben();
            }
        }

    }
    public void essenLokal(int anzahl){

            for (int i = 0; i<anzahl; i++){
                    incLeben();
                    gold = gold - standort.getEssen().getPreis();
            }
    }

    public boolean pruefeGold(int wert){
       return gold-wert>=0;  // wenn rest >= 0 true, else false
    }
    public boolean pruefeTragelast(double gewicht){
        return 100 - (tragelast + gewicht)>0;
    }

    public void erhoeheInventar(Ware w, int menge){
        for (int i=0; i<inventar.size();i++){
            if (inventar.get(i).getName().equals(w.getName())) {
                inventar.get(i).setMenge(inventar.get(i).getMenge()+ menge);
                inventar.get(i).setGewicht(getStandort().getAngebote().get(i).getGewicht());
            }
        }
    }
     public void verringereInventar(Ware w, int menge){
        for (int i=0; i<inventar.size();i++){
            if (inventar.get(i).getName().equals(w.getName())) {
                inventar.get(i).setMenge(inventar.get(i).getMenge()- menge);
            }
        }
    }
    public void reduziereGold(int wert){
        gold-=wert;
    }
    public void erhoeheGold(int wert){
        gold+=wert;
    }
    
    /*public void arbeiten(){
        starteTaetigkeit(standort.getTaetigkeit());
    }
    public void starteTaetigkeit(Taetigkeit t){
        erhoeheGold(t.getLohn());
        //tagWechseln();
    } */
    
    public boolean kaufen(int wareNr, int kaufmenge){
        
        wareNr=wareNr;
        kaufmenge=kaufmenge;
        boolean kaufOK=false; 
        if (pruefeGold(standort.getAngebote().get(wareNr).getEinkaufspreis()*kaufmenge)==true  && pruefeTragelast(standort.getAngebote().get(wareNr).getGewicht()*kaufmenge)==true){
        kaufOK = true;}
        
        if (kaufOK==true) {
            reduziereGold(standort.getAngebote().get(wareNr).getEinkaufspreis()*kaufmenge);
            erhoeheInventar(standort.getAngebote().get(wareNr), kaufmenge); // yeaaahh
            erhoeheTragelast(standort.getAngebote().get(wareNr).getGewicht()*kaufmenge);
            return true;
        }
        else {
            return false;
        }
        
        
    }
    public void interesseAkt(){
        for (int i= 0; i<inventar.size();i++){ 
            
            int randi=(int)(Math.random()*3); // 0 bis 2 = Multiplikator
            inventar.get(i).setInteresse(randi);
        }
    }
    
    public boolean verkaufen(int wNr, int vm){
        
        if (standort.typ=='S'){

        for (int i=6; i<inventar.size(); i++) {
            //--> BRAUCH ICH FÜR DIE ANZEIGE DER PREISE! System.out.print(i-5  + ".:  " + inventar.get(i).getName() + "\t\t" + Math.ceil(inventar.get(i).getVerkaufspreis()*(1 + 0.1 * letzteReisedauer)) + " Gold" + "\t\t Anzahl: " + inventar.get(i).getMenge());
        }

        int wareNr = wNr;
        int verkaufmenge=vm;

        boolean verkaufOK = verkaufmenge <= inventar.get(wareNr).getMenge();
        if (verkaufOK==true){
                erhoeheGold((int) Math.ceil(inventar.get(wareNr).getVerkaufspreis()*(1 + 0.1 * letzteReisedauer)) * verkaufmenge );
                verringereInventar(inventar.get(wareNr), verkaufmenge); // yeaaahh
                verringereTragelast(inventar.get(wareNr).getGewicht()*verkaufmenge);
            System.out.println("Warengewicht: "+inventar.get(wareNr).getGewicht());
                if (verkaufmenge>0) { kaufGesperrt=true;    taetigkeitGesperrt=true;}
                return true;
            }
        }

        
        else { //Dorf

            for (int i=1; i<6; i++){
            //System.out.println(i  + ".:  " + inventar.get(i).getName() + "\t\t" + inventar.get(i).getVerkaufspreis() + " Gold x " + inventar.get(i).getInteresse()  + "\t\t\t " + inventar.get(i).getMenge());
            }
            int wareNr = wNr;
            int verkaufmenge=vm;
        
            boolean verkaufOK = verkaufmenge <= inventar.get(wareNr).getMenge();
            if (verkaufOK==true){
                erhoeheGold(inventar.get(wareNr).getVerkaufspreis()*inventar.get(wareNr).getInteresse()*verkaufmenge);
                verringereInventar(inventar.get(wareNr), verkaufmenge); // yeaaahh
                verringereTragelast(inventar.get(wareNr).getGewicht()*verkaufmenge);
                return true;
            }
        }return false;
    }
        
      
   
        
    
    
    public void erhoeheTragelast(double wert){
            tragelast+=wert;
        }
    public void verringereTragelast(double wert){
        //System.out.println("Wert "+wert);
        //System.out.println("Alte Tragelast: "+tragelast);
            this.tragelast-=wert;
        //System.out.println("Neue Tragelast: "+tragelast);
        }
    
    public void setStandort(Ort x){
        standort=x;
    }
    public Ort getStandort(){
        return standort;
    }
    
    
    
    
    // --------  Getter, Setter  ------------
    public int getGold() {
        return gold;
    }

    public int getLeben() {
        return leben;
    }

    public double getTragelast() {
        return tragelast;
    }

    public List<Ware> getInventar() {
        return inventar;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setLeben(int leben) {
        this.leben = leben;
    }

    public void setTragelast(double tragelast) {
        this.tragelast = tragelast;
    }

    public void setInventar(List<Ware> inventar) {
        this.inventar = inventar;
    }
    
    
}
