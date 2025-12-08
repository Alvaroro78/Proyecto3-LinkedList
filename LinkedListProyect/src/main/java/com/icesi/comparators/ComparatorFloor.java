package com.icesi.comparators;

import com.icesi.model.House;

import java.util.Comparator;

public class ComparatorFloor implements Comparator<House> {
    @Override
    public int compare(House o1, House o2) {
        return Integer.compare(o1.getFloor(),o2.getFloor());
    }
}
