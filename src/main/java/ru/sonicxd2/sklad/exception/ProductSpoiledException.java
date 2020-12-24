package ru.sonicxd2.sklad.exception;

import ru.sonicxd2.sklad.product.Product;

public class ProductSpoiledException extends RuntimeException {
    private final Product product;

    public ProductSpoiledException(Product product) {
        this.product = product;
    }

    public ProductSpoiledException(String message, Product product) {
        super(message);
        this.product = product;
    }

    public ProductSpoiledException(String message, Throwable cause, Product product) {
        super(message, cause);
        this.product = product;
    }

    public ProductSpoiledException(Throwable cause, Product product) {
        super(cause);
        this.product = product;
    }

    public ProductSpoiledException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Product product) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}
