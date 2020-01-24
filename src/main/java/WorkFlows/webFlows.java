package WorkFlows;

import Extention.Verifications;
import Extention.uiActions;
import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import static junit.framework.TestCase.assertTrue;

public class webFlows extends CommonOps
{
    @Step ("Login OrangeHRM Flow")
    public static void login(String user, String pass)
    {
        uiActions.updateText(OrangeHRMLogin.txt_userName, user);
        uiActions.updateText(OrangeHRMLogin.txt_password, pass);
        uiActions.click(OrangeHRMLogin.txt_buttonLogin);

    }
    @Step ("Verify Admin user")
    public static void SearchUser(String UserName)
    {
        uiActions.updateText(OrangeHRMMSystemUserMainPage.SearchUser,UserName);
        uiActions.click(OrangeHRMMSystemUserMainPage.SearchButton);
    }

    @Step ("Create New User")
    public static void AddUser(String RoleValue, String EmployeeName, String UserName, String UserStat, String Password, String ConfirmPass) throws InterruptedException {
        uiActions.updateDropDown(OrangeHRMMAddUserPage.UserRole, RoleValue);
        uiActions.updateText(OrangeHRMMAddUserPage.EmployeeName, EmployeeName);
        uiActions.updateText(OrangeHRMMAddUserPage.UserName, UserName);
        uiActions.updateDropDown(OrangeHRMMAddUserPage.UserStatus, UserStat);
        uiActions.updateText(OrangeHRMMAddUserPage.Password, Password);
        uiActions.updateText(OrangeHRMMAddUserPage.ConfirmPassword, ConfirmPass);
        Thread.sleep(1000);
        uiActions.click(OrangeHRMMAddUserPage.SaveButton);
        uiActions.updateText(OrangeHRMMSystemUserMainPage.SearchUser,UserName);
        uiActions.click(OrangeHRMMSystemUserMainPage.SearchButton);

    }
    @Step ("Delete from Users Table")
    public static void DeleteUSer(String Username)
    {
        uiActions.updateText(OrangeHRMMSystemUserMainPage.SearchUser,Username);
        uiActions.click(OrangeHRMMSystemUserMainPage.SearchButton);
        uiActions.click(OrangeHRMMSystemUserMainPage.CheckboxResult);
        uiActions.click(OrangeHRMMSystemUserMainPage.DeleteButton);
        uiActions.click(OrangeHRMMSystemUserMainPage.PopUpDialog);
    }
}
