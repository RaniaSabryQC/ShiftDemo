package pages;

import engine.Bot;
import org.openqa.selenium.By;

public class AccountCreated {
    Bot bot;
    By accountCreatedMessage = By.xpath("//b[contains(text(),'Account Created!')]");
    By continueButton = By.xpath("//a[@data-qa='continue-button']");


    public AccountCreated(Bot bot) {
        this.bot = bot;
    }

    public String accountCreatedMessageDisplayed() {
        return bot.driver.browser().and().element().get().text(accountCreatedMessage);
    }
    public HomePage clickContinueButton() {
        bot.driver.browser().and().element().click(continueButton);
        return new HomePage(bot);
    }
}
