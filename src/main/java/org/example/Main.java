package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
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

        //WRITING THE OBJECT TO STRING
        String s = objectMapper.writeValueAsString(car);
        System.out.println(s);

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
    }
}
