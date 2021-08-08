package com.twu.refactoring;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class Customer {

	private static final String HEADER_LINE = "Rental Record for %s\n";
	private static final String TOTAL_CHARGE_LINE = "Amount owed is %s\n";
	private static final String TOTAL_POINTS_LINE = "You earned %s frequent renter points";
	private static final String EACH_RENTAL_RECORD_LINE = "\t%s\t%s\n";

	private final String name;
	private final List<Rental> rentalList = new ArrayList<>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public List<Rental> getRentalList() {
		return rentalList;
	}

	public String statement() {
		StringBuilder result = new StringBuilder(format(HEADER_LINE, name));
		for (Rental rental : rentalList) {
			result.append(format(EACH_RENTAL_RECORD_LINE, rental.getMovie().getTitle(), rental.getCharge()));
		}
		result.append(format(TOTAL_CHARGE_LINE, rentalList.stream().mapToDouble(Rental::getCharge).sum()));
		result.append(format(TOTAL_POINTS_LINE, (int)rentalList.stream().mapToDouble(Rental::getFrequentRenterPoints).sum()));
		return result.toString();
	}
}
