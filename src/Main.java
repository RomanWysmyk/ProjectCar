public class Main {
    public static void main(String[] args) throws InterruptedException {


        Auto auto = new Auto();
        Droga droga = new Droga();
        RoadEvents events = new RoadEvents();

        Menu menu = new Menu();
        menu.menuChoose(auto);
        //auto.showMyStatus();
        //auto.turnEngineOnOff();
        //auto.refuelCar(50);
        //auto.drive(droga);
    }
}
