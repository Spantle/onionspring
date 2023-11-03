package com.onionspring.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.onionspring.app.database.repositories.OrderRepository;
import com.onionspring.app.database.repositories.UserRepository;
import com.onionspring.app.database.tables.Order;
import com.onionspring.app.database.tables.User;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class ViewOrderController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/viewOrder")
    public String showOrder(HttpServletResponse response, HttpSession session, Model model) {
        Integer userID = (Integer) session.getAttribute("user");
        User user = userRepository.findById(userID).get();

        List<Order> orders = orderRepository.findAllByUser(user);
        List<Order> currentOrders = new ArrayList<Order>();
        for (Order order : orders) {
            if (order.isActive()) {
                currentOrders.add(order);
            }
        }
        model.addAttribute("currentOrders", currentOrders);
        model.addAttribute("orders", orders);

        return "viewOrder";
    }
}
