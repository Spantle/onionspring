package com.onionspring.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.onionspring.app.api.Item;
import java.util.List;
import java.util.ArrayList;

@Controller
public class MenuController {
        @GetMapping("/menu")
        public String showAvailableItems(
                        @RequestParam(name = "action", required = false, defaultValue = "menu") String action,
                        Model model) {
                List<Item> items = new ArrayList<>();
                items.add(new Item("Shreghetti",
                                "https://scontent.fsyd7-1.fna.fbcdn.net/v/t1.6435-9/30571368_10156607294544903_3035257137589649408_n.jpg?_nc_cat=111&ccb=1-7&_nc_sid=730e14&_nc_ohc=xAQ7T2VHsKAAX804498&_nc_ht=scontent.fsyd7-1.fna&oh=00_AfAE1yJBWy1mIXD29TfLh1jj58Kb1L-Dv99KhWxUQSQ7Kw&oe=652A865B"));
                items.add(new Item("Crusty Crabby Baguette",
                                "https://preview.redd.it/v0c8ym4ieuv21.jpg?width=1080&crop=smart&auto=webp&s=0b4cc9d892972fa08a3d2c7d604cb2a59e5da35c"));
                items.add(new Item("Peppa’s Snaughty Snacks",
                                "https://preview.redd.it/f8tx6wxdq9l51.jpg?width=1080&crop=smart&auto=webp&s=490a950421454be4cf4ced1819730974c5b1b47d"));

                model.addAttribute("action", action);
                model.addAttribute("items", items);
                return "menu";
        }

        @GetMapping("/shreghetti")
        public String showShreghetti(Model model) {
                return "shreghetti";
        }

        @GetMapping("/crusty-crabby-baguette")
        public String showCrustyCrabbyBaguette(Model model) {
                return "crusty-crabby-baguette";
        }

        @GetMapping("/peppa’s-snaughty-snacks")
        public String showPeppasSnaughtySnacks(Model model) {
                return "peppa’s-snaughty-snacks";
        }

}