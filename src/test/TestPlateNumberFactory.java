package test;

import car.factory.PlateNumberFactory;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestPlateNumberFactory extends TestCase {

    public void testDistinct(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("2");
        list.add("3");
        list.stream().forEach(System.out::println);
        System.out.println("--------");
        list = list.stream().distinct().collect(Collectors.toList());
        list.stream().forEach(System.out::println);
    }

    public void testPlateNumber(){
        assertTrue( true);
        PlateNumberFactory plateNumberFactory = new PlateNumberFactory();
        List<String> plateNumberList = plateNumberFactory.generatePlateNumber( 400 );
        //檢查是否有重複元素
        assertEquals(plateNumberList.size(),plateNumberList.stream().distinct().collect(Collectors.toList()).size());

        List<String> vehiclePlateNumber =
                plateNumberList.stream()
                        .filter( x -> x.length() == 6 )
                        .collect(Collectors.toList());

        List<String> autoCarPlateNumber =
                plateNumberList.stream()
                        .filter( x -> x.length() == 8 )
                        .collect(Collectors.toList());

        //檢查所有車牌不含66
        plateNumberList.stream()
                .forEach(x -> assertTrue( !x.contains("66")));

        //檢查小車車牌不含4
        autoCarPlateNumber.stream()
                .forEach(x -> assertFalse( x.contains("4") ));

    }
}
