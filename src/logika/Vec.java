package logika;

import javafx.scene.image.Image;

/**
 * Instance třídy věc představují jednotlivé předměty.
 * 
 * Tato třída je součástí jednoduché textové hry.
 *
 * @author     Jekaterina Krivenchuk
 * @version    ZS 2017
 */
public class Vec
{
    private String nazev;
    private boolean mec;    //dá se věc použít jako zbraň?
    private boolean prenosna;    //dá se věc přenášet?
    private String adresa;
    private String obrazek;

    /***************************************************************************
     * Konstuktor třídy
     * @param nazev
     * @param obrazek
     */
    public Vec(String nazev,String obrazek)
    {
        this.nazev = nazev;
        this.obrazek = obrazek;
    }

    /**
     * Metoda vrací název věci
     * @return 
     */ 
    public String getNazev() {
        return nazev;
    }

    /**
     *
     * @return
     */
    public String getObrazek() {
        return obrazek;
    }
    
    
}
