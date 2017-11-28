package logika;

/**
 *  Třída PrikazOdpovez implementuje pro hru příkaz odpovez.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 * @author     Jekaterina Krivenchuk
 * @version    ZS 2017
 */
public class PrikazOdpovez implements IPrikaz
{
    private static final String NAZEV = "odpovez";
    private HerniPlan plan;
    private Hra hra;
     
    /**
     *  Konstruktor třídy
     *  
     * @param plan herní plán, ve kterém se bude ve hře "odpovídat" 
     * @param hra 
     */ 
    public PrikazOdpovez(HerniPlan plan, Hra hra)
    {
        this.plan = plan;
        this.hra = hra;
    }

    /**
     * Metoda, která slouží k vyhodnocení, zda bylo na otázku odpovězeno ve správném prostoru a správně. Spravná odpoveď je pouze stin 
     * konec hry po třech pokusech. Odpoví-li hráč správně, pokracuje dal.
     * @return 
     */
    @Override
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo, tak ....
            return "Musis zadat odpoved.";
        }
        if (parametry.length == 1) {
            if(plan.getAktualniProstor().getNazev().equals("vezeni") && plan.state == State.StraznikVezeni) { 
                if((parametry[0].toLowerCase().equals("stin")) && plan.getPokus() < 3) {
                    plan.state = State.PrisonBreak;
                    plan.getProstor("vezeni").setVychod(plan.getProstor("les"));
                    return "Straznik: Spravna odpoved! Ted muzes jit ven do lesu.\n"
                            + "vychody: les";
                } else {
                    plan.spatnaOdpoved();
                    if (plan.getPokus() >= 3) {
                        hra.setKonecHry(true);
                        return "Nemas dalsi pokusy. Prohrala jsi.";
                    }
                    return "Straznik: Spatna odpoved, muzes zkusit jeste jednou " + (3 - plan.getPokus()) + "krat";
                }
            }
            else {
                return "Tady nemas komu odpovedet."; 
            }
        }
        return "odpoved";
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