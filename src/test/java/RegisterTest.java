import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class RegisterTest {

    @Test
    public void validRegisterTest()  {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
//        String email = RandomStringUtils.randomAlphanumeric(10)+"@email.com";
//        driver.findElement(By.cssSelector("#emailField")).sendKeys(email);
//
//        String qty = driver.findElement(By.cssSelector(".qty")).getAttribute("value");


//       WebElement womenCategory = driver.findElement(By.cssSelector(".level0 > a[href*='women']"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(womenCategory).perform();

        WebElement element = driver.findElement(By.id("select-language"));
        Select selectLanguage = new Select(element);
        selectLanguage.selectByVisibleText("German");
        wait(1500);

    }

    public static void wait(int mil){
        try {
            Thread.sleep(mil);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
