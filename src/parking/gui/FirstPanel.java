package parking.gui;

import parking.settings.Text;

public final class FirstPanel extends AbstractPanel implements Refresh {

    public FirstPanel() {
        super(300, 0, 395, 440);
        init();
    }

    private void init() {
        add(new MrLabel(Text.get("FIRST_HI_1"), 5, 85, 365, 40));
        add(new MrLabel(Text.get("FIRST_HI_2"), 5, 165, 365, 40));
        add(new MrLabel(Text.get("FIRST_HI_3"), 5, 245, 365, 40));
    }

    @Override
    public void refresh(int code) {
        removeAll();
    }

}
