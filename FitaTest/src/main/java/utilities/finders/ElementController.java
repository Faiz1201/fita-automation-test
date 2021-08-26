package utilities.finders;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import utilities.controller.LogController;
import utilities.readers.XMLReaderWriter;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;

public class ElementController {
    public HashMap<String, By> elementsLocator = null;
    public Hashtable<String, Hashtable<String, String>> xmlElements = null;
    public LogController logController = null;
    XMLReaderWriter xmlReader = null;

    public ElementController(String absoluteFilePath) throws Exception {
        xmlElements = new Hashtable<String, Hashtable<String, String>>();
        elementsLocator = new HashMap<>();
        xmlReader = new XMLReaderWriter();
        xmlElements = xmlReader.getElementParamsByTitle(absoluteFilePath);
        System.out.println("Size of xml file elemets : " + xmlElements.size());
        for (String key : xmlElements.keySet()) {
            System.out.println("Key : " + key + " in Repository");
            elementsLocator.put(key, getLocators(key, xmlElements.get(key).keySet()));
        }
    }

    private By getLocators(String key, Set<String> stringLocator) {
        By locator = null;
        for (String identifier : stringLocator) {
            if ("id".equals(identifier)) {
                System.out.println(true);
                locator = By.id(xmlElements.get(key).get("id"));
                break;
            } else if ("xpath".equals(identifier)) {
                locator = By.xpath(xmlElements.get(key).get("xpath"));
                break;
            } else if ("name".equals(identifier)) {
                locator = By.name(xmlElements.get(key).get("name"));
                break;
            } else if ("className".equals(identifier)) {
                locator = By.className(xmlElements.get(key).get("className"));
                break;
            } else if ("dynamicXpath".equals(identifier)) {
                break;
            } else if ("uiAutomator".equals(identifier)) {
                locator = MobileBy.AndroidUIAutomator(xmlElements.get(key).get("uiAutomator"));
                break;
            }
        }
        return locator;
    }
}
