import java.util.Scanner;

public class zad3_5 {
    public static String DziesiatnaNaBinarna(int liczba){
        String OdTylubinarnie = "";
        String binarnie = "";
        while(liczba!=0){
            OdTylubinarnie +=liczba%2;
            liczba = liczba/2;
        }
        for(int i = OdTylubinarnie.length()-1;i>=0;i--){
            binarnie = binarnie + OdTylubinarnie.charAt(i);
        }

        return binarnie;
    }
    public static int IleZerWSekwencji(String liczbaBinarnie){
        int IloscZer = 0;
        int IloscZerMax = 0;
        for(int i= 0; i<liczbaBinarnie.length();i++){
            if(liczbaBinarnie.charAt(i) == '0')
                IloscZer++;
            else if (liczbaBinarnie.charAt(i) == '1'){
                IloscZerMax = IloscZer;
                IloscZer = 0;
            }
        }
        if(IloscZerMax == 0) {
            System.out.println("Brak sekwencji zer");
            return 0;
        }
        else
        return IloscZerMax;
    }
    public static void main(String[]args){
        String LiczbaBinarnie;
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj liczbe dziesietna jaka chcesz zamienic na binarna: ");
        int liczba = sc.nextInt();
        System.out.println("Ta liczba binarnie to: " + DziesiatnaNaBinarna(liczba));

        System.out.println("Podaj liczbe binarnie: ");
        sc.nextLine();
        LiczbaBinarnie = sc.nextLine();
        System.out.println("Najwieksza sekwencja zer w podanej liczbie to: " + IleZerWSekwencji(LiczbaBinarnie));

    }
}
