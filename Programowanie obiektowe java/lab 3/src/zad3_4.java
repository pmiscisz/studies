import java.util.Locale;
import java.util.Scanner;

public class zad3_4 {
    public static String TekstNaLancuch(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj tekst: ");
        String tekst = sc.nextLine();
        return tekst;

    }
    public static String SzyfrowanieCezarem(int klucz,String wiadomosc){
        String zaszyfrowany = "";
        for(int i = 0; i < wiadomosc.length();i++){
            char znak = (char) ((int)wiadomosc.charAt(i) + klucz);
            if (znak > 64 && znak < 91 + klucz){
                if(znak > 'Z')
                    znak -= 26;
                zaszyfrowany += znak;
            }else if(znak > 96 && znak < 123 + klucz) {
                if (znak > 'z')
                    znak -= 26;
                zaszyfrowany += znak;
            }
        }
        return zaszyfrowany;

    }

    public static String OdszyfrowywanieCezarem(int klucz,String wiadomosc) {
        String odszyfrowany = "";
        for (int i = 0; i < wiadomosc.length(); i++) {
            char znak = (char) ((int) wiadomosc.charAt(i) - klucz);
            if (znak + klucz > 64 && znak < 91) {
                if (znak < 'A')
                    znak += 26;
                odszyfrowany += znak;
            } else if (znak + klucz > 96 && znak < 123) {
                if (znak < 'a')
                    znak += 26;
                odszyfrowany += znak;
            }
        }
        return odszyfrowany;
    }
    public static boolean Palindrom(String wyraz){
        wyraz = wyraz.toLowerCase();
        int przod = 0;
        int tyl = wyraz.length() - 1;
        while(przod < tyl){
            if(wyraz.charAt(przod) != wyraz.charAt(tyl))
                return false;
            przod++;
            tyl--;
        }
        return true;

    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj wiadomosc do zaszyfrowania: ");
        String wiadomosc = sc.nextLine();

        String zaszyfrowana = SzyfrowanieCezarem(3,wiadomosc);
        String odszyfrowana = OdszyfrowywanieCezarem(3,zaszyfrowana);
        System.out.println("Oto zaszyfrowana wiadomosc: " + zaszyfrowana);
        System.out.println("Oto odszyfrowana wiadomosc: " + odszyfrowana);

        System.out.println("Podaj wyraz ktory chcesz sprawdzic :");
        String wyraz = sc.nextLine();
        System.out.println("Czy wyraz jest palindromem? " + Palindrom(wyraz));





    }
}
