import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserPage {

    private String FRIND_IN_LOCATOR = "hook_Block_HeaderTopFriendsInToolbar";
    WebDriver driver;

    UserPage(WebDriver driver) {
        this.driver = driver;
        check();
    }

    protected void check() {
        (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.id(FRIND_IN_LOCATOR)));
    }

    public FriendsPage gotoFriends() throws InterruptedException {
        Thread.sleep(30);
        driver.findElement(By.id(FRIND_IN_LOCATOR)).click();
        return new FriendsPage(driver);
    }


}
