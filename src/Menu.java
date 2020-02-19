import java.util.Scanner;

public class Menu {

    // City Implementation
    // 1. change name of head method 2. Define cities Prizes 3. Define MainMenu City Name
    Scanner scanner = new Scanner(System.in);
    BoxOfApples boxOfApples = new BoxOfApples();

    //---------------------------------------------------------------------------------------------------------------------
    void menuNewYork(Auto auto) throws InterruptedException {
        // cityPrizeUpdater
        boxOfApples.setApplePrize(30);
        boxOfApples.appleInit = true;


        int choose;
        System.out.println();
        System.out.println("-----------------");
        System.out.println("New York City ");
        System.out.println("Co chcesz zrobić:");
        System.out.println();
        System.out.println("1. Sprawdz status");
        System.out.println("2. Jedź do...");
        System.out.println("3. Kup towar");
        System.out.println("4. Sprzedaj towar");
        System.out.println("5. Zatankuj");
        System.out.println("6. Włącz silnik");
        choose = scanner.nextInt();
        if (choose == 1) {
            auto.showMyStatus();
        } else if (choose == 2) {


            Droga droga = new Droga();
            System.out.println("    1. Washington D.C  (Dystans - " + droga.fromNYCtoWashingtonDC + ")");
            System.out.println("    2. Detroit  (Dystans - " + droga.fromNYCtoDetroit + ")");
            System.out.println("    3. Powrót");
            int innerChoose = scanner.nextInt();
            if (innerChoose == 1) {
                droga.roadFromNYCtoWashingtonDC();

                if (auto.drive(droga, auto) == true) {
                    menuWashingtonDC(auto);
                }
            } else if (innerChoose == 2) {
                droga.roadFromDetroitToNYC();
                if (auto.drive(droga, auto) == true) {
                    menuDetroit(auto);
                }

            } else if (innerChoose == 3) {
                menuNewYork(auto);
            } else {
                System.out.println("Nie ma takiej opcji");
                menuNewYork(auto);
            }


        } else if (choose == 3) {

            System.out.println("    Co chcesz kupić:");
            System.out.println("    1. Skrzynia Jabłek - Cena: " + boxOfApples.applePrize + "$  Waga: " + boxOfApples.appleWeight + "kg");
            System.out.println("    2.");
            System.out.println("    3. Powrót");
            int innerChoose = scanner.nextInt();
            if (innerChoose == 1) {

                boxOfApples.buyApples(auto, boxOfApples);
            } else if (innerChoose == 2) {
                System.out.println("BRAK IMPLEMENTACJI");
            } else if (innerChoose == 3) {
                System.out.println("Brak IMPLEMENTACJI 2");
            } else {
                System.out.println("Nie ma takiej opcji");
                menuNewYork(auto);
            }
        } else if (choose == 4) {
            System.out.println("    Co chcesz sprzedać:");
            if (boxOfApples.appleInit == true) {
                System.out.println("    1. Skrzynie Jabłek");
            }

            if (scanner.nextInt() == 1) {
                boxOfApples.sellApples(auto, boxOfApples);
            }


        } else if (choose == 5) {
            System.out.println("Za ile chcesz zatankować ? (Posiadasz " + auto.getCurrentMoney() + "$)");
            int howMuch;
            howMuch = scanner.nextInt();
            auto.refuelCar(howMuch);
        } else if (choose == 6) {
            auto.turnEngineOnOff();
        } else System.out.println("Nie ma takiej opcji");


        menuNewYork(auto);
    }

