package com.onionspring.app.database.tables;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User user;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "order_items", joinColumns = { @JoinColumn(name = "order_id") }, inverseJoinColumns = {
            @JoinColumn(name = "item_id") })
    private Set<Item> items = new HashSet<>();

    @Column(name = "active")
    private boolean active;

    public Order() {
    }

    public Order(User user) {
        this.user = user;
        this.active = true;
    }

    public Order(User user, Set<Item> items) {
        this.user = user;
        this.items = items;
        this.active = true;
    }

    public int getId() {
        return id;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
