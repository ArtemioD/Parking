package parking.gui.dialog;

import parking.gui.MainFrame;
import parking.settings.Text;

import javax.swing.*;

public final class ConfirmDialog {
    public static int show(MainFrame frame, String text, String title) {
        String[] option ={Text.get("YES"), Text.get("NO")};
        int resilt = JOptionPane.showOptionDialog(frame, text, title, JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
        return resilt;
    }

}