    //---------------------------------------------------------------------------------------------------------------------
    void menuWashingtonDC(Auto auto) throws InterruptedException {
        // cityPrizeUpdater
        boxOfApples.setApplePrize(40);
        boxOfApples.appleInit = true;


        int choose;
        System.out.println();
        System.out.println("-----------------");
        System.out.println("Washington D.C. ");
        System.out.println("Co chcesz zrobić:");
        System.out.println();
        System.out.println("1. Sprawdz status");
        System.out.println("2. Jedź do...");
        System.out.println("3. Kup towar");
        System.out.println("4. Sprzedaj towar");
        System.out.println("5. Zatankuj");
        System.out.println("6. Włącz silnik");
        choose = scanner.nextInt();
        if (choose == 1) {
            auto.showMyStatus();
        } else if (choose == 2) {


            Droga droga = new Droga();
            System.out.println("    1. New York  (Dystans - " + droga.fromNYCtoWashingtonDC + ")");
            System.out.println("    2. Chicago  (Dystans - " + droga.fromWashingtonDCToChicago + ")");
            System.out.println("    3. Powrót");
            if (scanner.nextInt() == 1) {
                droga.roadFromNYCtoWashingtonDC();

                if (auto.drive(droga, auto) == true) {
                    droga.roadFromNYCtoWashingtonDC();
                    menuNewYork(auto);
                }
            } else if (scanner.nextInt() == 2) {
                droga.roadFromWashingtonDCToChicago();
                if (auto.drive(droga, auto) == true) {
                    menuChicago(auto);
                }

            } else if (scanner.nextInt() == 3) {
                menuNewYork(auto);
            } else {
                System.out.println("Nie ma takiej opcji");
                menuWashingtonDC(auto);
            }


        } else if (choose == 3) {

            System.out.println("    Co chcesz kupić:");
            System.out.println("    1. Skrzynia Jabłek - Cena: " + boxOfApples.applePrize + "$  Waga: " + boxOfApples.appleWeight + "kg");
            System.out.println("    2.");
            System.out.println("    3. Powrót");
            int innerChoose = scanner.nextInt();
            if (innerChoose == 1) {

                boxOfApples.buyApples(auto, boxOfApples);
            } else if (innerChoose == 2) {
                System.out.println("BRAK IMPLEMENTACJI");
            } else if (innerChoose == 3) {
                System.out.println("Brak IMPLEMENTACJI 2");
            } else {
                System.out.println("Nie ma takiej opcji");
                menuWashingtonDC(auto);
            }
        } else if (choose == 4) {
            System.out.println("    Co chcesz sprzedać:");
            if (boxOfApples.appleInit == true) {
                System.out.println("    1. Skrzynie Jabłek");
            }

            if (scanner.nextInt() == 1) {
                boxOfApples.sellApples(auto, boxOfApples);
            }


        } else if (choose == 5) {
            System.out.println("Za ile chcesz zatankować ? (Posiadasz " + auto.getCurrentMoney() + "$)");
            int howMuch;
            howMuch = scanner.nextInt();
            auto.refuelCar(howMuch);
        } else if (choose == 6) {
            auto.turnEngineOnOff();
        } else System.out.println("Nie ma takiej opcji");


        menuWashingtonDC(auto);
    }

