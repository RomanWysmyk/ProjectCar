public class RoadEvents {


    void roadHelpwithTire(Auto auto) {

        System.out.println("Pomagasz nieznajomemu w potrzebie z wymianą koła i otrzymujesz 10 $");
        auto.setCurrentMoney(+10);
        System.out.println("Masz teraz " + auto.getCurrentMoney() + " gotówki");
    }

    void roadLuckt(Droga droga) {

        System.out.println("Zobaczyłeś tęczę !");

    }

    /*void eventRandomizer(Auto auto){
        this.auto = auto;
        Random randomEvent = new Random();


        if (randomEvent.nextInt(3)==0){
            void streetDemon(auto){

                System.out.println("Otrzymujesz mandat za szybką jazdę. Musisz zapłacić 20 $ grzywny");

                auto.setCurrentMoney(-20);
                System.out.println("Pozostało Ci "+auto.getCurrentMoney()+" pieniędzy");



            }
            System.out.println("lol");
        }

    }*/
}
