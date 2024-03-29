package org.sherwoodhs.situation.OtherSide.OtherSide1;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.npc.OtherSide.Alchemist;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.HiddenAlcove.HiddenAlcove1_0E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import javax.swing.*;

/*
   You talk to the Alchemist before you obtain the item required.
    It's just a little dialogue interaction
 */
public class OtherSide1_3D implements Situation {
    private Player player = Player.getInstance();
    private NPC alchemist = Alchemist.getInstance();
    private static Situation situation = new OtherSide1_3D();
    private OtherSide1_3D(){

    }
    public static Situation getInstance() {
        return situation;
    }

    @Override
    public String getTitle() {
        return "A Request";
    }

    @Override
    public String getDescription() {
        return (alchemist.getName() + ": So, have you gotten the USB yet?\n\n" +
                player.getName() + ": Uhhh, not yet...\n\n" +
                alchemist.getName() + ": Just a reminder, you need to get USB from the Clearwater Warehouse.\n\n" +
                "You walk away, presumably to get the requested item.");
    }

    @Override
    public SitType getSitType() {return SitType.Dialogue;}

    @Override
    public String[] getOptions() {
        return new String[]{"Continue"};
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Continue" :
                AdvGame.setSituation(HiddenAlcove1_0E.getInstance());
                break;
        }
    }

    @Override
    public ImageIcon getImg() {
        return null;
    }
}
