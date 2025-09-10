package tehtava_6_7;

import java.util.ArrayList;

public class EventList {
    private ArrayList<Event> list = new ArrayList<>();

    /**
     * Metodi uuden tapahtuman lisäämiseen listalle.
     * @param e Lisättävä Event-olio.
     */
    public void add(Event e) {
        list.add(e);
    }

    /**
     * Metodi, jolla saadaan viimeisin lisätty tapahtuma.
     * Käytettiin tehtävässä 6 kellonajan päivittämiseen.
     * @return Viimeisin Event-olio tai null, jos lista on tyhjä.
     */
    public Event getLastEvent() {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    /**
     * Metodi koko listan tulostamiseen konsoliin.
     */
    public void print() {
        for (Event e : list) {
            System.out.println(e);
        }
    }

    /**
     * Metodi, jolla saadaan koko lista käsittelyä varten.
     * Tarvittiin tehtävässä 7 asiakkaiden luomiseen.
     * @return ArrayList, joka sisältää kaikki Event-oliot.
     */
    public ArrayList<Event> getEvents() {
        return this.list;
    }
}