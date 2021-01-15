package parking.settings;

import parking.fuentes.Fuentes;

import javax.swing.*;
import java.awt.*;

public final class Style {

    public static final Font FONT_BUTTON = Fuentes.fuente(Fuentes.NFS, 0, 25);
    public static final Font FONT_BUTTON_MENU = Fuentes.fuente(Fuentes.NFS, 0, 11);
    public static final Font FONT_TEXT_FIELD = new Font("Roboto-Light", Font.BOLD, 13);
    public static final Font FONT_PATENT = new Font("Roboto-Light", Font.BOLD, 30);
    public static final Font FONT_LABEL = Fuentes.fuente(Fuentes.NFS, 0, 30);
    public static final Font FONT_TIME = new Font("Roboto-Light", Font.BOLD, 25);

    public static final Color COLOR_BUTTON_BACKGROUND = new Color(195, 214, 0);
    public static final Color COLOR_BUTTON_FOREGROUND = new Color(255, 255, 255);

    public static final ImageIcon ICON_PARKING = new ImageIcon("img\\logo_parking.png");

    public static final Icon ICON_ENGRANAJE = new ImageIcon("img\\engranaje.png");
    public static final ImageIcon ICON_ABOUT = new ImageIcon("img\\engranaje.png");
    public static final ImageIcon ICON_HELP = new ImageIcon("img\\help.png");
    public static final Icon ICON_LANGUAGE = new ImageIcon("img\\language.png");

    public static final ImageIcon ICON_VEHICLE_ENTRY = new ImageIcon("img\\icon_register2.png");
    public static final ImageIcon ICON_VEHICLE_DEPARTURE = new ImageIcon("img\\icon_exit2.png");
    public static final ImageIcon ICON_CAR_LIST = new ImageIcon("img\\icon_lista2.png");
    public static final ImageIcon ICON_CASH_PRICE = new ImageIcon("img\\cash.png");
    public static final ImageIcon ICON_EXIT = new ImageIcon("img\\icon_fin2.png");

    public static final ImageIcon SAVE_ICON = new ImageIcon("img\\save.png");
    public static final ImageIcon SEARCH_ICON = new ImageIcon("img\\search.png");
    public static final ImageIcon BORRAR_ICON = new ImageIcon("img\\borrar.png");

    public static final Icon LANGUAGE_RUSSIAN = new ImageIcon("img\\language_russian.png");
    public static final Icon LANGUAGE_SPANISH = new ImageIcon("img\\language_spanish.png");
    public static final Icon LANGUAGE_ENGLISH = new ImageIcon("img\\language_english.png");

}
