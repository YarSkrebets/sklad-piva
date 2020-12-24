package ru.sonicxd2.sklad.cart;

import ru.sonicxd2.sklad.exception.ProductSpoiledException;
import ru.sonicxd2.sklad.product.Product;

import java.util.List;

public class Cart {
    private List<Product> products;

    public Cart(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) throws ProductSpoiledException {
        if (product.getExpirationDate().getTime() < System.currentTimeMillis()) {
            throw new ProductSpoiledException(product);
        }
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }
}
