public class zad2_7 {
    public static void Liczbycalkowite(int zakresdol,int zakresgora,int dzielnik){
        System.out.println("Liczby w zakresie od: "+zakresdol+" do: "+zakresgora+" podzielne przez: "+dzielnik);
        for (int i = zakresdol;i <=zakresgora;i++){
            if(i%dzielnik==0)
                System.out.println(i);
        }
    }

    public static void main(String[] args){
        Liczbycalkowite(11,111,13);
    }
}
