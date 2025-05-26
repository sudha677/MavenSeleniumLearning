package Task11;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Step1:Open the URL
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Step 2: Click Here on the button
		WebElement ClickHere = driver.findElement(By.xpath("//a[text()='Click Here']"));
		ClickHere.click();

		// Step 3: Get the main window handle
		String mainWindow = driver.getWindowHandle();

		// Step 4: Switch to the child window/New window and get the Title
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindow)) {
				driver.switchTo().window(handle);
				String newWindowTitle = driver.getTitle();
				System.out.println("Switched to new Window: " + newWindowTitle);
				// Step 6: Verify the text "New Window" present on the page
				newWindowTitle.equals("New Window");
				// Step 6: Close the new window
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		// Step 7: Verify that the original window is Active
		if (driver.getWindowHandle().equals(mainWindow)) {
			System.out.println("Main/original window is currently active.");
		}
		// Step 8: Close the Browser instance
		driver.quit();

	}

}
