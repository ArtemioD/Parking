package parking.gui;

import parking.Parking;
import parking.settings.Style;
import parking.settings.Text;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class CarListPanel extends AbstractPanel implements Refresh{

    private JTextArea display;

    public CarListPanel() {
        super(300, 0, 395, 440);
        init();
    }

    private void init() {
        display = new JTextArea();
        display.setFont(Style.FONT_TEXT_FIELD);
        for (int i = 0; i < Parking.cars.size(); i++) {
            DateFormat date = new SimpleDateFormat("HH:mm  dd/MM/yyyy");
            display.append("******************************************************************\n " +
                    Text.get("TABLE_CAR_PATENT") + Parking.cars.get(i).getPatente() + "\n\t" +
                    Text.get("TABLE_CAR_TIME") + date.format(Parking.cars.get(i).getDate()) +
                    "\n******************************************************************\n");
        }
        display.setEditable(false);
        JScrollPane scroll = new JScrollPane(display);

        scroll.setBounds(15, 15, 350, 410);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroll);
    }

    @Override
    public void refresh(int code) {
        if (code == 1) {
            removeAll();
            init();
        }else removeAll();
    }

}
