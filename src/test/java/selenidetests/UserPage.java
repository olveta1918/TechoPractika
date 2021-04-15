package selenidetests;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

/**
 * Главная страница пользователя
 */
public class UserPage {
    private static By FRIENDS_NAV = By.xpath(".//*[@data-l='t,friends']");
    private static By AVATAR = By.id("hook_Block_Avatar");
    private static By FEED = By.xpath(".//*[@class='main-feed portlet']");

    /**
     * Конструктор главной страницы пользователя
     */
    UserPage(){
        check();
        System.out.println("Находимся на главной странице пользователя");
    }

    /**
     * Проверяем основные блоки главной страницы пользователя
     */
    protected void check(){
        $(AVATAR).shouldBe(Condition.visible);
        $(FEED).shouldBe(Condition.visible);
    }

    /**
     * Переходим в раздел друзей с главной страницы
     * @return FriendsPage страница друзей
     */
    public FriendsPage gotoFriends(){
        $(FRIENDS_NAV).click();
        System.out.println("Кликнули на кнопку 'друзья' в верхней панели навигации");
        return new FriendsPage();
    }
}
