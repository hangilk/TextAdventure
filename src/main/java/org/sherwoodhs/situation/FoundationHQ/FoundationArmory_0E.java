package org.sherwoodhs.situation.FoundationHQ;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.FoundationHQ.QuestTent.FoundationQuestTent_0E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import static org.sherwoodhs.World.getState;

public class FoundationArmory_0E implements Situation {

    private static Situation situation = new FoundationArmory_0E();


    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getDescription() {
        return "You see scrap metal and makeshift kilns that seem to have been overused";
    }

    @Override
    public SitType getSitType() {
        return null;
    }

    @Override
    public String[] getOptions() {
        String[] options = {"Talk to Blacksmith", "Go to quest tent", "Go back to HQ"};
        return options;


    }


    @Override
    public void perform(String option) {

            switch(option){
                case "Go back  to HQ":
                    AdvGame.setSituation(FoundationHub_0E.getInstance());
                    break;
                case "Talk to Blacksmith":
                    AdvGame.setSituation(FoundationBlacksmith_0E.getInstance());
                case "Go to quest tent":
                    AdvGame.setSituation(FoundationQuestTent_0E.getInstance());

            }
        }
    public static Situation getInstance(){
        return situation;
    }
}


