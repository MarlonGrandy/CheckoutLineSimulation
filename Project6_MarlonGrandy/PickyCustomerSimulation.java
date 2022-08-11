
/*
Marlon Grandy
Project 6
03/28/2022
File name: PickyCustomerSimulation.java
Class use: class simulates the picky customer simulation
*/
import java.util.Random;
import java.util.ArrayList;

public class PickyCustomerSimulation {
    // test function that creates a new LandscapeDisplay and populates it with 5
    // checkouts and 99 customers.
    public static void main(String[] args) throws InterruptedException {
        // runs a simulation for the picky customer class
        Random gen = new Random();
        ArrayList<CheckoutAgent> checkouts = new ArrayList<CheckoutAgent>(5);

        for (int i = 0; i < 5; i++) {
            CheckoutAgent checkout = new CheckoutAgent(i * 100 + 50, 480);
            checkouts.add(checkout);
        }
        Landscape scape = new Landscape(500, 500, checkouts, 1000);
        LandscapeDisplay display = new LandscapeDisplay(scape);
        Simulation s = new Simulation();
        for (int j = 0; j < scape.getSims(); j++) {

            Customer cust = new PickyCustomer(1 + gen.nextInt(7), checkouts.size());
            int choice = cust.chooseLine(checkouts);
            checkouts.get(choice).addCustomerToQueue(cust);
            s.updateCheckouts(scape);
            display.repaint();
            Thread.sleep(0);
            if (j % 100 == 0 && j != 0) {
                System.out.println(scape.printFinishedCustomerStatistics());
            }
        }

    }

}