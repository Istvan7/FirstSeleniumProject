import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {

    public void registerTest() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.cssSelector("#firstname")).sendKeys("Dorel");
        driver.findElement(By.cssSelector("#middlename")).sendKeys("Dorel");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Cristurean");
        driver.findElement(By.cssSelector("#email_address")).sendKeys("dorel_c@mailinator.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("123456789");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("123456789");
        driver.findElement(By.cssSelector("#is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
        driver.quit();




    }
}
