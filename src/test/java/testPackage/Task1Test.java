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
    public void navigateToDuckduckgoAndCheckLogo() {
        // Navigate to the DuckDuckGo page and assert the logo is displayed correctly
        bot.driver.browser().navigateToURL(new DynamicHTML(bot).url).
                and().element().assertThat(new DynamicHTML(bot).logoLocator).matchesReferenceImage();
    }
}
