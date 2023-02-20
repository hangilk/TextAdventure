package org.sherwoodhs;

import org.sherwoodhs.situation.Situation;
import org.sherwoodhs.situation.EntranceSituation.EntranceSituation_0E;

import javax.swing.border.TitledBorder;
import java.awt.*;

import static org.sherwoodhs.ui.ActionPanel.actionPanel;
import static org.sherwoodhs.ui.Frame.FRAME;
import static org.sherwoodhs.ui.SituationPanel.situationPanel;
import static org.sherwoodhs.ui.TextPanel.textPanel;
import static org.sherwoodhs.ui.QuestPanel.questPanel;

public class AdvGame {
    private static Situation currentSituation;
    private static AdvGame advGame = new AdvGame();
    private AdvGame() {}

    //Starts game at TestConversation1_0D then makes frame visible
    public void startGame() {
        setSituation(EntranceSituation_0E.getInstance());
        EventQueue.invokeLater(() -> {
            FRAME.setVisible(true);
        });
    }

    public static AdvGame getInstance() {
        return advGame;
    }

    //Changes situation and updates frame
    public static void setSituation(Situation situation) {
        currentSituation = situation;
        updateFrame();
    }
    public Situation getCurrentSituation (){
        return currentSituation;
    }

    /* Updates the frame */
    public static void updateFrame() {
        situationPanel.setSituationLabel(currentSituation.getTitle()); // Changes Situation Title
        textPanel.clearAllText(); // Empties the textfield
        textPanel.addText(currentSituation.getDescription()); // Changes textfield description
        textPanel.setBorder(new TitledBorder(currentSituation.getSitType().toString())); //setTitled border title
        actionPanel.initActions(currentSituation.getOptions()); //Changes buttons
    }

    public static void updateFrame(String newDesc, String[] options)
    {
        updateFrame(newDesc);
        actionPanel.initActions(options);
    }

    public static void updateFrame(String newDesc)
    {
        textPanel.addText("\n" + newDesc);
    }

    public static void addQuest(String quest)
    {
        questPanel.addQuest(quest);
    }

}
