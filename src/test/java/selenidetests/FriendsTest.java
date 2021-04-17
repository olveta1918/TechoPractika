package selenidetests;

import org.junit.Test;

/**
 * Тест проверяет, что найдем друга по имени друга
 * и не найдем никого по вымышленному имени
 */
public class FriendsTest extends BaseClass {
    String username = "TstBot2012YP";
    String password = "testQA1";
    String friendName = "Анастасия";
    String notFriendName = "Кот";

    @Test
    public void checkSearch(){
       FriendsPage friendsPage = login(username, password).gotoFriends();
       System.out.println("Проверим тестовые данные:");
       friendsPage.checkFriendIsPresent(friendName);
       friendsPage.checkFriendIsNotPresent(notFriendName);

       System.out.println("Ищем имеющегося друга по имени " + friendName);
       friendsPage.doSearch(friendName).checkFriendsResults(friendName);

       friendsPage = friendsPage.clickClearSearchButton();

       System.out.println("Ищем друга, которого нет в списке друзей");
       friendsPage.doSearch(notFriendName).checkAnyFriendNotFound();

       System.out.println("Как и ожидали, нашли друга с именем " + friendName +
               ". И не нашли по вымышленному имени + " + notFriendName);
    }
}
