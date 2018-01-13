package org.katas.refactoring;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class OrderReceiptTest {
  @Test
  public void shouldPrintCustomerInformationOnOrder() {
    String customerName = "Mr X";
    String address = "Chicago, 60601";
    Order order = new Order(customerName, address, new ArrayList<LineItem>(), 0.1);
    OrderReceipt receipt = new OrderReceipt(order);

    String output = receipt.printReceipt();

    assertThat(output, containsString(customerName));
    assertThat(output, containsString(address));
  }

  @Test
  public void shouldPrintLineItemAndSalesTaxInformation() {
    ArrayList<LineItem> lineItems = new ArrayList<LineItem>() {{
      add(new LineItem("milk", 10.0, 2));
      add(new LineItem("biscuits", 5.0, 5));
      add(new LineItem("chocolate", 20.0, 1));
    }};
    OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems, 0.1));

    String output = receipt.printReceipt();

    assertThat(output, containsString("milk\t10.0\t2\t20.0\n"));
    assertThat(output, containsString("biscuits\t5.0\t5\t25.0\n"));
    assertThat(output, containsString("chocolate\t20.0\t1\t20.0\n"));
    assertThat(output, containsString("Sales Tax\t6.5"));
    assertThat(output, containsString("Total Amount\t71.5"));
  }

}
