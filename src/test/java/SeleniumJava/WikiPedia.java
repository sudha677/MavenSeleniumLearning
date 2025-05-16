package SeleniumJava;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WikiPedia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

		 
		try {
	            // Open Wikipedia
	            
				driver.get("http://www.wikipedia.org/");
	            driver.manage().window().maximize();

	            // Search for "Artificial Intelligence"
	            WebElement searchInput = driver.findElement(By.id("searchInput"));
	            searchInput.sendKeys("Artificial Intelligence");
	            searchInput.submit();

	            // Wait until article loads
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstHeading")));

	            // Scroll to the History section
	            //WebElement historySection = driver.findElement(By.cssSelector("#toc-History > a:nth-child(1) > div:nth-child(1) > span:nth-child(2)"));
	            WebElement historySection = driver.findElement(By.xpath("//a/div/span[text()='History']"));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", historySection);

	            // Print the section title
	            System.out.println("Section Title: " + historySection.getText());

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            driver.quit();
	        }
	}

	}