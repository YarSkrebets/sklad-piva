package ru.sonicxd2.sklad.income;

import ru.sonicxd2.sklad.product.ProductMetadata;
import ru.sonicxd2.sklad.product.ProductStatus;
import ru.sonicxd2.sklad.product.ProductType;

import java.util.Date;

public class IncomeItem {
    private ProductMetadata productMetadata;
    private ProductStatus productStatus;
    private ProductType productType;
    private String descriptionLocation;
    private Date expiringDate;

    public IncomeItem(ProductMetadata productMetadata, ProductStatus productStatus, ProductType productType, String descriptionLocation, Date expiringDate) {
        this.productMetadata = productMetadata;
        this.productStatus = productStatus;
        this.productType = productType;
        this.descriptionLocation = descriptionLocation;
        this.expiringDate = expiringDate;
    }

    public ProductMetadata getProductMetadata() {
        return productMetadata;
    }

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public ProductType getProductType() {
        return productType;
    }

    public String getDescriptionLocation() {
        return descriptionLocation;
    }

    public Date getExpiringDate() {
        return expiringDate;
    }
}
