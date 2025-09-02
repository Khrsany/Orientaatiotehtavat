package tehtava_3_4_5;

public class CustomerGenerator {

    // Yksinkertainen metodi, joka luo asiakkaita ja lisää ne palvelupisteen jonoon.
    public static void generateCustomers(ServicePoint servicePoint, int numberOfCustomers) {
        System.out.println("Luodaan " + numberOfCustomers + " asiakasta...");
        for (int i = 0; i < numberOfCustomers; i++) {
            servicePoint.addToQueueue(new Customer());
        }
        System.out.println("Asiakkaat luotu ja lisätty jonoon.");
    }
}