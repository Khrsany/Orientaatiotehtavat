import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class EventList {
    private final PriorityQueue<Event> pq = new PriorityQueue<>();

    // 1) lisää tapahtuma
    public void add(Event e) {
        pq.add(e);
    }

    // 2) poista ja palauta seuraava (pienimmän ajan tapahtuma)
    public Event pollNext() {
        return pq.poll();
    }

    // apu: onko tyhjä
    public boolean isEmpty() {
        return pq.isEmpty();
    }

    public int size() {
        return pq.size();
    }

    // 3) tulostusta varten: tee kopio ja lajittele, jotta varmasti aikajärjestys
    public List<Event> snapshotSorted() {
        List<Event> copy = new ArrayList<>(pq);
        Collections.sort(copy);
        return copy;
    }
}
