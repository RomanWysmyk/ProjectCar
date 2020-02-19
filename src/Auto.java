import java.util.concurrent.TimeUnit;

public class Auto {

    public static int numberOfApples = 0;
    boolean engine = false;
    int currentMoney = 300;
    int carLoadLimit = 500;
    int currentCarLoad = 0;
    private int petrolPrize = 3;
    private int maxSpeed = 10;
    private double currentFuel = 50;
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
        if (engine == true) {
            System.out.println("Silnik włączony");
        } else {
            System.out.println("Silnik wyłączony");
        }
        System.out.println("Twoje oszczędności: " + currentMoney + "$");
        System.out.println("Stan paliwa: " + currentFuel + "L (Max " + fuelMaxCap + "L)");
        System.out.println("Limit ładunku: " + carLoadLimit + " kg.");
        System.out.println("Masz załadowane " + currentCarLoad + " kg ładunku.");
        System.out.println("Prędkośc maksymalna pojazdu: " + maxSpeed + " km/h");
        System.out.println("Aktualne zużycie paliwa: " + (1 + fuelByLoadWeightComsumption()));
        System.out.println();
        System.out.println("Aktualnie posiadasz: ");
        if (numberOfApples > 0) {
            System.out.println(BoxOfApples.name + " - ilość " + numberOfApples + " (Łączna waga " + numberOfApples * BoxOfApples.appleWeight + " kg)");
        } else {
            System.out.println("Nie posiadasz aktualnie rzadnych towarów");
        }

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
