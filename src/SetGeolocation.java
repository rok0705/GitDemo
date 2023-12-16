import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.emulation.Emulation;

public class SetGeolocation {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		// send command to CDP
		Map<String, Object> coordinates = new HashMap<String, Object>();
		coordinates.put("latitude", 37.566536);
		coordinates.put("longitude", 126.977966);
		coordinates.put("accuracy", 1);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		
		driver.get("https://my-location.org/");
		
//		driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
//		
//		Thread.sleep(500);
//		
//		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
//		 
//		Thread.sleep(500);
//		
//		System.out.println(driver.findElement(By.cssSelector("h1")).getText());
		
	}

}
