package com.twu.refactoring;

import java.util.List;

public class Order {
    private final String customerName;
    private final String customerAddress;
    private final List<LineItem> lineItems;

    public Order(String customerName, String customerAddress, List<LineItem> lineItems) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.lineItems = lineItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public String getPrintLine() {
        StringBuilder printLines = new StringBuilder();
        for (LineItem lineItem : lineItems) {
            printLines.append(lineItem.getDescription());
            printLines.append('\t');
            printLines.append(lineItem.getPrice());
            printLines.append('\t');
            printLines.append(lineItem.getQuantity());
            printLines.append('\t');
            printLines.append(lineItem.totalAmount());
            printLines.append('\n');
        }
        return printLines.toString();
    }

    public Double getTotalTax() {
        return lineItems.stream().mapToDouble(i -> i.totalAmount() * .10).sum();
    }

    public Double getTotalAmount() {
        return lineItems.stream().mapToDouble(LineItem::totalAmount).sum() + getTotalTax();
    }
}

