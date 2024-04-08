package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.Calendar;
import java.util.Calendar;
import java.util.Iterator;

public class AlternatingDinerMenuIterator implements Iterator<MenuItem> {
    MenuItem[] items;
    int position;

    public AlternatingDinerMenuIterator(MenuItem[] items) {
        this.items = items;
        // Initialize position based on the day of the week
        Calendar date = Calendar.getInstance();
        int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.TUESDAY || dayOfWeek == Calendar.THURSDAY) {
            position = 0; // Start from the first item
        } else {
            position = 1; // Start from the second item
        }
    }

    public MenuItem next() {
        MenuItem menuItem = items[position];
        // Increment position by 2 to alternate between items
        position += 2;
        return menuItem;
    }

    public boolean hasNext() {
        return position < items.length && items[position] != null;
    }
}
