package selenidetests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FriendsTransformer {
    private static By FRIEND_CARD = By.xpath(".//*[@class = 'ugrid_i']");

    /**
     * Превращает список веб элементов в список FriendsWrapper
     * @param elements
     * @return список FriendsWrapper
     */
    public static List<FriendsWrapper> wrap(ElementsCollection elements) {
        if (elements.isEmpty()) {
            return Collections.<FriendsWrapper>emptyList();
        }
        List<FriendsWrapper> friends = new ArrayList<FriendsWrapper>();
        for (SelenideElement friend : elements) {
            friends.add(new FriendsWrapper(friend));
        }
        return friends;
    }

    /**
     * Собрали ссылки на все карды друзей
     * @return List<FriendsWrapper> список ссылок на карды
     */
    public static List<FriendsWrapper> getFriends() {
        if ($(FRIEND_CARD).is(visible)) {
            return wrap($$(FRIEND_CARD));
        }
        return Collections.<FriendsWrapper>emptyList();
    }

    /**
     * Проверяем, виден ли друг с заданным именем
     * @param name
     * @return true - если виден
     */
    public static boolean isFriendPresent(String name) {
        List<FriendsWrapper> friends = getFriends();
        for (FriendsWrapper friendsWrapper : friends){
            if (friendsWrapper.getName().contains(name))
            {return true;}
        }
        return false;
    }

    private static class FriendsWrapper {
        private SelenideElement element;

        public FriendsWrapper(SelenideElement element) {
            this.element = element;
        }

        public String getName(){
            return element.getText();
        }
    }
}
