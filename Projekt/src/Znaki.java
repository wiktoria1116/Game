/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wikto
 * @author wikto
 */
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import java.awt.Image;

public class Znaki {
    private Image obrazek;
    private Image pytanie1;
    private int x;
    private int y;
    Znaki() { 
        x=0;
        y=0;
       obrazek = new ImageIcon("obrazki/stop.png").getImage();
    }
    Znaki(int x, int y){
       obrazek = new ImageIcon("obrazki/stop.png").getImage();
       pytanie1= new ImageIcon("obrazki/stoppytanie.png").getImage();
       this.x = x;
       this.y = y;
    }
    
    public void drawZnaki(Graphics2D plotno){
        plotno.drawImage(obrazek, x, y, null);
        plotno.drawImage(pytanie1, 0, 200, null);
    }
}
