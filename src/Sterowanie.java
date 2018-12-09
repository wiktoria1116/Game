import java.awt.*;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
    private Image       znak;
    private Timer       zegar;
    private Znaki       stop;
    private Menu        menu;
   
  
    

  
 
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
            blad();
        }
            if ((wsp[1]>=202 || wsp[1]<=278) && wsp[0]>=626){
            blad();
        }
            
             if (wsp[1]>=202  && wsp[0]>=675){
            blad();
        }
              if (wsp[1]>=202  && wsp[0]>=665){
            blad();
        }
            repaint();
            
        }
          
     }
     
    
  public void powrot(){
            wsp[1]=540;
    }
  public static void blad(){

       JOptionPane.showMessageDialog(null, "Źle prowadzone auto!");
       System.exit(0);

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
    }//playSound()
  
  
 
  
  
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
        stop            = new Znaki(560, 112);
        menu            = new Menu (21, 40);
       
        
        wsp[0] = 368;
        wsp[1] = 540;

        zegar = new Timer();
        zegar.scheduleAtFixedRate(new Zadanie(),0,10);

        this.addKeyListener(new KeyListener(){

            public void keyPressed(KeyEvent e){
                switch(e.getKeyCode()){
                    case KeyEvent.VK_UP:      klawisze[0] = true; break;
                    case KeyEvent.VK_DOWN:    klawisze[1] = true; break;
                    case KeyEvent.VK_LEFT:    klawisze[2] = true; break;
                    case KeyEvent.VK_RIGHT:   klawisze[3] = true; break;
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
  }
    
    public static void main(String[] args)
    {
       
        muzyka();
        Sterowanie okno = new Sterowanie();
        okno.repaint();
  
    }
    

    public void paint(Graphics g)
    {
      
        BufferStrategy bstrategy = this.getBufferStrategy();
        Graphics2D g2d = (Graphics2D)bstrategy.getDrawGraphics();

        g2d.drawImage(tlo1, 0,0,null);
        g2d.drawImage(samochodzik,wsp[0],wsp[1],null);
        g2d.setColor(Color.DARK_GRAY);
        g2d.setFont(new Font("Arial",Font.BOLD,20));
        //g2d.drawString("Wsp x: " + wsp[0], 5, 55);
       // g2d.drawString("Wsp y: "+ wsp[1], 5, 100);
        
        if(wsp[1]<=305 && wsp[0]<=612 && wsp[0]>=425 ){
          stop.drawZnaki(g2d);
          
          }
      
        menu.drawMenu(g2d);
        g2d.dispose();
        bstrategy.show();
        
    }
    
 

}


