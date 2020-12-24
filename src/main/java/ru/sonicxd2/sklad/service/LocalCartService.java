package ru.sonicxd2.sklad.service;

import ru.sonicxd2.sklad.cart.Cart;
import ru.sonicxd2.sklad.cart.CartService;
import ru.sonicxd2.sklad.invoice.Invoice;

import java.util.ArrayList;

public class LocalCartService implements CartService {
    @Override
    public Cart createNewCart() {
        return new Cart(new ArrayList<>());
    }

    @Override
    public Invoice createInvoice(Cart cart) {
        return Invoice.createRefund(cart.getProducts());
    }
}
