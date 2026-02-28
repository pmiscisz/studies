public class zad3_1 {
    public static int sprawdzenie(String lancuch,char znak){
        int licznik = 0;
        for(int i =0;i<lancuch.length();i++){
            if(lancuch.charAt(i)==znak)
                licznik++;
        }
        return licznik;

    }

    public static void main(String[]args){
        String lancuch="akakajajaja";
        char znak='a';
        System.out.println("W lancuchu znakow " + lancuch +" znak " + znak + " wystapil " + sprawdzenie(lancuch,znak) +" razy." );
    }
}
