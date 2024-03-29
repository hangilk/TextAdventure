package org.sherwoodhs.quest.Separatist;

import org.sherwoodhs.quest.Quest;

public class FoodMakingQuest implements Quest {
    private static Quest quest = new FoodMakingQuest();

    private String description;
    private boolean status;
    private static boolean progress = false;
    public FoodMakingQuest() {
        description = "You need to complete a customer's order.";
        status = false;
    }

    public void create()
    {
        //
    }

    @Override
    public String getName() {
        return "Make some food";
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String newDescription) {
        description = newDescription;
    }

    @Override
    public boolean isCompleted() {
        return status;
    }

    public static boolean inProgress() {
        return progress;
    }

    public static void setProgress(boolean b) {
        progress = b;
    }

    @Override
    public void complete() {
        status = true;
    }

    @Override
    public void reset() {
        description = "You need to complete a customer's order.";
        status = false;
    }

    public static Quest getInstance(){
        return quest;
    }
}
