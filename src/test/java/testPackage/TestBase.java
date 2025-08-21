package testPackage;

import com.shaft.driver.SHAFT;
import engine.Bot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    Bot bot;
    SHAFT.TestData.JSON testData;

    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("simpleJSON.json");
    }

    @BeforeMethod
    public void setUp() {
        bot = new Bot();
    }

    @AfterMethod
    public void tearDown() {
        bot.quit();
        bot = null;
    }
}
