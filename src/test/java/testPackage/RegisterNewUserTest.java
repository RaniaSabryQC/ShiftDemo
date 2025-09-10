package testPackage;


import org.testng.annotations.Test;
import pages.RegisterPage;
import utils.TestDataParser;
import utils.UserData;

import java.io.IOException;

@Test
public class RegisterNewUserTest extends TestBase {

    // Using SHAFT JSON test data directly
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

    // Using UserData class & TestDataParser utility class to hold and build user information
    @Test
    public void registerUserFromJsonUtilityClass() throws IOException {
        UserData user = TestDataParser.loadObject(testData, UserData.class);
        new RegisterPage(bot).navigateToRegisterPage().signUp(user.getName(), user.getEmail())
                .completeRegisterForm(user);
        bot.driver.browser().and().assertThat().url().contains("account_created");
    }

    // Using UserData class & Test data factory to hold and build user information from a JSON file path
    @Test
    public void registerNewUserFromJsonFilePath() throws IOException {
        UserData user = TestDataParser.readJsonFromJsonDataPath("src/test/resources/testDataFiles/newUserData.json", UserData.class);
        System.out.println("RAW JSON: " + testData.getTestData(""));
        new RegisterPage(bot).navigateToRegisterPage()
                .signUp(user.getName(), user.getEmail())
                .completeRegisterForm(user);
        bot.driver.browser().and().assertThat().url().contains("account_created");
    }
}
