package tehtava_6_7;

import java.util.LinkedList;

public class ServicePoint {

    private LinkedList<Customer> queue;
    private long totalServiceTime;
    private int servedCustomers;

    public ServicePoint() {
        this.queue = new LinkedList<>();
        this.totalServiceTime = 0;
        this.servedCustomers = 0;
    }

    public void addToQueueue(Customer a) {
        a.setStartTime(System.nanoTime());
        queue.add(a);
    }

    public Customer removeFromQueueue() {
        return queue.poll(); // poll() on turvallinen tapa poistaa, palauttaa null jos jono on tyhjä
    }

    public void serve() {
        System.out.println("Palvelupiste avautuu. Jonossa on " + queue.size() + " asiakasta.");

        while (!queue.isEmpty()) {
            Customer nextCustomer = removeFromQueueue();
            System.out.println("Palvellaan asiakasta: " + nextCustomer.getId());

            try {
                // Simuloidaan palveluaikaa (1-4 sekuntia)
                long serviceTimeMillis = (long) (Math.random() * 3000 + 1000);
                Thread.sleep(serviceTimeMillis);
                nextCustomer.setEndTime(System.nanoTime());

                // Kerätään dataa keskiarvoa varten
                this.totalServiceTime += serviceTimeMillis;
                this.servedCustomers++;

                long responseTimeNano = nextCustomer.getEndTime() - nextCustomer.getStartTime();
                double responseTimeMilli = responseTimeNano / 1.0e6;

                System.out.printf(" -> Asiakas %d palveltu. Vasteaika: %.2f ms (josta palveluaika %.0f ms)\n",
                        nextCustomer.getId(), responseTimeMilli, (double)serviceTimeMillis);

            } catch (InterruptedException e) {
                System.err.println("Palvelu keskeytyi.");
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Kaikki asiakkaat on palveltu. Palvelupiste sulkeutuu.");

        // Lasketaan ja tulostetaan lopuksi keskiarvo
        if (servedCustomers > 0) {
            double averageServiceTime = (double) totalServiceTime / servedCustomers;
            System.out.printf("Keskimääräinen palveluaika oli: %.2f ms\n", averageServiceTime);
        }
    }
}