package PageObject.OrangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TopMenu
{
    @FindBy(how= How.XPATH, using="//*[@id='menu_admin_viewAdminModule']")
    public WebElement AdminOption;

}
