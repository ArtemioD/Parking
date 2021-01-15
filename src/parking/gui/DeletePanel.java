package parking.gui;

import parking.settings.Text;

import javax.swing.*;

public final class DeletePanel extends AbstractPanel implements Refresh {

    private MrTextField textField;
    private MrButton displayDate, displayPay;

    public DeletePanel() {
        super(300, 0, 395, 440);
        init();
    }

    private void init() {
        add(new MrLabel(Text.get("CAR_PATENT"), 5, 10, 365, 30));
        add(new MrLabel(Text.get("CAR_TIME_ACTUAL"), 5, 125, 365, 40));
        add(new MrLabel(Text.get("TO_PAY"), 5, 240, 365, 40));
        add(new MrLabel(Text.get("TO_PAY_$"), 55, 290, 30, 50));

        textField = new MrTextField("", 30, 60, 260, 50);
        add(textField);

        displayDate = new MrButton("", 30, 180, 330, 50);
        add(displayDate);

        displayPay = new MrButton(100, 290, 180, 50);
        add(displayPay);
    }

    public MrButton getDisplayPay() {
        return displayPay;
    }

    public JTextField getTextField() {
        return textField;
    }

    public MrButton getDisplayDate() {
        return displayDate;
    }

    @Override
    public void refresh(int code) {
        if (code == 1) {
            removeAll();
            init();
        }else removeAll();
    }

}
