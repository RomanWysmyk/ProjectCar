import java.util.concurrent.TimeUnit;

public class Auto {

    boolean engine = false;
    int currentMoney = 50;
    private int petrolPrize = 3;
    private int maxSpeed = 100;
    int carLoadLimit = 1000;
    int currentCarLoad = 0;
    private double currentFuel = 10;
    private double fuelMaxCap = 150;

    public int getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(int currentMoney) {
        this.currentMoney = currentMoney;
    }

    double refuelCar(int howMuchMoneySpendForFuel) {

        if (howMuchMoneySpendForFuel > currentMoney || howMuchMoneySpendForFuel <= 0) {
            System.out.println("Masz niewystarczające środki na koncie");
        } else {
            int currentFueling = howMuchMoneySpendForFuel / petrolPrize;
            if (currentFueling + currentFuel > fuelMaxCap) {
                System.out.println("Nie możesz tyle zatankować. Próbujesz wlać do baku " + currentFueling + currentFuel + " litrów paliwa przy limicie " + fuelMaxCap + " litrów w baku pojazdu.");
            } else {
                currentMoney -= howMuchMoneySpendForFuel;
                currentFuel += currentFueling;
                System.out.println("Zatankowałeś Paliwo (Masz teraz " + currentFuel + " litrów w baku. Pozostało Ci " + currentMoney + " dolarów w portfelu)");
            }
        }
        return currentFuel;
    }

    void turnEngineOnOff() {
        if (engine == false && currentFuel > 0) {
            engine = true;
            System.out.println("Włączasz silnik");

        } else if (engine == true) {
            engine = false;
            System.out.println("Wyłączasz silnik");
        }
    }

    boolean drive(Droga droga, Auto auto) throws InterruptedException {
        int deley = maxSpeed * 10;
        if (engine == true) {

            System.out.println("Ruszasz w drogę:");

            for (int i = 0; i < droga.roadLenght; i++) {
                TimeUnit.MILLISECONDS.sleep(deley);
                currentFuel -= 1 + fuelByLoadWeightComsumption();
                System.out.println("Pokonałeś dystans: " + (i + 1) + " km");
                RoadEvents eventStarter = new RoadEvents();
                eventStarter.eventRandomizer(auto);

                if (currentFuel < 0) {
                    System.out.println("Przegrałeś skończyło Ci się paliwo");
                    auto.gameOver();
                    return false;

                }
            }


        } else {

            System.out.println("Nie udało się pojechać ponieważ silnik jest wyłączony");
            return false;

        }
        return true;

    }

    double fuelByLoadWeightComsumption() {

        double percentOfConsumption = (((double) currentCarLoad) / (double) carLoadLimit) * 100;
        double consumption = 0;

        if (percentOfConsumption < 20 && percentOfConsumption > 0) {

        } else if (percentOfConsumption >= 20 && percentOfConsumption < 40) {
            consumption = 0.4;
        } else if (percentOfConsumption >= 40 && percentOfConsumption < 60) {
            consumption = 0.6;
        } else if (percentOfConsumption >= 60 && percentOfConsumption < 80) {
            consumption = 1;
        } else if (percentOfConsumption >= 80 && percentOfConsumption < 100) {
            consumption = 1.5;
        }


        return consumption;
    }

    void showMyStatus() {
        System.out.println("Twoje oszczędności to :" + currentMoney + "$");
        System.out.println("Twój stan paliwa: " + currentFuel + "L (Max " + fuelMaxCap + "L)");
        System.out.println("Twój limit ładunku to: " + carLoadLimit + " kg.");
        System.out.println("Masz załadowane " + currentCarLoad + " kg łądunku.");
        System.out.println("Prędkośc twojego pojazdu to: " + maxSpeed + " km/h");
        System.out.println("Twoje aktualne zużycie paliwa wynosi: " + (1 + fuelByLoadWeightComsumption()));

    }

    void gameOver() {

        System.out.println("-----KONIEC--GRY-----");
        System.out.println();
        System.out.println("Twoje osiągnięcia:");
        System.out.println();
        System.out.println("Łącznie przjechałeś: " + " kilometrów");
        System.out.println("   Łącznie zarbiłeś: " + " dolarów");
        System.exit(0);
    }


}
