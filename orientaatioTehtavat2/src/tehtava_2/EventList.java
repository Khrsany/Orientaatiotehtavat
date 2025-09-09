import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class EventList {
    private final PriorityQueue<Event> pq = new PriorityQueue<>();

    // lisää tapahtuma listaan
    public void add(Event e) { pq.add(e); }

    // poista ja palauta seuraava (pienin aika)
    public Event pollNext() { return pq.poll(); }

    // apumetodit
    public boolean isEmpty() { return pq.isEmpty(); }
    public int size() { return pq.size(); }

    // tee järjestetty kopio tulostusta varten
    public List<Event> snapshotSorted() {
        List<Event> copy = new ArrayList<>(pq);
        Collections.sort(copy);
        return copy;
    }
}
