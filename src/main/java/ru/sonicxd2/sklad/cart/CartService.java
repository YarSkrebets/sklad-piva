package ru.sonicxd2.sklad.cart;

import ru.sonicxd2.sklad.invoice.Invoice;

public interface CartService {
    Cart createNewCart();

    Invoice createInvoice(Cart cart);

}
