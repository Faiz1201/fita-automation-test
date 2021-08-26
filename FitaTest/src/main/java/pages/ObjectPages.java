package pages;

import element.ObjectElement;
import io.qameta.allure.Step;
import utilities.finders.ElementAction;

public class ObjectPages {
    ObjectElement objectElement = new ObjectElement();
    ElementAction action = new ElementAction();

    @Step("Add Water Henley To Clothing Filter")
    public void testAddWaterHenleyToClothingFilter(String username, String password, String priceExpected){
        action.scrollOnly(objectElement.bannerShrine);
        action.sendKeys(objectElement.input_user_name, username);
        action.sendKeys(objectElement.Input_user_password, password);
        action.click(objectElement.btn_next);
        action.click(objectElement.btn_open_menu);
        action.click(objectElement.btn_clothing);
        action.clickElementScroll(objectElement.btn_product_click);
        action.click(objectElement.btn_cart);
        action.checkerEqual(objectElement.txt_price_total, priceExpected);
    }
}
