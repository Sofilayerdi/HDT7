package com.example;

public class Producto {
    private String sku;
    private double priceRetail;
    private double priceCurrent;
    private String productName;
    private String category;

    public Producto(String sku, double priceRetail, double priceCurrent, String productName, String category) {
        this.sku = sku;
        this.priceRetail = priceRetail;
        this.priceCurrent = priceCurrent;
        this.productName = productName;
        this.category = category;
    }

    // Getters
    public String getSku() {
        return sku;
    }

    public double getPriceRetail() {
        return priceRetail;
    }

    public double getPriceCurrent() {
        return priceCurrent;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return String.format(
            "Producto [SKU: %s, Nombre: %s, Categoría: %s, Precio Retail: %.2f, Precio Actual: %.2f]",
            sku, productName, category, priceRetail, priceCurrent
        );
    }
}