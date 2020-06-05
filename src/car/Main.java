package car;

import car.factory.CarFactory;
import car.factory.PlateNumberFactory;
import car.model.Car;
import car.model.VehicleType;

import java.util.List;
import java.util.stream.Collectors;


class CarThread implements Runnable{
    @Override
    public void run() {
        int countProduce = 100;  //大車小車個100輛

        PlateNumberFactory plateNumberFactory = new PlateNumberFactory();
        CarFactory carFactory = new CarFactory();
        List<String> plateNumberList = plateNumberFactory.generatePlateNumber(200);
        List<String> vehiclePlateNumberList = plateNumberList.stream().filter(x -> x.length()==6).collect(Collectors.toList());
        List<String> autoCarPlateNumberList = plateNumberList.stream().filter(x -> x.length()==8).collect(Collectors.toList());
        System.out.println(Thread.currentThread().getName() +"產生的大車車牌數量："+ vehiclePlateNumberList.size());
        System.out.println(Thread.currentThread().getName() +"產生的小車車牌數量："+ autoCarPlateNumberList.size());
        for(int i=0; i<countProduce ; i++){
            Car autoCar = carFactory.produceCar(VehicleType.CAR);
            Car vehicle = carFactory.produceCar(VehicleType.VEHICLE);

            try{
                String vehicleLiscense = vehiclePlateNumberList.get(0);
                vehiclePlateNumberList.remove(0);
                vehicle.setPlateNumber(vehicleLiscense);
                System.out.println(Thread.currentThread().getName() + vehicle);
            }catch (IndexOutOfBoundsException e){
                System.out.println(Thread.currentThread().getName() +"大車車牌用完了");
            }catch (Exception e){
                e.printStackTrace();
            }
            try{
                String autoCarLiscense = autoCarPlateNumberList.get(0);
                autoCarPlateNumberList.remove(0);
                autoCar.setPlateNumber(autoCarLiscense);
                System.out.println(Thread.currentThread().getName() + autoCar);
            }catch (IndexOutOfBoundsException e){
                System.out.println(Thread.currentThread().getName() +"小車車牌用完了");
            }catch (Exception e){
                e.printStackTrace();
            }
        }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println(Thread.currentThread().getName() +"剩餘大車車牌數量:"+vehiclePlateNumberList.size());
        System.out.println(Thread.currentThread().getName() +"剩餘小車車牌數量:"+autoCarPlateNumberList.size());
    }
}

public class Main {
    public static void main(String[] args) {

        CarFactory carFactory = new CarFactory();
        carFactory.produceCar(VehicleType.CAR);

        CarThread carThread = new CarThread();

        Thread thread1 = new Thread(carThread);
        Thread thread2 = new Thread(carThread);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("finished");
    }
}
