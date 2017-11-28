package logika;

/**
 *  Třída PrikazVyhod implementuje pro hru příkaz vyhod.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 * @author     Jekaterina Krivenchuk
 * @version    ZS 2017
 */
public class PrikazVyhod implements IPrikaz
{
    private static final String NAZEV = "vyhod";
    private HerniPlan plan;

    /***************************************************************************
     * Konstuktor třídy
     * 
     * @param plan herní plán, ve kterém se bude ve hře "vyhazovat" 
     */
    public PrikazVyhod(HerniPlan plan)
    {
        this.plan = plan;
    }

    /**
     * Provádí příkaz vyhod. Zkouší vyhodit věc z batohu.
     * @return 
     */
    @Override
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo, tak ....
            return "Co mam vyhodit? Musite zadat vec z batohu.";
        }
        else {
            if(parametry.length == 1 && plan.getBatoh().obsahujeVec(parametry[0])){
                Vec pomocna = plan.getBatoh().odeberVec(parametry[0]);
                plan.getAktualniProstor().vlozVec(pomocna);
                return "Vyhodila jsi vec z batohu "+ parametry[0] + ".";
            }
        }
        return "Tento predmet nemas.";
    }

    
     /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    public String getNazev() {
        return NAZEV;
    }

}
