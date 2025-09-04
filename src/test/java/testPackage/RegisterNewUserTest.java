package testPackage;

import org.testng.annotations.Test;
import pages.AccountCreatedPage;
import pages.RegisterPage;
import utils.UserData;

public class RegisterNewUserTest extends TestBase {

    @Test
    public void registerNewUserFromNormalMethod() {
        RegisterPage registerPage = new RegisterPage(bot).navigateToRegisterPage()
                .signUp(testData.getTestData("name"), testData.getTestData("email"))
                .completeRegistrationForm(testData.getTestData("password"), testData.getTestData("day"), testData.getTestData("month"),
                        testData.getTestData("year"), testData.getTestData("firstName"), testData.getTestData("lastName"),
                        testData.getTestData("company"), testData.getTestData("address1"), testData.getTestData("address2"),
                        testData.getTestData("country"), testData.getTestData("state"), testData.getTestData("city"),
                        testData.getTestData("zipcode"), testData.getTestData("mobileNumber"));
        bot.driver.browser().and().assertThat().url().contains("account_created");
    }

    @Test
    public void registerNewUserFromUserDataClass() {
        // userData optimize code
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
        new RegisterPage(bot).navigateToRegisterPage()
                .signUp(user.getName(), user.getEmail())
                .completeRegisterForm(user);
        bot.driver.browser().and().assertThat().url().contains("account_created");
    }


}
