package com.onionspring.app.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onionspring.app.database.repositories.ItemRepository;
import com.onionspring.app.database.repositories.OrderRepository;
import com.onionspring.app.database.repositories.UserRepository;
import com.onionspring.app.database.tables.Item;
import com.onionspring.app.database.tables.Order;
import com.onionspring.app.database.tables.User;
import com.onionspring.app.database.tables.Cart;

@RestController
public class Demo {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/api/demo")
    public String demo(@RequestParam(value = "name", defaultValue = "Default Name") String name) {
        User user = new User("user@test.com", name, "Lastname", "1234 Test St", "password", false);
        userRepository.save(user);

        Item item = new Item("Test Item", "Test Description", 1.0f,
                "https://via.placeholder.com/150");
        itemRepository.save(item);

        Order order = new Order(user);
        List<Item> items = itemRepository.findAll();
        for (Item i : items) {
            order.addItem(i);
        }
        orderRepository.save(order);

        return String.format("Created an account for %s", user.getFirstName());
    }
}
