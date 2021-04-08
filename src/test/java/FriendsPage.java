import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.List;

/**
 * Страница друзей
 */
public class FriendsPage {
    private String FRIENDS_BLOCK_LOCATOR = ".//*[@id='hook_Block_MyFriendsSquareCardsPagingB']";
    private String FRIEND_CARD = ".//*[@class = 'ugrid_i']";
    private String SEARCH_LOCATOR = ".//*[contains(@class, 'friend-search-input')]//*[contains(@class, 'input-field')]";

    WebDriver driver;
    FriendsPage(WebDriver driver) {
        this.driver = driver;
        check();
    }


    private void check() {
        (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(FRIENDS_BLOCK_LOCATOR)));
    }

    /**
     * Ищем карду друга с заданным именем
     * @param name имя друга
     * @return карда элемента
     */

    private WebElement getFriendByName (String name){
        List<WebElement> friendsList = getAllVisibleFriends();
        for (int index = 0; index < friendsList.size(); index++) {
            if (friendsList.get(index).getText().contains(name))
                return friendsList.get(index);
        }
        return (WebElement) Collections.emptyList();
    }
    public FriendsPage search (String text){
        driver.findElement(By.xpath(SEARCH_LOCATOR)).sendKeys(text);
        return new FriendsPage(driver);
    }

    /**
     * Проверяем наличие друга с заданной частью имени
     * @param name имя друга
     */
    public void isFriendPresent (String name) {
        Assert.assertNotNull("Мы не видим друга с именем "
                + name,getFriendByName(name));
        System.out.println("На странице есть друг с именем " + name);
    }

    /**
     * Все отображенные на странице друзья
     * @return список видимых в данный момент друзей
     */
    private List<WebElement> getAllVisibleFriends () {
        (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(FRIEND_CARD)));
       return driver.findElements(By.xpath(FRIEND_CARD));
    }
}
