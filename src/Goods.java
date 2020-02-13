import java.util.Scanner;

public class Goods {
    Scanner scanner = new Scanner(System.in);

    int generalGoods;

    static int applePrize = 30;

    String appleName = "Skrzynia Jabłek";
    static int appleWeight = 20;

    public void buy(Auto auto) {
        System.out.println("Ile sztuk towaru chcesz zakupić ?");
        int ile = scanner.nextInt();
        if ((ile * applePrize) > auto.currentMoney) {
            System.out.println("Za mało funduszy");
        } else {
            if ((ile * appleWeight) + auto.currentCarLoad > auto.carLoadLimit) {
                System.out.println("Twój pojazd nie pomieści tyle towaru");
            } else {
                System.out.println("Zakupiłeś " + ile + " " + appleName);
                auto.currentCarLoad += ile * appleWeight;
                auto.currentMoney -= ile * applePrize;

            }

        }
    }


}
