
/*
Marlon Grandy
Project 6
03/28/2022
File name: Pick2CustomerSimulation.java
Class use: simulates the pick2customer
*/
import java.util.ArrayList;
import java.util.Random;

public class Pick2CustomerSimulation {
    public static void main(String[] args) throws InterruptedException { // main method to run a simulation for a pick2
                                                                         // customer
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
            Customer cust = new Pick2Customer(1 + gen.nextInt(7));
            int choice = cust.chooseLine(checkouts);
            checkouts.get(choice).addCustomerToQueue(cust);
            s.updateCheckouts(scape);
            display.repaint();
            Thread.sleep(5);
            if (j % 100 == 0 && j != 0) {
                System.out.println(scape.printFinishedCustomerStatistics());
                
            }
        }

    }
}
