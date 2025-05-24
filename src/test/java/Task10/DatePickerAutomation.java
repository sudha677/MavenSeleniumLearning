package Task10;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerAutomation {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Step 1: Navigate to the jQuery UI Datepicker page
        driver.get("https://jqueryui.com/datepicker/");

        // Step 2: Switch to iframe
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        // Step 3: Open the date picker
        WebElement dateInput = driver.findElement(By.id("datepicker"));
        
        dateInput.click();

        // Step 4: Navigate to desired month (e.g., May)
        String desiredMonth = "May";
        String currentMonth = driver.findElement(By.className("ui-datepicker-month")).getText();

        while (!currentMonth.equalsIgnoreCase(desiredMonth)) {
            driver.findElement(By.className("ui-datepicker-next")).click();
            currentMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
        }

        // Step 5: Select date "22"
        driver.findElement(By.xpath("//a[text()='22']")).click();

        // Step 6: Print the selected date
        
        String selectedDate = dateInput.getAttribute("value");
        System.out.println("Selected Date: " + selectedDate);

        // Step 7: Close and quit the browser
        driver.quit();
	}

}
