package org.sherwoodhs.situation.OtherSide.OtherSide3;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.npc.OtherSide.Alchemist;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.HavenHubHallway;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import javax.swing.*;

/*
   YOu
 */
public class OtherSide3_2_0E implements Situation {
    private Player player = Player.getInstance();
    private NPC alchemist = Alchemist.getInstance();
    private static Situation situation = new OtherSide3_2_0E();
    private OtherSide3_2_0E(){

    }
    public static Situation getInstance() {
        return situation;
    }

    @Override
    public String getTitle() {
        return "Don't Regret Your Decision";
    }

    @Override
    public String getDescription() {
        return ("You wake up. You're back in the hallway. You check your pockets, looking for the USB, but it isn't there. " +
                alchemist.getName() + " must've grabbed it from you while you were out.\n\n" +
                "You looked back at where the Hidden Alcove once stood. It's now gone... Only a blank wall stands its place.\n\n" +
                "It's too late for you to do anything about it now. You get up, pat off the dust from your knees, and continue on your way.\n\n" +
                "You don't look back.");
    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}

    @Override
    public String[] getOptions() {
        return new String[]{"Continue"};
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Continue" :
                AdvGame.setSituation(HavenHubHallway.getInstance());
                break;
        }
    }

    @Override
    public ImageIcon getImg() {
        return null;
    }
}
