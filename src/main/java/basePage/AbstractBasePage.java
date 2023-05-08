package basePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract public class AbstractBasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public final String env = "https://github.com";


    public AbstractBasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    protected WebElement waitClickableElementByXpath(String locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }


    protected WebElement findElement(String locator) {
        return driver.findElement(By.xpath(locator));
    }

    public abstract <T> T open();
}
