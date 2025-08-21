package pages;

import engine.Bot;
import utils.Constants;
import org.openqa.selenium.By;

public class HomePage {
    Bot bot;
    By signupLink=By.xpath("//a[contains(text(),' Signup / Login')]");

    public HomePage(Bot bot){
        this.bot=new Bot();
    }

    public RegisterPage navigateToRegisterPage(){
        bot.driver.browser().navigateToURL(Constants.BASE_URL).and().element().click(signupLink);
        return new RegisterPage(bot);
       /// bot.driver.browser().and().element().click(signupLink);
    }


}
