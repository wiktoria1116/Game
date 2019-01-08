/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import java.awt.Image;

/**
 * Klasa 
 * @author Wiktoria Smigecka
 */
public class Znak {
    private Image obrazek; //obiekt obrazek-droga i trawa
    private Image chmura; // obiekt chmura, na której wyświetlane są pytania
    private int x; // zmienna pomocnicza określająca wartośc współrzędnej x
    private int y; // zmienna pomocnicza określająca wartośc współrzędnej y
    Znak(String znak_source) { 
        x=560;
        y=60;
       obrazek = new ImageIcon(znak_source).getImage();
       chmura  = new ImageIcon("obrazki/chmura.png").getImage();
    }
   
    /**
     *Funkcja wyświetlająca obrazki- drogę i znak, który zmienia się losowo. 
     * @param plotno
     */
    public void drawZnak(Graphics2D plotno){
        plotno.drawImage(obrazek, x, y, null);
        plotno.drawImage(chmura, 0, 314, null);
    }
}
