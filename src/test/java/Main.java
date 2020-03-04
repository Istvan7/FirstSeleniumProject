import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        RegisterTest reg = new RegisterTest();
        LoginTest login = new LoginTest();
        reg.register();
        login.login();
        WishListTest wishl = new WishListTest();
        wishl.wishList();




    }
}
