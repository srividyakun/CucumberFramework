package de.check24.cucumberFramework.helpers.assertions;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import de.check24.cucumberFramework.helpers.logger.LoggerHelper;
import de.check24.cucumberFramework.helpers.wait.WaitHelper;
import de.check24.cucumberFramework.testBase.ObjectReader;

public class VerificationHelper {

	WaitHelper waitHelper;
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(VerificationHelper.class);
	
    public VerificationHelper(WebDriver driver){
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
    
    public boolean isDisplayed(WebElement element) {
    	try {
    		waitHelper = new WaitHelper(driver);
    		waitHelper.waitForElement(element,ObjectReader.reader.getExplicitWait());
    		element.isDisplayed();
    		log.info("element is displayed.." + element.getText());
    		return true;
    	}catch(Exception e) {
    		log.error("element is not displayed" + e.getCause());
    		return false;
    	}
    }
    	public boolean isNotDisplayed(WebElement element) {
        	try {
        		element.isDisplayed();
        		log.info("element is displayed.." + element.getText());
        		return false;
        	}catch(Exception e) {
        		log.error("element is not displayed");
        		return true;
        	}
		
    	
    }
    	public String readValueFromElement(WebElement element) {
    		if(null==element) {
    			log.info("WebElement is null");
    			return null;
    		}
    		boolean status= isDisplayed(element);
    		if(status) {
    			log.info("element text is " +element.getText());
    		    return element.getText();
    		}else {
    			return null;
    		}
			
    		
    	}
    	
    	public String getText(WebElement element) {
    		if(null==element) {
    			log.info("WebElement is null");
    			return null;
    		}
    		boolean status= isDisplayed(element);
    		if(status) {
    			log.info("element text is " +element.getText());
    		    return element.getText();
    		}else {
    			return null;
    		}
			
    		
    	}
}
