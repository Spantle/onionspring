package com.onionspring.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PaymentController {
    @GetMapping("/payment") // path to page
    public String showPayment() {
        return "payment";
    }

    // public String showEmailName(
    // @RequestParam(name = "email_name", required = false, defaultValue = "Your
    // Email") String action,
    // Model model) {
    // model.addAttribute("email_name", action);
    // return "payment";
    // }

    // @RequestMapping(value = "/payment", method = RequestMethod.POST)
    // public String handleButtons(@RequestParam String action, Model m) {
    // if (action.equals("goBack")) {

    // } else if (action.equals("finalisePayment")) {

    // }
    // m.addAttribute("handleButtons", action);
    // return "payment";
    // }

}
