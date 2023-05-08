package pages;

import basePage.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends AbstractBasePage {
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SearchResultPage open() {
        openUrl(env + "/search?q=b0hdan1%2FHT_2&type=repositories");
        return this;
    }

    public WebElement getProject() {
        return waitClickableElementByXpath("//div[@class ='Box-sc-g0xbh4-0 bBwPjs search-title']");
    }

    public ProjectPage selectProject() {
        open();
        getProject().click();
        return new ProjectPage(driver);
    }

}
