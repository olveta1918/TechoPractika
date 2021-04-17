package seleniumTest;

import org.junit.Test;

public class LoginTest extends BaseClass{
    String username = "TstBot2012YP";
    String password = "testQA1";

    @Test
    public void testGoogleSearch() throws InterruptedException {
        LoginPage userPage = new LoginPage(driver);
        userPage.doLogin(username, password);
    }

    //тест
}
