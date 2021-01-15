package parking.gui;

import parking.gui.dialog.ConfirmDialog;
import parking.settings.Text;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public final class Listener extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent we) {
        int result = ConfirmDialog.show((MainFrame) we.getWindow(), Text.get("CONFIRM_EXIT_TEXT"), Text.get("CONFIRM_EXIT_TITLE"));
        if (result == JOptionPane.YES_OPTION) System.exit(0);
    }

}
