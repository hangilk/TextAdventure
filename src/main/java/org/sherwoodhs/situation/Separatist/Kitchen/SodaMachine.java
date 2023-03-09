package org.sherwoodhs.situation.Separatist.Kitchen;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.Separatist.WorkPlace;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class SodaMachine implements Situation {

    // REVERT EVERYTHING TO EXPLORATION TYPE, MAKE INDIVIDUAL CLASSES FOR EVERY OPTION (maybe with adding previous text in backwards).
    private static boolean firstTime = true;
    private static Situation situation = new SodaMachine();

    @Override
    public String getTitle() {
        return "Burger Station";
    }

    @Override
    public String getDescription() {
        return "You are standing in front of the soda machine. Fill up cups with soda.\n" +
                "_______________\n" +
                "|S||C||W||F||M|\n" +
                "|V  V  V  V  V|\n" +
                "|_____________|";
    }

    @Override
    public SitType getSitType() {return SitType.Interaction;}

    @Override
    public String[] getOptions() {
        String[] options = {"Back to Kitchen"}; // limit 6
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){

            // MAIN BRANCH

            // EXIT POINT
            case "Back to Kitchen":
                firstTime = false;
                AdvGame.setSituation(Kitchen.getInstance());
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }

}
