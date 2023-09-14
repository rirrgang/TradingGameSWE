/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.util.List;

/**
 *
 * @author Nutzer
 */
public class Ort {
    String name;
    char typ;
     Taetigkeit taetigkeit;
    List<Ware> angebote;
    LokalesEssen Essen;
    Point position;

    public Ort(String name, char typ, Taetigkeit taetigkeit, List<Ware> angebote, LokalesEssen Essen, Point position){
        this.name=name;
        this.typ=typ;
        this.taetigkeit=taetigkeit;
        this.angebote=angebote;
        this.Essen=Essen;
        this.position=position;
        
    }

    public void taetigkeitenAkt() {
        int rand=(int)(Math.random()*2);  // 0 oder 1 
        if (rand==0){ 
        taetigkeit.setVerfügbar(false);}
        
        if (rand==1) {
        taetigkeit.setVerfügbar(true);}
    }
  /*  public void interesseAkt(){
        for (int i= 0; i<angebote.size();i++){ 
            
            int randi=(int)(Math.random()*3); // 0 bis 2 = Multiplikator
            angebote.get(i).setInteresse(randi);
        }
    } */
    // brechneReisedauer() ??
    
    public String getName() {
        return name;
    }

    public char getTyp() {
        return typ;
    }

    public Taetigkeit getTaetigkeit() {
        return taetigkeit;
    }

    public List<Ware> getAngebote() {
        return angebote;
    }

    public LokalesEssen getEssen() {
        return Essen;
    }
    public Point getPosition() {
        return position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
    
   
}
