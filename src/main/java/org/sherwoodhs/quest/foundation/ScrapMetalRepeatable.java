package org.sherwoodhs.quest.foundation;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.quest.Quest;
import org.sherwoodhs.situation.foundation.quests.ScrapCollection;

public class ScrapMetalRepeatable implements Quest {
    private static Quest quest = new ScrapMetalRepeatable();

    private static int tracker = 0;
    String description;
    private static boolean status = false;


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
            status = true;
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

    public void resetQuest(){
        tracker = 0;
        status = false;
    }

    public static Quest getInstance(){
        return quest;
    }

}