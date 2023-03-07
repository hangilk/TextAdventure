package org.sherwoodhs.situation.BoilerRoom.Abyss.Canyon;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import static org.sherwoodhs.ui.InventoryPanel.inventoryPanel;

public class Crevasse_E implements Situation {
    private static Situation situation = new Crevasse_E();
    @Override
    public String getTitle() {
        return "???";
    }
    @Override
    public String getDescription() {
        if (inventoryPanel.containsItem("A small journal")) {
            return "You walk towards the massive crevasse. In the distance, you see an old rotting rope bridge you could probably cross.";
        }
        return "You move towards the crevasse. It stretches widely into some unfathomable darkness. " +
                "In the distance, you see an old rotting rope bridge… you think to yourself. " +
                "You should probably cross it once you have more information. " +
                "Behind you, there is a mound of fabric you haven’t inspected yet.";
    }
    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }
    @Override
    public String[] getOptions() {
        if (inventoryPanel.containsItem("A small journal")) {
            return new String[]{"Inspect the tent behind you", "Cross the rope bridge", "Return to the lake"};
        }
        return new String[]{"Inspect the mound of fabric", "Return to the lake"};
    }
    @Override
    public void perform(String option) {
        switch (option) {
            case "Inspect the tent behind you":
            case "Inspect the mound of fabric":
                AdvGame.setSituation(SpiralRock_1E.getInstance());
                break;
            case "Cross the rope bridge":
                break;
            case "Return to the lake":
                AdvGame.setSituation(Aquifer_E.getInstance());
                break;
        }
    }
    public static Situation getInstance() {
        return situation;
    }
}
