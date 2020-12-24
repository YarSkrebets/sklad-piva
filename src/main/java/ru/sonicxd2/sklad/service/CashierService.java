package ru.sonicxd2.sklad.service;

import ru.sonicxd2.sklad.cart.Cart;
import ru.sonicxd2.sklad.cart.CartService;
import ru.sonicxd2.sklad.invoice.Invoice;
import ru.sonicxd2.sklad.product.Product;
import ru.sonicxd2.sklad.product.ProductMetadata;

import java.util.List;

public class CashierService {
    private InvoiceService invoiceService;
    private CartService cartService;
    private ProductService productService;

    public CashierService(InvoiceService invoiceService, ProductService productService, CartService cartService) {
        this.invoiceService = invoiceService;
        this.productService = productService;
        this.cartService = cartService;
    }

    public Cart createCart() {
        return cartService.createNewCart();
    }

    public List<Product> foundProduct(ProductMetadata productMetadata) {
        return productService.getAvailableProductsByMeta(productMetadata);
    }

    public String foundLocationOfProduct(Product product) {
        return product.getLocationDescription();
    }

    public List<Product> getRecommendedProducts() {
        return productService.getRecommendedProducts();
    }

    public Invoice createInvoice(Cart cart) {
        return invoiceService.createInvoiceForCart(cart);
    }

    public void setInvoicePayed(Invoice invoice) {
        invoice.getProductList().forEach(product -> productService.sellProduct(product));
        invoice.markPayed();
        invoiceService.printInvoice(invoice);

    }

    public Invoice refundProducts(List<Product> products) {
        productService.addProducts(products);
        return invoiceService.createInvoiceForRefundProducts(products);
    }

    public void printInvoice(Invoice invoice) {
        invoiceService.printInvoice(invoice);
    }

}
