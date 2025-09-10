package tehtava_6_7;

import eduni.distributions.Negexp;
import java.util.ArrayList;

public class SimulationTest {

    public static void main(String[] args) {
        // --- ALUSTUS ---
        Clock clock = Clock.getInstance();
        EventList eventList = new EventList();
        ArrivalProcess arrivalProcess = new ArrivalProcess(
                new Negexp(10.0), // Keskim. saapumisväli 10
                new EventType("SAAPUMINEN")
        );
        ServicePoint servicePoint = new ServicePoint();

        // --- VAIHE 1: TAPAHTUMIEN LUONTI ---
        System.out.println("--- Vaihe 1: Luodaan 10 saapumistapahtumaa ---");
        for (int i = 0; i < 10; i++) {
            arrivalProcess.generateNextEvent(eventList, clock.getTime());
            clock.setTime(eventList.getLastEvent().getTime());
        }
        eventList.print();
        System.out.printf("Tapahtumien luonti valmis. Kellonaika: %.2f\n\n", clock.getTime());

        // --- VAIHE 2: TAPAHTUMIEN KÄSITTELY JA JONOTUS ---
        System.out.println("--- Vaihe 2: Luodaan asiakkaat ja lisätään jonoon ---");
        ArrayList<Event> events = eventList.getEvents();
        for (Event event : events) {
            Customer c = new Customer();
            c.setArrivalTime(event.getTime()); // Asiakkaan saapumisaika = tapahtuman aika
            servicePoint.addToQueue(c);
            System.out.println("Asiakas " + c.getId() + " jonoon ajassa " + String.format("%.2f", c.getArrivalTime()));
        }

        // --- VAIHE 3: JONON PURKAMINEN JA TULOSTEN LASKENTA ---
        System.out.println("\n--- Vaihe 3: Palvellaan asiakkaat ---");
        // Siirretään kelloa hieman eteenpäin
        clock.setTime(clock.getTime() + 5.0);
        System.out.printf("Kello siirretty eteenpäin. Uusi aika: %.2f\n", clock.getTime());

        while (!servicePoint.isQueueEmpty()) {
            Customer servedCustomer = servicePoint.serveNextCustomer();
            double departureTime = clock.getTime();
            double timeInSystem = departureTime - servedCustomer.getArrivalTime();

            System.out.printf("Palveltu asiakas %d. Poistumisaika: %.2f. Aika järjestelmässä: %.2f\n",
                    servedCustomer.getId(), departureTime, timeInSystem);
        }
    }
}