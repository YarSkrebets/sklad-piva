package ru.sonicxd2.sklad.service;

import ru.sonicxd2.sklad.cart.Cart;
import ru.sonicxd2.sklad.gson.GsonUtils;
import ru.sonicxd2.sklad.invoice.Invoice;
import ru.sonicxd2.sklad.product.Product;

import java.io.File;
import java.util.List;
import java.util.UUID;

public class LocalInvoiceService implements InvoiceService {
    @Override
    public Invoice createInvoiceForCart(Cart cart) {
        return Invoice.createInvoiceCart(cart);
    }

    @Override
    public Invoice createInvoiceForRefundProducts(List<Product> productList) {
        return Invoice.createRefund(productList);
    }

    @Override
    public void printInvoice(Invoice invoice) {
        String fileName = UUID.randomUUID().toString() + ".txt";
        System.out.println("Чек записан в файл " + fileName);
        GsonUtils.savePrettyToFile(new File(fileName), invoice);
    }
}
