package org.sherwoodhs.situation.Foundation.FoundationHQ.armory;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.player.Player;

import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;
import org.sherwoodhs.situation.Foundation.FoundationHQ.FoundationHub_0E;

import javax.swing.*;

public class FoundationBlacksmith_1E implements Situation {
    private static Situation situation = new FoundationBlacksmith_1E();
    Player player = Player.getInstance();
    @Override
    public String getTitle() {
        return "The Forges";
    }

    @Override
    public String getDescription() {
        return "As you work on the makeshift kiln you add scrap pieces to the furnace." +
                "Carefully watching as they melt down into liquid metal." +
                "With a pair of tongs, you remove the molten metal from the furnace and pour it into poorly made bullet molds." +
                "Why is the foundation working with such poor equipment you think to yourself but suddenly you hear footsteps approaching behind you";
    }

    @Override
    public SitType getSitType() {
        return SitType.Interaction;
    }

    @Override
    public String[] getOptions() {
        String[] options = {"Turn Around", "Keep Working", "Leave Armory"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch(option){
            case "Turn Around":
                AdvGame.updateFrame( player.getName() + ": Whats going. \n\n " +
                                "Foundation Employee: We're running out of gunpowder. " +
                                "start making metal batons instead"
                        , new String[]{"Work on Batons"});
                break;
            case "Keep Working":
                AdvGame.updateFrame("As the footsteps draw close your hear a foundation employee tap your shoulder"
                        , new String[]{"Turn Around", "Ignore Him"});
                break;
            case "Ignore Him":
                AdvGame.updateFrame("You hear a disgruntled voice \n\n" +
                        "Foundation Employee: If you dont turn around right now I will notify senior officers about this act of insubordination"
                        , new String[]{"Turn Around", "Keep Ignoring"});
                break;
            case "Keep Ignoring":
                AdvGame.updateFrame("Foundation Employee: your loss." +
                        "You Hear footsteps walking away");
                World.changeStateI("Foundation Rep", -5);
                AdvGame.setSituation(FoundationBlacksmith_1E.getInstance());
                break;
            case "Walk over to the kiln":
                AdvGame.setSituation(FoundationBlacksmith_1E.getInstance());
                break;
            case "Work on Batons":
                AdvGame.updateFrame("You nod stopping the pouring of the bullet molds and switch over to making metal batons," +
                        "carefully shaping the hot metal into the correct shape and size." +
                        "The work is just as intense, and time seems to fly by but you cant help but wonder how they are running out of gunpowder.");
                break;
            case "Leave Armory":
                AdvGame.setSituation(FoundationHub_0E.getInstance());
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













