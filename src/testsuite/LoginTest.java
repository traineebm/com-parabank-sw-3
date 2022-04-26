package testsuite;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Finding the username field element
        sendTextToElement(By.name("username"),"Meera08");

        // Finding the password field element
        sendTextToElement(By.name("password"),"Asdfg10");

        // Finding the login button and clicking on it
        clickOnElement(By.xpath("//input[@value='Log In']"));

        //Verify the given text from the requirements 'Accounts Overview' text is display

        //Validate expected and actual text message
        verifyElements("Error message displayed","Accounts Overview",By.xpath("//a[contains(text(),'Accounts Overview')]"));
    }
    @Test
    public void verifyTheErrorMessage() {
        // Finding the username field element
        sendTextToElement(By.name("username"),"musafir007");

        // Finding the password field element
        sendTextToElement(By.name("password"),"powerBall");

        // Finding the login button and clicking on it
        clickOnElement(By.xpath("//input[@value='Log In']"));

        //verify the error message form the given text 'The username and password couldnot be verified.'

        //Validate expected and actual text message
        verifyElements("Error message not displayed","The username and password could not be verified.",By.xpath("//p[contains(text(),'The username and password could not be verified.')]"));
    }

    @Test
    public void userShouldLogOutSuccessfully() {
        // Finding the username field element
        sendTextToElement(By.name("username"),"Meera08");

        // Finding the password field element
        sendTextToElement(By.name("password"),"Asdfg10");
        // Finding the login button and clicking on it
        clickOnElement(By.xpath("//input[@value='Log In']"));

        // Finding the login out link and clicking on it
        clickOnElement(By.xpath("//a[contains(text(),'Log Out')]"));

        //verify the given text 'Customer Login' from the requirements

        //Validate expected and actual text message
        verifyElements("Error message not displayed","Customer Login",By.xpath("//h2[contains(text(),'Customer Login')]"));
    }
     @After
    public void tearDown(){
     closeBrowser();
     }
}
















