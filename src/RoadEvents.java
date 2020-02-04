import java.util.Random;

public class RoadEvents implements Interface {


    void roadHelpwithTire(Auto auto) {

        System.out.println("Pomagasz nieznajomemu w potrzebie z wymianą koła i otrzymujesz 10 $");
        auto.setCurrentMoney(+10);
        System.out.println("Masz teraz " + auto.getCurrentMoney() + " gotówki");
    }

    void roadLuck() {

        System.out.println("Zobaczyłeś tęczę !");

    }

    void streetDemon(Auto auto) {

        System.out.println("Otrzymujesz mandat za szybką jazdę. Musisz zapłacić 20 $ grzywny");

        auto.setCurrentMoney(-20);
        System.out.println("Pozostało Ci " + auto.getCurrentMoney() + " pieniędzy");


    }

    void eventRandomizer(Auto auto) {

        Random eventRandomizer = new Random();
        int x = eventRandomizer.nextInt(2);

        if (x == 0) {

            class Events {

                void TESTT(Auto auto) {
                    auto.setCurrentMoney(1000);
                    System.out.println(auto.getCurrentMoney());
                    System.out.println("metoda numer 0");
                }

            }
            new Events().TESTT(auto);


        } else if (x == 1) {

            class Events {
                void TESTT1(Auto auto) {
                    auto.setCurrentMoney(2000);
                    System.out.println(auto.getCurrentMoney());
                    System.out.println("metoda numer 1");
                }
            }
            new Events().TESTT1(auto);
        }
    }

    @Override
    public void run() {

    }
}
