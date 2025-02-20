package pageObject;

import commons.WebDriverActions;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends WebDriverActions {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
