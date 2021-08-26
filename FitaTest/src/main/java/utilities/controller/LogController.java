package utilities.controller;

import org.testng.Reporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogController {

    public LogController() {
    }
    
    public void writeLogs(String Activity, String Description) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date now = new Date();
            String strDate = sdf.format(now);
            Reporter.log("Activity: " + Activity + ",\t Description: " + Description + "\t @Time :" + strDate);
        } catch (Exception exception) {
            exception.printStackTrace();
            Reporter.log("Exception in LogController writeLogs() method ::" + exception);
        }
    }
}
