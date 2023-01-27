import java.awt.*;

public class paddel {
    private int höjd, x, y, hastighet;
    private Color color;

    static final int PADDEL_WIDTH = 15;

    public paddel(int x, int y, int höjd, int hastighet, Color color) {
        this.x = x;
        this.y = y;
        this.höjd = höjd;
        this.hastighet = hastighet;
        this.color = color;


    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, PADDEL_WIDTH, höjd);

    }

    public void rörelseMot(int rörY) {
        int mittenY = y + höjd / 2;

        if(Math.abs(mittenY - rörY) > hastighet){

        if(mittenY > rörY){
            y -= hastighet;

        }
        if(mittenY < rörY){
            y += hastighet;
        }
      } 
    }

    public boolean kontrollKollision(paddel p, boll b){
        int högerX = x + PADDEL_WIDTH;
        int bottenY = y + höjd;

        if(b.getX() > (x - b.getSize()) && b.getX() < högerX){
            //check if Ball is between the y values
            if(b.getY() > y && b.getY() < bottenY){
                return true;
            }

        }
        return false;

    }

}