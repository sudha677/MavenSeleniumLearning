package SeleniumJava;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    // Initialise the Amazon WebDriver
	    WebDriver driver = new FirefoxDriver();
	    	   
	    try {
	        // Maximise the browser window
	        driver.manage().window().maximize();

	        // Navigate to Google
	        driver.get("http://google.com");

	        // Print the current page URL
	        System.out.println("Current URL: " + driver.getCurrentUrl());

	        // Reload the page
	      driver.navigate().refresh();

	    } finally {
	        // Close the browser
	        driver.close();
	    }
	}
}

		