package selenidetests;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.*;

public class BaseClass {
    String BASE_URL = "https://ok.ru";

    @Before
    public void init() {
        open(BASE_URL);
    }

    public UserPage login (String username, String password){
       return new LoginPage().doLogin(username, password);
    }

    @After
    public void end() {
        closeWebDriver();
    }
}
