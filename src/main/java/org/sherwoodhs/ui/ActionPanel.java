package org.sherwoodhs.ui;

import org.sherwoodhs.AdvGame;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionPanel extends JPanel {
    public static final ActionPanel actionPanel = new ActionPanel();
    private AdvGame adv;

    private ActionPanel() {
        super(new GridLayout(2, 3));
        setPreferredSize(new Dimension(750, 170));
        setBorder(new TitledBorder("Actions"));
        adv = AdvGame.getInstance();
    }
    /**
     * Adds # number of JButtons that represents the actions the player can take
     * @param texts represents the prompts the player will be given in each JButton, texts.length represents the amount of buttons added to the panel
     */
    public void initActions(String[] texts) {
        if (texts.length == 0)
            return;
        if (texts.length > 6)
            return;
        removeAllActions();
        int blanks = 0;
        for (String element : texts) {
            // if the element  cycling through is not blank
            if (!element.equals("")) {
                JButton action = new JButton(getWrappedText(element));
                action.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton b = (JButton) e.getSource();
                        String s = b.getText()
                                .replace("<html><center>", "")
                                .replace("</center></html>", "");
                        adv.getCurrentSituation().perform(s);
                    }
                });
                add(action);
            } else {
                blanks++;
            }
        }
        // adds empty space to non-existent cells
        for (int i = 0; i < 6 - (texts.length - blanks); i++) {
            add(new JLabel());
        }
    }
    /**
     * Changes the content and action of one button that is present in the panel
     * @param s represents the action that will be searched for to remove
     * @param text represents the text that will replace String s
     */
    public void changeAction(String s, String text) {
        Component[] comp = getComponents();
        for (Component element : comp) {
            if (element instanceof JButton) {
                // if the text of JButton element is equivalent to String s
                if (((JButton) element).getText().equals(s)) {
                    // sets text of the button to be changed
                    ((JButton) element).setText(text);
                    // sets actions of the button to be changed
                    ((JButton) element).addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // situation
                        }
                    });
                    return;
                }
            }
        }
        // will not achieve anything if a JButton with the content String s cannot be found on the panel
    }
    /**
     * Removes one button present in the panel
     * @param s represents the action that will be searched for to remove
     */
    public void removeAction(String s) {
        Component[] comp = getComponents();
        for (Component element : comp) {
            if (element instanceof JButton) {
                if (((JButton) element).getText().equals(s)) {
                    remove(element);
                }
            }
        }
        // will not achieve anything if a JButton with the content String s cannot be found on the panel
    }
    /**
     * Removes all action buttons in the panel
     */
    public void removeAllActions() {
        Component[] comp = getComponents();
        for (Component element : comp) {
            remove(element);
        }
    }
    private String getWrappedText(String s) {
        s = "<html><center>" + s + "</center></html>";
        return s;
    }
}