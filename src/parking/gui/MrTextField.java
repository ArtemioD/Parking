package parking.gui;

import parking.settings.Style;

import javax.swing.*;

public final class MrTextField extends JTextField {
    public MrTextField(String title, int x, int y, int width, int height) {
        super(title);
        setBounds(x, y, width, height);
        setFont(Style.FONT_PATENT);
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    public MrTextField(int x, int y, int width, int height) {
        super();
        setBounds(x, y, width, height);
        setFont(Style.FONT_PATENT);
        setHorizontalAlignment(SwingConstants.CENTER);
    }
}
