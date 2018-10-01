package de.check24.cucumberFramework.stepDefinitions;

import java.io.IOException;


import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import de.check24.cucumberFramework.helpers.logger.LoggerHelper;
import de.check24.cucumberFramework.testBase.BrowserConfiguration;
import de.check24.cucumberFramework.testBase.ObjectReader;
import de.check24.cucumberFramework.testBase.PropertyReader;

public class ServiceHooks {

	BrowserConfiguration browserConfiguration;

	Logger log = LoggerHelper.getLogger(ServiceHooks.class);

	@Before
	public void initializeTest() throws IOException {
		browserConfiguration = new BrowserConfiguration();
		ObjectReader.reader = new PropertyReader();
		browserConfiguration.initializeWebdriver();
	}

	@After
	public void endTest(Scenario scenario) {
		if (scenario.isFailed()) {

			try {
				log.info(scenario.getName() + " is Failed");
				final byte[] screenshot = ((TakesScreenshot) BrowserConfiguration.driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png"); // ... and embed it in
			} catch (WebDriverException e) {
				e.printStackTrace();
			}

		} else {
			try {
				log.info(scenario.getName() + " is pass");
				scenario.embed(((TakesScreenshot) BrowserConfiguration.driver).getScreenshotAs(OutputType.BYTES), "image/png");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		BrowserConfiguration.driver.quit();
	}
}