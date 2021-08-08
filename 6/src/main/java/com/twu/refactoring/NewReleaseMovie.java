package com.twu.refactoring;

public class NewReleaseMovie extends Movie{

    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    int getFrequentRenterPoints(int daysRented) {
        return daysRented > 1 ? 2: 1;
    }
}
