package data;

import com.fasterxml.jackson.databind.JavaType;
import com.shaft.driver.SHAFT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.formula.functions.T;
import utils.UserData;

import java.io.File;
import java.io.IOException;
import java.util.List;

public  class TestDataFactory {
    // Method to create a valid user from JSON test data
    public static  UserData createValidUser(SHAFT.TestData.JSON testData) {
        UserData user = new UserData();
        user.setName(testData.getTestData("name"));
        user.setEmail(testData.getTestData("email"));
        user.setPassword(testData.getTestData("password"));
        user.setDay(testData.getTestData("day"));
        user.setMonth(testData.getTestData("month"));
        user.setYear(testData.getTestData("year"));
        user.setFirstName(testData.getTestData("firstName"));
        user.setLastName(testData.getTestData("lastName"));
        user.setCompany(testData.getTestData("company"));
        user.setAddress1(testData.getTestData("address1"));
        user.setAddress2(testData.getTestData("address2"));
        user.setCountry(testData.getTestData("country"));
        user.setState(testData.getTestData("state"));
        user.setCity(testData.getTestData("city"));
        user.setZipcode(testData.getTestData("zipcode"));
        user.setMobileNumber(testData.getTestData("mobileNumber"));
        return user;
    }
    public static <T> T readJsonFromJsonData(String filename,Class<T> tClass) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
       // String jsonContent = testData.getTestData("");
        return objectMapper.readValue(new File(filename), tClass);
    }

    public static <T> T readJsonFromFile(SHAFT.TestData.JSON testData, Class<T> tClass) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonContent = testData.getTestData("userData");
        JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, UserData.class);
       return  objectMapper.readValue(jsonContent, type);

//    ObjectMapper objectMapper = new ObjectMapper();
//    JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, tClass);
//    return objectMapper.readValue(testData.getTestData("userData"), type);
}







}


