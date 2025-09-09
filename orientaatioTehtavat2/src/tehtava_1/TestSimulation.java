package tehtava_1;

public class TestSimulation {
    public static void main(String[] args) {
        EventList list = new EventList();

        // a) lisää tapahtumia (tahallaan sekaisin, että nähdään järjestäminen)
        list.add(new Event(5.0,  "Arrival"));
        list.add(new Event(2.0,  "Service Start"));
        list.add(new Event(7.0,  "Exit"));
        list.add(new Event(6.0,  "Arrival"));
        list.add(new Event(6.0,  "Router Finish"));
        list.add(new Event(10.0, "Later"));

        System.out.println("Alkuperäinen tehtava_1.EventList (järjestetty näkymä):");
        list.snapshotSorted().forEach(System.out::println);

        // b) poista seuraava (pienimmän ajan tapahtuma)
        Event next = list.pollNext();
        System.out.println("\nPoistettu seuraava tapahtuma: " + next);

        // c) tulosta jäljellä oleva lista aikajärjestyksessä
        System.out.println("\nJäljellä oleva tehtava_1.EventList (järjestetty näkymä):");
        list.snapshotSorted().forEach(System.out::println);

        System.out.println("\nJäljellä yhteensä: " + list.size());
    }
}
