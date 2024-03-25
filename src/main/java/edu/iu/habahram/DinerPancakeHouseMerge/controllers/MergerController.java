package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/merger")
public class MergerController {

    private final DinerRepository dinerRepository;
    private final PancakeHouseRepository pancakeHouseRepository;

    public MergerController(DinerRepository dinerRepository, PancakeHouseRepository pancakeHouseRepository) {
        this.dinerRepository = dinerRepository;
        this.pancakeHouseRepository = pancakeHouseRepository;
    }

    @GetMapping
    public MenuItem[] getMergedMenu() {
        List<MenuItem> mergedMenu = new ArrayList<>();

        // Add diner menu items to mergedMenu
        List<MenuItem> dinerMenuItems = List.of(dinerRepository.getTheMenu());
        for (MenuItem menuItem : dinerMenuItems) {
            mergedMenu.add(menuItem);
        }

        // Add pancake house menu items to mergedMenu
        List<MenuItem> pancakeHouseMenuItems = pancakeHouseRepository.getTheMenu();
        for (MenuItem menuItem : pancakeHouseMenuItems) {
            mergedMenu.add(menuItem);
        }

        // Sort the merged menu items by name
        mergedMenu.sort(Comparator.comparing(MenuItem::getName));

        // Convert List<MenuItem> to MenuItem[]
        MenuItem[] mergedMenuArray = mergedMenu.toArray(new MenuItem[mergedMenu.size()]);

        return mergedMenuArray;
    }
}
