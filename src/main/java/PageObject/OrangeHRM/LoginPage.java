package PageObject.OrangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage
{
   @FindBy(how= How.NAME, using="txtUsername")
    public WebElement txt_userName;

    @FindBy(how= How.NAME, using="txtPassword")
    public WebElement txt_password;

    @FindBy(how= How.ID, using="btnLogin")
    public WebElement txt_buttonLogin;

}
