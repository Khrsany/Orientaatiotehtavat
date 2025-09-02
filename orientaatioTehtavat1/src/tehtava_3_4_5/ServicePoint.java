package tehtava_3_4_5;

import java.util.LinkedList;

public class ServicePoint {

    private LinkedList<Customer> queue;

    // Konstruktori, joka luo uuden tyhjän jonon.
    public ServicePoint() {
        this.queue = new LinkedList<>();
    }

    // Metodi asiakkaan lisäämiseksi jonoon.
    public void addToQueueue(Customer a) {
        a.setStartTime(System.nanoTime()); // Asetetaan jonoon tuloaika
        queue.add(a);
    }

    // Metodi asiakkaan poistamiseksi jonosta.
    public Customer removeFromQueueue() {
        if (!queue.isEmpty()) {
            return queue.removeFirst(); // FIFO: Ensimmäinen sisään, ensimmäinen ulos
        }
        return null; // Palautetaan null, jos jono on tyhjä
    }

    // Päämetodi, joka simuloi asiakkaiden palvelemista.
    public void serve() {
        System.out.println("Palvelupiste avautuu. Jonossa on " + queue.size() + " asiakasta.");

        while (!queue.isEmpty()) {
            // Otetaan seuraava asiakas jonosta.
            Customer nextCustomer = removeFromQueueue();

            System.out.println("Palvellaan asiakasta: " + nextCustomer.getId());

            try {
                // Simuloidaan palveluaikaa satunnaisella viiveellä (1-4 sekuntia).
                long serviceTimeMillis = (long) (Math.random() * 3000 + 1000);
                Thread.sleep(serviceTimeMillis);

                // Asetetaan asiakkaan poistumisaika (palvelun päättymisaika).
                nextCustomer.setEndTime(System.nanoTime());

                // Lasketaan ja tulostetaan ajat.
                long responseTimeNano = nextCustomer.getEndTime() - nextCustomer.getStartTime();
                double responseTimeMilli = responseTimeNano / 1.0e6;
                double serviceTimeMilli = serviceTimeMillis;

                System.out.printf(" -> Asiakas %d palveltu. Vasteaika: %.2f ms (josta palveluaika %.2f ms)\n",
                        nextCustomer.getId(), responseTimeMilli, serviceTimeMilli);

            } catch (InterruptedException e) {
                System.err.println("Palvelu keskeytyi.");
                Thread.currentThread().interrupt(); // Palautetaan keskeytystila
            }
        }
        System.out.println("Kaikki asiakkaat on palveltu. Palvelupiste sulkeutuu.");
    }

    public static class Main {

        public static void main(String[] args) {
            // 1. Luo uusi palvelupiste.
            ServicePoint servicePoint = new ServicePoint();

            // 2. Käytä CustomerGeneratoria luomaan 5 asiakasta ja lisäämään ne jonoon.
            CustomerGenerator.generateCustomers(servicePoint, 5);

            // 3. Käynnistä palveluprosessi.
            servicePoint.serve();
        }
    }
}