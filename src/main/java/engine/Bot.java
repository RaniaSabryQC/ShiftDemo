package engine;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class Bot {

    public SHAFT.GUI.WebDriver driver;
    FluentWait<SHAFT.GUI.WebDriver> wait;


    public Bot(){
        driver = new SHAFT.GUI.WebDriver();
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);
    }

    public boolean isDisplayed(By locator) {
        return wait.until(d ->
                driver.browser().and().element().get().isDisplayed(locator));
    }

    public boolean isLogoDisplayCorrectly(By locator) {
         wait.until(d ->
                driver.browser().and().element().assertThat(locator).matchesReferenceImage());
         return true;
        //driver.browser().and().element().assertThat(locator).matchesReferenceImage();
    }


    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

}
