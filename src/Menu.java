import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    void menuChoose(Auto auto) throws InterruptedException {

        int choose;
        System.out.println("Witaj");
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
            auto.drive(droga);
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


        menuChoose(auto);
    }
}
