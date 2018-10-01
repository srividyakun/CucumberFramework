package de.check24.cucumberFramework.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import de.check24.cucumberFramework.helpers.logger.LoggerHelper;
import de.check24.cucumberFramework.helpers.wait.WaitHelper;
import de.check24.cucumberFramework.testBase.ObjectReader;

public class HomePage {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(HomePage.class);
	WaitHelper waitHelper;
	

	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(anmeldebestätigen,ObjectReader.reader.getExplicitWait());
		//new TestBase().getNavigationScreen(driver);
		//TestBase.logExtentReport("LandingPage Object Created");
	}
	
	@FindBy(xpath="//*[@id='c24-kb-container']/div/div[1]/div/div/div/p[contains(text(),'Sie sind angemeldet')]")
	public WebElement anmeldebestätigen;
	@FindBy(xpath="//*[@id='c24-meinkonto']/div/div[2]/a")
	public WebElement abmelden;
	@FindBy(xpath="//*[@id='c24-header-bottom']/div/nav/div/div[2]/ul/li[2]/a")
	public WebElement kontokreditlink;
	@FindBy(xpath="//*[@id='c24-fin']/li[2]/ul/li[2]/a")
	public WebElement festgeldlink;
	@FindBy(xpath="//*[@id='tm-invAmount']")
	public WebElement geplanteranlagebtrag;
	@FindBy(xpath="//*[@id='tm-invDuration']")
	public WebElement geplanteranladauer;
	@FindBy(xpath="//*[@id='form']/div/div[3]/input")
	public WebElement festgeldvergleich;
	
	
	

	}
