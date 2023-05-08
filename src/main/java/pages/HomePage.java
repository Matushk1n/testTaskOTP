package pages;

import basePage.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends AbstractBasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePage open() {
        openUrl(env);
        return this;
    }

    public WebElement getSearch() {
        return waitClickableElementByXpath("//span[@class = 'flex-1']");
    }

    public WebElement getSearchExpanded() {
        return waitClickableElementByXpath("//input[@id = 'query-builder-test']");
    }

    public HomePage clickSearch() {
        getSearch().click();
        return new HomePage(driver);
    }

    public HomePage setSearch(String name) {
        getSearchExpanded().sendKeys(name);
        return new HomePage(driver);
    }

    public SearchResultPage searchProject(String name) {
        open();
        clickSearch();
        setSearch(name);
        return new SearchResultPage(driver);
    }

}
