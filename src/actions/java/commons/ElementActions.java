package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

//thao tác với element
public class ElementActions {
    protected WebDriver driver;
    public ElementActions(WebDriver driver) {
        this.driver = driver;
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void getCurrentPageTitle() {
        driver.getTitle();
    }

    public void getCurrentUrl() {
        driver.getCurrentUrl();
    }

    public void backToPage(){
        driver.navigate().back();
    }

    public void forwardToPage(){
        driver.navigate().forward();
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public void cancelAlert(){
        driver.switchTo().alert().dismiss();
    }

    public void getAlertMessage(){
        driver.switchTo().alert().getText();
    }

    public void sendKeysToAlert(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    public void switchToWindowByTitle(String expectedTitle){
        Set<String> windowList = driver.getWindowHandles();
        for(String windowHandle : windowList){
            driver.switchTo().window(windowHandle);
            if(driver.getTitle().equals(expectedTitle)){
                break;
            }
        }
    }

    public void closeWindowByTitle(String expectedTitle){
        Set<String> windowList = driver.getWindowHandles();
        for(String windowHandle : windowList){
            driver.switchTo().window(windowHandle);
            if(driver.getTitle().equals(expectedTitle)){
                driver.close();
            }
        }
    }

    public void sleepInSeconds(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public By getLocatorBy(String locator){
        By by = null;
        if(locator.startsWith("id=") || locator.startsWith("ID=") || locator.startsWith("Id=") || locator.startsWith("iD=")){
            by = By.id(locator.substring(3));
        }else if (locator.startsWith("xpath=") || locator.startsWith("Xpath=") || locator.startsWith("XPATH=")){
            by = By.xpath(locator.substring(6));
        }else if(locator.startsWith("css=") || locator.startsWith("CSS=") || locator.startsWith("Css=")){
            by = By.cssSelector(locator.substring(4));
        } else if (locator.startsWith("Class=") || locator.startsWith("class=") || locator.startsWith("CLASS=")) {
            by = By.className(locator.substring(6));
        } else if (locator.startsWith("tagName=") || locator.startsWith("TagName=") || locator.startsWith("tagname=")) {
            by = By.tagName(locator.substring(8));
        }else{
            throw new RuntimeException("locator is invalid");
        }
        return by;
    }

    public WebElement findElement(String locator){
        return driver.findElement((getLocatorBy(locator)));
    }

    public void clickToElement(String locator){
       driver.findElement(getLocatorBy(locator)).click();
    }

    public void sendKeysToElement(String locator, String text){
        driver.findElement(getLocatorBy(locator)).sendKeys(text);
    }

    public void getTextFromElement(String locator){
        driver.findElement(getLocatorBy(locator)).getText();
    }

}
