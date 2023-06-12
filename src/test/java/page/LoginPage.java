package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {


    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameInp;

    @FindBy (xpath = "//input[@name='password']")
    private WebElement passwordInp;

    @FindBy (xpath = "//button[@type='submit']")
    private WebElement loginBtn;

//    public AdminPage(WebDriver driver) {
//        PageFactory.initElements(driver, this);
//    }
    public void login(String username,String password){
        usernameInp.sendKeys(username);
        passwordInp.sendKeys(password);
        loginBtn.click();
    }


}
