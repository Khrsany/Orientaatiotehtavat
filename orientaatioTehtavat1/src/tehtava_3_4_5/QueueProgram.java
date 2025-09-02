package tehtava_3_4_5;

import java.util.LinkedList;
import java.util.Scanner;

public class QueueProgram {

    public static void main(String[] args) {

        // 1. Luodaan jono, johon voidaan tallentaa Customer-olioita.
        LinkedList<Customer> jono = new LinkedList<>();

        // 2. Luodaan Scanner-olio, jolla luetaan käyttäjän syötteitä.
        Scanner lukija = new Scanner(System.in);

        boolean jatkuu = true;

        // 3. Ohjelma pyörii while-silmukassa, kunnes käyttäjä haluaa lopettaa.
        while (jatkuu) {
            System.out.println("\nValitse toiminto:");
            System.out.println("1. Lisää asiakas jonoon (kirjoita 'lisaa')");
            System.out.println("2. Palvele seuraava asiakas (kirjoita 'poista')");
            System.out.println("3. Lopeta ohjelma (kirjoita 'lopeta')");
            System.out.print("Valintasi: ");

            String komento = lukija.nextLine();

            switch (komento) {
                case "lisaa":
                    // Luodaan uusi asiakas. Konstruktori antaa sille automaattisesti ID:n.
                    Customer uusiAsiakas = new Customer();

                    // Asetetaan asiakkaan jonoon tuloajaksi nykyinen nanoaika.
                    uusiAsiakas.setStartTime(System.nanoTime());

                    // Lisätään asiakas jonon alkuun tehtävänannon mukaisesti.
                    jono.addFirst(uusiAsiakas);
                    System.out.println("Asiakas " + uusiAsiakas.getId() + " lisätty jonoon.");
                    break;

                case "poista":
                    if (!jono.isEmpty()) {
                        // Poistetaan asiakas jonon hännästä (FIFO-periaate).
                        Customer palveltuAsiakas = jono.removeLast();

                        // Otetaan talteen jonosta poistumisaika.
                        long poistumisaika = System.nanoTime();

                        // Haetaan jonoon tuloaika, joka asetettiin aiemmin.
                        long saapumisaika = palveltuAsiakas.getStartTime();

                        // Lasketaan jonotusaika nanosekunteina.
                        long jonotusaikaNano = poistumisaika - saapumisaika;

                        // Muunnetaan aika millisekunneiksi, jotta se on luettavampi.
                        double jonotusaikaMilli = jonotusaikaNano / 1.0e6;

                        System.out.println("Palveltu asiakas " + palveltuAsiakas.getId() + ".");
                        System.out.printf("Asiakas jonotti %.2f millisekuntia.\n", jonotusaikaMilli);
                    } else {
                        System.out.println("Jono on tyhjä, ei poistettavia asiakkaita.");
                    }
                    break;

                case "lopeta":
                    jatkuu = false;
                    System.out.println("Ohjelma lopetetaan.");
                    break;

                default:
                    System.out.println("Virheellinen komento, yritä uudelleen.");
                    break;
            }
        }

        lukija.close();
    }
}