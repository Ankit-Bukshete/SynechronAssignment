package stepDefinitions;

import base.Testbase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.util.Random;


public class AdminStepDef extends Testbase {
    public static WebDriver driver;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {

    }
    @When("the user enters the {string} and {string}")
    public void the_user_enters_the_and(String username, String password) {
        lp.login(username, password);
    }

    @When("the user adds new Admin {string}")
    public void the_user_adds_new_admin( String username) throws AWTException, InterruptedException {
        String randomString = generateRandomString();
        ap.AddUser( username + randomString, "pwd"+randomString);
    }

    private String generateRandomString() {

        int min = 10000;
        int max = 40000;

        System.out.println("Random value of type double between " + min + " to " + max + ":");
        double a = Math.random() * (max - min + 1) + min;
        System.out.println(a);

        System.out.println("Random value of type int between " + min + " to " + max + ":");
        int b = (int) (Math.random() * (max - min + 1) + min);
        System.out.println(b);
        return Integer.toString(b);
    }

    @Then("add user success message should be displayed")
    public void add_user_success_message_should_be_displayed() {
        ap.verifySuccessMessage();

    }
}
