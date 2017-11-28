package logika;

/**
 *  Třída PrikazDej implementuje pro hru příkaz dej.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 *  @author     Jekaterina Krivenchuk
 *  @version    pro školní rok 2016/2017
 */
public class PrikazDej implements IPrikaz
{
    private static final String NAZEV = "dej";
    private HerniPlan plan;   
    
    /**
     *  Konstruktor třídy
     *  
     * @param plan herní plán
     */    
    public PrikazDej(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Provádí příkaz dej. Zkouší dat věci, které jsou už vložené v batohu.
     * @return 
     */
    @Override
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední prostor), tak ....
            return "Co mam dat?";
        }

        if(parametry.length == 1) {
            switch (parametry[0]) {
                //vyhodnocuje se, zda napsaná hodnota (parametr) odpovídá jedné z těchto
                case "dort":  return dort();
                case "jed": return jed(); 
                case "otraveny_dort": return otraveny_dort(); 
                default: return "Tento predmet nemas."; //pokud se nenašla žádná z výše uvedených věcí
            }
        }
        return "Nic neprobehlo v dej.";
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
     * Metoda zajišťuje, že věc lze dat pouze pokud je již v batohu
     */
    private String dort(){
        if(plan.getBatoh().obsahujeVec("dort")){
            if (plan.getAktualniProstor().getNazev().equals("kralovsky_dvur") && !plan.kralovnaJeZiva) {
                return "Nikdo tu neni.";
            }
            plan.getBatoh().odeberVec("dort");
            return "Dal jsi dort.";
        }
        return "Nemas dort.";
    }

    /**
     * Metoda zajišťuje, že věc lze dat pouze pokud je již v batohu
     * @return 
     */
    public String jed(){
        if(plan.getBatoh().obsahujeVec("jed")){
            return "Nikdo tohle nepotrebuje.";
        }
        return "Nemas jed.";
    }
    
    /**
     * Metoda zajišťuje, že věc lze dat pouze pokud je již v batohu
     * @return 
     */
    public String otraveny_dort(){
        if(plan.getBatoh().obsahujeVec("otraveny_dort")){
            if (plan.getAktualniProstor().getNazev().equals("kralovsky_dvur") && plan.kralovnaJeZiva) {
                plan.getBatoh().odeberVec("otraveny_dort");
                plan.kralovnaJeZiva = false;
                return "Dal jsi otraveny_dort princezne a ted je mrtva.";
            }
            return "Nikdo to nepotrebuje.";
        }
        return "Nemas otraveny_dort.";
    }
}