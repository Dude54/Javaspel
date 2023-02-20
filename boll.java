import javax.swing.text.AttributeSet.ColorAttribute;
import javax.swing.*;
import java.awt.*;


public class boll {
private int x, y, cx, cy, hastighet, storlek;
private Color color;
static final int MAX_HASTIGHET = 100;
//private ImageIcon image = new ImageIcon(getClass().getResource("fotboll.png"));





public boll(int x, int y, int cx, int cy, int hastighet, Color color, int storlek) {
    this.x = x;
    this.y = y;
    this.cx = cx;
    this.cy = cy;
    this.hastighet = hastighet;
    this.color = color;
    this.storlek = storlek;
    

    

 }
 /*public void paint(Graphics g){
    g.drawImage(image.getImage(), x, y, storlek, storlek, null);
    

    
    
    
    

}*/

public void rörelseboll(){
    x += cx;
    y += cy;
}

public void studsPaddel(){
    reverseX();
}

public void studsa(int top, int bottom) {
    if (y > bottom){
        reverseY();
    }
    else if(y < top ){
        reverseY();
    }

   
 
}

    public void reverseY() {
    cy *= -1;
}

    public void reverseX() {
    cx *= -1;
}
    public int getY(){
        return y;
    }
    public int getX(){
        return x;
    }
    public int getSize() {
        return 0;
    }
    public void setX(int i) {
        x = i;
    }
    public void setY(int i) {
        y = i;
    }
    public void setCx(int i) {
        cx = i;
    }
    public void setCy(int i) {
        cy = i;
    }
    public void setHastighet(int i) {
        hastighet = i;
    }

    public void ökahastighet() {
        if (hastighet < MAX_HASTIGHET){
            hastighet++;

            cx = (cx / Math.abs(cx)*hastighet); 
            cy = (cy / Math.abs(cy)*hastighet); 


        }
    }

       



}



