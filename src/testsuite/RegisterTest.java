package testsuite;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){
        //Find register link element and click on register link
        clickOnElement(By.linkText("Register"));

        //Validate expected and actual message
        verifyElements("Incorrect details: Please try again","Signing up is easy!",By.xpath("//h1[contains(text(),'Signing up is easy!')]"));
    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
        //Find register link element and click on register link
        clickOnElement(By.linkText("Register"));

        // Finding the first name element
        sendTextToElement(By.name("customer.firstName"),"Meera");

        // Finding the last name element
        sendTextToElement(By.name("customer.lastName"),"Parmar");

        // Finding the address element
        sendTextToElement(By.id("customer.address.street"),"10 Brixton Road");

        // Finding the element of city
        sendTextToElement(By.id("customer.address.city"),"Watford");

        // Finding the element of state
        sendTextToElement(By.id("customer.address.state"),"UK");

        // Finding the element of zipcode
        sendTextToElement(By.id("customer.address.zipCode"),"WD24 4DX");

        // Finding the element of phone number
        sendTextToElement(By.id("customer.phoneNumber"),"7790697597");

        // Finding the element of SSN
        sendTextToElement(By.id("customer.ssn"),"123456");

        // Finding the username field element
        sendTextToElement(By.name("customer.username"),"Meera08");

        // Finding the password field element
        sendTextToElement(By.name("customer.password"),"Asdfg10");

        // Finding the confirm field element
        sendTextToElement(By.name("repeatedPassword"),"Asdfg10");

        // Finding the register button and clicking on it
        clickOnElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));

        //Verify the given text from the requirements 'Your account was created successfully. You are now logged in.'

        //Validate expected and actual text message
        verifyElements("Error message displayed","Your account was created successfully. You are now logged in.",By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
    }
    @After
    public void tearDown(){
      closeBrowser();
    }
}
