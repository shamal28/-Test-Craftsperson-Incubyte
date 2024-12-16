package StepDefinitions;



import BaseDriver.Basepage;
import PageObject.SignupPage;
import Utils.Screenshot;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Signupsteps extends Basepage{
	public static SignupPage sp;
	Screenshot sc;
	
	@Given("user launches browser and provide url")
	public void user_launches_browser_and_provide_url() throws Exception {
		browserlaunch(getData("url")); 
	}

	@When("user enter valid {string} and {string} and email and {string}")
	public void user_enter_valid_and_and_email_and(String firstname, String lastname, String password) {
	    sp=new SignupPage(driver);
	    sp.enterFirstName(firstname);
	    sp.enterLastName(lastname);
	    sp.enterEmail();
	    sp.enterPassword(password);
	    
	}

	@And("user confirms {string}")
	public void user_confirms(String cpassword) {
		sp.confirmPassword(cpassword);
	}

	@And("user click on creat and user button")
	public void user_click_on_creat_and_user_button() throws Exception {
	   sp.submitbtn();
	}


	@Then("user logs in with same credentials")
	public void user_logs_in_with_same_credentials() throws Exception {
	    sp.logout();
	    sp.login();
	}



	
}
