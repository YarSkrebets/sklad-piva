package ru.sonicxd2.sklad.invoice;

import ru.sonicxd2.sklad.cart.Cart;
import ru.sonicxd2.sklad.product.Product;

import java.math.BigDecimal;
import java.util.List;

public class Invoice {
    private final List<Product> productList;
    private final BigDecimal purse;
    private InvoiceStatus invoiceStatus;

    private Invoice(List<Product> productList, BigDecimal purse, InvoiceStatus invoiceStatus) {
        this.productList = productList;
        this.purse = purse;
        this.invoiceStatus = invoiceStatus;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public BigDecimal getPurse() {
        return purse;
    }

    public InvoiceStatus getInvoiceStatus() {
        return invoiceStatus;
    }

    public void markPayed() {
        invoiceStatus = InvoiceStatus.PAYED;
    }

    public static Invoice createInvoiceCart(Cart cart) {
        return new Invoice(cart.getProducts(), sum(cart.getProducts()), InvoiceStatus.NOT_PAYED);
    }

    public static Invoice createRefund(List<Product> products) {
        return new Invoice(products, sum(products).multiply(new BigDecimal(-1L)), InvoiceStatus.REFUND);
    }

    private static BigDecimal sum(List<Product> products) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Product product : products) {
            sum = sum.add(product.getPrice());
        }
        return sum;
    }

}
