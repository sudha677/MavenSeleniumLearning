package Task10;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SignUpLoginProcess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Step 1: Launch the GUVI website
            driver.get("https://www.guvi.in/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            // Step 2: Click on the Signup button
            WebElement signUpButton = driver.findElement(By.xpath("//a[text()='Sign up']"));
            signUpButton.click();
           
            // Step 3: Fill the signup form
            WebElement fullName = driver.findElement(By.id("name"));
            fullName.sendKeys("Test User");
            
            String email = "testuser" + System.currentTimeMillis() + "@mail.com"; // unique email
            System.out.println();
    		driver.findElement(By.id("email")).sendKeys(email);
			
            driver.findElement(By.id("password")).sendKeys("Test@12345");
            
            driver.findElement(By.id("mobileNumber")).sendKeys("9876543210");

            // Step 4: Click on Sign up
            driver.findElement(By.id("signup-btn")).click();

            // Step 5: Wait and verify registration success
            Thread.sleep(5000); // wait for page redirect or success indicator
            boolean isSignupSuccessful = driver.getPageSource().contains("Welcome") || driver.getCurrentUrl().contains("dashboard");
            System.out.println("Signup Successful: " + isSignupSuccessful);


            // Step 6: Click on Login (may need to logout first if still logged in)
            driver.get("https://www.guvi.in/"); // return to homepage
            WebElement loginBtn = driver.findElement(By.id("login-btn"));
            loginBtn.click();
            Thread.sleep(2000); // wait for login form

            // Step 7: Fill login form
            driver.findElement(By.id("email")).sendKeys(email);
            driver.findElement(By.id("password")).sendKeys("Test@12345");

            // Step 8: Click on Sign up button
            driver.findElement(By.id("login-btn")).click();

            // Step 9: Wait and verify login
            Thread.sleep(5000);
            boolean isLoginSuccessful = driver.getPageSource().contains("Welcome") || driver.getCurrentUrl().contains("dashboard");
            System.out.println("Login Successful: " + isLoginSuccessful);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Step 10: Close the browser
            driver.quit();
        }


	}

}
