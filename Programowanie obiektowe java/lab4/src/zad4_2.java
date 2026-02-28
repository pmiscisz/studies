import java.util.Random;

public class zad4_2 {
    public static int[][] TworzenieTablicyLosowej(){
        Random rnd = new Random();
        int rozmiar = rnd.nextInt(11)+10;
        int[][] tab = new int[rozmiar][rozmiar];

        for(int i = 0;i<rozmiar;i++){
            for(int j = 0;j<rozmiar;j++){
                if(i==j){
                    tab[i][j] = rnd.nextBoolean() ? 1 : -1;
                } else
                    tab[i][j] = rnd.nextInt(41)-20;
            }
        }
        return tab;
    }

    public static double StosunekSum(int[][] tab){
        int sumaParzysteWiersze = 0;
        int sumaNieparzysteKolumny =0;

        for(int i=0;i<tab.length;i++){
            for(int j=0;j<tab[i].length;j++){
                if(i%2==0){
                    sumaParzysteWiersze += tab[i][j];
                }if(j%2==1){
                    sumaNieparzysteKolumny += tab[i][j];
                }
            }
        }
        return (double) sumaParzysteWiersze / sumaNieparzysteKolumny;
    }
    public static void main(String[]args){
        int[][] losowaTablica = TworzenieTablicyLosowej();

        for(int i = 0;i< losowaTablica.length;i++){
            for(int j =0;j<losowaTablica[i].length;j++){
                System.out.print(losowaTablica[i][j]+"\t");;
            }
            System.out.println();
        }
        System.out.println("Stosunek sum wartosci parzsystych wierszy i nieparzystych kolumny wynosi: " + StosunekSum(losowaTablica));

    }
}
