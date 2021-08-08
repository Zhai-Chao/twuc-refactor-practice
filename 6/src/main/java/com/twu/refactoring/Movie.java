package com.twu.refactoring;

 abstract class Movie {

	private final String title;

    Movie(String title) {
    	this.title = title;
    }

    abstract double getCharge(int daysRented);

    abstract int getFrequentRenterPoints(int daysRented);

	String getTitle () {
		return title;
	}
}

