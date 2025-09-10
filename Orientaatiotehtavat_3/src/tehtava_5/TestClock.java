package tehtava_5;

public class TestClock {
    public static void main(String[] args) {
        // Haetaan kello-olio kahteen eri muuttujaan.
        Clock c1 = Clock.getInstance();
        Clock c2 = Clock.getInstance();

        // Asetetaan aika yhden muuttujan kautta.
        c1.setTime(99.5);

        // Tulostetaan aika toisen muuttujan kautta.
        // Tulosteen pitäisi olla sama, koska kyseessä on sama olio.
        System.out.println("Kellon c2 aika: " + c2.getTime());
        System.out.println("Ovatko c1 ja c2 sama olio? " + (c1 == c2));
    }
}