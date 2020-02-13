import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    void menuChoose(Auto auto) throws InterruptedException {

        int choose;
        System.out.println();
        System.out.println("-----------------");
        System.out.println("New York City ");
        System.out.println("Co chcesz zrobić:");
        System.out.println();
        System.out.println("1. Sprawdz status");
        System.out.println("2. Jedź do...");
        System.out.println("3. Kup towar");
        System.out.println("4. Zatankuj");
        System.out.println("5. Włącz silnik");
        choose = scanner.nextInt();
        if (choose == 1) {
            auto.showMyStatus();
        } else if (choose == 2) {


            Droga droga = new Droga();
            System.out.println("    1. Washington D.C  (Dystans - " + droga.fromNYCtoWashingtonDC + ")");
            System.out.println("    2. Detroit  (Dystans - " + droga.fromNYCtoDetroit + ")");
            System.out.println("    3. Powrót");
            if (scanner.nextInt() == 1) {
                // System.out.println("jedziem do dc");
                droga.roadToWashingtonDC();

                if (auto.drive(droga, auto) == true) {
                    menuChoose2(auto);
                }
            } else if (scanner.nextInt() == 2) {
                System.out.println("jedziem do det");
            } else if (scanner.nextInt() == 3) {
                menuChoose(auto);
            } else {
                System.out.println("Nie ma takiej opcji");
                menuChoose(auto);
            }


        } else if (choose == 3) {
            System.out.println("Co chcesz kupić:");
            System.out.println("1. Skrzynia Jabłek - Cena: " + Goods.applePrize + "$  Waga: " + Goods.appleWeight + "kg");
            System.out.println("2.");
            System.out.println("3. Powrót");
            Goods goods = new Goods();
            goods.buy(auto);


        } else if (choose == 4) {
            System.out.println("Za ile chcesz zatankować ? (Posiadasz " + auto.getCurrentMoney() + "$)");
            int howMuch;
            howMuch = scanner.nextInt();
            auto.refuelCar(howMuch);
        } else if (choose == 5) {
            auto.turnEngineOnOff();
        } else System.out.println("Nie ma takiej opcji");


        menuChoose(auto);
    }

    void menuChoose2(Auto auto) throws InterruptedException {

        int choose;
        System.out.println();
        System.out.println("-----------------");
        System.out.println("Washington D.C.");
        System.out.println("Co chcesz zrobić:");
        System.out.println();
        System.out.println("1. Sprawdz status");
        System.out.println("2. Jedź do...");
        System.out.println("3. Kup towar");
        System.out.println("4. Zatankuj");
        System.out.println("5. Włącz silnik");
        choose = scanner.nextInt();
        if (choose == 1) {
            auto.showMyStatus();
        } else if (choose == 2) {
            Droga droga = new Droga();
            auto.drive(droga, auto);
        } else if (choose == 3) {
            System.out.println("Kupujesz towar - FUNCKJA NIE ZAIMPLEMENTOWANA");
        } else if (choose == 4) {
            System.out.println("Za ile chcesz zatankować ?");
            int howMuch;
            howMuch = scanner.nextInt();
            auto.refuelCar(howMuch);
        } else if (choose == 5) {
            auto.turnEngineOnOff();
        } else System.out.println("Nie ma takiej opcji");


        menuChoose2(auto);
    }
}
