import java.util.concurrent.TimeUnit;

public class Auto {

    boolean engine = false;
    private int currentMoney = 50;
    private int petrolPrize = 3;
    private int maxSpeed = 100;
    private int currentSpeed = 0;
    private int carWeight = 100;
    private int currentFuel = 10;
    private int fuelMaxCap = 150;

    double refuelCar(int howMuchMoneySpendForFuel) {

        if (howMuchMoneySpendForFuel > currentFuel || howMuchMoneySpendForFuel <= 0) {
            System.out.println("Masz niewystarczające środki na koncie");
        } else {
            int currentFueling = howMuchMoneySpendForFuel / petrolPrize;
            if (currentFueling + currentFuel > fuelMaxCap) {
                System.out.println("Nie możesz tyle zatankować. Próbujesz wlać do baku " + currentFueling + currentFuel + " litrów paliwa przy limicie " + fuelMaxCap + " litrów w baku pojazdu.");
            } else {
                currentMoney -= howMuchMoneySpendForFuel;
                currentFuel += currentFueling;
                System.out.println("Zatankowałeś Paliwo (Masz teraz " + currentFuel + " litrów w baku. Pozostało Ci " + currentMoney + " zł w portfelu)");
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

    void drive(Droga droga) throws InterruptedException {
        int deley = maxSpeed * 10;
        if (engine == true) {

            System.out.println("Ruszasz w drogę:");

            for (int i = 0; i < droga.roadLenght; i++) {
                TimeUnit.MILLISECONDS.sleep(deley);
                currentFuel -= 1;
                System.out.println("Pokonałeś dystans: " + (i + 1) + " km");

                if (currentFuel < 0) {
                    System.out.println("Przegrałeś skończyło Ci się paliwo");
                    break;
                } else {
                    if (droga.roadLenght == i + 1) {

                        System.out.println("Dojechałeś do :" + droga.nameOfTheRoad);
                    }
                }

            }


        } else {

            System.out.println("Nie udało się pojechać ponieważ silnik jest wyłączony");

        }

    }


}
