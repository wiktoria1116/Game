import java.awt.*;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;





public class Sterowanie extends JFrame{
    
    private Image       tlo1;
    private Image       samochodzik;
    private boolean     klawisze[];
    private int         wsp[];
    private Timer       zegar;
    private Menu        menu;
    private Graphics2D  g2d;
    private Pytanie     quest; 
    private boolean     wczytanoPytanie; 
    private boolean     wyswietlPytanie;
    private boolean     moznaWyswietlicPytanie;
    private boolean     pytanieisOn;
    private int         wybranaOdp;
    private int         punkty;
    private boolean     wyjechalPozadroge;
    private boolean     bylNaDrodze;
    private boolean     wyswietlnapisKoniecGry;
    private boolean     samochodzikWidzialny;
    private boolean     OdpPop;
    private boolean     wyswietlKomunikat;
    
    
    
    class Zadanie extends TimerTask{
        
        

        public void run()
        {

            if(klawisze[0])
                wsp[1]-=1;
            if(klawisze[1])
                wsp[1]+=1;

            if(klawisze[2])
                wsp[0]-=1;
            if(klawisze[3])
                wsp[0]+=1;

           wsp[0] = (wsp[0]<0)?0:wsp[0];
           wsp[0] = (wsp[0]>720)?720:wsp[0];
           wsp[1] = (wsp[1]<20)?20:wsp[1];
           wsp[1] = (wsp[1]>540)?540:wsp[1];
           
           
           
           if (wsp[1]==20){
               powrot();
           }
           
           if ((wsp[1]>=276 || wsp[1]<=510) && wsp[0]>=612){
               wyjechalPozadroge = true;
           }
           else if ((wsp[1]>=202 || wsp[1]<=278) && wsp[0]>=626){
               wyjechalPozadroge = true;
           }
           else if (wsp[1]>=202  && wsp[0]>=675){
               wyjechalPozadroge = true;
           }
           else if (wsp[1]>=202  && wsp[0]>=665){
               wyjechalPozadroge = true;
           }
           else{
               wyjechalPozadroge = false;
               bylNaDrodze = true;
           }
           if(wsp[1]<=305 && wsp[0]<=612 && wsp[0]>=425 && moznaWyswietlicPytanie == true){
               wyswietlPytanie = true;
           }
           else{
               wyswietlPytanie = false;
               pytanieisOn = false;
           }
           repaint();
            
           }
          
     }
     

    
  public void powrot(){
            wsp[1]=540;
            if(pytanieisOn){
                punkty--;
            }
            wczytanoPytanie = false;
            moznaWyswietlicPytanie = true;
    }
    
  public static void muzyka(){
      
            playSound(new File("dzwieki/odglos.wav"));
        
    }

  public static synchronized void playSound(final File f) {
        new Thread(new Runnable() {
          public void run() {
            try {
              Clip clip = AudioSystem.getClip();
              AudioInputStream inputStream = AudioSystem.getAudioInputStream(f);
              clip.open(inputStream);
              clip.start(); 
            } catch (Exception e) {
              System.err.println(e.getMessage());
            }
          }
        }).start();
    }
  
  
 
  
  
