package com.org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    protected final int FIX_PRICE = 2024;

    public FixPriceProduct(String name) {
        super.title = name;
        super.price = FIX_PRICE;

    }

    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return super.toString() + " Фиксированная цена - " + FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
