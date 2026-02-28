import javax.swing.*;

public class zad2_6 {

    public static void trojkat(int bok1,int bok2,int bok3){
        if(bok1+bok2>bok3 && bok2+bok3>bok1 && bok1+bok3>bok2) {
            System.out.println("Da sie stworzyc trojkat z podanych bokow.");
            if(bok1==bok2 && bok1==bok3 && bok2==bok3)
                System.out.println("Ten trojkat jest rownoboczny.");

            else if (bok1==bok2 || bok2==bok3 || bok1==bok3) {
                System.out.println("Ten trojkat jest rownoramienny.");
            }
            else
                System.out.println("Ten trojkat jest roznoboczny.");
        }else
            System.out.println("Z podanych bokow nie da sie stworzyc trojkata.");


    }

    public static void main(String[] args){
        trojkat(1,3,3);
    }
}
