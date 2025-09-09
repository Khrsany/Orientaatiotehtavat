public class Event implements Comparable<Event> {
    private final double time;       // tapahtuma-aika
    private final EventType type;    // tapahtuman tyyppi (enum)

    public Event(double time, EventType type) {
        this.time = time;
        this.type = type;
    }

    public double getTime() { return time; }
    public EventType getType() { return type; }

    @Override
    public int compareTo(Event other) {
        // pienempi aika = käsitellään ensin
        return Double.compare(this.time, other.time);
    }

    @Override
    public String toString() {
        return "Event{time=" + time + ", type=" + type + "}";
    }
}
