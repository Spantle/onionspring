package com.onionspring.app.database.tables;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment_information")
public class PaymentInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "card_type")
    private String cardType;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_cvc")
    private String cardCvc;

    @Column(name = "card_exp")
    private String cardExp;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User user;

    public PaymentInformation() {
    }

    public PaymentInformation(User user, String cardType, String cardNumber, String cardCvc, String cardExp) {
        this.user = user;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.cardCvc = cardCvc;
        this.cardExp = cardExp;
    }

    public int getId() {
        return id;
    }

    public String getCardType() {
        return cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardCvc() {
        return cardCvc;
    }

    public String getCardExp() {
        return cardExp;
    }
}
