package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePage extends BaseClass{

    WebDriver driver;
    MessagePage(WebDriver driver) {
        this.driver = driver;
        check();
    }
    private void check() {
        //(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(FRIENDS_BLOCK_LOCATOR)));

    }

}
