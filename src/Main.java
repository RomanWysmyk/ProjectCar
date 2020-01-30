public class Main {
    public static void main(String[] args) throws InterruptedException {


        Auto auto = new Auto();
        Droga droga = new Droga();

        //auto.refuelCar(50);
        auto.turnEngineOnOff();
        auto.drive(droga);

    }
}
