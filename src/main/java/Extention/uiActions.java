package Extention;

import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class uiActions extends CommonOps
{
    @Step("Click on Element")
    public static void click(WebElement elem)
    {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();

    }
    @Step ("Send Text to Text-Field")
    public static void updateText(WebElement elem,String value)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(value);
    }
    @Step ("Update Drop Down Filed")
    public static void updateDropDown(WebElement elem,String value)
    {
        Select MyValue=new Select(elem);
        MyValue.selectByVisibleText(value);

    }
    @Step ("Mouse Over To Element")
    public static void MouseHoverElement(WebElement elem1,WebElement elem2)
    {
      action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }


}
