package testPackage;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountCreated;
import pages.RegisterPage;

public class RegisterNewUserTest extends TestBase {

    @Test
    public void registerNewUser() {
        RegisterPage registerPage = new RegisterPage(bot).navigateToRegisterPage()
                .signUp(testData.getTestData("name"), testData.getTestData("email"))
                .completeRegistrationForm(testData.getTestData("password"),
                        testData.getTestData("day"),
                        testData.getTestData("month"),
                        testData.getTestData("year"),
                        testData.getTestData("firstName"),
                        testData.getTestData("lastName"),
                        testData.getTestData("company"),
                        testData.getTestData("address1"),
                        testData.getTestData("address2"),
                        testData.getTestData("country"),
                        testData.getTestData("state"),
                        testData.getTestData("city"),
                        testData.getTestData("zipcode"),
                        testData.getTestData("mobileNumber"));
        AccountCreated accountCreated=new AccountCreated(bot);
        String accountCreatedMessage=accountCreated.accountCreatedMessageDisplayed();
        System.out.printf(accountCreatedMessage);
    }
}
