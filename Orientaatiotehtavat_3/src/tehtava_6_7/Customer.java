package tehtava_6_7;
package tehtava_6;

public class Customer {
    private double arrivalTime;
    private static int idCounter = 0;
    private int id;

    public Customer() {
        this.id = ++idCounter;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getId() {
        return id;
    }
}