import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;

public class pongspel extends JPanel implements MouseMotionListener {
    static final int WINDOW_WIDTH = 664, WINDOW_HEIGHT = 540;
    private boll spelboll;
    private paddel spelarpaddel, datorpaddel;
    private int spelarPoäng, datorPoäng;

    private int spelarmusY;
    private int bounceCount = 0;
    private ImageIcon förstaimage = new ImageIcon(getClass().getResource("fotboll.png"));
    //private ImageIcon litenImage = new ImageIcon(image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
    Image img = förstaimage.getImage();
    //TODO få så att spelboll ändrar storlek också
    //TODO Ändra pixlar på paddel så den studsar rätt
    Image img2 = img.getScaledInstance(20,20, java.awt.Image.SCALE_SMOOTH);
    private ImageIcon image = new ImageIcon(img2);



    public MainMenu meny;


   

    public pongspel(){

        spelboll = new boll(300, 200, 3, 3, 3, Color.WHITE, 10);
        spelarpaddel = new paddel(20, 200, 75, 10, Color.BLACK);
        datorpaddel =  new paddel(615, 200, 75, 5, Color.DARK_GRAY);
        
        meny = new MainMenu(this);


        spelarmusY = 0;
        spelarPoäng = 0;
        datorPoäng = 0;


        addMouseMotionListener(this);
        this.addMouseListener(meny);
        this.addMouseMotionListener(meny);
        
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

        if(spelarpaddel.kontrollKollisionSpelare(spelarpaddel, spelboll)){
            spelboll.studsPaddel();
            bounceCount++;
        }

        if(datorpaddel.kontrollKollisionDator(datorpaddel, spelboll)){
            spelboll.studsPaddel();
            bounceCount++;
        }
        if(bounceCount == 5){
            bounceCount = 0;

            spelboll.ökahastighet();
        }


        if(spelboll.getX() < 0){
            datorPoäng++;
            reset();
        }
        else if(spelboll.getX() > WINDOW_WIDTH){

            spelarPoäng++;
            reset();
        }


        /*if (datorpaddel.kontrollKollision(spelboll) || spelarpaddel.kontrollKollision(spelboll)) { 
            spelboll.reverseX();

            
        }*/



        
        
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
        g.setColor(new Color(255, 140, 0));
        g.fillRect(0, 0, WINDOW_WIDTH, 590);
        
      //draw circle outline
        //g.drawOval(80,80,150,150);

        g.drawImage(image.getImage(), spelboll.getX(), spelboll.getY(), this);
        
        spelarpaddel.paint(g);
        datorpaddel.paint(g);
        getRootPane().setBorder(
        BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white)); 
        setVisible(true);

            // Draw the white lines
        g.setColor(Color.WHITE);
        
        
        g.fillRect(getWidth()/2 - 10, 0, 10, getHeight()); // center line
        
        
        


        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
        g.drawString("Spelare [ " + spelarPoäng + " ]   Dator [ " + datorPoäng + " ]", 163, 30 );
        

        
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
       
        spelarmusY = e.getY();
    }
    public void start() {
    }

    

    
      

    



}