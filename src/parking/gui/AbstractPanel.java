package parking.gui;

import javax.swing.*;

public abstract class AbstractPanel extends JPanel {

    public AbstractPanel(int x, int y, int width, int height){
        super();
        setLayout(null);
        setBounds(x, y, width, height);
        setOpaque(false);
    }

}
