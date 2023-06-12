package page;

import base.Testbase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class AdminPage {


    @FindBy(xpath = "//a[@href='/web/index.php/admin/viewAdminModule']")
    private WebElement adminTab;

    @FindBy(xpath = "//*[@class='orangehrm-header-container']/button")
    private WebElement addButton;

    @FindBy(xpath = "//button[contains(.,'Search')]")
    private WebElement searchBtn;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginBtn;

    @FindBy(xpath = "//div//label[contains(.,'Username')]//..//..//input")
    protected WebElement usernameInput;

    @FindBy(css = ".oxd-grid-item:nth-of-type(1) .oxd-select-text.oxd-select-text")
    protected WebElement userRoleSelect;

    @FindBy(xpath = "//div[@class='oxd-autocomplete-wrapper']/div/input")
    protected WebElement employeeName;

    @FindBy(css = ".oxd-grid-item:nth-of-type(3) .oxd-select-text.oxd-select-text")
    protected WebElement userStatusSelect;

    @FindBy(xpath = "//div//label[contains(.,'Current')]//..//..//input")
    protected WebElement currentPasswordInput;

    @FindBy(xpath = "//div//label[not(contains(.,'Confirm'))]//..//..//input[@autocomplete='off'][contains(@type,'password')]")
    protected WebElement passwordInput;

    @FindBy(xpath = "//div//label[contains(.,'Confirm')]//..//..//input")
    protected WebElement confirmPasswordInput;

    @FindBy(xpath = "//button[contains(.,'Save')]")
    protected WebElement saveBtn;

    @FindBy(css = ".oxd-userdropdown-name")
    protected WebElement loggedInUser;

    @FindBy(css = ".oxd-toast--success")
    protected WebElement successMessage;


    //    public AdminPage(WebDriver driver) {
//        PageFactory.initElements(driver, this);
//    }
    public void AddUser(String username, String password) throws AWTException, InterruptedException {

        Robot robot = new Robot();
        adminTab.click();
        addButton.click();

        userRoleSelect.click();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        userStatusSelect.click();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

//        employeeName.sendKeys(name);
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(password);

        employeeName.sendKeys(loggedInUser.getText()+" ");
        Thread.sleep(5000);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        saveBtn.click();
    }

    public void verifySuccessMessage(){
        Assert.assertEquals("The message is not displayed",true,successMessage.isDisplayed());
    }
}
