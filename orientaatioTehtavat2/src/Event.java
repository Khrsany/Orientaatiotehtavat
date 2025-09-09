public class Event implements Comparable<Event> {
    private final double time;   // tapahtuman aika
    private final String type;   // esim. "Arrival", "Exit" (enum vasta tehtävässä 3)

    public Event(double time, String type) {
        this.time = time;
        this.type = type;
    }

    public double getTime() { return time; }
    public String getType() { return type; }

    @Override
    public int compareTo(Event other) {
        // Pienempi aika = suurempi prioriteetti (tulee ensin)
        return Double.compare(this.time, other.time);
    }

    @Override
    public String toString() {
        return "Event{time=" + time + ", type=" + type + "}";
    }
}
