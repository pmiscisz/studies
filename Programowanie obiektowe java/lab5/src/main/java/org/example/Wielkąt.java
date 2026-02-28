package org.example;

import java.awt.*;

class Wielkąt extends Figura{
        private int liczbaWierzcholkow,liczbaBokow,sumaKatowWewnetrznych;

    public Wielkąt(int pole, int obwod, Color kolor, int liczbaWierzcholkow, int liczbaBokow, int sumaKatowWewnetrznych) {
        super(pole, obwod, kolor);
        this.liczbaWierzcholkow = liczbaWierzcholkow;
        this.liczbaBokow = liczbaBokow;
        this.sumaKatowWewnetrznych = sumaKatowWewnetrznych;
    }

    public int getLiczbaWierzcholkow() {
            return liczbaWierzcholkow;
        }

        public int getLiczbaBokow() {
            return liczbaBokow;
        }

        public int getSumaKatowWewnetrznych() {
            return sumaKatowWewnetrznych;
        }

        public void setLiczbaWierzcholkow(int liczbaWierzcholkow) {
            this.liczbaWierzcholkow = liczbaWierzcholkow;
        }

        public void setLiczbaBokow(int liczbaBokow) {
            this.liczbaBokow = liczbaBokow;
        }

        public void setSumaKatowWewnetrznych(int sumaKatowWewnetrznych) {
            this.sumaKatowWewnetrznych = sumaKatowWewnetrznych;
        }
        public int SumaKatowWewnetrzynch(int n){
            int sumaKatow = (n-2)*180;
            return sumaKatow;
        }
    }
