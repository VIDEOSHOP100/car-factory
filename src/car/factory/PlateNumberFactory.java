package car.factory;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

public class PlateNumberFactory {

    public List<String> generatePlateNumber(int countOfPlateNumber){
        List<String> plateNumberList = new ArrayList<>();
        Map<String, Boolean> strIntMap = new HashMap<String, Boolean>();

        for( int i=0 ; i<countOfPlateNumber ; i++){
            String liscense = (int)(Math.random()*2)+1 == 1 ? createAutoCarLiscense() : createVehicleLiscense();

            int count = 0;
            while(strIntMap.containsKey(liscense)==true&&count==0) {
                String[] res = liscense.split("-");
                liscense = res[1] + "-" + res[0];
                count++;
            }
            strIntMap.put(liscense,true);
        }
        strIntMap.forEach((k,v)-> {
            if(!k.contains("66")){
                plateNumberList.add(k);
            }
        });
        return plateNumberList;
    }

    public String createVehicleLiscense() {

        Map<String, Boolean> IntMap = new HashMap<String, Boolean>();

        String preffix = "";
        String res = "";

        for (int i = 0; i < 2; i++) {
            preffix = preffix + String.valueOf((char) ('A' + (int) (Math.random() * ('Z' - 'A' + 1))));
        }
        res = preffix + "-";

        String temp = "";
        Random random = new Random();

        temp = String.format("%03d", random.nextInt(1000));
        while(IntMap.containsKey(temp)==true){
            temp = String.format("%03d", random.nextInt(1000));
        }

        IntMap.put(temp, true);

        res = res + temp;

        return res;
    }

    public String createAutoCarLiscense() {
        Map<String, Boolean> strIntMap = new HashMap<String, Boolean>();
        String res = "";
        int i = 0;
        for (; i < 3; i++) {
            res = res + String.valueOf((char) ('A' + (int) (Math.random() * ('Z' - 'A' + 1))));
        }
        res += "-";
        String temp = "";
        Random random = new Random();

        temp = String.format("%04d", random.nextInt(10000));
        while(strIntMap.containsKey(temp)==true||temp.contains("4")){
            temp = String.format("%04d", random.nextInt(10000));
        }

        strIntMap.put(temp, true);

        res = res + temp;
        return res;
    }
}
