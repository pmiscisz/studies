import javax.swing.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pisarz {
    public void porstyZapis(){
        File f = new File("Plik_Tekstowy.txt");
        try{
            FileWriter pisarz = new FileWriter(f,true);

            for(int i = 0; i< 10;i++){
                pisarz.append("Linia tekstu nr "+i+"\n");
            }
            pisarz.close();
        } catch (IOException ex) {
            System.out.println("Błąd: "+ex.getMessage() );
        }
    }
}

    public void porstyOdczyt(){
        BufferedReader br = null;
        File f = new File("Plik_Tekstowy.txt");
        try{
            br = new BufferedReader(new FileReader(f));
            String line="";
            while((line=br.readLine())!=null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Pisarz.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Pisarz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        Pisarz p = new Pisarz();
        p.porstyZapis();
    }
}