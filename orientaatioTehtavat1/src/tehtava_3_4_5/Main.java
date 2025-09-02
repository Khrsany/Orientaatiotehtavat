package tehtava_3_4_5;

public class Main {

    public static void main(String[] args) {
        // 1. Luo uusi palvelupiste.
        ServicePoint servicePoint = new ServicePoint();

        // 2. Käytä CustomerGeneratoria luomaan 5 asiakasta ja lisäämään ne jonoon.
        CustomerGenerator.generateCustomers(servicePoint, 5);

        // 3. Käynnistä palveluprosessi.
        servicePoint.serve();
    }
}