import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v119.network.model.Request;
import org.openqa.selenium.devtools.v119.network.model.Response;
import org.openqa.selenium.devtools.v119.network.Network;

public class NetworkLogActivity {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		devTools.addListener(Network.requestWillBeSent(), request -> 
		{
			Request req = request.getRequest();
			System.out.println(req.getUrl());
			
			
		});
		
		devTools.addListener(Network.responseReceived(), response-> 
		{
			Response res = response.getResponse();
			if(res.getStatus().toString().startsWith("4")) {
				System.out.println(res.getUrl() + " is failing with status code: " + res.getStatus());
			}
		});
		
		driver.get("https://www.google.com");
	}

}
