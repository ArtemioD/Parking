package parking.gui;

import parking.Parking;
import parking.settings.Style;
import parking.settings.Text;

import javax.swing.*;
import java.text.DecimalFormat;

public final class PricePanel extends AbstractPanel implements Refresh {

    private MrTextField textField_1, textField_2, textField_3, textField_4;

    public PricePanel() {
        super(300, 0, 395, 440);
        init();
    }

    private void init() {
        add(new MrLabel(Text.get("PRICE_1"), 5, 35, 200, 30));
        add(new MrLabel(Text.get("PRICE_2"), 5, 115, 200, 30));
        add(new MrLabel(Text.get("PRICE_3"), 5, 200, 200, 30));
        add(new MrLabel(Text.get("PRICE_4"), 5, 285, 200, 30));

        DecimalFormat df = new DecimalFormat("0.00");
        textField_1 = new MrTextField(df.format(Parking.price[0]), 215, 30, 150, 40);
        textField_2 = new MrTextField(df.format(Parking.price[1]), 215, 110, 150, 40);
        textField_3 = new MrTextField(df.format(Parking.price[2]), 215, 195, 150, 40);
        textField_4 = new MrTextField(df.format(Parking.price[3]), 215, 280, 150, 40);

        add(textField_1);
        add(textField_2);
        add(textField_3);
        add(textField_4);
    }

    public double getTextField_1() {
        return formatiador(textField_1.getText());
    }

    public double getTextField_2() {
        return formatiador(textField_2.getText());
    }

    public double getTextField_3() {
        return formatiador(textField_3.getText());
    }

    public double getTextField_4() {
        return formatiador(textField_4.getText());
    }

    private double formatiador(String text) {
        char[] cambiar = text.toCharArray();
        for (int i = 0; i < cambiar.length; i++) if (cambiar[i] == ',') cambiar[i] = '.';
        String a = String.valueOf(cambiar);
        double d = Double.parseDouble(a);
        return d;
    }

    @Override
    public void refresh(int code) {
        if (code == 1) {
            removeAll();
            init();
        }else removeAll();
    }
}
