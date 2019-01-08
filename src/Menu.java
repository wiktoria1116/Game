/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Image;

/**
 *
 * @author Wiktoria Smigecka
 */
public class Menu {
    
    private Image ZakonczGre;  // obiekt należący do menu, określa przycisk zakonczenia gry
    private Image NowaGra;      // obiekt należący do menu, określa przycisk NOwej gry
    private Image LiczbaPunktow; // Obiekt należący do menu, określający ilość punktów gracza
    private int x;              // zmienna pomocnicza określająca wartośc współrzędnej x
    private int y;              // zmienna pomocnicza określająca wartośc współrzędnej y
    
    /**
     * Konstruktor 
     * @param x
     * @param y
     */
    public Menu(int x, int y){
        this.x=x;
        this.y=y;
        
    
        ZakonczGre = new ImageIcon("obrazki/zakonczgre.png").getImage();
        NowaGra = new ImageIcon("obrazki/nowagra.png").getImage();
        LiczbaPunktow = new ImageIcon("obrazki/liczbapkt.png").getImage();
        
        
    }
    
    /**
     *
     * @param pulpit
     */
    public void drawMenu(Graphics pulpit){
        pulpit.drawImage(NowaGra, x, y, null);
        pulpit.drawImage(ZakonczGre, x, y+70, null);
        pulpit.drawImage(LiczbaPunktow, x, y+470, null); 
    }
    
}
