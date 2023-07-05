import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Register;
import pages.RegisteredPage;
import org.openqa.selenium.WebDriver;
import java.util.Random;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class POMTest {
    WebDriver driver;
    HomePage homePage;
    Register registerPage;
    RegisteredPage registeredPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        registerPage = new Register(driver);
        registeredPage = new RegisteredPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void registrationTest() {

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

        homePage.clickRegister();
        registerPage.enterFirstName(randomString);
        registerPage.enterLastName(randomString);
        registerPage.enterEmail(randomString + "@abv.bg");
        registerPage.enterTelephone("0123456789");
        registerPage.enterPassword(randomString);
        registerPage.confirmPassword(randomString);
        registerPage.selectRadioYes();
        registerPage.checkAgree();
        registerPage.clickGo();

        String heading = registeredPage.getHeading();
        Assert.assertEquals(heading, "Your Account Has Been Created!");
    }
}
