package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
  private Order order;
  private static final String CHAR_SPLIT = "\t";
  private static final String LINE_SPLIT = "\n";

  public OrderReceipt(Order order) {
    this.order = order;
  }

  public String printReceipt() {
    StringBuilder output = new StringBuilder();

    output.append("======Printing Orders======").append(LINE_SPLIT);

    // print date, bill no, customer name
    output.append(order.getCustomerName());
    output.append(order.getCustomerAddress());

    // prints lineItems
    generatePrintItems(output);

    // prints the state tax
    output.append("Sales Tax").append(CHAR_SPLIT).append(order.getTotalSalesTx());

    // print total amount
    output.append("Total Amount").append(CHAR_SPLIT).append(order.getTotalAmount());
    return output.toString();
  }

  private void generatePrintItems(StringBuilder output) {

    for (LineItem lineItem : order.getLineItems()) {
      output.append(lineItem.getDescription());
      output.append(CHAR_SPLIT);
      output.append(lineItem.getPrice());
      output.append(CHAR_SPLIT);
      output.append(lineItem.getQuantity());
      output.append(CHAR_SPLIT);
      output.append(lineItem.totalAmount());
      output.append(LINE_SPLIT);
    }
  }
}