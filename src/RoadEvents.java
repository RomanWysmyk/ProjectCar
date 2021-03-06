import java.util.Random;

public class RoadEvents {


    /*eventRandomizer randomize event spawning during road travel
     *
     * First step is to randomize which event will be tested for triggering.
     * Second step is to do another checking if the selected event will be launch
     * If all tests will pass, the event will appear.
     * If one of the test fail. Nothing happened.
     *
     * Remember to set in Road class frequency how often during the travel RoadEvents will trigger the tests.
     *
     * */
    void eventRandomizer(Auto auto) {

        Random eventRandomizer = new Random();
        int x = eventRandomizer.nextInt(2);

        if (x == 0) {

            class Events {

                void roadHelpwithTire(Auto auto) {

                    Random eventTriggerChance = new Random();
                    int spawnChance = eventTriggerChance.nextInt(100_000);
                    if (spawnChance < 5000) {
                        System.out.println("Pomagasz nieznajomemu w potrzebie z wymianą koła i otrzymujesz 10 $");
                        auto.currentMoney += 10;
                        System.out.println("Masz teraz " + auto.currentMoney + " gotówki");
                    }
                }
            }
            new Events().roadHelpwithTire(auto);


        } else if (x == 1) {

            class Events {
                void streetDemon(Auto auto) {
                    if (eventRandomizer.nextInt(100_000) < 3000) {

                        System.out.println("Otrzymujesz mandat za szybką jazdę. Musisz zapłacić 20 $ grzywny");

                        auto.currentMoney -= 20;
                        System.out.println("Pozostało Ci " + auto.currentMoney + " pieniędzy");
                    }
                }
            }
            new Events().streetDemon(auto);
        }
    }

}
