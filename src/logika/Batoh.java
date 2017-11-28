package logika;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/*******************************************************************************
 * Třída Batoh - popisuje batoh.
 * 
 *  Tato třída je součástí jednoduché textové hry.
 * "Batoh" reprezentuje "úložný prostor" pro sebrané věci (příkazem seber). 
 *  Věci jsou přenositelné. Jsou vkládány do batohu a kdykoli si pomocí příkazu
 * 'batoh' můžeme zjistit její obsah (vypíše se řetězec znaků). Lze je z batohu
 *  odebrat, resp. je "vymazat" příkazem vyhod.
 *  
 * @author     Jekaterina Krivenchuk
 * @version    ZS 2017
 */
public class Batoh implements ISeznamVeci
{
    private Map<String, Vec> veci; //klíč a k němu přiřazená hodnota
    private final int KAPACITA = 5; 


    /***************************************************************************
     * Konstruktor třídy
     */
    public Batoh()
    {
        veci = new HashMap<>(); //vytvořená nová mapa, do které se vkládají předměty
 
    }

    /**
     * Metoda k vypsání obsahu kabelky.
     */
    public String toString(){
        if(veci.size() == 0) { //počet prvků uložených v mapě je nula
            return "Batoh je prazdny.";
        }
        String result = "";
        for(String s : veci.keySet()) { //procházení mapy; vrací množinu obsahující klíče - předměty, které jsou v kabelce
            result += s+ ", ";
        }
        return result;
    }

    /**
     * Metoda rozhodne, zda v kabelce věc je.
     * @param nazev
     * @return 
     */
    public boolean obsahujeVec(String nazev) {
        return veci.containsKey(nazev); //pokud je klíč obsažen v mapě, vrací true
    }

    /**
     *
     * @return
     */
    public Map<String, Vec> getVeci() {
        return veci;
    }
    
    
    
    

    /**
     * Metoda vloží věc do kabelky.
     * @param vec
     * @return 
     */
    public Vec vlozVec(Vec vec) {
        veci.put(vec.getNazev(),vec); //vloží klíč a hodnotu do mapy
        if(veci.containsKey(vec.getNazev())) return vec;
        return null;
    }

    /**
     * Metoda odebere věc z batohu.
     * @param nazev
     * @return 
     */
    public Vec odeberVec(String nazev) {
        return veci.remove(nazev); //v mapě se zrusí odpovídající klíč s hodnotou
    }
    
     /**
     * @return Kolik zbývá místa v batohu.
     */
    public int getKapacita() {
        return (KAPACITA - veci.size());
    }

    /**
     * Metoda odebere věc z kabelky.
     * @param vec
     * @return 
     */
    public Vec odeberVec(Vec vec) {
        return null;
    }

    /**
     * Metoda vrátí "nic", byla-li věc snězena
     * @param vec
     * @return 
     */
    public Vec snezVec(Vec vec) {
        return null;
    }

    /**
     * Metoda vrátí "nic", byla-li věc odebrána z kabelky.
     * @param vec
     * @return 
     */
    public Vec odebranaVec(Vec vec) {
        return null;
    }


}
