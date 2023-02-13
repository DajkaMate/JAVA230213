
package dm.kolcsonzo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DMKolcsonzo {
    static ArrayList<kolcsonzo_adatok> Klist = new ArrayList<>();
    public static void main(String[] args) {
        try
        {   
            System.setProperty("file.encoding", "UTF8");
            FileReader fr = new FileReader("kolcsonzo.txt");
            BufferedReader br = new BufferedReader(fr);
            String sor = null;
            br.readLine();
            while ((sor = br.readLine()) != null) 
            {                
                String[] dbok = sor.split(";");
                String nev = dbok[0];
                String jarmu_azon = dbok[1];
                String elvitel_ora = dbok[2];
                String elvitel_perc = dbok[3];
                String visszahozatal_ora = dbok[4];
                String visszahozatal_perc = dbok[5];       
                kolcsonzo_adatok KA = new kolcsonzo_adatok(nev, jarmu_azon, elvitel_ora, elvitel_perc, visszahozatal_ora, visszahozatal_perc);
                Klist.add(KA);
            }
            br.close();
            fr.close();
        }
        catch(IOException | NumberFormatException e)
        {
            System.out.println("Hiba: "+ e);
        }

        System.out.println("A fájlbeolvasás megtörtént");
        System.out.println("5. Feladat: Napi kölcsönzések száma: " + Klist.size());
        String nev = null;
        
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("6. Feladat: Kérek egy nevet: ");
            nev = br.readLine();
             System.out.println("\t" + nev + " kölcsönzései:");
            for (int i = 0; i < Klist.size(); i++) {
                 if (Klist.get(i).getnev().equals(nev)) System.out.println("\t" + Klist.get(i).getelvitel_ora() + ":" + Klist.get(i).getelvitel_perc() + "-" 
                                                                         + Klist.get(i).getvisszahozatal_ora() + ":" + Klist.get(i).getvisszahozatal_perc());
            }   
        }   
        catch (Exception hiba)
        {
            System.out.println(hiba.toString());
        }
        
        String ido = null;
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("7. Feladat: Adjon meg egy időpontot óra:perc alakban: ");
            ido = br.readLine();
            System.out.println(ido);
            br.close();
        }   
        catch (Exception hiba)
        {
            System.out.println(hiba.toString());
        }
    }
    
}
