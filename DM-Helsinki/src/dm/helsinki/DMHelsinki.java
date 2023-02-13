
package dm.helsinki;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DMHelsinki {
    static ArrayList<helsinki_adatok> Hlist = new ArrayList<>();
    public static void main(String[] args) {
        try
        {   
            System.setProperty("file.encoding", "UTF8");
            FileReader fr = new FileReader("helsinki.txt");
            BufferedReader br = new BufferedReader(fr);
            String sor = null;
            while ((sor = br.readLine()) !=null) 
            {                
                String[] dbok = sor.split(" ");
                int helyezes = Integer.parseInt(dbok[0]);
                int csapattagok = Integer.parseInt(dbok[1]);
                String sportag = dbok[2];
                String versenynev = dbok[3];
                helsinki_adatok HA = new helsinki_adatok(helyezes, csapattagok, sportag, versenynev);
                Hlist.add(HA);
            }
            br.close();
            fr.close();
        }
        catch(IOException | NumberFormatException e)
        {
            System.out.println("Hiba: "+ e);
        }
        
        System.out.println("A fájlbeolvasás megtörtént");
        System.out.println("3. Feladat:");
        System.out.println("\tA pontszerző helyezések száma: " + Hlist.size() + " db");
        
        int arany = 0;
        int ezust = 0;
        int bronz = 0;
        int olimpiai_pontok = 0;
        for (int i = 0; i < Hlist.size(); i++) {
           if(Hlist.get(i).gethelyezes() == 1) arany ++; olimpiai_pontok = olimpiai_pontok + 7;
           if(Hlist.get(i).gethelyezes() == 2) ezust ++; olimpiai_pontok = olimpiai_pontok + 5;
           if(Hlist.get(i).gethelyezes() == 3) bronz ++; olimpiai_pontok = olimpiai_pontok + 4;
           if(Hlist.get(i).gethelyezes() == 4) olimpiai_pontok = olimpiai_pontok + 3;
           if(Hlist.get(i).gethelyezes() == 5) olimpiai_pontok = olimpiai_pontok + 2;
           if(Hlist.get(i).gethelyezes() == 6) olimpiai_pontok = olimpiai_pontok + 1;
        }
        System.out.println("4. Feladat:");
        System.out.println("\tArany: " + arany + " db");
        System.out.println("\tEzüst: " + ezust + " db");
        System.out.println("\tBronz: " + bronz + " db");
        System.out.println("\tÖsszesen: " + (bronz + ezust + arany) + " db");
        
        System.out.println("5. Feladat:");
        System.out.println("\tOlimpiai pontok száma: " + olimpiai_pontok);
        
        System.out.println("6. Feladat:");
        int uszas = 0;
        int torna = 0;
        for(int i=0; i< Hlist.size();i++)
        {
            if (Hlist.get(i).gethelyezes() >= 4 && Hlist.get(i).getsportag().equals("uszas")) uszas++;
            if (Hlist.get(i).gethelyezes() >= 4 && Hlist.get(i).getsportag().equals("torna")) torna++;
        }
        
        if (torna > uszas) System.out.println("\tA torna kapott több érmet (" + torna + ")");
        if (uszas > torna) System.out.println("\tAz úszás kapott több érmet(" + uszas + ")");
        if (torna == uszas) System.out.println("\tEgyenlő volt az érmek száma");
        
        boolean ok = false; 
        try
        {
            System.setProperty("file.encoding", "UTF8");
            PrintWriter pw = new PrintWriter("helsinki2.txt");
            for (int i = 0; i < Hlist.size(); i++)
            {
                pw.write(Hlist.get(i).gethelyezes()+" ");
                pw.write(Hlist.get(i).getcsapattagok()+" ");
                
                if (Hlist.get(i).gethelyezes() == 1) pw.write("7 ");
                if (Hlist.get(i).gethelyezes() == 2) pw.write("5 ");
                if (Hlist.get(i).gethelyezes() == 3) pw.write("4 ");
                if (Hlist.get(i).gethelyezes() == 4) pw.write("3 ");
                if (Hlist.get(i).gethelyezes() == 5) pw.write("2 ");
                if (Hlist.get(i).gethelyezes() == 6) pw.write("1 ");
                if (Hlist.get(i).gethelyezes() > 6) pw.write((Hlist.get(i).gethelyezes())+" ");
                
                pw.write(Hlist.get(i).getversenynev()+" ");
                
                if (Hlist.get(i).getsportag().equals("kajakkenu")) pw.write("kajak-kenu ");
                else pw.write(Hlist.get(i).getsportag()+" "); 
                
                pw.write(Hlist.get(i).getversenynev()+"\r\n");
            }
            ok = true;
            pw.close();
        }
        catch(IOException hiba)        
        {
            System.out.println("Nincs meg a fájl!"+hiba);                 
        }
        
        if(ok) System.out.println("Adatokat kiírtam!");     
        
        System.out.println("8. Feladat:");
        
	
        int max = 1;
        int maxindex = 1;
	for(int i = 1; i < Hlist.size(); i++)
        {
            if(Hlist.get(i).getcsapattagok() > max) max = Hlist.get(i).getcsapattagok(); maxindex = i;
        }
        for (int i = 0; i < Hlist.size(); i++) 
        {
            if(Hlist.get(i).getcsapattagok() == max)
            {
                System.out.println("\tHejezés: " + Hlist.get(i).gethelyezes());
                System.out.println("\tSportág: " + Hlist.get(i).getsportag());
                System.out.println("\tVersenyszám: " + Hlist.get(i).getversenynev());
                System.out.println("\tSportolók száma: " + Hlist.get(i).getcsapattagok());
            }
        }
        
        
       
        
        
        
        
          
        
        
        
        
        
       
    }
    
}
