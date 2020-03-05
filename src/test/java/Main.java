import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {


        LoginTest test = new LoginTest();
        RegisterTest register = new RegisterTest();
        WishListTest wishl =new WishListTest();

        test.login();
        register.registerTest();
        wishl.wishList();


    }
}

