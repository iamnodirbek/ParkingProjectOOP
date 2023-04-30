public class Cell {

    private Car car;
    private boolean isEmpty = true;

    public Cell() {
    }


    public Cell(Car car, boolean isEmpty) {
        this.car = car;
        this.isEmpty = isEmpty;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}

