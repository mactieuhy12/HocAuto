package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.sql.Struct;

public class Topic_test {

    WebDriver driver;
    @Test
    public void tcs_01_input_valid_data() {
        inputToFormatLogin("locator1", "locator2", "locator3", "yenhocdot", "yensimplor");
    }

    @Test
    public void tcs_01_input_invalid_data() {
        inputToFormatLogin("locator1", "locator2", "locator3", "yenhocdot1", "yensimplor");
    }

    @Test
    public void tcs_01_input_null_data() {
        inputToFormatLogin("locator1", "locator2", "locator3", "", "");
    }



    public void inputToFormatLogin(String email, String password, String button, String emailValue, String passValue) {
       sendKeysToElement(email, emailValue);
       sendKeysToElement(password, passValue);
       clickToElement(button);
    }


    private void sendKeysToElement(String locator, String value) {
        driver.findElement(By.xpath(locator)).clear();
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }

    private void clickToElement(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }
}
