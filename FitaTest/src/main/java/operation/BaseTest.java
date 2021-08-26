package operation;

import constants.AndroidCapabilityType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;

public class BaseTest {
    public static URL url;
    public static DesiredCapabilities capabilities;
    public static AndroidDriver<MobileElement> driver;
    public static TouchAction touchAction;
    public WebDriverWait wait;

    public void setupAppium(String urlServer) throws MalformedURLException, IOException {

        System.out.println("instance " + this.getClass().getSimpleName());
        Properties configFile = new Properties();
        configFile.load(BaseTest.class.getClassLoader().getResourceAsStream("config.properties"));
        String apk_Path = System.getProperty("user.dir")
                + configFile.getProperty("androidAppLocation");
        capabilities = new DesiredCapabilities();
        try {
            url = new URL(configFile.getProperty(urlServer));
            switch (urlServer) {
                /* Use Local Server */
                case "localURL":
                    capabilities.setCapability(MobileCapabilityType.UDID, configFile.getProperty("udid"));
                    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, configFile.getProperty("androidPlatformName"));
                    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, configFile.getProperty("androidPlatformVersion"));
                    capabilities.setCapability(AndroidCapabilityType.APP_PACKAGE, configFile.getProperty("androidAppPackage"));
                    capabilities.setCapability(AndroidCapabilityType.APP_ACTIVITY, configFile.getProperty("androidAppActivity"));
                    capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
                    capabilities.setCapability(AndroidCapabilityType.AUTO_GRANT_PERMISSION, "true");
                    capabilities.setCapability(MobileCapabilityType.APP, apk_Path);
                    break;

                /* Use Cloud Server */
                case "cloudURL":

                    capabilities.setCapability("browserstack.user", configFile.getProperty("bsUser"));
                    capabilities.setCapability("browserstack.key", configFile.getProperty("bsKey"));
                    // Set URL of the application under test
                    capabilities.setCapability("app", configFile.getProperty("bsAppLink"));

                    // Specify device and os_version for testing
                    capabilities.setCapability("device", configFile.getProperty("bsDevice"));
                    capabilities.setCapability("os_version", configFile.getProperty("bsDeviceOSVersion"));

                    // Set other BrowserStack capabilities
                    capabilities.setCapability("project", "Fita Automation Java Project");
                    capabilities.setCapability("build", "Java Android");
                    capabilities.setCapability("name", "fita_test");
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver = new AndroidDriver<MobileElement>(url, capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.hideKeyboard();
        wait = new WebDriverWait(driver, 15);

        //Populating the properties file
        configFile.setProperty("Device Name", configFile.getProperty("udid"));
        configFile.setProperty("Android Version", configFile.getProperty("androidPlatformVersion"));
        File file = new File("allure-results/environment.properties");
        FileOutputStream fileOut = new FileOutputStream(file);
        configFile.store(fileOut, "Device Info");
        fileOut.close();
    }

    public void closeApp() throws IOException {
        driver.resetApp();
    }

    public void uninstallApp() {
//        driver.removeApp(BaseData.ApplicationInformation.ANDROID_APPLICATION_PACKAGE);
    }
}