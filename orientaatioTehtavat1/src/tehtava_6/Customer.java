package tehtava_6;

public class Customer {
    private static int nextId = 1;
    private int id;
    private long startTime;
    private long endTime;

    // Konstruktori luo asiakkaan ja antaa sille uniikin ID:n
    public Customer(){
        this.id = nextId;
        nextId++;
    }

    // Getterit ja setterit
    public long getStartTime(){
        return this.startTime;
    }

    public void setStartTime(long uusiAika){
        this.startTime = uusiAika;
    }

    public long getEndTime(){
        return this.endTime;
    }

    public void setEndTime(long uusiLoppuAika){
        this.endTime = uusiLoppuAika;
    }

    public int getId(){
        return this.id;
    }

    // Metodi, joka laskee asiakkaan kokonaisajan järjestelmässä
    public long getDuration(){
        return (endTime - startTime);
    }
}