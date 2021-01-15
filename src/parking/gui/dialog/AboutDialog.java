package parking.gui.dialog;

import parking.settings.Style;
import parking.settings.Text;

import javax.swing.*;

public final class AboutDialog extends JDialog {

    public AboutDialog() {
        super();
        init();
        setTitle(Text.get("DIALOG_ABOUT_TITLE"));
        setIconImage(Style.ICON_ABOUT.getImage());
        setResizable(false);
    }

    private void init() {
        JEditorPane pane = new JEditorPane("text/html", Text.get("ABOUT"));
        pane.setEditable(false);

        add(pane);
        pack();
        setLocationRelativeTo(null);
    }

}

