package car.model;

public class Vehicle extends Car {

    public Vehicle(VehicleType vehicleType){
        setVehicleType(vehicleType);
        setLength((int)(Math.random()*11 )+90);
        setWidth((int)(Math.random()*11 )+80);
    }
}
