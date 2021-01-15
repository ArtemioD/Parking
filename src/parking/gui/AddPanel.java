package parking.gui;

import parking.settings.Text;

import javax.swing.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public final class AddPanel extends AbstractPanel implements Refresh, Runnable {

    private String hora, minutos, segundos;
    private Thread h1;
    private MrButton buttonHora;
    private MrTextField textField;

    public AddPanel() {
        super(300, 0, 395, 440);
        init();
        h1 = new Thread(this);
        h1.start();
    }

    private void init() {
        add(new MrLabel(Text.get("CAR_PATENT"),5, 40, 365, 40));
        add(new MrLabel(Text.get("CAR_TIME_ACTUAL"), 5, 190, 365, 40));

        textField = new MrTextField(40, 100, 300, 50);
        add(textField);

        buttonHora = new MrButton(110, 260, 160, 50);
        add(buttonHora);
    }

    public JTextField getTextField() {
        return textField;
    }

    @Override
    public void refresh(int code) {
        if (code == 1) {
            removeAll();
            init();
        }else removeAll();
    }

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == h1) {
            calcula();
            buttonHora.setText(hora + ":" + minutos + ":" + segundos);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error en 'AddPanel' con reloj");
            }
        }
    }

    private void calcula() {
        Calendar calendar = new GregorianCalendar();
        Date fechaHoraActual = new Date();

        calendar.setTime(fechaHoraActual);
        hora = calendar.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendar.get(Calendar.HOUR_OF_DAY) : "0" + calendar.get(Calendar.HOUR_OF_DAY);
        minutos = calendar.get(Calendar.MINUTE) > 9 ? "" + calendar.get(Calendar.MINUTE) : "0" + calendar.get(Calendar.MINUTE);
        segundos = calendar.get(Calendar.SECOND) > 9 ? "" + calendar.get(Calendar.SECOND) : "0" + calendar.get(Calendar.SECOND);
    }
}
