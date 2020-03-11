import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    private WebDriver driver;

    @Before
    public void initdriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void login() {


        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("dorel_c@mailinator.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456789");
        driver.findElement(By.cssSelector("#send2")).click();
        WebElement welcome = driver.findElement(By.cssSelector("body > div.wrapper > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div > div.welcome-msg > p.hello > strong"));
        Assert.assertEquals("Hello, Dorel Dorel Cristurean!", welcome.getText());
    }

    @Test
    public void wrong_email() {


        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("dor123el_c@mailinator.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456789");
        driver.findElement(By.cssSelector("#send2")).click();
        WebElement error = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.account-login > ul > li > ul > li > span"));
        Assert.assertEquals("Invalid login or password.", error.getText());
    }

    @Test
    public void forgot_your_password() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#login-form > div > div.col-2.registered-users > div.content.fieldset > ul > li:nth-child(3) > a")).click();
        WebElement forgetpassword = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.page-title > h1"));
        Assert.assertEquals("FORGOT YOUR PASSWORD?", forgetpassword.getText());


    }

    @Test

    public void log_out() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("dorel_c@mailinator.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456789");
        driver.findElement(By.cssSelector("#send2")).click();
       driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
       driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
       WebElement logout = driver.findElement(By.cssSelector("body > div.wrapper > div.page > div.header-language-background > div > p"));
       Assert.assertEquals("WELCOME",logout.getText());

    }



    @After
    public void Close() {
        driver.quit();


    }


}





