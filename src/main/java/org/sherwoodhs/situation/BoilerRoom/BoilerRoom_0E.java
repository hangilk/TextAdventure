package org.sherwoodhs.situation.BoilerRoom;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.location.BoilerRoom;
import org.sherwoodhs.location.Location;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class BoilerRoom_0E implements Situation {
    private boolean firstTime = true;
    private static Situation situation = new BoilerRoom_0E();
    Location location = BoilerRoom.getInstance();
    private BoilerRoom_0E() {
        World.setStateS("Location", location.getName());
    }
    @Override
    public String getTitle() {
        return "The Boiler Room";
    }
    @Override
    public String getDescription() {
        if (firstTime) {
            return "Stretching out in front of you is a massive complex of rusty pipes and gears. " +
                    "Some of the pipes must be extremely old; copious amounts of white vapor leaks from some of them. " +
                    "You'd take a quick glance to see if there was anything interesting here, but you can't see how far the pipes spread out due to the shadows.\n\n" +
                    "As you wipe condensation off your face, you peer into the darkness.";
        }
        return "The boiler room is just as humid as it was before... it's stifling. " +
                "As you stand alone surrounded by rusty pipes and the hiss of steam escaping from their confines, the darkness wraps around you like a blanket.";

    }
    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }
    @Override
    public String[] getOptions() {
        return new String[]{"Enter the darkness", "Inspect one of the pipes", "Leave"};
    }
    @Override
    public void perform(String option) {
        firstTime = false;
        switch (option) {
            case "Enter the darkness":
                AdvGame.setSituation(BoilerRoom_1E.getInstance());
                break;
            case "Inspect one of the pipes":

                break;
            case "Leave":
                // leave
                break;
        }
    }
    public static Situation getInstance() {
        return situation;
    }
}