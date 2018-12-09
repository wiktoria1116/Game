/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wikto
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import java.awt.Image;

public class Menu {
    
    private Image ZakonczGre;
    private Image NowaGra;
    private Image Poziom;
    private Image LiczbaPunktow;
    private int x;
    private int y;
    
    

    Menu(int x, int y){
        this.x=x;
        this.y=y;
        
    
     ZakonczGre = new ImageIcon("obrazki/nowagra.png").getImage();
     NowaGra = new ImageIcon("obrazki/zakonczgre.png").getImage();
     Poziom = new ImageIcon("obrazki/liczbapkt.png").getImage();
     LiczbaPunktow = new ImageIcon("obrazki/poziom.png").getImage();
        
    }
    
    public void drawMenu(Graphics pulpit){
     pulpit.drawImage(ZakonczGre, x, y, null);
     pulpit.drawImage(NowaGra, x, y+70, null);
     pulpit.drawImage(LiczbaPunktow, 620, y+470, null);
     pulpit.drawImage(Poziom, x, y+470, null);
     
    }
    
}
