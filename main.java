import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {
    private static final int DELAY = 0;
    static JFrame f = new JFrame("Pong spel") ;
    

public static void main(String[] args) {
    
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.setSize(664,590);
    f.setVisible(true);

    pongspel game = new pongspel();
    f.add(game);
    f.setVisible(true);

    Timer timer = new Timer(10, new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            game.spellogik();
            game.repaint();
        }
    });
    timer.start();

    


}




}