    //---------------------------------------------------------------------------------------------------------------------
    void menuDetroit(Auto auto) throws InterruptedException {
        // cityPrizeUpdater
        boxOfApples.setApplePrize(50);
        boxOfApples.appleInit = true;


        int choose;
        System.out.println();
        System.out.println("-----------------");
        System.out.println("Detroit ");
        System.out.println("Co chcesz zrobić:");
        System.out.println();
        System.out.println("1. Sprawdz status");
        System.out.println("2. Jedź do...");
        System.out.println("3. Kup towar");
        System.out.println("4. Sprzedaj towar");
        System.out.println("5. Zatankuj");
        System.out.println("6. Włącz silnik");
        choose = scanner.nextInt();
        if (choose == 1) {
            auto.showMyStatus();
        } else if (choose == 2) {

            Droga droga = new Droga();
            System.out.println("    1. New York City  (Dystans - " + droga.fromNYCtoDetroit + ")");
            System.out.println("    2. Chicago  (Dystans - " + droga.fromDetroitToChicago + ")");
            System.out.println("    3. Minneapolis  (Dystans - " + droga.fromMinneapolisToDetroit + ")");
            System.out.println("    4. Powrót");
            int innerChoose = scanner.nextInt();
            if (innerChoose == 1) {
                droga.roadFromNYCtoWashingtonDC();

                if (auto.drive(droga, auto) == true) {
                    menuNewYork(auto);
                }
            } else if (innerChoose == 2) {
                droga.roadFromDetroitToChicago();

                if (auto.drive(droga, auto) == true) {
                    menuChicago(auto);
                }
            } else if (innerChoose == 3) {
                droga.roadFromMinneapolisToDetroit();
                if (auto.drive(droga, auto) == true) {
                    menuMinneapolis(auto);
                }
            } else if (innerChoose == 4) {
                System.out.println("Powrót");
                menuDetroit(auto);
            } else {
                System.out.println("Nie ma takiej opcji");
                menuDetroit(auto);
            }

        } else if (choose == 3) {

            System.out.println("    Co chcesz kupić:");
            System.out.println("    1. Skrzynia Jabłek - Cena: " + boxOfApples.applePrize + "$  Waga: " + boxOfApples.appleWeight + "kg");
            System.out.println("    2. BRAK IMPLEMENATACJI");
            System.out.println("    3. Powrót");
            int innerChoose = scanner.nextInt();
            if (innerChoose == 1) {

                boxOfApples.buyApples(auto, boxOfApples);
            } else if (innerChoose == 2) {
                System.out.println("BRAK IMPLEMENTACJI");
            } else if (innerChoose == 3) {
                System.out.println("Brak IMPLEMENTACJI 2");
            } else {
                System.out.println("Nie ma takiej opcji");
                menuDetroit(auto);
            }
        } else if (choose == 4) {
            System.out.println("    Co chcesz sprzedać:");
            if (boxOfApples.appleInit == true) {
                System.out.println("    1. Skrzynie Jabłek");
            }

            if (scanner.nextInt() == 1) {
                boxOfApples.sellApples(auto, boxOfApples);
            }

        } else if (choose == 5) {
            System.out.println("Za ile chcesz zatankować ? (Posiadasz " + auto.getCurrentMoney() + "$)");
            int howMuch;
            howMuch = scanner.nextInt();
            auto.refuelCar(howMuch);
        } else if (choose == 6) {
            auto.turnEngineOnOff();
        } else System.out.println("Nie ma takiej opcji");


        menuDetroit(auto);
    }

    //---------------------------------------------------------------------------------------------------------------------
    void menuChicago(Auto auto) throws InterruptedException {
        // cityPrizeUpdater
        boxOfApples.setApplePrize(40);
        boxOfApples.appleInit = true;


        int choose;
        System.out.println();
        System.out.println("-----------------");
        System.out.println("Chicago ");
        System.out.println("Co chcesz zrobić:");
        System.out.println();
        System.out.println("1. Sprawdz status");
        System.out.println("2. Jedź do...");
        System.out.println("3. Kup towar");
        System.out.println("4. Sprzedaj towar");
        System.out.println("5. Zatankuj");
        System.out.println("6. Włącz silnik");
        choose = scanner.nextInt();
        if (choose == 1) {
            auto.showMyStatus();
        } else if (choose == 2) {


            Droga droga = new Droga();
            System.out.println("    1. Washington D.C  (Dystans - " + droga.fromWashingtonDCToChicago + ")");
            System.out.println("    2. Detroit  (Dystans - " + droga.fromDetroitToChicago + ")");
            System.out.println("    3. Minneapolis  (Dystans - " + droga.fromWashingtonDCToChicago + ")");
            System.out.println("    4. Powrót");
            int innerChoose = scanner.nextInt();
            if (innerChoose == 1) {
                droga.roadFromNYCtoWashingtonDC();

                if (auto.drive(droga, auto) == true) {
                    menuWashingtonDC(auto);
                }
            } else if (innerChoose == 2) {
                droga.roadFromDetroitToChicago();
                if (auto.drive(droga, auto) == true) {
                    menuDetroit(auto);
                }
            } else if (innerChoose == 3) {
                droga.roadFromMinneapolistoChicago();
                if (auto.drive(droga, auto) == true) {
                    menuMinneapolis(auto);
                }
            } else if (innerChoose == 4) {
                System.out.println("Nie ma takiej opcji");
                menuChicago(auto);
            }


        } else if (choose == 3) {

            System.out.println("    Co chcesz kupić:");
            System.out.println("    1. Skrzynia Jabłek - Cena: " + boxOfApples.applePrize + "$  Waga: " + boxOfApples.appleWeight + "kg");
            System.out.println("    2.");
            System.out.println("    3. Powrót");
            int innerChoose = scanner.nextInt();
            if (innerChoose == 1) {

                boxOfApples.buyApples(auto, boxOfApples);
            } else if (innerChoose == 2) {
                System.out.println("BRAK IMPLEMENTACJI");
            } else if (innerChoose == 3) {
                System.out.println("Brak IMPLEMENTACJI 2");
            } else {
                System.out.println("Nie ma takiej opcji");
                menuChicago(auto);
                ;
            }
        } else if (choose == 4) {
            System.out.println("    Co chcesz sprzedać:");
            if (boxOfApples.appleInit == true) {
                System.out.println("    1. Skrzynie Jabłek");
            }

            if (scanner.nextInt() == 1) {
                boxOfApples.sellApples(auto, boxOfApples);
            }


        } else if (choose == 5) {
            System.out.println("Za ile chcesz zatankować ? (Posiadasz " + auto.getCurrentMoney() + "$)");
            int howMuch;
            howMuch = scanner.nextInt();
            auto.refuelCar(howMuch);
        } else if (choose == 6) {
            auto.turnEngineOnOff();
        } else System.out.println("Nie ma takiej opcji");


        menuChicago(auto);
    }

