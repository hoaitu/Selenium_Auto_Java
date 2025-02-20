package pageObject;

import commons.WebDriverActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomPageObject extends WebDriverActions {
    private WebDriver driver;

    public HomPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
