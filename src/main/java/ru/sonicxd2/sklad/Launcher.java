package ru.sonicxd2.sklad;

import ru.sonicxd2.sklad.cart.Cart;
import ru.sonicxd2.sklad.invoice.Invoice;
import ru.sonicxd2.sklad.product.Product;
import ru.sonicxd2.sklad.product.ProductMetadata;
import ru.sonicxd2.sklad.product.ProductStatus;
import ru.sonicxd2.sklad.product.ProductType;
import ru.sonicxd2.sklad.service.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Launcher {

    private static Product snikers;

    public static void main(String[] args) {
        LocalProductService productService = new LocalProductService();
        productService.load();
        LocalInvoiceService invoiceService = new LocalInvoiceService();
        LocalCartService cartService = new LocalCartService();
        CashierService cashierService = new CashierService(invoiceService, productService, cartService);

        fillProducts(productService);
        Cart cart = cashierService.createCart();
        cart.addProduct(snikers);
        System.out.println("В корзине сейчас " + cart.getProducts().stream().map(Objects::toString).collect(Collectors.joining(", ")));

        Invoice invoice = cashierService.createInvoice(cart);
        cashierService.printInvoice(invoice);
        cashierService.setInvoicePayed(invoice);

        productService.save();
    }

    public static void fillProducts(ProductService productService) {
        List<Product> products = new ArrayList<>();
        snikers = new Product(0, new ProductMetadata("snikers", "snikers", "1.0"), ProductStatus.VERIFIED, ProductType.MILK,
                BigDecimal.ONE, new Date(System.currentTimeMillis() + 100000000), "На полке справа.");
        products.add(snikers);
        products.add(new Product(1, new ProductMetadata("snikers", "milkiway", "1.0"), ProductStatus.VERIFIED, ProductType.MILK,
                BigDecimal.ONE, new Date(System.currentTimeMillis() + 100000000), "На полке слева."));
        productService.addProducts(products);
    }
}
