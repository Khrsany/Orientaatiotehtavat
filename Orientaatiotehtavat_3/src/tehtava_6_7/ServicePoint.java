package tehtava_6_7;

import java.util.LinkedList;
import java.util.Queue;

public class ServicePoint {
    private Queue<Customer> queue = new LinkedList<>();

    public void addToQueue(Customer customer) {
        queue.add(customer);
    }

    public Customer serveNextCustomer() {
        return queue.poll(); // Ottaa ja poistaa jonon ensimmäisen
    }

    public boolean isQueueEmpty() {
        return queue.isEmpty();
    }
}