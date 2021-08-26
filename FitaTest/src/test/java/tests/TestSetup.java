package tests;

import operation.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.IOException;

public class TestSetup extends BaseTest {

    @Parameters({"deviceName"})
    @BeforeSuite
    public void setUp() throws IOException {
        setupAppium("cloudURL");
    }


    @AfterMethod
    public void closeAppSwitch() throws IOException {
        closeApp();
    }
}
