package org.sherwoodhs.quest.Foundation;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.quest.Quest;

public class ScrapMetalRepeatable implements Quest {
    private static Quest quest = new ScrapMetalRepeatable();

    private static int tracker = 0;
    String description;
    private static boolean completed = false;


    @Override
    public String getName() {
        return "Collect Scrap\n    Collected scrap: " + tracker;
    }

    public static int getTracker() {
        return tracker;
    }

    public static void advanceQuest(){
        AdvGame.removeQuest(ScrapMetalRepeatable.getInstance());
        tracker++;
        AdvGame.addQuest(ScrapMetalRepeatable.getInstance());
        if(tracker == 10){
            completed = true;
        }
    }

    @Override
    public String getDescription() {
        description = "Collect scrap metal for the Foundation";
        return description;
    }

    @Override
    public void setDescription(String newDescription) {
        description = newDescription;
    }

    @Override
    public boolean isCompleted() {
        if(completed){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public void complete() {
        completed = true;
    }

    @Override
    public void reset() {
        completed = false;
        tracker = 0;
        description = "Collect scrap metal for the Foundation";
    }


    public static Quest getInstance(){
        return quest;
    }

}
