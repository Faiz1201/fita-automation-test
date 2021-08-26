package element;

import operation.BaseTest;
import org.openqa.selenium.By;
import utilities.finders.ElementAction;

public class ObjectElement extends BaseTest {

    ElementAction action = new ElementAction();
    public String bannerShrine = "new UiScrollable(new UiSelector()"
            + ".class(\"android.widget.HorizontalScrollView\")).scrollIntoView("
            + "new UiSelector().xpath(\"//android.view.View[@content-desc=\"Shrine A fashionable retail app\"]\"));";
    public By input_user_name = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[1]");
    public By Input_user_password = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[2]");
    public By btn_next = By.xpath("//android.widget.Button[@content-desc=\"NEXT\"]");
    public By btn_open_menu = By.xpath("//android.widget.Button[@content-desc=\"Open menu\"]");
    public By btn_clothing = By.xpath("//android.widget.Button[@content-desc=\"CLOTHING\"]");
    public By btn_search = By.xpath("//android.widget.Button[@content-desc=\"Search\"]");
    public String btn_product_click = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View";
    public By btn_cart = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View");
    public By txt_price_total = By.xpath("//android.view.View[@content-desc=\"TOTAL $47.28\"]");
    public By btn_clear_cart = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View");
}
