package data;

import com.shaft.driver.SHAFT;
import utils.UserData;

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
}


