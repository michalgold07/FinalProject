package PageObject.OrangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class SystemUserMainPage
{
        @FindBy(how = How.XPATH, using = "//*[@id='resultTable']/tbody/tr")
        public List<WebElement> Rows;

        @FindBy(how = How.XPATH, using = "//*[@id='btnAdd']")
        public WebElement AddUser;

        @FindBy(how = How.XPATH, using = "//*[@id='searchSystemUser_userName']")
        public WebElement SearchUser;

        @FindBy(how = How.XPATH, using = "//*[@id='searchBtn']")
        public WebElement SearchButton;

        @FindBy(how = How.XPATH, using = "//*[@id='ohrmList_chkSelectAll']")
        public WebElement CheckboxResult;

        @FindBy(how = How.XPATH, using = "//*[@id='btnDelete']")
        public WebElement DeleteButton;

        @FindBy(how = How.XPATH, using = "//*[@id='dialogDeleteBtn']")
        public WebElement PopUpDialog;

        @FindBy(how = How.XPATH, using = "//*[@id='resultTable']/tbody/tr/td[2]/a")
        public WebElement ResultRows;

        @FindBy(how = How.XPATH, using = "//*[@id='resultTable']/tbody/tr/td")
        public WebElement ResultRowsWhenEmpty;





}