    Sterowanie(){        
        super("Good road");
        setBounds(50,60,800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        createBufferStrategy(2);

        klawisze        = new boolean[4];
        wsp             = new int[2];
        tlo1            = new ImageIcon("obrazki/droga.png").getImage();
        samochodzik     = new ImageIcon("obrazki/car.png").getImage();
        menu            = new Menu (21, 40);
        wczytanoPytanie = false;
        wyswietlPytanie = false;
        pytanieisOn     = false;
        wybranaOdp      = 0;
        punkty          = 0;
        wsp[0]          = 520;
        wsp[1]          = 540;
        bylNaDrodze     = true;
        wyjechalPozadroge = false;
        moznaWyswietlicPytanie = true;
        wyswietlnapisKoniecGry = false;
        samochodzikWidzialny = true;
        wyswietlKomunikat = false;
        

        zegar = new Timer();
        zegar.scheduleAtFixedRate(new Zadanie(),0,10);

        this.addKeyListener(new KeyListener(){

            public void keyPressed(KeyEvent e){
                switch(e.getKeyCode()){
                    case KeyEvent.VK_UP:      klawisze[0] = true; wyswietlKomunikat = false; break;
                    case KeyEvent.VK_DOWN:    klawisze[1] = true; wyswietlKomunikat = false; break;
                    case KeyEvent.VK_LEFT:    klawisze[2] = true; wyswietlKomunikat = false; break;
                    case KeyEvent.VK_RIGHT:   klawisze[3] = true; wyswietlKomunikat = false; break;
                }
            }

            public void keyReleased(KeyEvent e){
                switch(e.getKeyCode()){
                    case KeyEvent.VK_UP:      klawisze[0] = false; break;
                    case KeyEvent.VK_DOWN:    klawisze[1] = false; break;
                    case KeyEvent.VK_LEFT:    klawisze[2] = false; break;
                    case KeyEvent.VK_RIGHT:   klawisze[3] = false; break;
                }
            }
            
            public void keyTyped(KeyEvent e){
            }
            
            
        }
    );
        this.addMouseListener(new MouseAdapter(){
          @Override
            public void mouseClicked(MouseEvent me){    
              if(me.getX() > 30 && me.getX()< 180 && me.getY() > 66 && me.getY() < 89){
                NowaGra();
              }
              //Czy wybrano z Menu pozycję Koniec gry
              if(me.getX() > 23 && me.getX()< 208 && me.getY() > 123 && me.getY() < 157){
                System.exit(0);
              }
              if(me.getX() > 58 && me.getX() < 224 && me.getY() > 436 && me.getY() < 508 && pytanieisOn == true){
                  wybranaOdp = 1;
                  OdpPop = sprawdzOdp();
                  ZakonczGre();
              }
              if(me.getX() > 321 && me.getX() < 500 && me.getY() > 477 && me.getY() < 543 && pytanieisOn == true){
                  wybranaOdp = 2;
                  OdpPop = sprawdzOdp();
                  ZakonczGre();
              }
              if(me.getX() > 555 && me.getX() < 718 && me.getY() > 419 && me.getY() < 481 && pytanieisOn == true){
                  wybranaOdp = 3;
                  OdpPop = sprawdzOdp();
                  ZakonczGre();
                  
              }
          }
        }
    );
  }
    
    
    

    @Override
    public void paint(Graphics g) 
    {
      
        BufferStrategy bstrategy = this.getBufferStrategy();
        if (bstrategy == null)
        {
            createBufferStrategy(3);
            return;
        }
        g2d = (Graphics2D)bstrategy.getDrawGraphics(); 
        g2d.drawImage(tlo1, 0, 0, null);
        g2d.setColor(Color.DARK_GRAY);
        g2d.setFont(new Font("Arial",Font.BOLD,20));
        //g2d.drawString("Wsp x: " + wsp[0], 5, 55);
        //g2d.drawString("Wsp y: " + wsp[1], 5, 100);
        g2d.setColor(Color.RED);
        g2d.setFont(new Font("Arial",Font.BOLD,30));
        g2d.drawString(Integer.toString(punkty), 172, 550);
        
        if(wyswietlPytanie){
            pokazPytanie();
        }

        if(menu != null){
            menu.drawMenu(g2d);
        }
        if(wyjechalPozadroge){
            pozaDroga();
        }
        if(wyswietlnapisKoniecGry){
            g2d.setColor(Color.RED);
            g2d.setFont(new Font("Arial",Font.BOLD,50));
            g2d.drawString("Koniec gry!" , 300, 250);
            g2d.drawString("Twoj wynik: " + punkty, 300, 330);
        }
        if(samochodzikWidzialny){
            g2d.drawImage(samochodzik,wsp[0],wsp[1],null);
        }
        if(wyswietlKomunikat){
            if(OdpPop){
            g2d.setColor(Color.BLUE);
            g2d.setFont(new Font("Arial",Font.BOLD,50));
            g2d.drawString("Dobra odpowiedz!" , 190, 250);
            }
            else{
            g2d.setColor(Color.RED);
            g2d.setFont(new Font("Arial",Font.BOLD,50));
            g2d.drawString("Zla odpowiedz!" , 210, 250);
            }
            
        }
        g2d.dispose();
        bstrategy.show();
        
    }
    
    public void pozaDroga(){
        g2d.setColor(Color.RED);
        g2d.setFont(new Font("Arial",Font.BOLD,50));
        g2d.drawString("Wyjechales poza droge!", 110, 300);
        if(bylNaDrodze){
            punkty--;
            bylNaDrodze = false;
        }
    }
   
    public void pokazPytanie(){
        if (wczytanoPytanie == false){
            quest = new Pytanie();
            wczytanoPytanie = true;
        }
        if(wczytanoPytanie){
        quest.wyswietlPytanie(g2d);
        pytanieisOn = true;
        }
    }
    public boolean sprawdzOdp() {
        if (wybranaOdp == quest.getPoprawna())
        {
            moznaWyswietlicPytanie = false;
            punkty++;
            wyswietlKomunikat = true;
            return true;
        }
        else 
        {
            moznaWyswietlicPytanie = false;
            punkty--;
            wyswietlKomunikat = true;
            return false;
        }
   
    }
    public void NowaGra(){
        punkty = 0;
        wsp[0]          = 520;
        wsp[1]          = 540;
        wyswietlnapisKoniecGry = false;
        samochodzikWidzialny   = true;
    }
    
    public void ZakonczGre(){
        if (punkty >= 10){
        wyswietlnapisKoniecGry = true;
        samochodzikWidzialny   = false;
        }
        
    }
    
    
 public static void main(String[] args)
    {
       
        //muzyka();
        Sterowanie okno = new Sterowanie();
        okno.repaint();
        
        
        
        
        
    }

}


