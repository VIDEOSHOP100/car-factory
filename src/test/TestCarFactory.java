package test;

import car.factory.CarFactory;
import car.model.Car;
import car.model.VehicleType;
import junit.framework.TestCase;

public class TestCarFactory extends TestCase {

    public void testVehicle(){
        for(int i=0; i<=100; i++){
            CarFactory carFactory = new CarFactory();
            Car vehicle = carFactory.produceCar(VehicleType.VEHICLE);
//            System.out.println(vehicle.getWidth());
//            System.out.println(vehicle.getLength());
            assertTrue( vehicle.getWidth() >=100 );
            assertTrue( vehicle.getWidth() <=110 );

            assertTrue( vehicle.getLength() >=115 );
            assertTrue( vehicle.getLength() <=130 );
        }
    }

    public void testAutoCar(){
        for(int i=0; i<=100; i++){
            CarFactory carFactory = new CarFactory();
            Car autoCar = carFactory.produceCar(VehicleType.CAR);
//            System.out.println(autoCar.getWidth());
//            System.out.println(autoCar.getLength());
            assertTrue( autoCar.getWidth() >=70 );
            assertTrue( autoCar.getWidth() <=90 );

            assertTrue( autoCar.getLength() >=100 );
            assertTrue( autoCar.getLength() <=110 );
        }
    }
}
