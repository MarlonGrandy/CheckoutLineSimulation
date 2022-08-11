
/*
Marlon Grandy
Project 6
03/28/2022
File name CheckoutAgent.java
Class use: defines a queue for customers and x y positions
*/
import java.awt.Graphics;
import java.awt.Color;

public class CheckoutAgent {
    private int x;
    private int y;
     MyQueue<Customer> customers;

    public CheckoutAgent(int x, int y) { // constructor. The queue should be initialized to an empty MyQueue<Customer>.
        this.x = x;
        this.y = y;
        customers = new MyQueue<Customer>();
    }

    public int getX() { //returns x attribute
        return this.x;
    }
    public int getY() { //returns y attribute
        return this.y;
    }

    public void addCustomerToQueue(Customer c) { // add a Customer to its queue.
        customers.offer(c);
    }

    public int getNumInQueue() { // returns the number of Customers in its queue.
        return customers.getSize();
    }

    public void draw(Graphics g) {// draws the CheckoutAgent with a height proportional to the number
                                  // of Customers
        if (getNumInQueue() > 0) {
            g.setColor(Color.cyan);
            g.fillRect(this.x, this.y - 10 * customers.getSize(), 10,
                    10 * customers.getSize());
        } else {
            g.setColor(Color.WHITE);
            g.drawString("Empty", x, y);
        }

    }

}
