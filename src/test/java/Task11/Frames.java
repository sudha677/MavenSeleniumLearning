package Task11;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Step1:Open the URL
		
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Switch to the top frame
		
		driver.switchTo().frame("frame-top");

		//Verify that there are 3 Frames on the Page
		List <WebElement> framesInSideTopFrame =driver.findElements(By.xpath("//frame[contains(@name, 'frame')]"));
		
		int numberOfFramesInTopFrame = framesInSideTopFrame.size();
		
		System.out.println("Number of Frames inside Top Frame: "+numberOfFramesInTopFrame);
		
		if (numberOfFramesInTopFrame == 3){
			
			System.out.println("There are 3 Frames on the Page and so Verification Passed");
		}
		else {
			System.out.println("Verification of 3 Frames on the Page is Failed");
		}
		
		//Switch to Top Left Frame
		
		driver.switchTo().frame("frame-left");
		
		//Verify that the left frame has a text "LEFT"
		String leftFrameText = driver.findElement(By.xpath("//body")).getText();
		
		System.out.println("Text on the Left Frame: "+leftFrameText);
		
		if(leftFrameText.equals("LEFT")) {			
			System.out.println("Left Frame Text Verification Passed");
		}
		else {
			System.out.println("Left Frame Text Verification Failed");
		}
		
		//Switch back to the top frame
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-top");
		
		//Switch to the middle frame
		driver.switchTo().frame("frame-middle");
		
		//Verify that the left frame has a text "MIDDLE"
		String middleFrameText = driver.findElement(By.xpath("//body")).getText();
		System.out.println("Text on the Middle Frame: "+middleFrameText);
		if(middleFrameText.equals("MIDDLE")) {			
			System.out.println("Middle Frame Text Verification Passed");
		}
		else {
			System.out.println("Middle Frame Text Verification Failed");
		}
		
		//Switch back to the top frame
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-top");
		
		//Switch to the right frame
		driver.switchTo().frame("frame-right");
		
		//Verify that the right frame has a text "RIGHT"
		String rightFrameText = driver.findElement(By.xpath("//body")).getText();
		System.out.println("Text on the Right Frame: "+rightFrameText);
		if(rightFrameText.equals("RIGHT")) {			
			System.out.println("Right Frame Text Verification Passed");
		}
		else {
			System.out.println("Right Frame Text Verification Failed");
		}

		//Switch back to the top frame
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-top");
		
		//Switch to the bottom frame
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-bottom");
		
		//Verify that the bottom frame has a text "BOTTOM"
		String bottomFrameText = driver.findElement(By.xpath("//body")).getText();
		System.out.println("Text on the Bottom Frame: "+bottomFrameText);
		if(bottomFrameText.equals("BOTTOM")) {			
			System.out.println("Bottom Frame Text Verification Passed");
		}
		else {
			System.out.println("Bottom Frame Text Verification Failed");
		}

		//Switch back to the top frame
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-top");
		
		//Close the Browser Instance
		driver.quit();

	}

}
