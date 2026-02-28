public class Main {
    public static void main(String[] args) {
        Dziecko dziecko = new Dziecko() {
            @Override
            public void zabawa() {

            }

            @Override
            public void obowiazki() {

            }
        };
        Dorosly dorosly = new Dorosly() {
            @Override
            public void zabawa() {

            }

            @Override
            public void obowiazki() {

            }
        };
        Uczen uczen = new Uczen();
        Student student = new Student();
        Emeryt emeryt = new Emeryt();

        dziecko.jedz();
        dziecko.pij();
        System.out.println("Wiek dziecka: "+ dziecko.ileLat());


        dorosly.cechy();
        dorosly.jedz();
        System.out.println("Wiek doroslego: "+dorosly.ileLat());

        uczen.spij();
        uczen.jedz();
        uczen.uczSie();
        System.out.println("Wiek ucznia"+uczen.ileLat());

        student.spij();
        student.spij();
        student.spij();
        student.nieIdzNaZajecia();
        student.spij();

        emeryt.idzDoLekarza();
        emeryt.idzDoLekarza();
        emeryt.idzDoLekarza();
        emeryt.idzDoLekarza();


    }
}