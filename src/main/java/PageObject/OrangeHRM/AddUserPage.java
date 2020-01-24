package PageObject.OrangeHRM;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddUserPage
{
    @FindBy(how= How.XPATH, using="//*[@id='systemUser_userType']")
    public WebElement UserRole;

    @FindBy(how= How.XPATH, using="//*[@id='systemUser_employeeName_empName']")
    public WebElement EmployeeName;

    @FindBy(how= How.CSS, using="input[id='systemUser_userName']")
    public WebElement UserName;

    @FindBy(how= How.XPATH, using="//*[@id='systemUser_status']")
    public WebElement UserStatus;

    @FindBy(how= How.XPATH, using="//*[@id='systemUser_password']")
    public WebElement Password;

    @FindBy(how= How.XPATH, using="//*[@id='systemUser_confirmPassword']")
    public WebElement ConfirmPassword;

    @FindBy(how= How.XPATH, using="//*[@id='btnSave']")
    public WebElement SaveButton;

}
