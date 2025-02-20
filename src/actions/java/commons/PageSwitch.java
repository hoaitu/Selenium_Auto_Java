package commons;

import org.openqa.selenium.WebDriver;
import pageObject.HomPageObject;
import pageObject.LoginPageObject;

// các hàm để khởi tạo page mới
public class PageSwitch extends WebDriverActions{

    public static LoginPageObject openLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static HomPageObject openHomPage(WebDriver driver) {
        return new HomPageObject(driver);
    }
}
