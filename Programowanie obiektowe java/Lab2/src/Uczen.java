import javax.swing.*;

public class Uczen {
    String imie,nazwisko;
    int wiek;
    double srednia;
    public Uczen(String imie,String nazwisko,int wiek,double srednia){
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.wiek=wiek;
        this.srednia=srednia;
    }
    public Uczen(){}
    public void Wyswietl_dane(){
        System.out.println(nazwisko+" "+imie+" lat: "+wiek+" srednia: "+srednia);
    }
    public static void main(String[] args) {
        Uczen Karol = new Uczen("Karol","Kowalski",18,4.50);
        Karol.Wyswietl_dane();
    }
}
