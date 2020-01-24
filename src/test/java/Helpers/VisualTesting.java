package Helpers;

import Utilities.CommonOps;
import Utilities.HelpersMethods;
import org.testng.annotations.Test;
import WorkFlows.webFlows;


public class VisualTesting extends CommonOps
{
   @Test
    public void CreateScreenshot()
   {
       webFlows.login("Admin", "admin123");
       System.out.println(OrangeHRMMainPage.OrangeImage);
       HelpersMethods.TakeElementScreenShot(OrangeHRMMainPage.OrangeImage,"Orangefiruit");
   }

}
