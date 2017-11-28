package logika;

/**
 *  Enumerace, ktera slouzi k urceni aktualniho stavu hry.
 * @author     Jekaterina Krivenchuk
 * @version    ZS 2017
 */

public enum State {
    //Stav, ve kterem straznik ceka na odpoved

    /**
     *
     */
    StraznikVezeni, 
    //Stav od zacatku hry

    /**
     *
     */
    Zacatek, 
    //Stav, kdyz hrac ma mec a muze jit domu

    /**
     *
     */
    MecVJeskyni, 
    //Stav, kdyz hrac muze jit ven z vezeni

    /**
     *
     */
    PrisonBreak
}
