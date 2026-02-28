public class Owoc {
    String nazwa;
    double masa;
    public Owoc(String nazwa,double masa){
        this.nazwa=nazwa;
        this.masa=masa;
    }
    public void wyswietl(){
        System.out.println(nazwa+" masa: "+masa+"g");
    }

    public static void main(String[] args) {
        Owoc banan = new Owoc("banan",400);
        Owoc jablko = new Owoc("jablko",450);
        banan.wyswietl();
        jablko.wyswietl();
        System.out.println();
    }
    public static void met_statyczna(){
        System.out.println("Statyczna");
    }
}
