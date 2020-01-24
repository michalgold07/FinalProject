package Utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import okio.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.net.URL;

public class CommonOps extends base
{
    public static String getData(String nodeName)
    {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("C:/automation/AutomationProjectFullStack/Configuration/DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
        catch(Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();

    }
    @BeforeClass
    public void StartSession()
    {
        if(getData("PlatformName").equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));
            else if (getData("PlatformName").equalsIgnoreCase("mobile"))
            initMobile();
        else
        {
            throw new RuntimeException("Invalid platform stated");
        }
        managePages.init();

    }
    private void initBrowser(String BrowserType)
    {
     if(BrowserType.equalsIgnoreCase("chrome"))
         driver=InitChromeDriver();
         else if(BrowserType.equalsIgnoreCase("firefox"))
         driver=InitFireFoxDriver();
     else if(BrowserType.equalsIgnoreCase("ie"))
         driver=InitIEDriver();
     else
         throw new RuntimeException("Invalid platform stated");
     driver.manage().window().maximize();
     driver.get(getData("url"));
     driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
     wait= new WebDriverWait(driver,Long.parseLong(getData("Timeout")));
     action=new Actions(driver);

     }

    public static WebDriver InitChromeDriver()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        return driver;
    }
    public static WebDriver InitFireFoxDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        return driver;
    }
    public static WebDriver InitIEDriver()
    {
        WebDriverManager.iedriver().setup();
        driver=new InternetExplorerDriver();
        return driver;
    }
    public static void initMobile()
    {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("APP_PACKAGE"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("APP_ACTIVITY"));
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), dc);
        }
        catch (MalformedURLException e) {
            System.out.println("Cannot connect to android URL, see details: " + e);
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("timeOut")), TimeUnit.SECONDS);
        managePages.init();
    }

    @AfterMethod
    public void AfterMethod()
    {
      driver.get(getData("url"));
    }

    @AfterClass
    public void AfterSession()
    {
       driver.quit();
    }
}
