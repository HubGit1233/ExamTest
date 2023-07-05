package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class HomePage {

    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get("http://shop.pragmatic.bg");
    }

    By myACC = By.xpath("//i[contains(@class, 'fa fa-user')]");
    By register = By.linkText("Register");

    public void clickRegister() {
        driver.findElement(myACC).click();
        driver.findElement(register).click();
    }
}
