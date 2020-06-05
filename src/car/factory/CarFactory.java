package car.factory;


import car.model.Autocar;
import car.model.VehicleType;
import car.model.Car;
import car.model.Vehicle;


public class CarFactory {

    public Car produceCar(VehicleType vehicleType){
        Car car = null;
        switch (vehicleType){
            case CAR:
                car = new Autocar(VehicleType.CAR);
                break;
            case VEHICLE:
                car = new Vehicle(VehicleType.VEHICLE);
                break;
        }
        return car;
    }

}
