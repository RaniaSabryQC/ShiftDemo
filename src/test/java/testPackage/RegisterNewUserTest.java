package testPackage;


import org.testng.annotations.Test;
import pages.RegisterPage;
import data.TestDataFactory;
import utils.UserData;

public class RegisterNewUserTest extends TestBase {

    @Test
    public void registerNewUserFromNormalMethod() {
        new RegisterPage(bot).navigateToRegisterPage()
                .signUp(testData.getTestData("name"), testData.getTestData("email"))
                .completeRegistrationForm(testData.getTestData("password"), testData.getTestData("day"), testData.getTestData("month"),
                        testData.getTestData("year"), testData.getTestData("firstName"), testData.getTestData("lastName"),
                        testData.getTestData("company"), testData.getTestData("address1"), testData.getTestData("address2"),
                        testData.getTestData("country"), testData.getTestData("state"), testData.getTestData("city"),
                        testData.getTestData("zipcode"), testData.getTestData("mobileNumber"));
        bot.driver.browser().and().assertThat().url().contains("account_created");
    }

    // Using UserData class & Test data factory to hold and build user information

    @Test
    public void registerNewUserFromUserDataClass() {
        UserData user = TestDataFactory.createValidUser(testData);
        new RegisterPage(bot).navigateToRegisterPage()
                .signUp(user.getName(), user.getEmail())
                .completeRegisterForm(user);
        bot.driver.browser().and().assertThat().url().contains("account_created");
    }


}
