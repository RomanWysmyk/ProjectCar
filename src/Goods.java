import java.util.Scanner;


class BoxOfApples {
    public static final int appleWeight = 20;
    public static String name = "Skrzynia jabłek";
    Scanner scanner = new Scanner(System.in);
    Boolean appleInit = false;
    int applePrize = 20;

    public String getName() {
        return name;
    }

    public void setApplePrize(int applePrize) {
        this.applePrize = applePrize;
    }

    public void buyApples(Auto auto, BoxOfApples boxOfApples) {
        System.out.println("Ile sztuk towaru chcesz kupić ?");
        int ile = scanner.nextInt();
        if ((ile * boxOfApples.applePrize) > auto.currentMoney) {
            System.out.println("Za mało funduszy");
        } else {
            if ((ile * boxOfApples.appleWeight) + auto.currentCarLoad > auto.carLoadLimit) {
                System.out.println("Twój pojazd nie pomieści tyle towaru");
            } else {
                System.out.println("Zakupiłeś " + ile + " " + name + " za " + ile * applePrize + "$");
                auto.currentCarLoad += ile * boxOfApples.appleWeight;
                auto.currentMoney -= ile * boxOfApples.applePrize;
                auto.numberOfApples += ile;

            }
        }
    }

    public void sellApples(Auto auto, BoxOfApples boxOfApples) {
        System.out.println("Ile sztuk towaru chcesz sprzedać ?");
        int ile = scanner.nextInt();

        if (auto.numberOfApples < ile) {
            System.out.println("Nie masz tyle towaru!");

        } else {
            if ((ile * boxOfApples.appleWeight) + auto.currentCarLoad > auto.carLoadLimit) {
                System.out.println("Twój pojazd nie pomieści tyle towaru");
            } else {
                System.out.println("Sprzedałeś " + ile + " " + name + " za " + ile * applePrize + "$");
                auto.currentCarLoad -= ile * boxOfApples.appleWeight;
                auto.currentMoney += ile * boxOfApples.applePrize;
                auto.numberOfApples -= ile;

            }
        }


    }

}


