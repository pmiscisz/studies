import javax.swing.*;

public class zad4_1 {
    public static int[] TworzenieTablicy(){
        int tab[] = new int[100];

        for(int i = 0;i<tab.length;i++){
            tab[i]=i;
        }
        return tab;
    }
    public static void WyswietlenieTablicy(int[] tab){
        for(int i=0;i < tab.length;i++){
            if(i < 10)
                System.out.print("0");
            System.out.print(i+", ");
            if((i+1) % 10==0)
                System.out.println();
            }
        }

    public static void main(String[]args){
        int tablica[] = TworzenieTablicy();
        WyswietlenieTablicy(tablica);

    }
}
