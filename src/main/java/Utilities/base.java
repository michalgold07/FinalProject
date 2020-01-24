package Utilities;

import PageObject.OrangeHRM.LoginPage;
import PageObject.OrangeHRM.MainPage;
import PageObject.OrangeHRM.TopMenu;
import PageObject.OrangeHRM.UserManagementMenuPage;
import PageObject.OrangeHRM.SystemUserMainPage;
import PageObject.OrangeHRM.AddUserPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import java.awt.image.BufferedImage;

public class base
{

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions action;
    public static Screenshot ImageScreenshot;
    public static ImageDiffer Imdiff=new ImageDiffer();
    public static ImageDiff Diff;
    public static DesiredCapabilities dc = new DesiredCapabilities();



    public static LoginPage OrangeHRMLogin;
    public static MainPage OrangeHRMMainPage;
    public static TopMenu OrangeHRMMTopMenu;
    public static UserManagementMenuPage OrangeHRMMUserManagmentMenuPage;
    public static SystemUserMainPage OrangeHRMMSystemUserMainPage;
    public static AddUserPage OrangeHRMMAddUserPage;



}


