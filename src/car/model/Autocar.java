package car.model;

public class Autocar extends Car {
    public Autocar(VehicleType vehicleType){
        setVehicleType(vehicleType);
        setLength((int)(Math.random()*11 )+100);
        setWidth((int)(Math.random()*21 )+70);
    }
}
