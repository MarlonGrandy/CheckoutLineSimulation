/*
 Marlon Grandy
 Project 6
 03/28/2022
 File name: Pick2Customer.java
 Class use: extends customer class and implements specific decision making process to choose queue.
 Customer rnadomly chooses two lines and evaluates line choice base on each line, chooses the best line.
 */

import java.util.ArrayList;
import java.util.Random;

public class Pick2Customer extends Customer {
    
    public Pick2Customer(int num_items) { // constructor
        super(num_items, 2);
    }

    public int chooseLine(ArrayList<CheckoutAgent> checkouts) { // returns the index of the shorter of two randomly
                                                                // chosen queues
        Random rand = new Random();
        int ranInt1 = rand.nextInt(checkouts.size());
        int ranInt2 = rand.nextInt(checkouts.size());
        while (ranInt2 == ranInt1) {
            ranInt2 = rand.nextInt(checkouts.size());
        }
        if (checkouts.get(ranInt2).customers.getSize() < checkouts.get(ranInt1).customers.getSize()) {
            return ranInt2;
        } else {
            return ranInt1;
        }
    }
}
