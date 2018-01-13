package org.katas.refactoring;

import java.util.List;

public class Order {
  private final String name;
  private final String address;
  private final List<LineItem> lineItems;

  private double totalSalesTx = 0d;
  private double totalAmount = 0d;

  public Order(String name, String address, List<LineItem> lineItems) {
    this.name = name;
    this.address = address;
    this.lineItems = lineItems;

    calcSalesTax();
  }

  public String getCustomerName() {
    return name;
  }

  public String getCustomerAddress() {
    return address;
  }

  public List<LineItem> getLineItems() {
    return lineItems;
  }

  private void calcSalesTax(){

    double salesTax = 0d;

    for (LineItem lineItem: lineItems) {

      salesTax = lineItem.totalAmount() * .10;
      totalSalesTx += salesTax;

      // calculate total amount of lineItem = price * quantity + 10 % sales tax
      totalAmount += lineItem.totalAmount() + salesTax;

    }

  }

  public double getTotalSalesTx(){
    return this.totalSalesTx;
  }

  public double getTotalAmount() {
    return totalAmount;
  }
}
