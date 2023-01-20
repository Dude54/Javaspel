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

}