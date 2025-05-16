package SeleniumJava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SampleSeleniem {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new EdgeDriver();
		driver.get("https://WWW.Saucedemo.com/");
		driver.manage().window().maximize();
		 close();
		
		

	}

	private static void close() {
		// TODO Auto-generated method stub
		
	}

}
