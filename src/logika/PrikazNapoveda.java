package logika;

/**
 *  Třída PrikazNapoveda implementuje pro hru příkaz napoveda.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 * @author     Jekaterina Krivenchuk
 * @version    ZS 2017
 *  
 */
class PrikazNapoveda implements IPrikaz {
    private static final String NAZEV = "napoveda";
    private SeznamPrikazu platnePrikazy;

    /**
     *  Konstruktor třídy
     *  
     *  @param platnePrikazy seznam příkazů,
     *                       které je možné ve hře použít,
     *                       aby je nápověda mohla zobrazit uživateli. 
     */    
    public PrikazNapoveda(SeznamPrikazu platnePrikazy) {
        this.platnePrikazy = platnePrikazy;
    }

    /**
     *  Vrací základní nápovědu po zadání příkazu "napoveda". Nyní se vypisuje
     *  vcelku primitivní zpráva a seznam dostupných příkazů.
     *  
     *  @return napoveda ke hre
     */
    @Override
    public String proved(String... parametry) {
        return "\n Tvym ukolem je zahranit svuj dum ped bilyma chodci .\n"
        + "Cestou muzes vkladat veci do batohu a pote je snist, vylozit, kombinovat.\n"
        + "\n"
        + "Muzes zadat tyto prikazy:\n"
        + platnePrikazy.vratNazvyPrikazu();
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }

}
