package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

//các thao tác khi test
public class WebDriverActions {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver getWebDriver(String browserName, String url) {
        BrowserList browsers = BrowserList.valueOf(browserName.toUpperCase());
        switch (browsers) {
            case CHROME:
                driver = new ChromeDriver();
                break;

            case EDGE:
                driver = new EdgeDriver();
                break;
              default:
                  break;
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    protected void quitDriver() {
        driver.quit();
    }
}
