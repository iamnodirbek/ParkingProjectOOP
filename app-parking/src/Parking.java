
public class Parking {
    private String name;
    private Cell[][] building;

    public Parking(String name) {
        this.name = name;
    }

    public void buildPark(int rows, int cols) {
        building = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                building[i][j] = new Cell();
            }
        }
    }

    public void displayPark() {
        System.out.println("-----");
        for (int i = 0; i < building.length; i++) {
            for (int j = 0; j < building[i].length; j++) {
                Cell cell = building[i][j];
                if (cell.isEmpty()) {
                    System.out.print(" " + CarType.EMPTY_SIGN + " ");
                } else {
                    System.out.print(" " + cell.getCar().getCarType() + " ");
                }
            }
            System.out.println();
        }
        System.out.println("-----");
    }


    public boolean park(Car car, int row, int col) {
        Cell cell = building[row][col];
        if (!cell.isEmpty()) {
            System.out.println("WARNING !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.print("This Cell is not empty");
            System.out.println("Please select other cell");
            return false;
        }

        cell.setCar(car);
        cell.setEmpty(false);
        return true;
    }

    public boolean parkOut(String carNumber , int row , int col){
        Cell cell = building[row][col];
        if (cell.isEmpty()){
            System.out.println("WARNING !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("This Cell is empty");
            System.out.println("Please select other cell");
            return false;
        }
        Car car = cell.getCar();
        if (!(carNumber.equals(car.getSerial()))) {
            System.out.println("GO OUUUTTTT");
            return false;
        }
        cell.setCar(null);
        cell.setEmpty(true);
        return true;
    }


    public int countAvailableCells() {
        int countP = 0;

        for (int i = 0; i < building.length; i++) {
            for (int j = 0; j < building[i].length; j++) {
                Cell cell = building[i][j];
                if (cell.isEmpty()) {
                    countP++;
                }
            }
        }
        return countP;
    }


    public int countNotAvailableCells() {
        int countP = 0;

        for (int i = 0; i < building.length; i++) {
            for (int j = 0; j < building[i].length; j++) {
                Cell cell = building[i][j];
                if (!cell.isEmpty()) {
                    countP++;
                }
            }
        }
        return countP;
    }


    public String getName() {
        return name;
    }
}
