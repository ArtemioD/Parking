package parking.gui;

import parking.gui.dialog.AboutDialog;
import parking.settings.Settings;
import parking.settings.Style;
import parking.settings.Text;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class MainMenu extends JMenuBar {

    private MainFrame frame;
    private JMenuItem help;
    private JRadioButtonMenuItem menuRussian, menuSpanish, menuEnglish;

    public MainMenu(MainFrame frame) {
        super();
        this.frame = frame;
        init();
    }

    private void init() {

        JMenu menuLeng = new JMenu(Text.get("DIALOG_LANGUAGE"));
        menuLeng.setFont(Style.FONT_BUTTON_MENU);
        menuLeng.setIcon(Style.ICON_LANGUAGE);

        JMenu menuProg = new JMenu(Text.get("MENU_HELP"));
        menuProg.setFont(Style.FONT_BUTTON_MENU);
        menuProg.setIcon(Style.ICON_HELP);

        help = new JMenuItem(Text.get("DIALOG_ABOUT_TITLE"));
        help.setIcon(Style.ICON_ENGRANAJE);
        help.setFont(Style.FONT_BUTTON_MENU);
        menuProg.add(help);

        help.addActionListener(new GestionaMenus());

        add(menuLeng);
        add(menuProg);

        addRadioButton(menuLeng);
    }

    private void addRadioButton(JMenu menuLeng) {

        menuRussian = new JRadioButtonMenuItem(Text.get("MENU_LANGUAGE_RUSSIAN"));
        menuRussian.setIcon(Style.LANGUAGE_RUSSIAN);
        menuRussian.setFont(Style.FONT_BUTTON_MENU);
        menuRussian.addActionListener(new GestionaMenus());

        menuSpanish = new JRadioButtonMenuItem(Text.get("MENU_LANGUAGE_SPANISH"));
        menuSpanish.setIcon(Style.LANGUAGE_SPANISH);
        menuSpanish.setFont(Style.FONT_BUTTON_MENU);
        menuSpanish.addActionListener(new GestionaMenus());

        menuEnglish = new JRadioButtonMenuItem(Text.get("MENU_LANGUAGE_ENGLISH"));
        menuEnglish.setIcon(Style.LANGUAGE_ENGLISH);
        menuEnglish.setFont(Style.FONT_BUTTON_MENU);
        menuEnglish.addActionListener(new GestionaMenus());

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(menuEnglish);
        buttonGroup.add(menuRussian);
        buttonGroup.add(menuSpanish);

        if (Settings.getLANGUAGE().equals("ru")) menuRussian.setSelected(true);
        else if (Settings.getLANGUAGE().equals("en")) menuEnglish.setSelected(true);
        else menuSpanish.setSelected(true);

        menuLeng.add(menuEnglish);
        menuLeng.add(menuRussian);
        menuLeng.add(menuSpanish);
    }

    private class GestionaMenus implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object botonPulsado = e.getSource();
            if (botonPulsado == help) new AboutDialog().setVisible(true);
            if (botonPulsado == menuEnglish) {
                Settings.setLANGUAGE("en");
                Text.init();
                frame.refresh(1);
            }
            if (botonPulsado == menuRussian) {
                Settings.setLANGUAGE("ru");
                Text.init();
                frame.refresh(1);
            }
            if (botonPulsado == menuSpanish) {
                Settings.setLANGUAGE("es");
                Text.init();
                frame.refresh(1);
            }
        }
    }

}
