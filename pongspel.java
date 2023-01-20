import javax.swing.*;
import java.awt.*;

public class pongspel extends JPanel {
    static final int WINDOW_WIDTH = 664, WINDOW_HEIGHT = 540;
    private boll spelboll;
    private paddel spelarpaddel, datorpaddel;


    public pongspel(){

        spelboll = new boll(300, 200, 3, 3, 3, Color.WHITE, 10);
        spelarpaddel = new paddel(10, 200, 75, 3, Color.YELLOW);
        datorpaddel =  new paddel(650, 200, 75, 3, Color.GREEN);
    }   
    
    public void spellogik() {
        spelboll.rörelseboll();
        spelboll.studsa(0, WINDOW_HEIGHT);
    }


    // BAKGRUND
    public void paintComponent(Graphics g){
        //super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, WINDOW_WIDTH, 590);

        spelboll.paint(g);
        spelarpaddel.paint(g);
        datorpaddel.paint(g);
        

        //getRootPane().setBorder(
        //BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white)); 
        //setVisible(true);

            // Draw the white lines
        //g.setColor(Color.WHITE);
        
        //g.fillRect(getWidth()/2 - 10, 0, 10, getHeight()); // center line
        
    }

    

    
      

    



}