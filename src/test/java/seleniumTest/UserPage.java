package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserPage {

    private String FRIND_IN_LOCATOR = ".//*[@data-l='t,friends']";
    private String Message_Locator = ".//*[@data-l='t,messages']";
    WebDriver driver;

    UserPage(WebDriver driver) {
        this.driver = driver;
        check();
    }

    protected void check() {
        (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(FRIND_IN_LOCATOR)));
    }

    public FriendsPage gotoFriends() throws InterruptedException {
        Thread.sleep(30);
        driver.findElement(By.xpath(FRIND_IN_LOCATOR)).click();
        return new FriendsPage(driver);
    }

    public MessagePage goToMessage() throws InterruptedException {
        Thread.sleep(30);
        driver.findElement(By.xpath(Message_Locator)).click();
        return new MessagePage(driver);
    }


}
