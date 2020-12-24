package ru.sonicxd2.sklad.service;

import ru.sonicxd2.sklad.cart.Cart;
import ru.sonicxd2.sklad.invoice.Invoice;
import ru.sonicxd2.sklad.product.Product;

import java.util.List;

public interface InvoiceService {
    Invoice createInvoiceForCart(Cart cart);

    Invoice createInvoiceForRefundProducts(List<Product> productList);

    void printInvoice(Invoice invoice);
}
