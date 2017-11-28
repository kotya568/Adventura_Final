package logika;

/**
 *  Třída implementující toto rozhraní ve hře implementuje jednotlivé metody.
 *  Toto rozhraní je součástí jednoduché textové hry.
 *  
 * @author     Jekaterina Krivenchuk
 * @version    ZS 2017
 */
public interface ISeznamVeci
{

    /**
     *
     * @param nazev
     * @return
     */
    public boolean obsahujeVec(String nazev);

    /**
     *
     * @param vec
     * @return
     */
    public Vec vlozVec(Vec vec);

    /**
     *
     * @param nazev
     * @return
     */
    public Vec odeberVec(String nazev);

    /**
     *
     * @param vec
     * @return
     */
    public Vec odeberVec(Vec vec);

    /**
     *
     * @param vec
     * @return
     */
    public Vec odebranaVec(Vec vec);

    /**
     *
     * @param vec
     * @return
     */
    public Vec snezVec(Vec vec);
}
