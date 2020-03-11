import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
    private WebDriver driver;

    @Before
    public void initdriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test

    public void registerTest() {

        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.cssSelector("#firstname")).sendKeys("Dorel");
        driver.findElement(By.cssSelector("#middlename")).sendKeys("Dorel");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Cristurean");
        driver.findElement(By.cssSelector("#email_address")).sendKeys("dorel6_c@mailinator.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("123456789");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("123456789");
        driver.findElement(By.cssSelector("#is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
        WebElement succesulregistration = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div > ul > li > ul > li > span"));
        Assert.assertEquals("Thank you for registering with Madison Island.", succesulregistration.getText());


    }

    @Test
    public void registration_without_name_field_completed() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.cssSelector("#firstname")).sendKeys("");
        driver.findElement(By.cssSelector("#middlename")).sendKeys("");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Cristurean");
        driver.findElement(By.cssSelector("#email_address")).sendKeys("dorel_c@mailinator.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("123456789");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("123456789");
        driver.findElement(By.cssSelector("#is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
        WebElement error = driver.findElement(By.cssSelector("#advice-required-entry-firstname"));
        Assert.assertEquals("This is a required field.", error.getText());


    }

    @Test
    public void registration_with_already_used_email() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.cssSelector("#firstname")).sendKeys("asdasd");
        driver.findElement(By.cssSelector("#middlename")).sendKeys("dsadasdd");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Cristurean");
        driver.findElement(By.cssSelector("#email_address")).sendKeys("dorel_c@mailinator.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("123456789");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("123456789");
        driver.findElement(By.cssSelector("#is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
        WebElement error = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.account-create > ul > li > ul > li > span"));
        Assert.assertEquals("There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.", error.getText());

    }

    @After
    public void Close() {
        driver.quit();


    }
}