package com.onionspring.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.onionspring.app.database.repositories.OrderRepository;
import com.onionspring.app.database.tables.Order;

@Controller
public class AdminViewOrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/adminViewOrder")
    public String showAdminOrder(Model model) {
        List<Order> orders = orderRepository.findAll();
        List<Order> currentOrders = new ArrayList<Order>();
        for (Order order : orders) {
            if (order.isActive()) {
                currentOrders.add(order);
            }
        }
        model.addAttribute("currentOrders", currentOrders);
        model.addAttribute("orders", orders);

        return "adminViewOrder";
    }
}
