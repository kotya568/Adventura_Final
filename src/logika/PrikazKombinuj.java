package logika;

/**
 *  Třída PrikazKombinuj implementuje pro hru příkaz kombinuj.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 * @author     Jekaterina Krivenchuk
 * @version    ZS 2017
 */
public class PrikazKombinuj implements IPrikaz
{
    private static final String NAZEV = "kombinuj";
    private HerniPlan plan;   
    
    /**
     *  Konstruktor třídy
     *  
     * @param plan herní plán, ve kterém se bude ve hře "kombinovat veci" 
     */    
    public PrikazKombinuj(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Provádí příkaz kombinuj. Zkouší kombinovat věci, které jsou už vložené v batohu.
     * @return 
     */
    @Override
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo, tak ....
            return "Co mam kombinovat?";
        }
        if (parametry.length == 1) {
            // pokud chybí treti slovo, tak ....
            return "Co mam kombinovat? Musis zadat 2 veci.";
        }
        if(parametry.length == 2) {
            return kombinuj(parametry[0], parametry[1]);
        }
        return "Nic neprobehlo v kombinuj.";
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
     * Metoda zajišťuje, jestli se věci da kombinovat.
     */
    private String kombinuj(String vec1, String vec2){
        if(plan.getBatoh().obsahujeVec(vec1) && plan.getBatoh().obsahujeVec(vec2)){
            if (vec1.equals("dort") && vec2.equals("jed") || vec2.equals("dort") && vec1.equals("jed")) {
                plan.getBatoh().odeberVec("dort");
                plan.getBatoh().odeberVec("jed");
                plan.getBatoh().vlozVec(new Vec("otraveny_dort","otraveny_dort.jpg"));
                return "Kombinace se provedna uspesne. Ted mas otraveny_dort ve svem batohu.";
            }
            return "Toto se nekombinuje.";
        }
        return "Neco z toho jeste nemas.";
    }
}