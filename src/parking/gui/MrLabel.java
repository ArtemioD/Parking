package parking.gui;

import parking.settings.Style;

import javax.swing.*;

public final class MrLabel extends JLabel {

    public MrLabel(String title, int x, int y, int width, int height) {
        super(title, SwingConstants.CENTER);
        setBounds(x, y, width, height);
        setForeground(Style.COLOR_BUTTON_FOREGROUND);
        setFont(Style.FONT_LABEL);
    }

}
