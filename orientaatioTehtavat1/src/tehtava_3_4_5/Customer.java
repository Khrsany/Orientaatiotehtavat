package tehtava_3_4_5;

public class Customer {
    private static int nextId = 1;
    private int id;
    private long startTime;
    private long endTime;

    //konstruktori
    public Customer(){
        id = nextId;
        nextId +=1;
    }
    //metodit
    public long getStartTime(){
        return startTime;
    }
    public void setStartTime(long uusiAika){
        this.startTime = uusiAika;
    }
    public long getEndTime(){
        return endTime;
    }
    public void setEndTime(long uusiLoppuAika){
        this.endTime = uusiLoppuAika;
    }
    public int getId(){
        return id;
    }
    public long getDuration(){
        return (endTime - startTime);
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setStartTime(2);
        customer.setEndTime(5);
        System.out.println("ensimmäisen asiakkaan id on: " + customer.getId());
        System.out.println("aloitus aika on: " + customer.getStartTime());
        System.out.println("lopetus aika on: "+ customer.getEndTime());
        System.out.println("aika viety: " + customer.getDuration());
        Customer customer2 = new Customer();
        System.out.println("Toisen asiakkaan ID: " + customer2.getId());
    }
}
