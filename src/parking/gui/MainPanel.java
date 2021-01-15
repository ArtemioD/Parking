package parking.gui;

import parking.settings.Style;
import parking.settings.Text;

public final class MainPanel extends AbstractPanel implements Refresh {

    private MrButton button1, button2, button3, button4, button5;

    public MainPanel() {
        super(0, 0, 300, 491);
        init();

        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
    }

    private void init() {
        button1 = new MrButton(Text.get("VEHICLE_ENTRY"), Style.ICON_VEHICLE_ENTRY, 15, 15, 270, 70);
        button2 = new MrButton(Text.get("VEHICLE_DEPARTURE"), Style.ICON_VEHICLE_DEPARTURE, 15, 100, 270, 70);
        button3 = new MrButton(Text.get("CAR_LIST"), Style.ICON_CAR_LIST, 15, 185, 270, 70);
        button4 = new MrButton(Text.get("PRICE_PARKING"), Style.ICON_CASH_PRICE, 15, 270, 270, 70);
        button5 = new MrButton(Text.get("EXIT"), Style.ICON_EXIT, 15, 355, 270,70);
    }

    public MrButton getButton1() {
        return button1;
    }

    public MrButton getButton2() {
        return button2;
    }

    public MrButton getButton3() {
        return button3;
    }

    public MrButton getButton4() {
        return button4;
    }

    public MrButton getButton5() {
        return button5;
    }

    @Override
    public void refresh(int code) {
        if (code == 1) {
            removeAll();
            init();
        }else {
            removeAll();
        }
    }

}
