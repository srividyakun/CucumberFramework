package de.check24.cucumberFramework.stepDefinitions;

import org.apache.log4j.Logger;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import de.check24.cucumberFramework.helpers.assertions.AssertionHelper;
import de.check24.cucumberFramework.helpers.assertions.VerificationHelper;
import de.check24.cucumberFramework.helpers.logger.LoggerHelper;
import de.check24.cucumberFramework.helpers.wait.WaitHelper;
import de.check24.cucumberFramework.pageObjects.HomePage;
import de.check24.cucumberFramework.pageObjects.LoginPage;
import de.check24.cucumberFramework.testBase.BrowserConfiguration;
import de.check24.cucumberFramework.testBase.ObjectReader;

public class LoginStepDefinitions extends BrowserConfiguration{

	LoginPage loginPage ;
	WaitHelper waitHelper;
	private Logger log = LoggerHelper.getLogger(LoginStepDefinitions.class);
	
	@Given("^User is on Login page URL \"([^\"]*)\"$")
    public void user_is_on_login_page_url_something(String strArg1) throws Throwable {
		    driver.get(strArg1);
		    loginPage = new LoginPage(driver);
		   
    }
	
	 @Then("^I should see Log In Page$")
	    public void i_should_see_log_in_page() throws Throwable {
		 waitHelper = new WaitHelper(driver);
		 waitHelper.waitForElement(loginPage.meineemailadresse,ObjectReader.reader.getExplicitWait());
		 log.info("log in page is displayed");
	    }

    @When("^I enter username as \"([^\"]*)\"$")
    public void i_enter_username_as_something(String userName) throws Throwable {
    	loginPage.enterEmail(userName);
    	log.info("Entered email");
    }

    @And("^I enter password as \"([^\"]*)\"$")
    public void i_enter_password_as_something(String password) throws Throwable {
    	loginPage.enterPassword(password);
    	log.info("Entered password");
    }

    @And("^click on login button$")
    public void click_on_login_button() throws Throwable {
    	loginPage.loginButton();
    	log.info("clicked on Sign in button");
    }
    
    @Then("^I sould see application homepage$")
    public void i_sould_see_application_homepage() throws Throwable {
    	boolean status=new VerificationHelper(driver).isDisplayed(loginPage.anmeldebestätigen);
    	
		if(status==true){
			AssertionHelper.updateTestStatusWithMessage(status, "User is able to Login successfully");
			log.info("User logged in successfully");			
		}else {
			AssertionHelper.updateTestStatusWithMessage(status, "User is not able to login");
			log.info("User not able to login successfully");
		}
	    
	}
    
}
