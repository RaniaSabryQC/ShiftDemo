package utils;

import lombok.Getter;
import lombok.Setter;


// A simple POJO class to hold user data  and generate getters and setters using Lombok
@Getter
@Setter
public class UserData {
    private String name;
    private String email;
    private String password;
    private String day;
    private String month;
    private String year;
    private String firstName;
    private String lastName;
    private String company;
    private String address1;
    private String address2;
    private String country;
    private String state;
    private String city;
    private String zipcode;
    private String mobileNumber;
}