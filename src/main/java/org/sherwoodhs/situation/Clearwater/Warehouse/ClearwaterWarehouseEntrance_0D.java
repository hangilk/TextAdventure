package org.sherwoodhs.situation.Clearwater.Warehouse;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.quest.Misc.OtherSideQuest;
import org.sherwoodhs.situation.BoilerRoom.BoilerRoom_0E;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.OtherSide.OtherSide2.OtherSide2_0E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import javax.swing.*;

public class ClearwaterWarehouseEntrance_0D implements Situation {
    private static final Situation situation = new ClearwaterWarehouseEntrance_0D();

    @Override
    public String getTitle() {
        return "Warehouse Entrance";
    }

    @Override
    public String getDescription() {
        return "You walk across the plaza to a large bay door, currently shuttered by a metal grating. On the other " +
                "side of the grating, a wide hallway curves around out of sight. You hear distant sounds of shouting " +
                "echoing from the hall.\n\nA Foundation guard leans against the metal grating, eyeing you.";
    }

    @Override
    public SitType getSitType() {
        return SitType.Dialogue;
    }

    @Override
    public String[] getOptions() {
        return new String[]{"Talk", "Enter", "Leave"};
    }

    @Override
    public void perform(String option) {
        switch (option) {
            case "Talk":
                AdvGame.updateFrame("",
                        new String[]{"The Distributor sent me", "Bribe [100x scrap]"});
                break;
            case "Enter":
                AdvGame.updateFrame("Guard: Sorry pal, that’s a restricted area. No entry without " +
                                "proper clearance.\n\nHe stares at you",
                        new String[]{"Talk", "Leave"});
                break;
            case "The Distributor sent me":
                AdvGame.updateFrame("You: The Distributor told me to come here. He offered me a job working for " +
                                "Clearwater...this is the place, right?\n\nThe guard looks at you a moment longer, turns and spits, " +
                                "then presses a button on the wall.\n\nYou hear the sound of a creaky motor coming to life, and the metal grate rises.\n",
                        new String[]{"Enter ", "Leave"});
                break;
            case "Bribe [100x scrap]":
                AdvGame.updateFrame("The guard glances around, then nods silently and takes your offering. He presses " +
                                "a button on the wall and the metal grate slowly rises.",
                        new String[]{"Enter ", "Leave"});
                break;
            case "Enter ":
                String[] string = new String[]{"Continue", "Go into the boiler room", ""};
                if (OtherSideQuest.getProgress() == 1){
                    string[2] = "Follow the Map to Crete";
                }
                AdvGame.updateFrame("You step across the threshold and into the passageway. It’s poorly lit and has a greasy, mechanical look." +
                        "\n\nThere is a gray utility door off to your right with a small sign. The sign states, with red text, \"Boiler Room\".",
                        string);
                break;
            case "Go into the boiler room":
                AdvGame.setSituation(BoilerRoom_0E.getInstance());
                break;
            case "Follow the Map to Crete" :
                AdvGame.setSituation(OtherSide2_0E.getInstance());
                break;
            case "Continue":
                AdvGame.setSituation(ClearwaterWarehouse_0D.getInstance());
                break;
            case "Leave":
                AdvGame.setSituation(HavenCenter_E.getInstance());
                break;
        }
    }

    @Override
    public ImageIcon getImg() {
        return null;
    }

    public static Situation getInstance(){
        return situation;
    }
}
