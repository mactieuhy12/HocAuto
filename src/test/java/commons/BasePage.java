package commons;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BasePage {
    public static BasePage getBasePageObject(){
        return new BasePage();
    }
    protected void implicitWaitBrowser(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    protected void openPageUrl(WebDriver driver, String pageURL){
        driver.get(pageURL);
    }
    protected void quitBrowser(WebDriver driver){
        driver.quit();
    }
    protected void maximizeBrowsers(WebDriver driver){
        driver.manage().window().maximize();
    }
    protected String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    protected String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }
    protected void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    protected void refreshToPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    protected void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }
}
