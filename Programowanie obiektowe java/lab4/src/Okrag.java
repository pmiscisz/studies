import java.util.Random;

class Okrag {
    private int x,y;
    private double promien;

    public Okrag(){
        Random rnd = new Random();
        this.x = rnd.nextInt(91)+5;
        this.y = rnd.nextInt(91)+5;
        this.promien = rnd.nextInt(6)+1;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public double getPromien(){
        return promien;
    }
    public static Okrag[] tworzenieTablicyOkregow(int iloscOkregow){
        Okrag[] tablicaOkregow = new Okrag[iloscOkregow];
        for(int i = 0;i< iloscOkregow;i++){
            tablicaOkregow[i] = new Okrag();
        }
        return tablicaOkregow;
    }
    public static String sprawdzaniePolozenia(Okrag okrag1,Okrag okrag2){
        double odlegloscMiedzySrodkami = Math.sqrt(Math.pow(okrag1.getX() - okrag2.getX(), 2)
                + Math.pow(okrag1.getY() - okrag2.getY(), 2));
        double sumaPromieni = okrag1.getPromien() + okrag2.getPromien();

        if (odlegloscMiedzySrodkami < sumaPromieni) {
            return "Okregi przecinaja sie";
        } else if (odlegloscMiedzySrodkami == sumaPromieni) {
            return "Okregi sa styczne";
        } else if (odlegloscMiedzySrodkami > sumaPromieni) {
            return "Okregi sa rozlaczne";
        } else {
            return "Okregi pokrywaja sie";
        }
    }
    public static void wyswietlPolaOkregu(Okrag[] tablicaOkregow) {
        int i =0;
        for (Okrag okrag : tablicaOkregow) {
            System.out.println("Okrag "+ i );
            System.out.print("Wspolzedna x: "+okrag.x);
            System.out.print(" Wspolzedna y: "+okrag.y);
            System.out.print(" Promien: "+okrag.promien + "\n");
            i++;
        }
    }



    public static void main(String[]args){
        int iloscOkregow = 3;
        Okrag[] tablicaOkregow = tworzenieTablicyOkregow(iloscOkregow);
        System.out.println(sprawdzaniePolozenia(tablicaOkregow[0], tablicaOkregow[1]));
        System.out.println(sprawdzaniePolozenia(tablicaOkregow[0], tablicaOkregow[2]));

        wyswietlPolaOkregu(tablicaOkregow);
    }
}



