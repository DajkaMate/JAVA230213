/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dm.helsinki;

/**
 *
 * @author user09
 */
public class helsinki_adatok {
    private int helyezes;
    private int csapattagok;
    private String sportag;
    private String versenynev;                                                                                              
    public helsinki_adatok(int helyezes, int csapattagok, String sportag, String versenynev){
        this.helyezes = helyezes;
        this.csapattagok = csapattagok;
        this.sportag = sportag;
        this.versenynev = versenynev;
    }
    
    public int gethelyezes() {
        return helyezes;
    }

    public int getcsapattagok() {
        return csapattagok;
    }

    public String getsportag() {
        return sportag;
    }

    public String getversenynev() {
        return versenynev;
    }
}
