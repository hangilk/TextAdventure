package org.sherwoodhs.quest.foundation;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.quest.Quest;

public class GuardQuest implements Quest {
    private static Quest quest = new ScrapMetalCollection();

    private static int tracker = 0;
    String description;
    private static boolean status = false;


    @Override
    public String getName() {
        return "Guard Shift\n    Hours: " + tracker;
    }

    public static int getTracker() {
        return tracker;
    }

    public static void advanceQuest(){
        AdvGame.removeQuest(GuardQuest.getInstance());
        tracker++;
        AdvGame.addQuest(GuardQuest.getInstance());
        if(tracker == 6){
            status = true;
        }
    }

    @Override
    public String getDescription() {
        description = "Guard Foundation interests and \"secure\" The Haven.";
        return description;
    }

    @Override
    public void setDescription(String newDescription) {
        description = newDescription;
    }

    @Override
    public boolean isCompleted() {
        if(status){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public void complete() {
        status = true;
    }



    public static Quest getInstance(){
        return quest;
    }

}
