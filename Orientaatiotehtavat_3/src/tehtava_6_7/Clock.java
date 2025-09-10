package tehtava_6_7;

public class Clock {

    private static Clock instance;
    private double time;

    // Yksityinen konstruktori estää olion luomisen new-komennolla.
    private Clock() {
        this.time = 0.0;
    }

    // Ainoa tapa saada Clock-olio. Luo olion vain kerran.
    public static Clock getInstance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }

    public void setTime(double newTime) {
        this.time = newTime;
    }

    public double getTime() {
        return this.time;
    }
}