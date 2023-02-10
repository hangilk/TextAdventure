package org.sherwoodhs.situation;

import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.inventory.Player;

public abstract class Combat implements Situation {
    //Calls in player singleton
    protected Player player = Player.getInstance();

    //Enemy involved in combat
    protected NPC enemy;

    protected Combat (NPC enemy){
        this.enemy = enemy;
    }

}