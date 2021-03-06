import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

public class LoginTest {
    private WebDriver driver;

    @Before
    public void openDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }


    @Test
    public void loginWithValidCredentialsTest() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
//        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
//        accountLink.click();
        driver.findElement(By.cssSelector("a[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        WebElement dashboardTextElement = driver.findElement(By.cssSelector(".page-title h1"));
        String textFromElement = driver.findElement(By.cssSelector(".hello strong")).getText();
        Assert.assertTrue(dashboardTextElement.isDisplayed());
        Assert.assertEquals("Hello, Cosmin Fast!",textFromElement);
        driver.switchTo().alert().accept();

        String allProductsText = driver.findElement(By.cssSelector(".products-grid.first")).getText();
        Assert.assertTrue(allProductsText.contains("SILVER DESERT NECKLACE"));


        List<WebElement> listOfProducts = driver.findElements(By.cssSelector(".products-grid .product-name"));

        boolean found= false;
        for (WebElement element : listOfProducts){
            if (element.getText().equals("SILVER DESERT NECKLACE")){
                found=true;
                break;
            }
        }
        Assert.assertTrue("Product was not found in the list!",found);
    }

    @Test
    public void loginWithInvalidPasswordTest() {

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
//        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
//        accountLink.click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.id("pass")).sendKeys("121233456");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
        String textFromElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.account-login > ul > li > ul > li > span")).getText();
        Assert.assertEquals("Invalid login or password.", textFromElement);
    }

    @Test
    public void loginWithInvalidEmail() {

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
//        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
//        accountLink.click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("cosminfasttrackit.org");
        driver.findElement(By.id("pass")).sendKeys("121233456");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
    }

    @Test
    public void loginWithoutCredentialsTest() {
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
//        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
//        accountLink.click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
    }

    @Test
    public void loginWithBlankEmailTest() {
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("pass")).sendKeys("121233456");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();

    }


    @Test
    public void loginWithBlankPasswordTest() {
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();


    }



    @After
    public void close() {
        driver.close();
    }
}
