package pages;

import engine.Bot;
import org.openqa.selenium.By;

public class DynamicHTML {
    Bot bot;
    public String url = "https://duckduckgo.com/";
    public By logoLocator = By.xpath("//div[contains(@class,'Desktop')]//img");

    // Constructor to initialize the Bot instance
    public DynamicHTML(Bot bot) {
        this.bot = bot;
    }


}
