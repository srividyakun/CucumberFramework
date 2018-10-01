package de.check24.cucumberFramework.testBase;


public interface ConfigReader {

	
		
		public int getImpliciteWait();
		public int getExplicitWait();
		public int getPageLoadTime();
		public int getPollingMillSeconds();
		public String browserType();
		public String getUrl();
		public String getUserName();
		public String getPassword();
		

	
}
