package ru.sonicxd2.sklad.product;

import java.util.Objects;

public class ProductMetadata {
    private String company;
    private String name;
    private String kilos;

    public ProductMetadata(String company, String name, String kilos) {
        this.company = company;
        this.name = name;
        this.kilos = kilos;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKilos() {
        return kilos;
    }

    public void setKilos(String kilos) {
        this.kilos = kilos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductMetadata that = (ProductMetadata) o;
        return Objects.equals(company, that.company) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, name);
    }

    @Override
    public String toString() {
        return "ProductMetadata{" +
                "company='" + company + '\'' +
                ", name='" + name + '\'' +
                ", kilos='" + kilos + '\'' +
                '}';
    }
}
