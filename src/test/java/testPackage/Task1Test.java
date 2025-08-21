package testPackage;

import org.testng.annotations.Test;
import pages.DynamicHTML;

public class Task1Test extends TestBase{

    @Test
    public void navigateToDuckduckgoAndCheckPageTitle() {
        // Navigate to the DuckDuckGo page and assert the title
        bot.driver.browser().navigateToURL(new DynamicHTML(bot).url)
                .and().assertThat().title().contains(testData.getTestData("expectedTitle"));
    }

    @Test
    public void navigateToDuckduckgoAndCheckLogoIsDisplay() {
        // Navigate to the DuckDuckGo page and assert the logo is displayed correctly
        DynamicHTML dynamicHTML=new DynamicHTML(bot);
        bot.driver.browser().navigateToURL(dynamicHTML.url)
                .and().assertThat().equals(dynamicHTML.navigateToDuckDuckGoAndCheckLogoIsDisplayed());
    }

    @Test
    public void navigateToDuckduckgoAndCheckLogoIsDisplayCorrectly(){
        DynamicHTML dynamicHTML=new DynamicHTML(bot);
        bot.driver.browser().navigateToURL(dynamicHTML.url).and().assertThat().equals(dynamicHTML.isLogoDisplayCorrectly());
    }
}
