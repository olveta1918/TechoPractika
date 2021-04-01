import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
    WebDriver driver;
    private final String BASE_URL = "https://ok.ru";

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\configs\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @After
    public void stop() {
        driver.quit();
    }
}
