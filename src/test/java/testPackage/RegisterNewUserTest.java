package testPackage;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountCreated;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterNewUserTest extends TestBase {

    @Test
    public void registerNewUser() {
        HomePage homePage=new HomePage(bot);
        homePage.navigateAndclickToRegisterPage()
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
       // bot.driver.browser().assertThat().equals(String .valueOf(new AccountCreated(bot).isAccountCreatedMessageDisplayed()));
        Assert.assertEquals(accountCreated.isAccountCreatedMessageDisplayed(), "ACCOUNT CREATED!", "Account creation message is not as expected");
        accountCreated.clickContinueButton();

    }

    @Test
    public void checkEmailRequiredValidationMessage() {
        HomePage homePage=new HomePage(bot);
        RegisterPage registerPage=homePage.navigateAndclickToRegisterPage();
        String validationMessage = registerPage.validateEmailRequiredMessage();
        Assert.assertEquals(validationMessage, "Please fill out this field.", "Validation message is not as expected");
    }

}
