package de.check24.cucumberFramework.pageObjects;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import de.check24.cucumberFramework.helpers.logger.LoggerHelper;
import de.check24.cucumberFramework.helpers.wait.WaitHelper;
import de.check24.cucumberFramework.testBase.ObjectReader;

public class LoginPage {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(LoginPage.class);
	WaitHelper waitHelper;
	

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(siesindhieranmelden,ObjectReader.reader.getExplicitWait());
		
	}
	
	@FindBy(xpath = "//*[@id='c24-meinkonto']/span/span[2]")
	public WebElement meinKonto;
	@FindBy(xpath="//*[@id='email']")
	public WebElement meineemailadresse;
	@FindBy(xpath="//*[@id='password']")
	public WebElement meincheck24password;
	@FindBy(xpath="//*[@id='pw_reset_btn']")
	public WebElement passwordvergessen;
	@FindBy(xpath="//*[@id='new_customer']")
	public WebElement startensiehier;
	@FindBy(xpath="//*[@id='c24-kb-register-btn']")
	public WebElement anmeldentaste;
	@FindBy(xpath="//*[@id='oauth-container']/div/div[3]/div/div[1]/button")
	public WebElement facebookanmelden;
	@FindBy(xpath="//*[@id='oauth-container']/div/div[3]/div/div[2]/button")
	public WebElement googleanmelden;
	@FindBy(xpath="//*[@id='c24-breadcrumb']/div/ul/li/a")
	public WebElement siesindhieranmelden;
	@FindBy(xpath="//*[@id='c24-meinkonto']/div/div[2]/a")
	public WebElement abmelden;
	@FindBy(xpath="//*[@id='c24-kb-container']/div/div[1]/div/div/div/p[contains(text(),'Sie sind angemeldet')]")
	public WebElement anmeldebestätigen;
	@FindBy(xpath = "//*[@id='c24-customer-salutation']/a")
	public WebElement anmeldenlink;
	
	public void enterEmail(String emailaddress){
		log.info("Entering email address...");
		meineemailadresse.clear();
		meineemailadresse.sendKeys(emailaddress);
	}
	
	public void enterPassword(String password){
		log.info("Entering password...");
		meincheck24password.clear();
		meincheck24password.sendKeys(password);
	}
	
	public void loginButton(){
		log.info("Clicking on login...");
		anmeldentaste.click();
		
	}
	
	
	
}
