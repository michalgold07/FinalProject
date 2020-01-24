package SanityTest;

import Extention.Verifications;
import Extention.uiActions;
import Utilities.CommonOps;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



@Listeners(Utilities.listeners.class)
public class OrangeHRM extends CommonOps
{

    @Test(description="Test01: Login to OrangeHRM")
    @Description("Test Description: Login to Web Application")
    public void test01_login()
    {
        webFlows.login("Admin", "admin123");
        Verifications.TextInElement(OrangeHRMMainPage.WelcomeAdminTitle, "Welcome Admin");
    }

    @Test(description="Test02: Verify Admin User")
    @Description("Test Description: Verify Admin User")
    public void test02_VerifyAdminUser()
    {
        uiActions.click(OrangeHRMMTopMenu.AdminOption);
        uiActions.MouseHoverElement(OrangeHRMMUserManagmentMenuPage.UserManagement, OrangeHRMMUserManagmentMenuPage.Users);
        webFlows.SearchUser("Admin");
        Verifications.TextInElement(OrangeHRMMSystemUserMainPage.ResultRows,"Admin");
    }

    @Test(description="Test03: Add and Verify User")
    @Description("Test Description: Add New User to Table And verify that he exist")
    public void test03_AddUser() throws InterruptedException
    {
        uiActions.click(OrangeHRMMTopMenu.AdminOption);
        uiActions.MouseHoverElement(OrangeHRMMUserManagmentMenuPage.UserManagement, OrangeHRMMUserManagmentMenuPage.Users);
        uiActions.click(OrangeHRMMSystemUserMainPage.AddUser);
        webFlows.AddUser("ESS","Linda Anderson","linda1467", "Disabled", "Admin12345", "Admin12345");
        Verifications.TextInElement(OrangeHRMMSystemUserMainPage.ResultRows,"linda1467");
    }

    @Test(description="Test04: Delete User From Table")
    @Description("Test Description: Delete User From Table and verify that User Table updated")
    public void test04_DeleteUser()
    {
        uiActions.click(OrangeHRMMTopMenu.AdminOption);
        uiActions.MouseHoverElement(OrangeHRMMUserManagmentMenuPage.UserManagement, OrangeHRMMUserManagmentMenuPage.Users);
        webFlows.DeleteUSer("linda1467");
        uiActions.click(OrangeHRMMTopMenu.AdminOption);
        uiActions.MouseHoverElement(OrangeHRMMUserManagmentMenuPage.UserManagement, OrangeHRMMUserManagmentMenuPage.Users);
        webFlows.SearchUser("linda1467");
        Verifications.TextInElement(OrangeHRMMSystemUserMainPage.ResultRowsWhenEmpty,"No Records Found");
    }

    @Test(description="Test05: Verify Orange Fruit")
    @Description("Test Description: Verify Orange Logo")
    public void test05_VerifyOrange()
    {
       Verifications.VisualElement(OrangeHRMMainPage.OrangeImage,"Orangefruit");
    }
}