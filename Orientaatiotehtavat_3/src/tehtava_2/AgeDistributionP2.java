package tehtava_2;

import java.util.Random;

public class AgeDistributionP2 {

    // Kuinka monta arpa-arvoa tehdään
    private static final int REITERATIONS = 1000;

    // Suurin ikä taulukossa (täältä vain tulostuksen rajaa varten)
    private static final int MAXAGE = 35;

    // Kertyvien rajojen taulukko: {kertyvä_prosenttiyläraja, ikä}
    // Sama idea kuin materiaalin esimerkissä (“Your own distribution”).
    // 1..16 -> 20 v, 17..34 -> 21 v, jne.
    private static final int[][] AGE_DISTRIBUTION = {
            {16, 20},   // 16 %
            {34, 21},   // 18 %
            {52, 22},   // 18 %
            {68, 23},   // 16 %
            {82, 24},   // 14 %
            {89, 25},   // 7  %
            {94, 26},   // 5  %
            {96, 28},   // 2  %
            {98, 30},   // 2  %
            {100, MAXAGE} // 2 %
    };

    public static void main(String[] args) {
        // Testauksen vuoksi sallitaan siemen (seed) komentoriviltä.
        // Jos et anna siementä, käytetään System.currentTimeMillis().
        long seed = (args.length > 0) ? Long.parseLong(args[0]) : System.currentTimeMillis();
        Random rng = new Random(seed);

        int[] count = new int[MAXAGE + 1]; // laskurit iälle

        // 1) Arvo tasajakautunut luku 1..100
        // 2) Etsi ensimmäinen rivi, jonka kertyvä_yläraja >= arpa
        // 3) Nosta kyseisen iän laskuria
        for (int i = 0; i < REITERATIONS; i++) {
            int x = rng.nextInt(100) + 1; // 1..100
            int j = 0;
            while (x > AGE_DISTRIBUTION[j][0]) {
                j++;
            }
            int age = AGE_DISTRIBUTION[j][1];
            count[age]++;
        }

        // Tulostus
        System.out.println("Seed = " + seed);
        System.out.println("Age  count     %-share");
        for (int age = 0; age <= MAXAGE; age++) {
            if (count[age] > 0) {
                double pct = (count[age] * 100.0) / REITERATIONS;
                System.out.printf("%-4d %-8d %-8.2f%n", age, count[age], pct);
            }
        }
    }
}
