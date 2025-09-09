public class TestSimulation {
    public static void main(String[] args) {
        EventList list = new EventList();

        // a) lisää muutama tapahtuma enum-tyypeillä (sekaisin, jotta näemme järjestyksen)
        list.add(new Event(5.0,  EventType.ARRIVAL));
        list.add(new Event(2.0,  EventType.ARRIVAL));
        list.add(new Event(7.0,  EventType.EXIT));
        list.add(new Event(6.0,  EventType.ARRIVAL));
        list.add(new Event(6.0,  EventType.EXIT));
        list.add(new Event(10.0, EventType.ARRIVAL));

        System.out.println("Alkuperäinen EventList (järjestetty näkymä):");
        list.snapshotSorted().forEach(System.out::println);

        // b) poista seuraava (pienimmän ajan tapahtuma)
        Event next = list.pollNext();
        System.out.println("\nPoistettu seuraava tapahtuma: " + next);

        // c) tulosta jäljellä oleva lista aikajärjestyksessä
        System.out.println("\nJäljellä oleva EventList (järjestetty näkymä):");
        list.snapshotSorted().forEach(System.out::println);

        System.out.println("\nJäljellä yhteensä: " + list.size());
    }
}
