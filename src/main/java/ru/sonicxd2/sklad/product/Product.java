package ru.sonicxd2.sklad.product;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Product {
    private int id;
    private ProductMetadata productMetadata;
    private ProductStatus productStatus;
    private ProductType productType;
    private BigDecimal price;
    private Date expirationDate;
    private String locationDescription;

    public Product(int id, ProductMetadata productMetadata, ProductStatus productStatus, ProductType productType, BigDecimal price, Date expirationDate, String locationDescription) {
        this.id = id;
        this.productMetadata = productMetadata;
        this.productStatus = productStatus;
        this.productType = productType;
        this.price = price;
        this.expirationDate = expirationDate;
        this.locationDescription = locationDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductMetadata getProductMetadata() {
        return productMetadata;
    }

    public void setProductMetadata(ProductMetadata productMetadata) {
        this.productMetadata = productMetadata;
    }

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productMetadata, product.productMetadata) &&
                productStatus == product.productStatus &&
                productType == product.productType &&
                Objects.equals(price, product.price) &&
                Objects.equals(expirationDate, product.expirationDate) &&
                Objects.equals(locationDescription, product.locationDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productMetadata, productStatus, productType, price, expirationDate, locationDescription);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productMetadata=" + productMetadata +
                ", productStatus=" + productStatus +
                ", productType=" + productType +
                ", price=" + price +
                ", expirationDate=" + expirationDate +
                ", locationDescription='" + locationDescription + '\'' +
                '}';
    }
}
