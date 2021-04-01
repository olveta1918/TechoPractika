import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest extends BaseClass{
    String username = "Test";
    String password = "12qw!@QW";

    @Test
    public void testGoogleSearch() throws InterruptedException {
        LoginPage userPage = new LoginPage(driver);
        userPage.doLogin(username, password);
    }

    //тест
}
