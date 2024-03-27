
package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class Menu extends MenuComponent {
    ArrayList<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
    String name;
    String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public MenuComponent getChild(int i) {
        return (MenuComponent)menuComponents.get(i);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public MenuItem[] getItems() {
        List<MenuItem> items = new ArrayList<>();
        Iterator<MenuComponent> iterator = menuComponents.iterator();
        while (iterator.hasNext()){
            MenuComponent menuComponent = iterator.hasNext();
            Collections.addAll();
        }
    }
}