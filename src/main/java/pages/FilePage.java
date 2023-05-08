package pages;

import basePage.AbstractBasePage;
import org.openqa.selenium.WebDriver;


public class FilePage extends AbstractBasePage {

    public FilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public FilePage open() {
        openUrl(env + "/b0hdan1/HT_2/blob/main/pom.xml");
        return this;
    }

}
