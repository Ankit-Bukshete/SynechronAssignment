package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import page.AdminPage;
import page.LoginPage;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Testbase {
    public static WebDriver driver;
    public static Properties config;
    public LoginPage lp;
    public AdminPage ap;
    public Testbase(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\IdeaProjects\\SynechronBDDAssignment\\src\\test\\resources\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        LoadConfigProperty();
        driver.get(config.getProperty("LOGIN_URL"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        lp= PageFactory.initElements(driver, LoginPage.class);
        ap= PageFactory.initElements(driver, AdminPage.class);
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public void LoadConfigProperty() {
        try {
            config = new Properties();
            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + "//src//test//resources//config//config.properties");
            config.load(ip);

        } catch (Exception e) {
            //Nothing
        }

    }
}
