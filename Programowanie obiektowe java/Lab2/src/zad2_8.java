public class zad2_8 {
    public static void fibonaci(int n){
        int a = 0,b = 1;
        System.out.print("Oto "+n+" liczb ciagu fibonaciego: ");
        for(int i = 0;i<n;i++){
            System.out.print(a+" ");
            int suma =a+b;
            a=b;
            b=suma;
        }
    }

    public static void main(String[] args){
        fibonaci(10);
    }
}
