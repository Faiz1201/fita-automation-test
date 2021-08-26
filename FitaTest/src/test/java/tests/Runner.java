package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import listeners.TestAllureListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ObjectPages;

@Listeners({TestAllureListener.class})
public class Runner extends TestSetup{

    ObjectPages objectPages = new ObjectPages();

    @Test(priority = 51, description = "Test Case 1 - User can put product to cart and check")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Successfully check Cart.")
    @Story("Story Name : Check Price")
    public void checkValidLoginUsingEmail() throws InterruptedException {
        objectPages.testAddWaterHenleyToClothingFilter("admin", "admin", "$47.28");
    }
}
