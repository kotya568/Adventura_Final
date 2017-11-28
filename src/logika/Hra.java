package logika;

/**
 *  Třída Hra - třída představující logiku adventury.
 * 
 *  Toto je hlavní třída  logiky aplikace.  Tato třída vytváří instanci třídy HerniPlan, která inicializuje mistnosti hry
 *  a vytváří seznam platných příkazů a instance tříd provádějící jednotlivé příkazy.
 *  Vypisuje uvítací a ukončovací text hry.
 *  Také vyhodnocuje jednotlivé příkazy zadané uživatelem.
 * 
 * @author     Jekaterina Krivenchuk
 * @version    ZS 2017
 */

public class Hra implements IHra {
    
    /**
     *
     */
    protected static final String IMAGE_PATH = "planek.jpg";
    private final SeznamPrikazu platnePrikazy;    // obsahuje seznam přípustných příkazů
    private final HerniPlan herniPlan;
    private boolean konecHry = false;

    /**
     *  Vytváří hru a inicializuje místnosti (prostřednictvím třídy HerniPlan) a seznam platných příkazů.
     */
    public Hra() {
        herniPlan = new HerniPlan(this);
        platnePrikazy = new SeznamPrikazu();
        platnePrikazy.vlozPrikaz(new PrikazNapoveda(platnePrikazy));
        platnePrikazy.vlozPrikaz(new PrikazJdi(this));
        platnePrikazy.vlozPrikaz(new PrikazKonec(this));
        platnePrikazy.vlozPrikaz(new PrikazSeber(this.getHerniPlan()));
        platnePrikazy.vlozPrikaz(new PrikazVyhod(this.getHerniPlan()));
        platnePrikazy.vlozPrikaz(new PrikazSnez(this));
        platnePrikazy.vlozPrikaz(new PrikazBatoh(this.getHerniPlan()));
        platnePrikazy.vlozPrikaz(new PrikazMluv(this.getHerniPlan(),this));
        platnePrikazy.vlozPrikaz(new PrikazOdpovez(this.getHerniPlan(),this));
        platnePrikazy.vlozPrikaz(new PrikazDej(this.getHerniPlan()));
        platnePrikazy.vlozPrikaz(new PrikazKombinuj(this.getHerniPlan()));
        platnePrikazy.vlozPrikaz(new PrikazMapa(platnePrikazy));
    }

    /**
     *  Vrátí úvodní zprávu pro hráče.
     */
    public String vratUvitani() {
        return "Vitej!\n" +
        "Tvym hlavnim ukolem je zaсhranit svuj dum pred bilyma chodci.\n" +
        "Z vezeni se dostnes k carodejnici, ktera tobe rekne jak zabit bile chodce. \n" +
        "Pak dostanes ukol od carodejnice. Napoveda Dort se nahazi v jeskyni u matky, jeho potrebujes zkombinovat s jedem. \n" +
        "Jenom takovym zpusobem muzes zabit kralovnu, kdyz ona sni dort s jedem. \n" +
        "Predem bys vsak mel najit nejakou vyzbroj, abys mel proti bilym chodcum vubec sanci. \n" +
        "Promluv si s kazdou postavu, treba se neco dozvis.\n" +
        "Napiste 'napoveda', pokud si nevite rady, jak hrat dal.\n\n" +
        herniPlan.getAktualniProstor().dlouhyPopis();
    }

    /**
     *  Vrátí závěrečnou zprávu pro hráče.
     */
    public String vratEpilog() {
        return "Dekuji, ze jste si zahrali!";
    }

    /** 
     * Vrací true, pokud hra skončila.
     */
    public boolean konecHry() {
        return konecHry;
    }

    /**
     *  Metoda zpracuje řetězec uvedený jako parametr, rozdělí ho na slovo příkazu a další parametry.
     *  Pak otestuje zda příkaz je klíčovým slovem  např. jdi.
     *  Pokud ano spustí samotné provádění příkazu.
     *
     *@param  radek  text, který zadal uživatel jako příkaz do hry.
     *@return          vrací se řetězec, který se má vypsat na obrazovku
     */
    public String zpracujPrikaz(String radek) {
        String [] slova = radek.split("[ \t]+");
        String slovoPrikazu = slova[0];
        String []parametry = new String[slova.length-1];
        for(int i=0 ;i<parametry.length;i++){
            parametry[i]= slova[i+1];   
        }
        String textKVypsani=" .... ";
        if (platnePrikazy.jePlatnyPrikaz(slovoPrikazu)) {
            IPrikaz prikaz = platnePrikazy.vratPrikaz(slovoPrikazu);
            textKVypsani = prikaz.proved(parametry);
        }
        else {
            textKVypsani= "Nevim, co tim myslis. Tento prikaz neznam.";
        }
        return textKVypsani;
    }

    /**
     *  Nastaví, že je konec hry, metodu využívá třída PrikazKonec,
     *  mohou ji použít i další implementace rozhraní Prikaz.
     *  
     *  @param  konecHry  hodnota false= konec hry, true = hra pokračuje
     */
    void setKonecHry(boolean konecHry) {
        this.konecHry = konecHry;
    }

    /**
     *  Metoda vrátí odkaz na herní plán, je využita hlavně v testech,
     *  kde se jejím prostřednictvím získává aktualní místnost hry.
     *  
     *  @return     odkaz na herní plán
     */
    public HerniPlan getHerniPlan(){
        return herniPlan;
    }

}

