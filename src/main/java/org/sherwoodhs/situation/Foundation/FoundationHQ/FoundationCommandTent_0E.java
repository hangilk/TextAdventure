package org.sherwoodhs.situation.Foundation.FoundationHQ;

import org.sherwoodhs.AdvGame;

import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;
import org.sherwoodhs.situation.Foundation.FoundationHQ.QuestTent.FoundationQuestTent_0E;

public class FoundationCommandTent_0E implements Situation {
    private static Situation situation = new FoundationQuestTent_0E();
    @Override
    public String getTitle() {
        return "The Foundation command tent";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public SitType getSitType() {
        return SitType.Interaction;
    }

    @Override
    public String[] getOptions() {
        String[] options = {"Leave"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch(option){
            case "Leave":
                AdvGame.setSituation(FoundationHub_0E.getInstance());
                break;

        }
    }

    public static Situation getInstance(){
        return situation;
    }
}
