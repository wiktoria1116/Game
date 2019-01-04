
import java.awt.Image;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wikto
 */
public class Panel {
     public static boolean pause=false;
    /** Zmienna stanu okreĹ›lajÄ…ca czy wybrano menu*/
    public static boolean levelPause=false;
    /**  Dopuszczalny czas gry   */
    public static long GAME_TIME=Long.MAX_VALUE;
    /**  Liczba poziomĂłw gry   */
    public final static long NO_LEVELS=2;
    /**  Obraz tĹ‚a   */
    public static Image bgImage;
    /**  Obraz ikony Menu   */
    public static Image menuImage;
    /**  Obraz ikony Menu powrotu do gry  */
    public static Image menuGameImage;
    /**  Obraz ikony logo   */
    public static Image logoImage;
    /** Obraz ikony kursora - tarcza*/
    public static Image cursorImage;
    /**  Tablica obiektĂłw pierwszego planu   */
    public static Image samochodzik;
    /**  Zmienna stanu okreĹ›lajÄ…cam czy jest przerwa w grze   */

    public static long startTime;
    /** Zmienna pomocnicza okreĹ›lajÄ…ca czas ukoĹ„czenia aktualnego poziomu */
    public static double levelTime;
    /** Zmienna pomocnicza okreĹ›lajÄ…ca aktualny poziom gry */
    public static int MoveMODE=1;
    /** Zmienna pomocnicza okreĹ›lajÄ…ca status ukoĹ„czenia gry */
    public static boolean end=false;
    /** Zmienna pomocnicza okreĹ›lajÄ…ca maksymalnÄ… liczÄ™ obiektĂłw pierwszego planu */
    public static int noOfObjects=12;
    /** SzerokoĹ›Ä‡ pola graficznego gry */
    public static int gWidth=1024;
    /** WysokoĹ›Ä‡ pola graficznego gry */
    public static int gHeight=768;
   
    
    
    
    

    public static void loadInitialImages() {
        
        bgImage = loadImage("obrazki/tlo.jpg");
        menuImage=loadImage("obrazki/menu_1024.png");
        menuGameImage=loadImage("obrazki/gra_1024.png");
        logoImage=loadImage("obrazki/domestic_logo_url.png");
        samochodzik  =loadImage("obrazki/car.png");


        
    }//koniec loadInitialImages()
    
    /**
     * Metoda pobierania obiektu klasy Image na podstawie Ĺ›cieĹĽki
     * dostepu podanej jako String
     */
    public static Image loadImage(String fileName) {
        return new ImageIcon(fileName).getImage();
    }//koniec loadImage();
    
}//koniec class GameParameters   
    
