package logika;


import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *  Třída PrikazMapa implementuje pro hru příkaz mapa.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 * @author     Jekaterina Krivenchuk
 * @version    ZS 2017
 */
    public class PrikazMapa implements IPrikaz {
    private static final String NAZEV = "mapa";
    private SeznamPrikazu platnePrikazy;

    /**
     *  Konstruktor třídy
     *  
     *  @param platnePrikazy seznam příkazů,
     *                       které je možné ve hře použít,
     *                       aby je nápověda mohla zobrazit uživateli. 
     */    
    public PrikazMapa(SeznamPrikazu platnePrikazy) {
        this.platnePrikazy = platnePrikazy;
    }

    /**
     *  Vrací základní nápovědu po zadání příkazu "mapa". Nyní se vypisuje
     *  vcelku primitivní zpráva a seznam dostupných příkazů.
     *  
     *  @return napoveda ke hre
     */
    @Override
    public String proved(String... parametry) {
        JFrame frame = new JFrame();
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(Hra.IMAGE_PATH));
            frame.add(new JLabel(new ImageIcon(img)));  
            frame.setExtendedState( frame.getExtendedState()|JFrame.MAXIMIZED_BOTH );
            frame.setVisible(true);
            return "Byla otevrena mapa.";
        }
        catch (Exception e) {
            System.err.println("Nepodarilo se otevrit obrazek s mapou.");
        }
        return "Nepodarilo se otevrit obrazek s mapou.";
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
