package PageObject;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import BaseDriver.Basepage;
import org.testng.Assert;


public class SignupPage extends Basepage {

	String emailId;
	
	@FindBy(linkText="Create an Account")WebElement creatuserlink;
	@FindBy(xpath="//span[text()='Create New Customer Account']")WebElement createusertitle;
	@FindBy(xpath="//span[text()='Personal Information']")WebElement personalinfo;
	@FindBy(id="firstname")WebElement fname;
	@FindBy(id="lastname")WebElement lname;
	@FindBy(xpath="//span[text()='Sign-in Information']")WebElement signininfo;
	@FindBy(id="email_address")WebElement emailfield;
	@FindBy(id="password")WebElement pwd;
	@FindBy(id="password-confirmation")WebElement cnfmpwd;
	@FindBy(xpath="//button[@title= 'Create an Account']")WebElement createuserbtn;
	@FindBy(xpath="//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")WebElement usercreatedmsg;
	@FindBy(xpath="/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")WebElement dropdown;
	@FindBy(linkText="Sign Out")WebElement signoutbtn;
	@FindBy(linkText="Sign In")WebElement signInbtn; 
	@FindBy(xpath="//input[@id='email']")WebElement emailfieldlog;
	@FindBy(xpath="//input[@title='Password']")WebElement pwdfield;
	@FindBy(xpath="//button[@name='send' and @class='action login primary']")WebElement signIn;
	
	
	
	public SignupPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	
		}
	
	public void enterFirstName(String firstname) {
		creatuserlink.click();
		fname.click();;
        fname.sendKeys(firstname);
    }

    public void enterLastName(String lastname) {
    	lname.click();
        lname.sendKeys(lastname);
        
    }

    public void enterEmail() {
    	emailfield.click();
    	// create a emailstring of all characters
	    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	    // create random string builder
	    StringBuilder sb = new StringBuilder();

	    // create an object of Random class
	    Random random = new Random();

	    // specify length of random string
	    int length = 7;

	    for(int i = 0; i < length; i++) {

	      // generate random index number
	      int index = random.nextInt(alphabet.length());

	      // get character specified by index
	      // from the string
	      char randomChar = alphabet.charAt(index);

	      // append the character to string builder
	      sb.append(randomChar);
	     
	    }
	    sb.append("@gmail.com");

	    emailId = sb.toString();
	    
	    emailfield.sendKeys(emailId);
	    
	    
	    
    }

    public void enterPassword(String password) {
    	pwd.click();
        pwd.sendKeys(password);
    }

    public void confirmPassword(String cpassword) {
    	cnfmpwd.click();
    	cnfmpwd.sendKeys(cpassword);
    }
    
    
    public void submitbtn() throws Exception {
    	createuserbtn.click();
    	
    	String usercreationmsg=usercreatedmsg.getText();
    	
    	
    	Assert.assertEquals(usercreationmsg, getData("createdusermsg"));
    	
    }
    
    public void logout() throws Exception {
    	Thread.sleep(2000);
    	dropdown.click();
    	signoutbtn.click();
    
    }
    
    
    public void login() {
    	
    	signInbtn.click();
    	emailfieldlog.click();
    	emailfieldlog.sendKeys(emailId);
    	pwdfield.click();
    	pwdfield.sendKeys("Pravin@28");
    	signIn.click();
    	
    	
    }
    
    
    
    
	
	
	
	
	
	

}
