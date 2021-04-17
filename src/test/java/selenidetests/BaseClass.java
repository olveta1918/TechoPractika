package selenidetests;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.*;

/**
 * Базовый тестовый класс
 */
public class BaseClass {
    String BASE_URL = "https://ok.ru";

    @Before
    public void init() {
        open(BASE_URL);
    }

    /**
     * Логинимся на сайт
     * @param username логин
     * @param password пароль
     * @return UserPage главная страница пользователя
     */
    public UserPage login (String username, String password){
       return new LoginPage().doLogin(username, password);
    }

    @After
    public void end() {
        closeWebDriver();
    }
}
