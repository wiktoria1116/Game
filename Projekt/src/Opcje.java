

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wikto
 */
public class Opcje extends JPanel {
    
    public Opcje(int width, int height){
        
        Gra();
        
       
        
        /* Dodaj obsługę zdarzeń - wciśnięcie przycisku myszki*/
        addMouseListener(new MouseAdapter(){
           
          @Override
          public void mouseClicked(MouseEvent me){
              //Czy wybrano opcję Menu w pasku dolnym
              
              //Czy wybrano z Menu pozycję Koniec gry
              if(me.getX()>(10) && me.getX()<(179)  && me.getY()>(92) &&  me.getY()<(121)){
                  if(Pomocnicza.pause){
                      System.exit(1);
                  }
              }
          }
        });
        
                }       
    
    private void Gra(){
    
        Pomocnicza.czasStartu=System.currentTimeMillis();
        Pomocnicza.pause=false;}
    

}
          

