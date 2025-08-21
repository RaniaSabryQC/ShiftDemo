package pages;

import engine.Bot;
import org.openqa.selenium.By;

public class DynamicHTML {
    Bot bot;
    public String url = "https://duckduckgo.com/";
    public By logoLocator = By.xpath("//div[contains(@class,'container_fullWidth__1H_L8')]//img");

    // Constructor to initialize the Bot instance
    public DynamicHTML(Bot bot) {
        this.bot = bot;
    }

    // Method to navigate to the DuckDuckGo page and assert the logo is displayed correctly
    public boolean navigateToDuckDuckGoAndCheckLogoIsDisplayed() {
       return bot.isDisplayed(logoLocator);
    }

    public boolean isLogoDisplayCorrectly() {
       return bot.isLogoDisplayCorrectly(logoLocator);
    }

    


}
