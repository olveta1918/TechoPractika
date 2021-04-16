package selenidetests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FriendsSearchResultsTransformer {
    private static final By FRIEND_CARD = By.xpath(".//*[@class = 'gs_result_i_w ']");
    private static final By FRIENDS_LIST = By.id("hook_Block_MyFriendsFriendSearchPagingB");
    /**
     * Превращает список веб элементов в список FriendsWrapper
     * @param elements список веб элементов
     * @return список FriendsWrapper
     */
    public static List<FriendsSearchResultsTransformer.FriendsResultsWrapper> wrap(ElementsCollection elements) {
        if (elements.isEmpty()) {
            return Collections.emptyList();
        }
        List<FriendsSearchResultsTransformer.FriendsResultsWrapper> friends = new ArrayList<>();
        for (SelenideElement friend : elements) {
            friends.add(new FriendsSearchResultsTransformer.FriendsResultsWrapper(friend));
        }
        return friends;
    }

    /**
     * Собрали ссылки на все карды друзей
     * @return List<FriendsWrapper> список ссылок на карды
     */
    public static List<FriendsSearchResultsTransformer.FriendsResultsWrapper> getFriends() {
        if ($(FRIENDS_LIST).is(visible)) {
            return wrap($(FRIENDS_LIST).$$(FRIEND_CARD));
        }
        return Collections.emptyList();
    }

    public static void checkAllNames (String friendName){
        List<FriendsSearchResultsTransformer.FriendsResultsWrapper> friends = getFriends();
        Assert.assertFalse("На странице нет ни одного друга",friends.isEmpty());
        for (FriendsSearchResultsTransformer.FriendsResultsWrapper friendsResults : friends){
            friendsResults.name().shouldHave(text(friendName));
        }
    }
    private static class FriendsResultsWrapper {
        private final SelenideElement element;
        private final By nameLine = By.className("ellip");

        public FriendsResultsWrapper(SelenideElement element) {
            this.element = element;
        }

        public SelenideElement name(){
            return element.$(nameLine);
        }

    }
}
