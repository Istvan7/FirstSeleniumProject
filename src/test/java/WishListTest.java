import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishListTest {
    private WebDriver driver;

    @Before
    public void initdriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Before
    public void login() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("dorel_c@mailinator.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456789");
        driver.findElement(By.cssSelector("#send2")).click();

    }

    @Test

    public void wishList() {

        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a")).click();
        driver.findElement(By.cssSelector("#product-collection-image-423")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > ul.add-to-links > li:nth-child(1) > a")).click();
        WebElement addwishlist = driver.findElement(By.cssSelector("body > div.wrapper > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div.my-wishlist > ul > li > ul > li > span"));
        Assert.assertEquals("Racer Back Maxi Dress has been added to your wishlist. Click here to continue shopping.", addwishlist.getText());


    }

    @Test
    public void remuve_item_from_wishList() {

        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(2) > a")).click();
        driver.findElement(By.cssSelector("#item_571 > td.wishlist-cell5.customer-wishlist-item-remove.last > a")).click();
        WebElement delete = driver.findElement(By.cssSelector("#wishlist-view-form > div > p"));
        Assert.assertEquals("You have no items in your wishlist.", delete.getText());


    }

    @Test
    public void change_quantity() {

        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(2) > a")).click();
        driver.findElement(By.cssSelector("#item_594 > td.wishlist-cell2.customer-wishlist-item-quantity > div > div > input")).clear();
        driver.findElement(By.cssSelector("#item_594 > td.wishlist-cell2.customer-wishlist-item-quantity > div > div > input")).sendKeys("5");
        driver.findElement(By.cssSelector("#wishlist-view-form > div > div > button.button.btn-update.button-secondary > span > span")).click();
        WebElement quanyity = driver.findElement(By.cssSelector("#item_594 > td.wishlist-cell2.customer-wishlist-item-quantity > div > div > input"));
        Assert.assertNotEquals("0 && 1",quanyity.getCssValue("#item_594 > td.wishlist-cell2.customer-wishlist-item-quantity > div > div > input"));


    }
    @Test
    public void share_wishlist_is_working(){
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(2) > a")).click();
        driver.findElement(By.cssSelector("#wishlist-view-form > div > div > button.button.btn-share > span > span")).click();
        WebElement share = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div > h1"));
        Assert.assertEquals("SHARE YOUR WISHLIST",share.getText());

    }

    @After
    public void Close(){
        driver.quit();
    }


}
