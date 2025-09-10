package tehtava_6_7;

import eduni.distributions.ContinuousGenerator;

// Tämä luokka luo uusia saapumistapahtumia.
public class ArrivalProcess {

    // Ominaisuudet: satunnaislukugeneraattori ja tapahtuman tyyppi
    private ContinuousGenerator generator;
    private EventType eventType;

    public ArrivalProcess(ContinuousGenerator g, EventType type) {
        this.generator = g;
        this.eventType = type;
    }

    // Metodi luo uuden tapahtuman ja lisää sen annettuun listaan.
    public void generateNextEvent(EventList eventList, double currentTime) {
        // Arvotaan satunnainen aika seuraavaan tapahtumaan
        double interval = generator.sample();
        // Lasketaan uusi tapahtuma-aika
        double newTime = currentTime + interval;
        eventList.add(new Event(eventType, newTime));
    }
}