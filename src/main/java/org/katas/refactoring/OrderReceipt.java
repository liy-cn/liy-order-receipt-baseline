package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
  private Order order;

  public OrderReceipt(Order order) {
    this.order = order;
  }

  public String printReceipt() {
    StringBuilder output = new StringBuilder();

    output.append("======Printing Orders======\n");

    // print date, bill no, customer name
    output.append(order.getCustomerName());
    output.append(order.getCustomerAddress());

    // prints lineItems
    generatePrintItems(output);

    // prints the state tax
    output.append("Sales Tax").append('\t').append(order.getTotalSalesTx());

    // print total amount
    output.append("Total Amount").append('\t').append(order.getTotalAmount());
    return output.toString();
  }

  private void generatePrintItems(StringBuilder output) {
    for (LineItem lineItem : order.getLineItems()) {
      output.append(lineItem.getDescription());
      output.append('\t');
      output.append(lineItem.getPrice());
      output.append('\t');
      output.append(lineItem.getQuantity());
      output.append('\t');
      output.append(lineItem.totalAmount());
      output.append('\n');
    }
  }
}