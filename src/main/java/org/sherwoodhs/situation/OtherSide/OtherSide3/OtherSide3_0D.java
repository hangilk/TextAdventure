package org.sherwoodhs.situation.OtherSide.OtherSide3;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.npc.OtherSide.Alchemist;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import javax.swing.*;

/*
 This event only occurs have fulfilled part II of the questline and return to the hidden alcove.
 You get to decide whether or not you give the USB to the alchemist.
 */
public class OtherSide3_0D implements Situation {
    private NPC alchemist = Alchemist.getInstance();
    private Player player = Player.getInstance();
    private static Situation situation = new OtherSide3_0D();
    private OtherSide3_0D(){
    }
    public static Situation getInstance() {
        return situation;
    }

    @Override
    public String getTitle() {
        return "Item Fetched";
    }

    @Override
    public String getDescription() {
        String string = "You returned back to the Hidden Alcove with the USB in hand. When you entered, " + alchemist.getName() +
                " was sitting at a table with some glassware on top.\n\n" +
                player.getName() + ": Ahem, I got the USB you wanted.\n\n" +
                alchemist.getName() + " turned around to see you.\n\n" +
                alchemist.getName() + ": You- you actually got it!\n\n";
        if (alchemist.getName().equals("Hecate")){
            alchemist.changeRelModifier(5);
            string += alchemist.getName() + " was so surprised that that she jumped up from her chair, knocking off her hood." +
                    "You could see the sheer surprise in her eyes. She did not expect someone like you to accomplish her task." +
                    "There was also the faintest smile smile on her face.\n\n" +
                    "(+5 relationship with " + alchemist.getName() + ")\n\n" +
                    alchemist.getName() + ": Thank you.\n\n" +
                    "You could tell she was being truly grateful right now.\n\n";
        } else {
            alchemist.changeRelModifier(3);
            string += alchemist.getName() + " was so surprised that she was stunned for a second before standing up." +
                    "You could catch a quick glimpse of glowing green eyes from underneath the hood.\n\n" +
                    alchemist.getName() + ": I didn't think you would be able to get that, if I'm going to be honest." +
                    "You didn't give me the best first impression.\n\n" +
                    "(+3 relationship with " + alchemist.getName() + ")\n\n" +
                    "You could tell she was truly impressed with you right now.\n\n";
        }
        string += alchemist.getName() + ": Can you please hand over that USB?";
        return (string);
    }

    @Override
    public SitType getSitType() {return SitType.Dialogue;}

    @Override
    public String[] getOptions() {
        return new String[]{"Hand the item over", "Refuse to hand the item over"};
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Hand the item over" :
                AdvGame.setSituation(OtherSide3_1_0D.getInstance());
                break;
            case "Refuse to hand the item over":
                if (alchemist.getObRel() == -5){

                } else { //Death
                    //AdvGame.setSituation(.getInstance());
                    break;
                }
        }

    }

    @Override
    public ImageIcon getImg() {
        return null;
    }
}
