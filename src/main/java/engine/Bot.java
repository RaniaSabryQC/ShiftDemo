package engine;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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


    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

}
