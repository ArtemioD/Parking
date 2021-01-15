package parking.gui;

import parking.settings.Style;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public final class MrButton extends JButton {

    public MrButton(String title, ImageIcon icon, int x, int y, int width, int height) {
        super(title);
        setIcon(icon);
        addMouseListener(new HoverButton()); // внутренний класс
        setBounds(x, y, width, height);
        setFont(Style.FONT_BUTTON);
        setForeground(Style.COLOR_BUTTON_FOREGROUND);
        setBackground(Style.COLOR_BUTTON_BACKGROUND); // los dos para que
        setOpaque(false);                             // sea transparente
        setFocusPainted(false);
    }

    public MrButton(String title, int x, int y, int width, int height) {
        super(title);
        setBounds(x, y, width, height);
        setEnabled(false);
        setFont(Style.FONT_TIME);
        setForeground(Color.BLACK);
    }

    public MrButton(int x, int y, int width, int height) {
        super();
        setBounds(x, y, width, height);
        setEnabled(false);
        setFont(Style.FONT_TIME);
        setForeground(Color.BLACK);
    }

    private class HoverButton extends MouseAdapter {

        @Override
        public void mouseEntered(MouseEvent e) {
            setOpaque(true);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setOpaque(false);
        }
    }

}
