package logika;

/**
 *  Třída PrikazSnez implementuje pro hru příkaz snez.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 * @author     Jekaterina Krivenchuk
 * @version    ZS 2017
 *  
 */
public class PrikazSnez implements IPrikaz
{
    private static final String NAZEV = "snez";
    private HerniPlan plan;   
    private Hra hra;   

    /**
     *  Konstruktor třídy
     * 
     * @param hra
     */    
    public PrikazSnez(Hra hra) {
        this.plan = hra.getHerniPlan();
        this.hra = hra;
    }

    /**
     * Provádí příkaz sněz. Zkouší sníst věci, které jsou už vložené v batohu.
     * @return 
     */
    @Override
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední prostor), tak ....
            return "Co mam snist?";
        }

        if(parametry.length == 1) {
            switch (parametry[0]) {
                //vyhodnocuje se, zda napsaná hodnota (parametr) odpovídá jedné z těchto
                case "dort":  return dort();
                case "jed": return jed(); 
                case "otraveny_dort": return otraveny_dort(); 
                default: return "Tento predmet jsi jeste nesebrala."; //pokud se nenašla žádná z výše uvedených věcí
            }
        }
        return "Nic neprobehlo v snez.";
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    public String getNazev() {
        return NAZEV;
    }

    /**
     * Metoda zajišťuje, že věc lze sníst.
     */
    private String dort(){
        if(plan.getBatoh().obsahujeVec("dort")){
            plan.getBatoh().odeberVec("dort");
            return "Snedla jsi dort.";
        }
        return "Nemas dort.";
    }

    /**
     * Metoda zajišťuje, že věc lze sníst.
     * @return 
     */
    public String jed(){
        if(plan.getBatoh().obsahujeVec("jed")){
            hra.setKonecHry(true);
            plan.getBatoh().odeberVec("jed");
            return "Snedla jsi jed. Dobra prace!";
        }
        return "Nemas jed.";
    }

    /**
     * Metoda zajišťuje, že věc lze sníst.
     * @return 
     */
    public String otraveny_dort(){
        if(plan.getBatoh().obsahujeVec("otraveny_dort")){
            hra.setKonecHry(true);
            plan.getBatoh().odeberVec("otraveny_dort");
            return "Snedla jsi otraveny_dort. Dobra prace!";
        }
        return "Nemas otraveny_dort.";
    }
}