package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseClass{
    WebDriver driver;
    private String LOGIN_LOCATOR = ".//input[@id='field_email']";
    private String PASSWORD_LOCATOR = ".//input[@id='field_password']";
    private String SIGN_IN_LOCATOR = ".//*[@value='Войти в Одноклассники']";


    LoginPage(WebDriver driver) {
        this.driver = driver;
        check();
    }

    protected void check() {
        (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(LOGIN_LOCATOR)));
        (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(PASSWORD_LOCATOR)));
        (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(SIGN_IN_LOCATOR)));
    }

    public UserPage doLogin(String username, String password) throws InterruptedException {
        Thread.sleep(4);
        driver.findElement(By.xpath(LOGIN_LOCATOR)).sendKeys(username);
        driver.findElement(By.xpath(PASSWORD_LOCATOR)).sendKeys(password);
        driver.findElement(By.xpath(SIGN_IN_LOCATOR)).click();
        return new UserPage(driver);
    }


}
