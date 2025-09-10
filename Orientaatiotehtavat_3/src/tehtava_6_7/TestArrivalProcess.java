package tehtava_6_7;

import eduni.distributions.Negexp;

public class TestArrivalProcess {
    public static void main(String[] args) {
        // 1. Alustetaan kaikki tarvittavat oliot
        Clock clock = Clock.getInstance(); // Olettaa, että Clock-luokka on olemassa
        EventList eventList = new EventList();

        // Käytetään eksponenttijakaumaa eduni.distributions-kirjastosta
        Negexp generator = new Negexp(10.0); // Keskimääräinen saapumisväli 10.0

        EventType arrivalType = new EventType("SAAPUMINEN");
        ArrivalProcess arrivalProcess = new ArrivalProcess(generator, arrivalType);

        System.out.println("Luodaan 10 saapumistapahtumaa...");

        // 2. Luodaan 10 tapahtumaa silmukassa
        for (int i = 0; i < 10; i++) {
            // Luodaan uusi tapahtuma nykyhetkestä alkaen
            arrivalProcess.generateNextEvent(eventList, clock.getTime());
            // Siirretään kello uuden tapahtuman aikaan
            clock.setTime(eventList.getLastEvent().getTime());
        }

        // 3. Tulostetaan lopputulos
        System.out.println("\nTulostetaan tapahtumalista:");
        eventList.print();
        System.out.printf("\nLopullinen kellonaika: %.2f\n", clock.getTime());
    }
}