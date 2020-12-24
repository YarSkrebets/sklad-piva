package ru.sonicxd2.sklad.service;

import ru.sonicxd2.sklad.exception.ProductSpoiledException;
import ru.sonicxd2.sklad.product.Product;
import ru.sonicxd2.sklad.product.ProductMetadata;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    List<Product> getRecommendedProducts();

    List<Product> getAvailableProductsByMeta(ProductMetadata productMetadata);

    void sellProduct(Product product) throws ProductSpoiledException;

    /**
     * Return spoiled products.
     * @param products
     * @return
     */
    List<Product> addProducts(List<Product> products);
}
