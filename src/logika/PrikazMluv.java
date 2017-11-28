package logika;

/**
 *  Třída PrikazMluv implementuje pro hru příkaz mluv.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 * @author     Jekaterina Krivenchuk
 * @version    ZS 2017
 *  
 */
public class PrikazMluv implements IPrikaz
{
    private static final String NAZEV = "mluv";
    private HerniPlan plan;
    private Hra hra;
     
    /**
     *  Konstruktor třídy
     *  
     * @param plan herní plán, ve kterém se bude ve hře "mluvit" 
     * @param hra 
     */ 
    public PrikazMluv(HerniPlan plan, Hra hra)
    {
        this.plan = plan;
        this.hra = hra;
    }

    /**
     * Metoda, která slouží k vyhodnocení, zda je s kym mluvit v aktualnim prostoru
     * konec hry po třech pokusech. Odpoví-li hráč správně, muze pokracovat a jit do lesu.
     * @return 
     */
    @Override
    public String proved(String... parametry) {
        if(plan.getAktualniProstor().getNazev().equals("vezeni")) {
            if (plan.state == State.Zacatek) {
                plan.state = State.StraznikVezeni;
                return "Straznik: Zdravim trestanec, nachazis se ve vezeni. Vypustim tebe jestli odhadnes moji hadanku:\n"
                        + "\tSpadne to do vody a vodou to ani nehne. Co je to?";
            }
            if (plan.state == State.PrisonBreak) {
                return "Straznik: Ted muzes jit ven do lesu.";
            }
            return "Straznik: Musis odpovedet.";
        }
        else if(plan.getAktualniProstor().getNazev().equals("les")) { 
            if (plan.kralovnaJeZiva) {
                if (!plan.dostalJed) {
                    plan.getProstor("les").vlozVec(new Vec("jed","jed.jpg"));
                    plan.dostalJed = true;
                }
                return "Carodejnice: Zdravim , nachazis se v lese. Muzu tobe napovedet jak zabit bile chodci.\n"
                    + "Ale predtim musis splnit muj ukol. Zabij kralovnu!! Otravuje me zivot.\n"
                    + "Jdi k matce do jeskyne a vezmi dort. A pak zkombinuj ho s jedem, ktery muzes vzit u mne.\n"
                    + "Potom dej ho kralovne a vrat se ke mne.";
            }
            else {
                if (plan.state == State.MecVJeskyni) {
                    plan.state = State.MecVJeskyni;
                    plan.getProstor("jeskyne").vlozVec(new Vec("mec","mec.jpg"));
                    return "Carodejnice: Vitam zpatky. Zabil sis kralovnu ? Dobra prace!\n" +
                        "Ted ti povim, kde v jeskyni je schovan mec, kterym se da zabit bile chodci.";
                }
                return "Carodejnice: Vezmi si mec, ktery najdes v jeskyni.";
            }
        }
        else if(plan.getAktualniProstor().getNazev().equals("kralovsky_dvur") && plan.kralovnaJeZiva) { 
            return "Kralovna: Zdravim, nachazis se v kralovskem dvore. Doufam ze mas nejaky dar pro mne?";
        }
        else if(plan.getAktualniProstor().getNazev().equals("jeskyne")) { 
            return "Matka: Zdravim, hledas neco? Prave jsem upekla cokoladovy dort";
        }
        else {
            return "Tady nemas s kym mluvit."; 
        }
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