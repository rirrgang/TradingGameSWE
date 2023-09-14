package code;


import javafx.fxml.FXML;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Spiel {

    public int tageszaehler = 1;

    public List<Ware> angeboteDorf = new ArrayList<Ware>(
            Arrays.asList(
            new Ware("Weizen",1,2,2,'D',0),
            new Ware("Mais",1.5,3,3,'D',0),
            new Ware("Kartoffeln",1,2,2,'D',0),
            new Ware("Rüben",0.5,1,1,'D',0)
            ));

    public List<Ware> angeboteStadt = new ArrayList<Ware>(
            Arrays.asList(
            new Ware("Bohnen mit Speck",1,1,0,'S',0),
            new Ware("Töpfe",2,3,3,'S',0),
            new Ware("Geschirr",1,2,2,'S',0),
            new Ware("Hacke",3,5,5,'S',0),
            new Ware("Hammer",2,4,4,'S',0),
            new Ware("Säge",2,3,3,'S',0)
    ));

    public List<Ort> orte = new ArrayList<Ort>(
            Arrays.asList(
            new Ort("Bielefeld",'S',new Taetigkeit("Hilfstätigkeit", 15), angeboteStadt, new LokalesEssen("Klöse mit Schwein", 2), new Point(3,3)),
            new Ort("Auenheim",'D',new Taetigkeit("Feldarbeit", 10), angeboteDorf, new LokalesEssen("Kartoffelkuchen", 1), new Point(1,2)),
            new Ort("Kohlbach",'D',new Taetigkeit("Feldarbeit", 9), angeboteDorf, new LokalesEssen("Kohl mit Rüben", 1), new Point(3,1)),
            new Ort("Rippershausen",'D',new Taetigkeit("Feldarbeit", 11), angeboteDorf, new LokalesEssen("Döner Kebab", 1) , new Point(4,2)),
            new Ort("Sushifeld",'D',new Taetigkeit("Feldarbeit", 10), angeboteDorf, new LokalesEssen("Fisch mit Lachs", 1), new Point(6,0)),
            new Ort("Helenbach",'D',new Taetigkeit("Feldarbeit", 8), angeboteDorf, new LokalesEssen("Leipziger Allerlei", 1), new Point(2,5))
            ));

    public List<Ware> invent = new ArrayList<Ware>(
            Arrays.asList(
            new Ware("Bohnen mit Speck",0,1,0,'S',0) ,
            new Ware("Töpfe",0,3,3,'S',0),
            new Ware("Geschirr",0,2,2,'S',0) ,
            new Ware("Hacke",0,5,5,'S',0)  ,
            new Ware("Hammer",0,4,4,'S',0),
            new Ware("Säge",0,3,3,'S',0)   ,
            new Ware("Weizen",0,2,2,'D',0)  ,
            new Ware("Mais",0,3,3,'D',0)   ,
            new Ware("Kartoffeln",0,2,2,'D',0),
            new Ware("Rüben",0,2,2,'D',0)
            ));

    public Spieler player = new Spieler(100,100,0,orte.get(0),invent);

    public boolean endeAbfragen(){
        if ( tageszaehler>100 || player.getLeben()>100 || player.getLeben()<0 )
        {
            System.out.println("Game Over");
            return true;
        }return false;
    }

    public void reiseNach(int ortNr2) {
        int a = 0;
        int gegessen = 0;
        List<Ort> neueOrte = new ArrayList<Ort>();

        for (int i=1; i<orte.size()+1; i++) {
                neueOrte.add(orte.get(i - 1));
        }

        int ortNr = ortNr2;
        for (int i=1;i<Math.round(getReisedauer(player, neueOrte.get(ortNr))); i++){  //von 1 bis Reisedauer
            tageszaehler++;
            player.decLeben();

            if (player.getInventar().get(0).getMenge()>0){
                player.incLeben();
                player.getInventar().get(0).setMenge(player.getInventar().get(0).getMenge() - 1 );
                player.verringereTragelast(player.getInventar().get(0).getGewicht());
                gegessen++;
            }

        }
        tagWechseln();
        if (player.getInventar().get(0).getMenge()>0){
            player.incLeben();
            player.getInventar().get(0).setMenge(player.getInventar().get(0).getMenge() - 1 );
            player.verringereTragelast(player.getInventar().get(0).getGewicht());
            gegessen++;
        }

        player.letzteReisedauer=(int) Math.round(getReisedauer(player, neueOrte.get(ortNr)));  // für später wenn man den Einkaufspreis in der Staadt berechnen muss
        // tageszaehler=tageszaehler+(int)(Math.round(getReisedauer(player, neueOrte.get(ortNr)))-1);   // -1 weil Tageswechsel() noch ausgeführt wird, was den Tag auch +1 erhöht

        player.setStandort(neueOrte.get(ortNr));

        // --> eventuell für Status-View System.out.println("Du hast auf deiner Reise " + gegessen + " Bohnen mit Speck verbraucht.");

    }


    public double getReisedauer(Spieler s, Ort o){
        double a=o.getPosition().getX() - s.getStandort().getPosition().getX();
        double b=o.getPosition().getY() - s.getStandort().getPosition().getY();
        double reisedauer = Math.sqrt(a*a + b*b);
        return reisedauer;
    }

    public void incTag(){
        tageszaehler+=1;
    }

    public void tagWechseln(){
        if ( tageszaehler>100 || player.getLeben()>100 || player.getLeben()<0 )
        {
            System.out.println("GAME OVER");
        }else {
            player.decLeben();
            incTag();
            player.interesseAkt();
            player.getStandort().taetigkeitenAkt();
            player.taetigkeitGesperrt = false;
            player.kaufGesperrt = false;
            player.verkaufGesperrt = false;
        }
    }


    public void arbeiten() {

            player.setGold(player.getGold() + player.getStandort().getTaetigkeit().getLohn());
            tagWechseln();

        }
}
