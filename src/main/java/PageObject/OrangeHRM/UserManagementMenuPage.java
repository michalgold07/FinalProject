package PageObject.OrangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserManagementMenuPage
{
    @FindBy(how= How.XPATH, using="//*[@id='menu_admin_UserManagement']")
    public WebElement UserManagement;
    @FindBy(how= How.XPATH, using="//*[@id='menu_admin_viewSystemUsers']")
    public WebElement Users;



}
