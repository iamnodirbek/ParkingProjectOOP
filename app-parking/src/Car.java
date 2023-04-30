
public class Car {
    private String serial;
    private String carType; //

    public Car() {
    }

    public Car(String serial, String carType) {
        this.serial = serial;
        this.carType = carType;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}
