public class zad2_5 {
    public static void main(String[] args){
        for(int i = 5; i<=80;i=i+15)
            System.out.print(i+" ");

        System.out.println("");
        int i = 5;
        while(i<81){
            System.out.print(i+" ");
            i=i+15;
        }
        System.out.println("");
        i = 5;
        do{
            System.out.print(i+" ");
            i=i+15;
        }while(i<81);
    }

}
