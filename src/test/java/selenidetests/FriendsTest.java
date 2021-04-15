package selenidetests;

import org.junit.Test;

public class FriendsTest extends BaseClass {
    String username = "TstBot2012YP";
    String password = "testQA1";
    String name = "Анастасия";
    @Test
    public void checkSearch(){
       UserPage userPage = login(username, password);
       userPage.gotoFriends().checkFriendPresent(name);
    }
}
