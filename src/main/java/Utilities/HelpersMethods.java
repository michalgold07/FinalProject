package Utilities;

import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import javax.imageio.ImageIO;
import java.io.File;

public class HelpersMethods extends CommonOps
{
    public static void TakeElementScreenShot(WebElement ImageElement,String ImageName)
    {
     ImageScreenshot=new AShot().takeScreenshot(driver,ImageElement);
     try {

         ImageIO.write(ImageScreenshot.getImage(), "png", new File( getData("ImageRepo")+ImageName+".png"));
         }
     catch(Exception e)
     {
         System.out.println("Error writing image file, see details:"+e);
     }
    }
}
