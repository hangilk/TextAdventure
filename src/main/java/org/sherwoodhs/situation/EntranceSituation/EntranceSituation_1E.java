package org.sherwoodhs.situation.EntranceSituation;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;
/*
The first situation inside the ikea. Moves the player towards the bedroom section.
 */

public class EntranceSituation_1E implements Situation {
    private static Situation situation = new EntranceSituation_1E();

    @Override
    public String getTitle() {
        return "Inside IKEA";
    }

    @Override
    public String getDescription() {
        return "You always realise that you hate doing something the moment it's too late to turn back. Ikea is such a maze. You need to find a bed and leave ASAP, before they close.";
    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}

    @Override
    public String[] getOptions() {
        String[] options = {"Food Court", "Bedrooms", "Kitchens", "Staff only"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Food Court":
                AdvGame.updateFrame("The meatballs are good, but I don't have the time.");
                break;
            case "Bedrooms":
                AdvGame.setSituation(EntranceSituation_2E.getInstance());
                break;
            case "Kitchens":
                AdvGame.updateFrame("Thankfully all my appliances are hard to remove. I don't need to replace any of them.");
                break;
            case "Staff only":
                AdvGame.updateFrame("I would never want to work here.");
        }
    }

    public static Situation getInstance(){
        return situation;
    }

}