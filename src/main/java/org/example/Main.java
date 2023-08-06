package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        String jsonString = "{ \"color\" : \"Black\", \"brand\" : \"Fiat\", \"year\" : \"1970\" }";
        ObjectMapper objectMapper = new ObjectMapper();

        //CONVERTING STRING JSON TO OBJECT
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);//IGNORING YEAR WHICH IS NOT PRESENT IN CAR
        Car car = objectMapper.readValue(jsonString, Car.class);
        System.out.println(car.getBrand());

        //WRITING THE OBJECT TO STRING OR JSON
        String s = objectMapper.writeValueAsString(car);

        System.out.println(s);


        HashMap<String, Object> map1 = new HashMap<>();
        //You can convert any Object.
        String[] value1 = new String[]{"value11", "value12", "value13"};
        String[] value2 = new String[]{"value21", "value22", "value23"};
        map1.put("key1", value1);
        map1.put("key2", value2);
        map1.put("key3", "string1");
        map1.put("key4", "string2");

        String json = new ObjectMapper().writeValueAsString(map1);
        System.out.println(json);

        //We can parse a STRING  JSON into a Java Map:
        Map<String, Object> map = objectMapper.readValue(jsonString, new TypeReference<Map<String, Object>>() {
        });
        for (Map.Entry<String, Object> e : map.entrySet()) {
            String key = e.getKey();
            String value = (String) e.getValue();
            System.out.println(key + ":" + value);
        }

        //USE FOR LIST
        String jsonCarArray = "[{ \"color\" : \"Black\", \"brand\" : \"BMW\" }, { \"color\" : \"Red\", \"brand\" : \"FIAT\" }]";

        List<Car> carList = objectMapper.readValue(jsonCarArray, new TypeReference<List<Car>>() {
        });
        for (Car c : carList) {
            System.out.println(c.getColor());
        }

        // USE FOR ARRAY
        Car[] c = objectMapper.readValue(jsonCarArray, new TypeReference<Car[]>() {
        });
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i].getBrand());
        }

        //CONVERT VALUE USE CASE TO CONVERT ONE OBJECT TO OTHER WITH SAME TYPE
        Car2 car2 = objectMapper.convertValue(car, Car2.class);
        System.out.println(car2.getBrand());

        //output
//        Fiat
//        {"color":"Black","brand":"Fiat"}
//        color:Black
//        brand:Fiat
//        year:1970
//        Black
//         Red
//        BMW
//         FIAT
//        Fiat

        //Dependency to be used
        /*
            <dependencies>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.7.5</version>
        </dependency>
    </dependencies>
         */
    }
}
