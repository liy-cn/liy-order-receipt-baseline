package org.katas.refactoring;

public class LineItem {
  private final String description;
  private final double price;
  private final int quantity;

  public LineItem(String description, double price, int quantity) {
    this.description = description;
    this.price = price;
    this.quantity = quantity;
  }

  public String getDescription() {
    return description;
  }

  public double getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }

  public double totalAmount() {
    return price * quantity;
  }

  public String asString(){
    StringBuilder output = new StringBuilder();
    output.append(this.getDescription());
    output.append(Consts.CHAR_SPLIT);
    output.append(this.getPrice());
    output.append(Consts.CHAR_SPLIT);
    output.append(this.getQuantity());
    output.append(Consts.CHAR_SPLIT);
    output.append(this.totalAmount());
    output.append(Consts.LINE_SPLIT);
    return output.toString();
  }
}