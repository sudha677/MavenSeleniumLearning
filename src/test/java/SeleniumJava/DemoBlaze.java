package SeleniumJava;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class DemoBlaze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    // Create a new instance of ChromeDriver
	    WebDriver driver = new ChromeDriver();

	    try {
	        // Maximise the browser window
	        driver.manage().window().maximize();

	        // Navigate to the target Website
	        driver.get("http://www.demoblaze.com/");

	        // Get the title of the page
	        String actualTitle = driver.getTitle();

	        // Verify the title
	        if (actualTitle.equals("STORE")) {
	            System.out.println("Page landed on correct website");
	        } else {
	            System.out.println("Page not landed on correct website");
	        }

	    } finally {
	        // Close the browser
	        driver.quit();
	    }
	}


	}


