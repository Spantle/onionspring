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
                int id;
                try {
                        id = Integer.parseInt(itemID);
                } catch (NumberFormatException e) {
                        return "error";
                }
                Optional<Item> optionalItem = itemRepository.findById(id);

                if (optionalItem.isPresent()) {
                        model.addAttribute("item", optionalItem.get());
                        return "item"; // This will return the item.html view
                } else {
                        return "error";
                }
        }

        @PostConstruct
        public void addShreghetti() {
                String itemName = "Shreghetti";
                Optional<Item> existingItem = itemRepository.findByName(itemName);
                if (!existingItem.isPresent()) {
                        Item item = new Item("Shreghetti",
                                        "A delicious pasta dish with a twist of fun. Perfect for those who love Italian cuisine with a playful touch.",
                                        6.90f,
                                        "https://bit.ly/shreghetti");
                        itemRepository.save(item);
                }
        }

        @PostConstruct
        public void addCrustyCrabbyBaguette() {
                String itemName = "Crusty Crabby Baguette";
                Optional<Item> existingItem = itemRepository.findByName(itemName);
                if (!existingItem.isPresent()) {
                        Item item = new Item("Crusty Crabby Baguette",
                                        "A delicious pasta dish with a twist of fun. Perfect for those who love Italian cuisine with a playful touch.",
                                        4.20f,
                                        "https://preview.redd.it/v0c8ym4ieuv21.jpg?width=1080&crop=smart&auto=webp&s=0b4cc9d892972fa08a3d2c7d604cb2a59e5da35c");
                        itemRepository.save(item);
                }
        }

        @PostConstruct
        public void addPeppasSnaughtySnacks() {
                String itemName = "Peppa's Snaughty Snacks";
                Optional<Item> existingItem = itemRepository.findByName(itemName);
                if (!existingItem.isPresent()) {
                        Item item = new Item("Peppa's Snaughty Snacks",
                                        "An assortment of snacks perfect for a quick bite or to satisfy those mid-day cravings. Enjoy the burst of\r\n"
                                                        + //
                                                        "            flavors!",
                                        80.08f,
                                        "https://preview.redd.it/f8tx6wxdq9l51.jpg?width=1080&crop=smart&auto=webp&s=490a950421454be4cf4ced1819730974c5b1b47d");
                        itemRepository.save(item);
                }
        }
}