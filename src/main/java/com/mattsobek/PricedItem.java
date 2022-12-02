package com.mattsobek;

public interface PricedItem<T extends Number> {

    T getPrice();

    void setPrice(T price);
}
