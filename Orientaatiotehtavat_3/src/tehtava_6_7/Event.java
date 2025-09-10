package tehtava_6_7;

class Event {
    private EventType type;
    private double time;
    public Event(EventType type, double time) { this.type = type; this.time = time; }
    public double getTime() { return time; }
    @Override public String toString() { return String.format("Tyyppi: %s, Aika: %.2f", type, time); }
}