
/*
Marlon Grandy
Project 6
03/28/2022
File name: Simulation.java
Class use: updates the state of the checkoutagents.
*/

public class Simulation {

    public void updateState(CheckoutAgent ca, Landscape scape) { // updates checkout queue state
        for (Customer c : ca.customers) {
            c.incrementTime();
        }

        if (ca.customers.peek() != null) {
            Customer c = ca.customers.getHead().getData();
            if (c.getNumItems() != 0) {
                c.giveUpItem();
            } else {
                scape.addFinishedCustomer(c);
                ca.customers.poll();
            }

        }
    }

    public void updateCheckouts(Landscape scape) { // loops through all of the CheckoutAgents, and calls updateState.
        for (CheckoutAgent c : scape.COAList) {
            updateState(c, scape);
        }
    }
}
