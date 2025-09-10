package tehtava_6_7;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Aloitetaan simulaatio ---");

        // Luodaan uusi palvelupiste
        ServicePoint servicePoint = new ServicePoint();

        // Luodaan 5 asiakasta ja lisätään ne jonoon
        int numberOfCustomers = 5;
        System.out.println("Luodaan " + numberOfCustomers + " asiakasta...");
        for (int i = 0; i < numberOfCustomers; i++) {
            servicePoint.addToQueueue(new Customer());
        }
        System.out.println("Asiakkaat luotu ja lisätty jonoon.");

        // Käynnistetään palveluprosessi
        servicePoint.serve();

        System.out.println("\n--- Simulaatio suoritettu ---");
    }
}