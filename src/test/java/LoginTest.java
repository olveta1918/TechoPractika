import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest extends BaseClass{
    String username = "TstBot2012YP";
    String password = "testQA1";

    @Ignore
    @Test
    public void testGoogleSearch() throws InterruptedException {
        LoginPage userPage = new LoginPage(driver);
        userPage.doLogin(username, password);
    }

    //тест
}
