package car.model;

public enum VehicleType {
    VEHICLE("vehicle"),
    CAR("car");

    private String value;
    /**
     * Constructor
     *
     * @param value 值
     */
    private VehicleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
