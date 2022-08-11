
/*
 Marlon Grandy
 Project 6
 03/28/2022
 File name: RandomCustomer.java
 Class use: extends customer class and implements specific decision making process to choose queue. Decision 
 randomly chooses a line to enter.
 */
import java.util.ArrayList;
import java.util.Random;

public class RandomCustomer extends Customer {
    //random customer randomly choosesa line to go through

    public RandomCustomer(int num_items) { // constructor that makes call to super constructor with proper arguments
        super(num_items, 1);
    }

    public int chooseLine(ArrayList<CheckoutAgent> checkouts) { // returns an integer randomly chosen from the range 0
                                                                // (inclusive) to the lenght of the list (exclusive).
        Random rand = new Random();
        return rand.nextInt(checkouts.size());
    }

}
