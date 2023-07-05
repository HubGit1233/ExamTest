package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class RegisteredPage {

    WebDriver driver;
    public RegisteredPage(WebDriver driver) {
        this.driver=driver;
    }

    By heading1 = By.xpath("//div[@id='content']/h1");

    public String getHeading() {
        String head = driver.findElement(heading1).getText();
        return head;
    }
}
