import javax.swing.text.AttributeSet.ColorAttribute;
import javax.swing.*;
import java.awt.*;

public class boll {
private int x, y, cx, cy, hastighet, storlek;
private Color color;

public boll(int x, int y, int cx, int cy, int hastighet, Color color, int storlek) {
    this.x = x;
    this.y = y;
    this.cx = cx;
    this.cy = cy;
    this.hastighet = hastighet;
    this.color = color;
    this.storlek = storlek;
    

 }
 public void paint(Graphics g){

    //set the brush color to the ball color
    g.setColor(color);

    //paint the ball at x, y with a width and height of the ball size
    g.fillOval(x, y, storlek, storlek);

}

public void rörelseboll(){
    x += cx;
    y += cy;
}

public void studsa(int top, int bottom) {
    if (y > bottom){
        reverseY();
    }
    else if(y < top ){
        reverseY();
    }

    if(x < 0){
        reverseX();
    }
    else if(x > 640){
        reverseX();
    }

}

public void reverseY() {
    cy *= -1;
}

public void reverseX() {
    cx *= -1;
}

}



