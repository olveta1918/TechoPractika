import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import static com.codeborne.selenide.Selenide.*;

public class UserPage {

    private String FRIND_IN_LOCATOR = ".//*[@data-l='t,friends']";
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


}
