package constants;

import org.openqa.selenium.remote.CapabilityType;

public interface AndroidCapabilityType extends CapabilityType {
    String APP_PACKAGE = "appPackage";
    String APP_ACTIVITY = "appActivity";
    String AUTO_GRANT_PERMISSION = "autoGrantPermissions";
}
