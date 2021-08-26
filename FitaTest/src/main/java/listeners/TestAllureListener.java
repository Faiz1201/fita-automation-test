package listeners;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import operation.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class TestAllureListener implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult){
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "Page Screenshot", type = "image/png")
    public byte[] saveScreenShotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }
    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Allure.addAttachment("screenShot", new ByteArrayInputStream(((TakesScreenshot)iTestResult.getTestContext().getAttribute("WebDriver")).getScreenshotAs(OutputType.BYTES)));

        Object webDriverAttribute = iTestResult.getTestContext().getAttribute("WebDriver");
        saveScreenShotPNG((WebDriver) webDriverAttribute);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Allure.addAttachment("screenShot", new ByteArrayInputStream(((TakesScreenshot)iTestResult.getTestContext().getAttribute("WebDriver")).getScreenshotAs(OutputType.BYTES)));

        Object webDriverAttribute = iTestResult.getTestContext().getAttribute("WebDriver");
        saveScreenShotPNG((WebDriver) webDriverAttribute);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("Start Method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", BaseTest.driver);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("I am in onFinish method " + iTestContext.getName());
    }
}
