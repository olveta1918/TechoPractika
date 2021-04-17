package selenidetests;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

/**
 * Страница логина Одноклассников
 */
public class LoginPage {

    private static final By LOGIN_FIELD = By.xpath(".//input[@id='field_email']");
    private static final By PASSWORD_FIELD = By.xpath(".//input[@id='field_password']");
    private static final By SIGN_IN_BUTTON = By.xpath(".//*[@value='Войти в Одноклассники']");

    /**
     * Конструктор страницы
     */
    LoginPage(){
        check();
        System.out.println("Находимся на странице логина");
    }

    /**
     * Проверяем наличие основных полей и кнопок
     */
    protected void check(){
        $(LOGIN_FIELD).shouldBe(visible);
        $(PASSWORD_FIELD).shouldBe(visible);
        $(SIGN_IN_BUTTON).shouldBe(enabled);
    }

    /**
     * Логинимся на сайт
     * @param username имя
     * @param password пароль
     * @return seleniumTest.UserPage главная страница пользователя
     */
    public UserPage doLogin(String username, String password){
        $(LOGIN_FIELD).setValue(username);
        $(PASSWORD_FIELD).setValue(password);
        $(SIGN_IN_BUTTON).click();
        System.out.println("Залогинились с именем " + username + " и паролем " + password);
        return new UserPage();
    }
}
