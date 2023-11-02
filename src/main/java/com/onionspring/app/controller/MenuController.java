package com.onionspring.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.onionspring.app.database.repositories.ItemRepository;
import com.onionspring.app.database.tables.Item;

import jakarta.annotation.PostConstruct;

@Controller
public class MenuController {
        @Autowired
        private ItemRepository itemRepository;

        @GetMapping("/")
        public String showAvailableItems(
                        @RequestParam(name = "action", required = false, defaultValue = "menu") String action,
                        Model model) {
                List<Item> items = itemRepository.findAll();

                model.addAttribute("action", action);
                model.addAttribute("items", items);
                return "menu";
        }

        @GetMapping("/item/{itemID}")
        public String showItem(@PathVariable String itemID, Model model) {
                Optional<Item> optionalItem = itemRepository.findById(Integer.parseInt(itemID));

                if (optionalItem.isPresent()) {
                        model.addAttribute("item", optionalItem.get());
                        return "item"; // This will return the item.html view
                } else {
                        return "error";
                }
        }

        @PostConstruct
        public void addDummyValues() {
                String itemName = "poptards";
                Optional<Item> existingItem = itemRepository.findByName(itemName);
                if (!existingItem.isPresent()) {
                        Item item = new Item("poptards", "description", 1.99f,
                                        "https://img.wattpad.com/90b176f068e2062cadc85d2d0f372c087e1d78e3/68747470733a2f2f73332e616d617a6f6e6177732e636f6d2f776174747061642d6d656469612d736572766963652f53746f7279496d6167652f446e4c7567646c395f367a7165413d3d2d323834312e313632623930636361313461313066653339343435353135363234382e6a7067?s=fit&w=720&h=720");
                        itemRepository.save(item);
                }
        }
}