package selenidetests;

import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

/**
 * Страница друзей
 */
public class FriendsPage {
    private static final By FRIENDS_CATALOG = By.id("hook_Block_UserFriendsCatalogRB");
    private static final String SEARCH_BLOCK_CSS = "friend-search-input";
    private static final By SEARCH_RESULTS_BLOCK = By.xpath(".//*[@class = 'gs_result_list']");
    private static final By SEARCH_CLEAN = By.xpath(".//*[contains(@class, 'button-clean')]");
    private static final By SEARCH_STUB = By.xpath(".//*[@class = 'stub-empty __friends ']");

    /**
     * Конструктор
     */
    FriendsPage() {
        check();
        System.out.println("Находимся на странице друзей");
    }

    /**
     * Проверяем, что отображаются основные блоки страницы
     */
    protected void check(){
        $(FRIENDS_CATALOG).shouldBe(visible);
        $(SEARCH_BLOCK_CSS).shouldBe(enabled);
    }

    /**
     * Проверяем, что на странице друзей есть друг с заданным именем
     * @param name имя
     */
    public void checkFriendIsPresent(String name){
        Assert.assertTrue("Не отображается друг с именем " + name,
                FriendsTransformer.isFriendPresent(name));
        System.out.println("Как и ожидали, в списке всех друзей имеется друг с именем " + name);
    }

    /**
     * Проверяем, что на странице друзей нет пользователя с заданным именем
     * @param name имя
     */
    public void checkFriendIsNotPresent(String name){
        Assert.assertFalse("Отображается друг с именем " + name + ". Хотя ожидали обратное",
                FriendsTransformer.isFriendPresent(name));
        System.out.println("Как и ожидали, в списке всех друзей нет друга с именем " + name);
    }

    /**
     * Выполняем поиск
     * @param name поисковый запрос
     * @return новое состояние seleniumTest.FriendsPage
     */
    public FriendsPage doSearch(String name){
        $(SEARCH_BLOCK_CSS).$("input").setValue(name);
        $(SEARCH_BLOCK_CSS).$(byText("Найти")).click();
        $(SEARCH_CLEAN).shouldBe(visible);
        $(SEARCH_RESULTS_BLOCK).shouldBe(visible);
        System.out.println("Выполнили поиск по имени " + name);
        return new FriendsPage();
    }

    /**
     * Кликаем на крестик в строке поиска
     * @return seleniumTest.FriendsPage новое состояние страницы друзей
     */
    public FriendsPage clickClearSearchButton(){
        $(SEARCH_BLOCK_CSS).$(SEARCH_CLEAN).click();
        $(SEARCH_BLOCK_CSS).$(SEARCH_CLEAN).should(disappear);
        System.out.println("Очистили строку поиска");
        return new FriendsPage();
    }

    /**
     * Проверяем, что все отображаемые поисковые результаты соответствуют запросу
     * @param name поисковый запрос
     */
    public void checkFriendsResults(String name){
        FriendsSearchResultsTransformer.checkAllNames(name);
        System.out.println("Все отображаемые результаты содержат " + name);
    }

    /**
     * Проверяем, что не нашлось ни одного друга
     */
    public void checkAnyFriendNotFound(){
        $(SEARCH_STUB).shouldBe(visible);
        System.out.println("Не найдено ни одного друга");
    }
}
