import javax.swing.*;
import javax.xml.transform.sax.SAXSource;
import java.util.Scanner;

public class zad3_3 {
    public static void LiczbaNaZnak(int liczba){
        if(liczba > 32 && liczba < 127)
            System.out.println("Przypisany znak do liczby: " + liczba + " to: " + (char)liczba);
        else
            System.out.println("Podana liczba nie nalezy do podanego zakresu");
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int liczba;
        boolean flag = false;
        while(!flag){
            System.out.println("Podaj liczbe z zakresu <33,126>: ");
            liczba = sc.nextInt();
            LiczbaNaZnak(liczba);
            if(liczba > 32 && liczba < 127)
                flag = true;

        }
    }
}
