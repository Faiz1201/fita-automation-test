package utilities.finders;

import io.appium.java_client.MobileElement;
import operation.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ElementAction extends BaseTest {

    public void waitUntilElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void click(By element) {
        waitUntilElement(element);
        driver.findElement(element).click();
    }

    public String getText(By element) {
        waitUntilElement(element);
        String text = driver.findElement(element).getText();
        return text;
    }

    public void sendKeys(By element, String inputKey) {
        waitUntilElement(element);
        driver.findElement(element).sendKeys(inputKey);
    }

    public void checkerEqual(By element, String expected) {
        waitUntilElement(element);
        Assert.assertEquals(driver.findElement(element).getText(), expected);
    }

    public void checkerDisabled(By element) {
        waitUntilElement(element);
        Assert.assertFalse(driver.findElement(element).isEnabled());
    }

    public void checkerEnabled(By element) {
        waitUntilElement(element);
        Assert.assertTrue(driver.findElement(element).isEnabled());
    }

    public void checkerElementExist(By element) {
        Assert.assertNotNull(driver.findElement(element));
    }

    public MobileElement scrollToElement(String element) {
        MobileElement elementToClick = (MobileElement) driver.findElementByAndroidUIAutomator(element);
        try {
            return elementToClick;
        } catch (Exception e) {
            return null;
        }
    }

    public void scrollOnly(String element) {
        scrollToElement(element);
    }

    public void clickElementScroll(String element) {
        scrollToElement(element).click();
    }

    public void inputElementScroll(String element, String inputKey) {
        scrollToElement(element).sendKeys(inputKey);
    }

    public void countClick(By element, int count) {
        int i;
        for(i=0;i<=count;i++) {
            driver.findElement(element).click();
        }
    }
}
