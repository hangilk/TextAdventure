package org.sherwoodhs.ui;

import org.sherwoodhs.quest.Quest;
import org.sherwoodhs.ui.util.CellRenderer;
import org.sherwoodhs.ui.util.DisabledItemSelectionModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class QuestPanel extends JPanel {
    public static final QuestPanel questPanel = new QuestPanel();
    private DefaultListModel<String> questListModel = new DefaultListModel<>();
    private JList<String> questList;
    private int index = 0;

    private QuestPanel() {
        super(new BorderLayout());
        setPreferredSize(new Dimension(150,550));
        setBorder(new TitledBorder("Current Quests"));

        questList = new JList<>(questListModel);
        questList.setSelectionModel(new DisabledItemSelectionModel());
        questList.setCellRenderer(new CellRenderer());
        add(questList);
    }
    /**
     * Adds one element to questList without clearing its contents after adding "> " to the beginning of the string
     * @param quest one element to be added to questList
     */
    public void addQuest(Quest quest) { // iterator doesn't work currently.

        String questName = "";
        questListModel.add(index, questName);

        for (int i = 0; i < questName.length(); i++) {
            questName += String.valueOf(setQuestConvention(quest.getName()).charAt(i));
            questListModel.set(index, questName);
        }

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        index++;

    }
    private String setQuestConvention(String s) {return "> " + s;}
    /**
     * Removes one element from questList without clearing its contents
     * @param quest one element to be removed from questList; method will not work if the element cannot be found
     */
    public void removeQuest(Quest quest) {
        String s = setQuestConvention(quest.getName());
        questListModel.removeElement(s);
        index--;
    }
    /**
     * Checks questList for quest
     * @param quest quest to be checked
     */
    public boolean containsQuest(Quest quest){
        String s = setQuestConvention(quest.getName());
        if(questListModel.contains(s)){
            return true;
        }else{
            return false;
        }
    }

    public void clearQuestList(){
        questListModel.clear();
        index = 0;
    }

}