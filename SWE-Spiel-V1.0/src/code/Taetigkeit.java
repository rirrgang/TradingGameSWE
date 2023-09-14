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
public class Taetigkeit  {
    public String name;
    public int lohn;
    public boolean verfügbar;
    
    public Taetigkeit(String name, int lohn){
        this.name=name;
        this.lohn=lohn;
        verfügbar=false;
    }

    public String getName() {
        return name;
    }

    public int getLohn() {
        return lohn;
    }

    public boolean isVerfügbar() {
        return verfügbar;
    }

    public void setName(String name) {
        this.name=name;;
    }

    public void setLohn(int lohn) {
        this.lohn = lohn;
    }

    public void setVerfügbar(boolean verfügbar) {
        this.verfügbar = verfügbar;
    }
    
    
}
