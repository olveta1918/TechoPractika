package seleniumTest;

import org.junit.Test;

public class MessageTest extends BaseClass {
    String username = "TstBot2012YP";
    String password = "testQA1";

    /**
     * Проверим наличие друга с заданным именем
     * @throws InterruptedException
     */
    @Test
    public void testGoogleSearch() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin(username, password);
        UserPage userPage = new UserPage(driver);
        userPage.goToMessage();
    }
}
