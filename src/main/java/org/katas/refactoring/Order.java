package org.katas.refactoring;

import java.util.List;

public class Order {
  private final String customerName;
  private final String customerAddress;
  private final List<LineItem> lineItems;
  private final double taxRate;

  private double totalSalesTx = 0d;
  private double totalAmount = 0d;

  public Order(String customerName, String customerAddress, List<LineItem> lineItems, double taxRate) {
    this.customerName = customerName;
    this.customerAddress = customerAddress;
    this.lineItems = lineItems;
    this.taxRate = taxRate;
    calcSalesTax();
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

  private void calcSalesTax() {

    double salesTax;

    for (LineItem lineItem : lineItems) {

      salesTax = lineItem.totalAmount() * this.taxRate;
      totalSalesTx += salesTax;

      // calculate total amount of lineItem = price * quantity + 10 % sales tax
      totalAmount += lineItem.totalAmount() + salesTax;

    }

  }

  public double getTotalSalesTx() {
    return this.totalSalesTx;
  }

  public double getTotalAmount() {
    return totalAmount;
  }

  public String asString() {
    StringBuilder output = new StringBuilder();
    // print date, bill no, customer name
    if (this.getCustomerName() != null) {
      output.append(this.getCustomerName());
    }
    if (this.getCustomerAddress() != null) {
      output.append(this.getCustomerAddress());
    }

    // prints lineItems
    if (this.getLineItems() != null && this.getLineItems().size() > 0) {
      for (LineItem lineItem : this.getLineItems()) {
        output.append(lineItem.asString());
      }
    }

    // prints the state tax
    output.append("Sales Tax").append(Consts.CHAR_SEPERATOR).append(this.getTotalSalesTx());

    // print total amount
    output.append("Total Amount").append(Consts.CHAR_SEPERATOR).append(this.getTotalAmount());

    return output.toString();
  }
}
