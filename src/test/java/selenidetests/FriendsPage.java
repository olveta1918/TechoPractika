package selenidetests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class FriendsPage {
    private static By FRIENDS_CATALOG = By.id("hook_Block_UserFriendsCatalogRB");


    FriendsPage(){
        check();
        System.out.println("Находимся на странице друзей");
    }
    protected void check(){
        $(FRIENDS_CATALOG).shouldBe(visible);
    }

    public void checkFriendPresent(String name){
        Assert.assertTrue("На странице нет друга с именем " + name,
                FriendsTransformer.isFriendPresent(name));
    }


}
