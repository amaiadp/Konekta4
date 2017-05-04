package ui;

import java.awt.HeadlessException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import kud.LanguagesController;

public class IzenaSartu extends JOptionPane{
	private static LanguagesController hiztegi = Hizkuntza.getHiztegi();
	
	public static String showInputDialog(final Object message, final Object[] options)
            throws HeadlessException {
        final JOptionPane pane = new JOptionPane(message, QUESTION_MESSAGE,
                                                 OK_OPTION, null,
                                                 options, null);
        pane.setWantsInput(true);
        pane.setMessageType(QUESTION_MESSAGE);
        pane.selectInitialValue();
        final String title = hiztegi.getWord("Izena");
        final JDialog dialog = pane.createDialog(null, title);
        dialog.setVisible(true);
        dialog.dispose();
        final String value = (String)pane.getInputValue();
        return (value != null && (value.length() > 0) && value != UNINITIALIZED_VALUE) ? value : null;
    }
}
