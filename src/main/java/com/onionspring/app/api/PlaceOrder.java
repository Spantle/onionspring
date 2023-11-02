package com.onionspring.app.api;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onionspring.app.database.repositories.ItemRepository;
import com.onionspring.app.database.repositories.OrderRepository;
import com.onionspring.app.database.repositories.UserRepository;
import com.onionspring.app.database.tables.Item;
import com.onionspring.app.database.tables.Order;
import com.onionspring.app.database.tables.User;
import com.onionspring.utils.CartItem;
import com.onionspring.utils.CartItems;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
public class PlaceOrder {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/placeOrder")
    public String placeOrder(HttpServletResponse response, HttpSession session) {
        List<Item> items = new ArrayList<>();
        String cart = (String) session.getAttribute("cart");
        Integer userID = (Integer) session.getAttribute("user");
        User user = userRepository.findById(userID).get();
        if (cart != null && !cart.equals("")) {
            String[] itemIDs = cart.split(",");
            for (String itemID : itemIDs) {
                Optional<Item> optionalItem = itemRepository.findById(Integer.parseInt(itemID));
                if (!optionalItem.isPresent()) {
                    continue;
                }
                items.add(optionalItem.get());
            }
        }

        List<CartItem> cartItems = new CartItems(items).cartItems;
        Set<Item> orderItems = new HashSet<>();
        for (CartItem cartItem : cartItems) {
            orderItems.add(cartItem.item);
        }
        Order order = new Order(user, orderItems);
        orderRepository.save(order);

        session.setAttribute("cart", "");

        return "OK";
    }

    @PostMapping("/api/order/{orderID}")
    public String addItemToCart(@PathVariable String orderID, HttpServletResponse response) {
        int id;
        try {
            id = Integer.parseInt(orderID);
        } catch (NumberFormatException e) {
            return "error";
        }
        Optional<Order> optionalOrder = orderRepository.findById(id);

        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setActive(false);
            orderRepository.save(order);
            response.setStatus(204);
            return "";
        }

        return "Error";
    }
}
