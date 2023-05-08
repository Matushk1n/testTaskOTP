package pages;

import basePage.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage extends AbstractBasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage open() {
        openUrl(env + "/login");
        return this;
    }

    public WebElement getEmail() {
        return waitClickableElementByXpath("//input[@id='login_field']");
    }

    public WebElement getPassword() {
        return waitClickableElementByXpath("//input[@id='password']");
    }

    public WebElement getSubmitBtn() {
        return waitClickableElementByXpath("//input[@name='commit']");
    }

    public LoginPage setEmail(String email) {
        getEmail().sendKeys(email);
        return new LoginPage(driver);
    }

    public LoginPage setPassword(String password) {
        getPassword().sendKeys(password);
        return new LoginPage(driver);
    }

    public LoginPage setSubmitBtn() {
        getSubmitBtn().click();
        return this;
    }

    public HomePage signInUser(String email, String password) {
        open();
        setEmail(email);
        setPassword(password);
        setSubmitBtn();
        return new HomePage(driver);
    }

}
