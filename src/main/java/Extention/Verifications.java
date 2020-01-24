package Extention;

import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import static org.testng.Assert.*;

public class Verifications extends CommonOps
{
    @Step("Verify Text in element")
   public static void TextInElement(WebElement elem, String ExpectedValue)
   {
       wait.until(ExpectedConditions.visibilityOf(elem));
       assertEquals(elem.getText(), ExpectedValue);
   }
    @Step("Verify Number of Elements equals to")
    public static void NumberOfElement(List<WebElement> elems, int ExpectedValue)
    {
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size()-1)));
        assertEquals(elems.size(), ExpectedValue);
    }

    @Step("Verify Element Visually")
    public static void VisualElement(WebElement ImageElement, String ExpectedImageName)
    {
        BufferedImage ExpectedImage=null;
        try
        {
            ExpectedImage=ImageIO.read(new File(getData("ImageRepo")+ExpectedImageName+".png"));

        } catch (IOException e) {
            System.out.println("Error reading image file"+e);
        }
         Screenshot ImageScreenshot=new AShot().takeScreenshot(driver,ImageElement);
        BufferedImage actualImage=ImageScreenshot.getImage();
        Diff=Imdiff.makeDiff(actualImage,ExpectedImage);
        assertFalse(Diff.hasDiff(),"Image are not the same");
    }


}
