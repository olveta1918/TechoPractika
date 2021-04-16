package selenidetests;

import com.codeborne.selenide.Condition;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class FriendsPage {
    private static final By FRIENDS_CATALOG = By.id("hook_Block_UserFriendsCatalogRB");
    private static final String SEARCH_BLOCK_CSS = "friend-search-input";
    private static final By SEARCH_RESULTS_BLOCK = By.xpath(".//*[@class = 'gs_result_list']");
    private static final By SEARCH_FIELD = By.xpath(".//input");
    private static final By SEARCH_CLEAN = By.xpath(".//*[contains(@class, 'button-clean')]");
    private static final By SEARCH_BUTTON = By.xpath(".//*[@value='Найти']");
    private static final By SEARCH_STUB = By.xpath(".//*[@class = 'stub-empty __friends ']");
    private static final By FRIENDS_LIST = By.id("hook_Block_MyFriendsFriendSearchPagingB");

    FriendsPage() {
        check();
        System.out.println("Находимся на странице друзей");
    }

    protected void check(){
        $(FRIENDS_CATALOG).shouldBe(visible);
        $(SEARCH_BLOCK_CSS).shouldBe(enabled);
    }

     public void checkFriendFound(String name){
        FriendsSearchResultsTransformer.checkAllNames(name);
        System.out.println("Все отображаемые результаты содержат " + name);
    }

    public void checkAnyFriendNotFound(){
        $(SEARCH_STUB).shouldBe(visible);
        System.out.println("Не найдено ни одного друга");
    }

    public FriendsPage doSearch(String name){
        $(SEARCH_BLOCK_CSS).$("input").setValue(name);
        $(SEARCH_BLOCK_CSS).$(byText("Найти")).click();
        $(SEARCH_CLEAN).shouldBe(visible);
        $(SEARCH_RESULTS_BLOCK).shouldBe(visible);
        System.out.println("Выполнили поиск по имени " + name);
        return new FriendsPage();
    }

    public void checkFriendIsPresent(String name){
        Assert.assertTrue("Не отображается друг с именем " + name, FriendsTransformer.isFriendPresent(name));
        System.out.println("Как и ожидали, в списке всех друзей имеется друг с именем " + name);
    }

    public void checkFriendIsNotPresent(String name){
        Assert.assertFalse("Отображается друг с именем " + name + ". Хотя ожидали обратное",
                FriendsTransformer.isFriendPresent(name));
        System.out.println("Как и ожидали, в списке всех друзей нет друга с именем " + name);
    }

    public FriendsPage clickClearSearchButton(){
        $(SEARCH_BLOCK_CSS).$(SEARCH_CLEAN).click();
        $(SEARCH_BLOCK_CSS).$(SEARCH_CLEAN).should(disappear);
        System.out.println("Очистили строку поиска");
        return new FriendsPage();
    }
}
