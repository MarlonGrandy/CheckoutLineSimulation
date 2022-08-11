
/*
Marlon Grandy
Project 6
03/28/2022
File name Customer.java
Class use: Abstract class defining methods that define the queue time
*/
import java.util.ArrayList;
    
public abstract class Customer {
    private int basket;
    private int time;

    public Customer(int num_items) { //constructor method
        time = 0;
        basket = num_items;
}

public Customer(int num_items, int time_steps) { //constructor method with non-zero time step
    time = time_steps;
    basket = num_items;
}

public void incrementTime() { //increments the number of time steps.
    time++;
}

public int getTime() { //returns the number of time steps
    return time;
}
public void giveUpItem(){ //decrements the number of items
basket --;
}

public int getNumItems() { //returns the number of items.
    return basket;
}
public abstract int chooseLine(ArrayList<CheckoutAgent> checkouts); //abstract method for how the customer chooses the line

}
