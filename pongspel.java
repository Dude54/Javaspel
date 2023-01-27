import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseMotionListener;

public class pongspel extends JPanel implements MouseMotionListener {
    static final int WINDOW_WIDTH = 664, WINDOW_HEIGHT = 540;
    private boll spelboll;
    private paddel spelarpaddel, datorpaddel;
    private int spelarPoäng, datorPoäng;

    private int spelarmusY;

    


    public pongspel(){

        spelboll = new boll(300, 200, 3, 3, 3, Color.WHITE, 10);
        spelarpaddel = new paddel(20, 200, 75, 10, Color.BLUE);
        datorpaddel =  new paddel(615, 200, 75, 10, Color.CYAN);

        spelarmusY = 0;
        spelarPoäng = 0;
        datorPoäng = 0;


        addMouseMotionListener(this);
        
    }     
    public void reset() {
        spelboll.setX(300);
        spelboll.setY(200);
        spelboll.setCx(3);
        spelboll.setCy(3);
        spelboll.setHastighet(3);
        



    }


 
    public void spellogik() {
        spelboll.rörelseboll();
        spelboll.studsa(0, WINDOW_HEIGHT);
        spelarpaddel.rörelseMot(spelarmusY);
        datorpaddel.rörelseMot((spelboll.getY()));
        if(spelarpaddel.kontrollKollision(spelarpaddel, spelboll)){
            spelboll.studsPaddel();
        }
        if(datorpaddel.kontrollKollision(datorpaddel, spelboll)){
            spelboll.studsPaddel();
        }

        if(spelboll.getX() < 0){
            datorPoäng++;
            reset();
        }
        else if(spelboll.getX() > WINDOW_WIDTH){

            spelarPoäng++;
            reset();
        }

        
        
    }
    
    /*public void kontrollKollision() {
        
    }*/

    @Override
    public void musdrag(MouseEvent e) {
        
    }
    
    
    @Override
    public void musrörelse(MouseEvent e) {
        spelarmusY = e.getY();
    }  


    // BAKGRUND
    public void paintComponent(Graphics g){
        //super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, WINDOW_WIDTH, 590);

        spelboll.paint(g);
        spelarpaddel.paint(g);
        datorpaddel.paint(g);

        g.setColor(Color.WHITE);
        g.drawString("Poäng - Spelare [ " + spelarPoäng + " ] Dator [ " + datorPoäng + " ]", 250, 20);
        

        //getRootPane().setBorder(
        //BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white)); 
        //setVisible(true);

            // Draw the white lines
        //g.setColor(Color.WHITE);
        
        //g.fillRect(getWidth()/2 - 10, 0, 10, getHeight()); // center line
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
       
        spelarmusY = e.getY();
    }

    

    
      

    



}