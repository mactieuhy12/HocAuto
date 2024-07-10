package testcases;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Level_01_Setup_Environment extends BaseTest {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver = getBrowserDriver("chrome");
    }

    @AfterClass
    public void afterClass(){
        quitBrowser(driver);
    }

    @Test
    public void TC_01(){
        // Get(): de truyen URL -> mo ra page day
        // Get nhan vao 1 chuoi gia tri la String -> nen phai co ""
        driver.get("");
    }
}
