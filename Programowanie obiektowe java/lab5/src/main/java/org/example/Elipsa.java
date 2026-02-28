package org.example;

import java.awt.*;

import static java.lang.Math.sqrt;


class Elipsa extends Figura {
        private double a,b,x,y,c;//półoś wielka,polos mala,pozycje x,y dla dwoch ognisk (F1x,F1y,F2x,F2y),odleglosc ognisk od srodka elipsy

    public Elipsa(int pole, int obwod, Color kolor, double a, double b, double x, double y, double c) {
        super(pole, obwod, kolor);
        this.a = a;
        this.b = b;
        this.x = x;
        this.y = y;
        this.c = c;
    }

    public double getA() {
            return a;
        }

        public void setA(double a) {
            this.a = a;
        }

        public double getB() {
            return b;
        }

        public void setB(double b) {
            this.b = b;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public double getC() {
            return c;
        }

        public void setC(double c) {
            this.c = c;
        }

    public Elipsa(int pole, int obwod, Color kolor) {
        super(pole, obwod, kolor);
    }

    public Elipsa() {
        super();
    }

    @Override
    protected void rysuj() {
        super.rysuj();
    }

    @Override
    protected void usuń() {
        super.usuń();
    }

    @Override
    protected void przesuń() {
        super.przesuń();
    }

    @Override
    protected String podajParametry() {
        return super.podajParametry();
    }

    @Override
    public Color getKolor() {
        return super.getKolor();
    }

    @Override
    public int getObwod() {
        return super.getObwod();
    }

    @Override
    public int getPole() {
        return super.getPole();
    }

    @Override
    public void setKolor(Color kolor) {
        super.setKolor(kolor);
    }

    @Override
    public void setObwod(int obwod) {
        super.setObwod(obwod);
    }

    @Override
    public void setPole(int pole) {
        super.setPole(pole);
    }
    public double odlegloscOgniskOdSrodka(double a, double b){
        double c = sqrt((a*a)-(b*b));
        return c;
    }
}
