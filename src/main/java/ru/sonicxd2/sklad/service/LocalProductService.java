package ru.sonicxd2.sklad.service;

import ru.sonicxd2.sklad.exception.ProductSpoiledException;
import ru.sonicxd2.sklad.gson.GsonUtils;
import ru.sonicxd2.sklad.product.Product;
import ru.sonicxd2.sklad.product.ProductMetadata;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LocalProductService implements ProductService {
    private static Type LIST_PRODUCT_TYPE = new com.google.gson.reflect.TypeToken<List<Product>>() {
    }.getType();

    private List<Product> products;

    public void load() {
        File file = new File("products.json");
        if (!file.exists()) {
            products = new ArrayList<>();
        } else products = GsonUtils.loadFromFile(file, LIST_PRODUCT_TYPE);

    }

    public void save() {
        GsonUtils.savePrettyToFile(new File("products.json"), products);
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public List<Product> getRecommendedProducts() {
        return products.stream().skip(1).limit(1).collect(Collectors.toList());
    }

    @Override
    public List<Product> getAvailableProductsByMeta(ProductMetadata productMetadata) {
        return products.stream().filter(product -> product.getProductMetadata().equals(productMetadata)).collect(Collectors.toList());
    }

    @Override
    public void sellProduct(Product product) throws ProductSpoiledException {
        products.remove(product);
    }

    @Override
    public List<Product> addProducts(List<Product> products) {
        products.stream().filter(p -> p.getExpirationDate().getTime() > System.currentTimeMillis())
                .forEach(this.products::add);
        return products.stream().filter(p -> p.getExpirationDate().getTime() < System.currentTimeMillis())
                .collect(Collectors.toList());
    }
}
