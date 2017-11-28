/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 * @author     Jekaterina Krivenchuk
 * @version    ZS 2017
 */
public interface Subject {
    
    /**
     *
     * @param observer
     */
    void registerObserver (Observer observer);
    
    /**
     *
     * @param observer
     */
    void deleteObserver (Observer observer);
    
    /**
     *Vsechny pozorovatele
     */
    void notifyAllObservers ();
    
}
