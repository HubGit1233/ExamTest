package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register {

    WebDriver driver;
    public Register(WebDriver driver) {
        this.driver = driver;
    }

    By firstName = By.xpath("//input[@id='input-firstname']");
    public void enterFirstName(String firstname) {
        driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(firstname);
    }

    By lastName = By.xpath("//*[@id=\"input-lastname\"]");
    public void enterLastName(String lastname) {
        driver.findElement(By.xpath("//*[@id=\"input-lastname\"]")).sendKeys(lastname);
    }

    By email = By.xpath("//*[@id=\"input-email\"]");
    public void enterEmail(String email) {
        driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(email);
    }

    By telephone = By.xpath("//*[@id=\"input-telephone\"]");
    public void enterTelephone(String telephone) {
        driver.findElement(By.xpath("//*[@id=\"input-telephone\"]")).sendKeys(telephone);
    }

    By password = By.xpath("//*[@id=\"input-password\"]");
    public void enterPassword(String password) {
        driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(password);
    }

    By confirmPassword = By.xpath("//*[@id=\"input-confirm\"]");
    public void confirmPassword(String confirmpassword) {
        driver.findElement(By.xpath("//*[@id=\"input-confirm\"]")).sendKeys(confirmpassword);
    }

    By radioButton = By.xpath("//input[@name='confirm']");
    public void selectRadioYes() {
        driver.findElement(By.xpath("//input[@type='radio' and @name='newsletter']")).click();
    }

    By agree = By.xpath("//input[@name='agree']");
    public void checkAgree() {
        driver.findElement(By.xpath("//input[@name='agree']")).click();
    }

    By go = By.xpath("//input[@type='submit' and @value='Continue']");
    public void clickGo() {
        driver.findElement(By.xpath("//input[@type='submit' and @value='Continue']")).click();
    }
}
