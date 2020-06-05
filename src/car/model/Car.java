package car.model;


public class Car {

    private VehicleType vehicleType;
    private String plateNumber;
    private int length;
    private int width;

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Car{" +
                "vehicleType=" + vehicleType +
                ", plateNumber='" + plateNumber + '\'' +
                ", length=" + length +
                ", width=" + width +
                '}';
    }


}
