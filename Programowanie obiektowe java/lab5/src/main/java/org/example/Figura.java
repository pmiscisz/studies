package org.example;
import java.awt.Color;

public class Figura  {
    protected int pole,obwod;
   private Color kolor;

   public Figura(int pole,int obwod,Color kolor){
       this.kolor=kolor;
       this.pole=pole;
       this.obwod=obwod;
   }
   public Figura(){

   }

    protected void rysuj() {

    }

    protected void usuń(){

    }

    protected void przesuń(){

    }

    protected String podajParametry(){
    return "";
    }

    public Color getKolor() {
        return kolor;
    }

    public int getObwod() {
        return obwod;
    }

    public int getPole() {
        return pole;
    }

    public void setKolor(Color kolor) {
        this.kolor = kolor;
    }

    public void setObwod(int obwod) {
        this.obwod = obwod;
    }

    public void setPole(int pole) {
        this.pole = pole;
    }
}
