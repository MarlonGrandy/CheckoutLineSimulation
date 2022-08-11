
/*
 Marlon Grandy
 Project 6
 03/28/2022
 File name: PickyCustomer.java
 Class use: extends customer class and implements specific decision making process to choose queue. Customer 
 analyzes eachline and chooses the shortest.
 */

import java.util.ArrayList;

public class PickyCustomer extends Customer {

    public PickyCustomer(int num_items, int num_lines) { // constructor
        super(num_items, num_lines);
    }

    public int chooseLine(ArrayList<CheckoutAgent> checkouts) { // returns the index of the CheckoutAgent with the //
                                                                // shortest line.
        int actIndex = 0;
        int val = 50000;
        int index = 0;
        for (CheckoutAgent c : checkouts) {
            if (c.customers.getSize() < val) {
                val = c.customers.getSize();
                actIndex = index;
                index++;
            } else {
                index++;
            }
        }
        return actIndex;
    }

}
