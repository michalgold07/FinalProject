package PageObject.OrangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage
{
    @FindBy(how= How.XPATH, using="//*[@id='welcome']")
    public WebElement WelcomeAdminTitle;

    @FindBy(how= How.CSS, using="img[src='/webres_5df488ddad8b23.30204013/themes/default/images/logo.png']")
    public WebElement OrangeImage;


}
