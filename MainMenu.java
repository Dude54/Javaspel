
import java.awt.event.MouseAdapter;

import javax.swing.UIDefaults.ActiveValue;

import java.awt.Rectangle;

public class MainMenu extends MouseAdapter {

    public boolean aktiv;

    //Knapp start
    private Rectangle spelBtn;
    private String spelText = "Spel";
    private boolean pHighlight = false;


    // knapp avslut
    private Rectangle AvslutaBtn;
    private String AvslutaText = "Avsluta";
    private boolean qHighlight = false;

    //private Font font;


public MainMenu(pongspel pongspel) {
    aktiv = true;
    pongspel.start();
    


}
    
}
