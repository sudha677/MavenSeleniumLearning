package Task10;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        try {
            // Navigate to the draggable demo site
            driver.get("https://jqueryui.com/droppable/");

            // Switch to the frame that contains the draggable elements
            driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));

            // Find the source and target elements
            WebElement source = driver.findElement(By.id("draggable"));
            WebElement target = driver.findElement(By.id("droppable"));

            // Perform drag and drop
            Actions actions = new Actions(driver);
            actions.dragAndDrop(source, target).perform();

            // Wait for a short time to observe the drop result (optional)
            Thread.sleep(1000);

            // Verify the drop action
            String droppedText = target.getText();
            String backgroundColor = target.getCssValue("background-color");

            System.out.println("Dropped Text: " + droppedText);
            System.out.println("Background Color: " + backgroundColor);

            if (droppedText.equals("Dropped!") && backgroundColor != null) {
                System.out.println("Drag and Drop operation successful!");
            } else {
                System.out.println("Drag and Drop operation failed.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }


	}

}
