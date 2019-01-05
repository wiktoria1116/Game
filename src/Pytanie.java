
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adule
 */
public class Pytanie {
    
    private static final int LICZBA_PYTAN = 3;
    private static final int LINIE_NA_PYTANIE = 6;
    private static final String PLIK_ZRODLOWY = "pytania/pytania.txt";
    private int nr_pytania;
    private String pytanie;
    private String odpA;
    private String odpB;
    private String odpC;
    private int poprawna;
    private String znak_source;
    private Znak znak;
    
    public Pytanie(){
        Random generator = new Random();
        nr_pytania = generator.nextInt(LICZBA_PYTAN) + 1;
        try {
            wczytajPytanie(nr_pytania);
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(Pytanie.class.getName()).log(Level.SEVERE, null, ex);
        }
        znak = new Znak(znak_source);
    }
    private void wczytajPytanie(int nr) throws FileNotFoundException{
        File pytania = new File(PLIK_ZRODLOWY);
        Scanner input = new Scanner(pytania);
        idzdoPytania(nr, input);
        pytanie = input.nextLine();
        znak_source = input.nextLine();
        odpA = input.nextLine();
        odpB = input.nextLine();
        odpC = input.nextLine();
        poprawna = input.nextInt();  
    }
    
    private void idzdoPytania(int nr, Scanner input){
        int poczatekPytania = (nr-1)*LINIE_NA_PYTANIE;
        for (int i = 0; i < poczatekPytania; i++){
            input.nextLine();
        }
    }

    public void wypiszPytanie(Graphics2D plotno){
        System.out.println(pytanie + "\n" + odpA + "\n" + odpB + "\n" + odpC + "\n" + poprawna + "\n" + znak_source + "\n");
    }
    public void wyswietlPytanie(Graphics2D plotno){
        znak.drawZnak(plotno);
        plotno.setColor(Color.DARK_GRAY);
        plotno.setFont(new Font("Arial",Font.BOLD,20));
        plotno.drawString(pytanie, 149, 399);
        plotno.drawString(odpA, 33, 480);
        plotno.drawString(odpB, 298, 517);
        plotno.drawString(odpC, 531, 457);
    }
    public int getPoprawna(){
        return poprawna;
    }
}
