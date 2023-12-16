import java.net.URI;
import java.util.function.Predicate;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuthentication {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		Predicate<URI> uriPredicate = uri -> uri.getHost().contains("https://conductor2501.fyre.ibm.com:8889/lab");
		
		((HasAuthentication)driver).register(uriPredicate,UsernameAndPassword.of("Admin", "Admin"));
		
		driver.get("https://conductor2501.fyre.ibm.com:8889/lab");
	}

}
