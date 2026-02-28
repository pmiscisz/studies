public class zad3_2 {
    public static int SumaASCII(String lancuch){
        int suma=0;
        for(int i=0;i<lancuch.length();i++){
            if(((int)lancuch.charAt(i)>47 && (int)lancuch.charAt(i)<58) || ((int)lancuch.charAt(i)>96 && (int)lancuch.charAt(i)<122))
                suma=suma+(int)lancuch.charAt(i);
        }
        return suma;

    }
    public static void main(String[]args){
        String lancuch = "abcd1AXC";
        System.out.println("Suma wartosci malych liter i cyfry w: " + lancuch + " wynosi: " + SumaASCII(lancuch));

    }
}
