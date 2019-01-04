/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wikto
 */
class Status{
    /** Liczba zgromadzonych punktĂłw na danynm poziomie*/
    public int points;
    /** Numer poziomu */
    public int level;
    /** Czas gry na danym poziomie*/   
    public double time;
    
    /**
     * Zeruj parametry gry
     */
    public void reset(){
        points=0;
        level=1;
        time=0.0;
    }//reset()
    /**
     * Zeruj licznÄ™ punktĂłw
     */
    public void resetPoints(){
        points=0;
    }//resetPoints()
    /**
     * ZwiÄ™ksz wskaĹşnik poziomu
     */
    public void nextLevel(){
        level++;
    }//nextLevel()
}//koniec class GameStatus
