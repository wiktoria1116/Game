/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wikto
 */

import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import java.awt.Image;

public class Znak {
    private Image obrazek;
    private Image chmura;
    private int x;
    private int y;
    Znak(String znak_source) { 
        x=560;
        y=60;
       obrazek = new ImageIcon(znak_source).getImage();
       chmura  = new ImageIcon("obrazki/chmura.png").getImage();
    }
   
    public void drawZnak(Graphics2D plotno){
        plotno.drawImage(obrazek, x, y, null);
        plotno.drawImage(chmura, 0, 314, null);
    }
}
