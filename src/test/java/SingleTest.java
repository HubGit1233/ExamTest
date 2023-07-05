import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Random;

public class SingleTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://shop.pragmatic.bg");
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }


    @Test
    public void RegisterAndAssert() {

        Random random = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder builder = new StringBuilder();
        int minLength = 4;
        int maxLength = 20;
        int length = random.nextInt(maxLength - minLength + 1) + minLength;

        for (int i = 0; i < length; i++) {
            char randomChar = alphabet.charAt(random.nextInt(alphabet.length()));
            builder.append(randomChar);
        }

        String randomString = builder.toString();

        WebElement myAcc = driver.findElement(By.xpath("//i[contains(@class, 'fa fa-user')]\n"));
        myAcc.click();
        WebElement register = driver.findElement(By.linkText("Register"));
        register.click();

        WebDriverWait wait = new WebDriverWait(driver, 3);

        WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.sendKeys(randomString);
        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"input-lastname\"]"));
        lastName.sendKeys(randomString);
        WebElement eMail = driver.findElement(By.xpath("//*[@id=\"input-email\"]"));
        eMail.sendKeys(randomString + "@abv.bg");
        WebElement telephone = driver.findElement(By.xpath("//*[@id=\"input-telephone\"]"));
        telephone.sendKeys("0123456789");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"input-password\"]"));
        password.sendKeys(randomString);
        WebElement passwordConfirm = driver.findElement(By.xpath("//*[@id=\"input-confirm\"]"));
        passwordConfirm.sendKeys(randomString);

        WebElement radioButton = driver.findElement(By.xpath("//input[@type='radio' and @name='newsletter']"));
        radioButton.click();

        WebElement agree = driver.findElement(By.xpath("//input[@name='agree']"));
        agree.click();

        WebElement go = driver.findElement(By.xpath("//input[@type='submit' and @value='Continue']"));
        go.click();

        String expectedURL = "http://shop.pragmatic.bg/index.php?route=account/success";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(expectedURL, actualURL);

    }
}
