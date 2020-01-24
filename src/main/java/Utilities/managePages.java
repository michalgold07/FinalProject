package Utilities;

import PageObject.OrangeHRM.AddUserPage;
import PageObject.OrangeHRM.SystemUserMainPage;
import PageObject.OrangeHRM.UserManagementMenuPage;
import org.openqa.selenium.support.PageFactory;

public class managePages extends base
{

    public static void init()
    {
        OrangeHRMLogin = PageFactory.initElements(driver, PageObject.OrangeHRM.LoginPage.class);
        OrangeHRMMainPage = PageFactory.initElements(driver, PageObject.OrangeHRM.MainPage.class);
        OrangeHRMMTopMenu = PageFactory.initElements(driver, PageObject.OrangeHRM.TopMenu.class);
        OrangeHRMMUserManagmentMenuPage = PageFactory.initElements(driver, UserManagementMenuPage.class);
        OrangeHRMMSystemUserMainPage = PageFactory.initElements(driver, SystemUserMainPage.class);
        OrangeHRMMAddUserPage = PageFactory.initElements(driver, AddUserPage.class);
    }
}
