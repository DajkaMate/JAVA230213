package dm.kolcsonzo;

public class kolcsonzo_adatok {
    private String nev;
    private String jarmu_azon;
    private String elvitel_ora;
    private String elvitel_perc;
    private String visszahozatal_ora;
    private String visszahozatal_perc;                                                                                             
    public kolcsonzo_adatok(String nev, String jarmu_azon, String elvitel_ora, String elvitel_perc, String visszahozatal_ora, String visszahozatal_perc){
        this.nev = nev;
        this.jarmu_azon = jarmu_azon;
        this.elvitel_ora = elvitel_ora;
        this.elvitel_perc = elvitel_perc;
        this.visszahozatal_ora = visszahozatal_ora;
        this.visszahozatal_perc = visszahozatal_perc;
    }
    
    public String getnev() {
        return nev;
    }

    public String getjarmu_azon() {
        return jarmu_azon;
    }

    public String getelvitel_ora() {
        int elvitel_ora_num = String.valueOf(elvitel_ora).length();
        if (elvitel_ora_num == 1)
        {
            elvitel_ora = "0" + elvitel_ora;
        }
        return elvitel_ora;
    }

    public String getelvitel_perc() {
        int elvitel_perc_num = String.valueOf(elvitel_perc).length();
        if (elvitel_perc_num == 1)
        {
            elvitel_perc = "0" + elvitel_perc;
        }
        return elvitel_perc;
    }
    
    public String getvisszahozatal_ora() {
        int visszahozatal_ora_num = String.valueOf(visszahozatal_ora).length();
        if (visszahozatal_ora_num == 1)
        {
            visszahozatal_ora = "0" + visszahozatal_ora;
        }
        return visszahozatal_ora;
    }
    
    public String getvisszahozatal_perc() {
        int visszahozatal_perc_num = String.valueOf(visszahozatal_perc).length();
        if (visszahozatal_perc_num == 1)
        {
            visszahozatal_perc = "0" + visszahozatal_perc;
        }
        return visszahozatal_perc;
    }
}