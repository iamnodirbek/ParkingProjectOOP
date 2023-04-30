import java.util.Scanner;

public class Service {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        Parking parking = new Parking("Easy Parking Campany");
        parking.buildPark(4,6);

        System.out.println("--------- Welcome to " + parking.getName()+"----------");

        while (true){
            displayMenu();
            String menuOption = getConsoleOption("Select you option => ");
            switch (menuOption){
                case "1": parking.displayPark(); break;
                case "2": countAvailableCells(parking); break; // available count
                case "3": countNotAvailableCells(parking); break; // not available count
                case "4": parkIn(parking); break;
                case "5": parkOut(parking); break; // Out
                case "q": System.exit(0);
            }
        }


    }

    private static void parkIn(Parking parking) {

        parking.displayPark();

        String row = getConsoleOption("Select Row => ");
        String col = getConsoleOption("Select Col => ");

        String carType = getYourCarType();
        String carSerial = getConsoleOption("Enter your Car Number");
        Car car = new Car(carSerial, carType);

        boolean isParked = parking.park(car,Integer.parseInt(row),Integer.parseInt(col));
        parking.displayPark();
        if (isParked)
            System.out.println("Parking Successfully Compleated");
    }



    private static void parkOut(Parking parking) {

        parking.displayPark();

        String row = getConsoleOption("Select Row => ");
        String col = getConsoleOption("Select Col => ");

        String carSerial = getConsoleOption("Enter your Car Number");

        boolean isParked = parking.parkOut(carSerial,Integer.parseInt(row),Integer.parseInt(col));
        parking.displayPark();
        if(isParked)
            System.out.println("Park Out Successfully Compleated");
    }



    private static void countAvailableCells(Parking parking){
        parking.displayPark();

        System.out.println("Bo'sh joylar soni:");
        System.out.println(parking.countAvailableCells());
    }


    private static void countNotAvailableCells(Parking parking){
        parking.displayPark();

        System.out.println("Bo'sh bo'magan joylar soni:");
        System.out.println(parking.countNotAvailableCells());
    }


    private static String getConsoleOption(String hint) {
        System.out.print(hint);
        return scanner.nextLine();
    }

    private static void displayMenu() {
        System.out.println("Display Park              -> 1");
        System.out.println("Available cells count     -> 2");
        System.out.println("Not Available cells count -> 3");
        System.out.println("Start parking             -> 4");
        System.out.println("Out                       -> 5");
        System.out.println("Quit                      -> q");
    }

    private static String getYourCarType() {
        System.out.println(CarType.MINIBUS + " -> 1");
        System.out.println(CarType.POLICE_CAR + " -> 2");
        System.out.println(CarType.BUS + " -> 3");
        System.out.println(CarType.AUTOMOBILE + " -> 4");
        String carOption = getConsoleOption("Select Your Car Type => ");
        return switch (carOption){
            case "1" -> CarType.MINIBUS;
            case "2" -> CarType.POLICE_CAR;
            case "3" -> CarType.BUS;
            case "4" -> CarType.AUTOMOBILE;
            default -> CarType.AUTOMOBILE;
        };
    }
}

