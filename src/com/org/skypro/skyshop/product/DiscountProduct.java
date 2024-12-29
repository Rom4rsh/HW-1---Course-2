package com.org.skypro.skyshop.product;

public class DiscountProduct extends Product {
    protected int basicPrice;
    protected int percentDiscount;

    public DiscountProduct(String name, int price, int percentDiscount) {
        super(name, price);
        if (percentDiscount <= 0 || percentDiscount >= 100) {
            throw new IllegalArgumentException(" Цена продукта или процент скидки указан не верно");
        }
        this.basicPrice = price;
        this.percentDiscount = percentDiscount;
    }

    @Override
    public int getPrice() {
        return price = basicPrice * (100 - percentDiscount) / 100;
    }

    @Override
    public String toString() {
        return super.toString() + " скидка " + percentDiscount + "%";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
