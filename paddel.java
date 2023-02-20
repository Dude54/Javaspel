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

    public boolean kontrollKollisionSpelare(paddel p, boll b){
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

    public boolean kontrollKollisionDator(paddel p, boll b){
        int WINDOW_WIDTH = 664;
        int VänsterX = x-(PADDEL_WIDTH*2);
        int bottenY = y + höjd;

        /*if(b.getX() > (x + b.getSize()) && b.getX() > 415){
            //check if Ball is between the y values
            /*if(b.getY() > y && b.getY() < bottenY){
                return true;
            }
            return true;


        }*/
        if((b.getX() + 10) > 615){
            if(b.getY() > y && b.getY() < bottenY){
        return true;
            }
        }
        return false;


    }

}