    // ---------------------------------------------------------------------------------------------------------------------
    void menuMinneapolis(Auto auto) throws InterruptedException {
        // cityPrizeUpdater
        boxOfApples.setApplePrize(60);
        boxOfApples.appleInit = true;


        int choose;
        System.out.println();
        System.out.println("-----------------");
        System.out.println("Minneapolis ");
        System.out.println("Co chcesz zrobić:");
        System.out.println();
        System.out.println("1. Sprawdz status");
        System.out.println("2. Jedź do...");
        System.out.println("3. Kup towar");
        System.out.println("4. Sprzedaj towar");
        System.out.println("5. Zatankuj");
        System.out.println("6. Włącz silnik");
        choose = scanner.nextInt();
        if (choose == 1) {
            auto.showMyStatus();
        } else if (choose == 2) {


            Droga droga = new Droga();
            System.out.println("    1. Detroit  (Dystans - " + droga.fromMinneapolisToDetroit + ")");
            System.out.println("    2. Chicago  (Dystans - " + droga.fromMinneapolisToChicago + ")");
            System.out.println("    3. Powrót");
            int innerChoose = scanner.nextInt();
            if (innerChoose == 1) {
                droga.roadFromMinneapolisToDetroit();

                if (auto.drive(droga, auto) == true) {
                    menuDetroit(auto);
                }
            } else if (innerChoose == 2) {
                droga.roadFromMinneapolistoChicago();
                if (auto.drive(droga, auto) == true) {
                    menuChicago(auto);
                }

            } else if (innerChoose == 3) {
                menuMinneapolis(auto);
            } else {
                System.out.println("Nie ma takiej opcji");
                menuMinneapolis(auto);
            }


        } else if (choose == 3) {

            System.out.println("    Co chcesz kupić:");
            System.out.println("    1. Skrzynia Jabłek - Cena: " + boxOfApples.applePrize + "$  Waga: " + boxOfApples.appleWeight + "kg");
            System.out.println("    2.");
            System.out.println("    3. Powrót");
            int innerChoose = scanner.nextInt();
            if (innerChoose == 1) {

                boxOfApples.buyApples(auto, boxOfApples);
            } else if (innerChoose == 2) {
                System.out.println("BRAK IMPLEMENTACJI");
            } else if (innerChoose == 3) {
                System.out.println("Brak IMPLEMENTACJI 2");
            } else {
                System.out.println("Nie ma takiej opcji");
                menuMinneapolis(auto);
            }
        } else if (choose == 4) {
            System.out.println("    Co chcesz sprzedać:");
            if (boxOfApples.appleInit == true) {
                System.out.println("    1. Skrzynie Jabłek");
            }

            if (scanner.nextInt() == 1) {
                boxOfApples.sellApples(auto, boxOfApples);
            }


        } else if (choose == 5) {
            System.out.println("Za ile chcesz zatankować ? (Posiadasz " + auto.getCurrentMoney() + "$)");
            int howMuch;
            howMuch = scanner.nextInt();
            auto.refuelCar(howMuch);
        } else if (choose == 6) {
            auto.turnEngineOnOff();
        } else System.out.println("Nie ma takiej opcji");


        menuMinneapolis(auto);
    }

}
