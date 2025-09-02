package pages;

import engine.Bot;
import org.openqa.selenium.By;

public class AccountCreated {
    Bot bot;
    By accountCreatedMessage = By.xpath("//h2[@data-qa='account-created']");
    By continueButton = By.xpath("//a[@data-qa='continue-button']");

    public AccountCreated(Bot bot){
        this.bot=bot;
    }

    public String isAccountCreatedMessageDisplayed() {
        return bot.driver.browser().and().element().get().text(accountCreatedMessage);
    }
    public void clickContinueButton(){
        bot.driver.browser().and().element().click(continueButton);
    }

}
