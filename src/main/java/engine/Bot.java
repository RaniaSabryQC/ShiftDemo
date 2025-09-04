package engine;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class Bot {

    public SHAFT.GUI.WebDriver driver;



    public Bot(){
        driver = new SHAFT.GUI.WebDriver();
    }

    public boolean isDisplayed(By locator) {

        return driver.browser().and().element().get().isDisplayed(locator);
    }

    public boolean isLogoDisplayCorrectly(By locator) {
        driver.browser().and().element().assertThat(locator).matchesReferenceImage();
         return true;
    }


    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

}
