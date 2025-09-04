package pages;

import engine.Bot;
import org.openqa.selenium.By;
import utils.Constants;
import utils.UserData;

public class RegisterPage {
    Bot bot;

    By signupLink = By.xpath("//a[contains(text(),' Signup / Login')]");
    By nameInputField = By.xpath("//input[@data-qa='signup-name']");
    By emailInputField = By.xpath("//input[@data-qa='signup-email']");
    By signupButton = By.xpath("//button[@data-qa='signup-button']");
    By titleRadioButton = By.xpath("//input[@id='id_gender1']");
    By passwordInputField = By.xpath("//input[@id='password']");
    By daysDropdown = By.xpath("//select[@id='days']");
    By monthsDropdown = By.xpath("//select[@id='months']");
    By yearsDropdown = By.xpath("//select[@id='years']");
    By newsletterCheckbox = By.xpath("//input[@id='newsletter']");
    By offersCheckbox = By.xpath("//input[@id='optin']");
    By firstNameInputField = By.xpath("//input[@id='first_name']");
    By lastNameInputField = By.xpath("//input[@id='last_name']");
    By companyInputField = By.xpath("//input[@id='company']");
    By address1InputField = By.xpath("//input[@id='address1']");
    By address2InputField = By.xpath("//input[@id='address2']");
    By countryDropdown = By.xpath("//select[@id='country']");
    By stateInputField = By.xpath("//input[@id='state']");
    By cityInputField = By.xpath("//input[@id='city']");
    By zipcodeInputField = By.xpath("//input[@id='zipcode']");
    By mobileNumberInputField = By.xpath("//input[@id='mobile_number']");
    By createAccountButton = By.xpath("//button[@data-qa='create-account']");


    public RegisterPage(Bot bot) {
        this.bot = bot;
    }

    public RegisterPage navigateToRegisterPage() {
        bot.driver.browser().navigateToURL(Constants.BASE_URL).and().element().click(signupLink);
        return this;
    }

    public RegisterPage signUp(String name, String email) {
        bot.driver.browser().and().element().type(nameInputField, name)
                .and().element().type(emailInputField,generateUniqueEmail(email))
                .and().element().click(signupButton);
        return this;
    }
    /**
     * CRITICAL: Replace {timestamp} with actual timestamp to ensure unique email addresses.
     */
    public static String generateUniqueEmail(String emailTemplate) {
        if (emailTemplate.contains("{timestamp}")) {
            long timestamp = System.currentTimeMillis();
            return emailTemplate.replace("{timestamp}", String.valueOf(timestamp));
        }
        return emailTemplate;
    }

    public void completeRegistrationForm(String password, String day, String month, String year,
                                                 String firstName, String lastName, String company,
                                                 String address1, String address2, String country,
                                                 String state, String city, String zipcode, String mobileNumber) {
        bot.driver.browser().and().element().click(titleRadioButton)
                .and().element().type(passwordInputField, password)
                .and().element().select(daysDropdown, day)
                .and().element().select(monthsDropdown, month)
                .and().element().select(yearsDropdown, year)
                .and().element().click(newsletterCheckbox)
                .and().element().click(offersCheckbox)
                .and().element().type(firstNameInputField, firstName)
                .and().element().type(lastNameInputField, lastName)
                .and().element().type(companyInputField, company)
                .and().element().type(address1InputField, address1)
                .and().element().type(address2InputField, address2)
                .and().element().select(countryDropdown, country)
                .and().element().type(stateInputField, state)
                .and().element().type(cityInputField, city)
                .and().element().type(zipcodeInputField, zipcode)
                .and().element().type(mobileNumberInputField, mobileNumber)
                .and().element().click(createAccountButton);
    }

    public void completeRegisterForm(UserData userData) {
        bot.driver.browser().and().element().click(titleRadioButton)
                .and().element().type(passwordInputField, userData.getPassword())
                .and().element().select(daysDropdown, userData.getDay())
                .and().element().select(monthsDropdown, userData.getMonth())
                .and().element().select(yearsDropdown, userData.getYear())
                .and().element().click(newsletterCheckbox)
                .and().element().click(offersCheckbox)
                .and().element().type(firstNameInputField, userData.getFirstName())
                .and().element().type(lastNameInputField, userData.getLastName())
                .and().element().type(companyInputField, userData.getCompany())
                .and().element().type(address1InputField, userData.getAddress1())
                .and().element().type(address2InputField, userData.getAddress2())
                .and().element().select(countryDropdown, userData.getCountry())
                .and().element().type(stateInputField, userData.getState())
                .and().element().type(cityInputField, userData.getCity())
                .and().element().type(zipcodeInputField, userData.getZipcode())
                .and().element().type(mobileNumberInputField, userData.getMobileNumber())
                .and().element().click(createAccountButton);
    }
}
