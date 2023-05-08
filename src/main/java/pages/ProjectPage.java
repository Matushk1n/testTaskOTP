package pages;

import basePage.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectPage extends AbstractBasePage {
    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProjectPage open() {
        openUrl(env + "/b0hdan1/HT_2");
        return this;
    }

    public WebElement getPomFileLink() {
        return waitClickableElementByXpath("//a[@title = 'pom.xml']");
    }

    public FilePage selectPomFile() {
        open();
        getPomFileLink().click();
        return new FilePage(driver);
    }

}
