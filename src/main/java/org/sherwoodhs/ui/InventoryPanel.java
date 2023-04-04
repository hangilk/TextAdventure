package org.sherwoodhs.ui;

import org.sherwoodhs.ui.util.DisabledItemSelectionModel;
import org.sherwoodhs.ui.util.InvPanelCellRenderer;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class InventoryPanel extends JPanel {
    public static final InventoryPanel inventoryPanel = new InventoryPanel();
    private DefaultListModel<String> inventoryListModel = new DefaultListModel<>();
    private JList<String> inventoryList;
    private int index = 0;

    private InventoryPanel() {
        super(new BorderLayout());
        setPreferredSize(new Dimension(250, 295));
        setBorder(new TitledBorder("Inventory"));

        inventoryList = new JList<>(inventoryListModel);
        inventoryList.setSelectionModel(new DisabledItemSelectionModel());
        inventoryList.setCellRenderer(new InvPanelCellRenderer());
        add(inventoryList);

        initInventory(new String[]{});
    }
    /**
     * Clears all contents inside inventoryList, then adds every element in String[] inventory
     * @param inventory all contents inside the player's inventory as a {@link String} array
     */
    public void initInventory(String[] inventory) {
        clearInventory();
        for (String element : inventory) {
            inventoryListModel.addElement(element);
        }
    }
    /**
     * Adds one element to inventoryList without clearing its contents
     * @param item one element to be added to inventoryList
     */
    public void addToInventory(String item) { // identical method to TextPanel's "addText", but runs in its own thread

        Thread t = new Thread() {
            public void run() {
                inventoryListModel.add(index, "|");
                for (int i = 0; i < item.length()+1; i++) {
                    inventoryListModel.set(index, (item.substring(0,i)+"|"));
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                inventoryListModel.set(index, item);
            }
        };
        t.start();
    }
    /**
     * Removes one element from inventoryList without clearing its contents
     * @param item one element to be removed from inventoryList; method will not work if the element cannot be found
     */
    public void removeFromInventory(String item) {
        inventoryListModel.removeElement(item);
    }
    /**
     * Clears all content inside inventoryList
     */
    public void clearInventory() {
        inventoryListModel.clear();
    }
    /**
     * Returns a boolean that determines whether an item is contained in the inventory
     * @param item represents the item to be searched for in inventoryList
     */
    public boolean containsItem (String item){
        if (inventoryListModel.contains(item)) {
            return true;
        } else {
            return false;
        }
    }
}
