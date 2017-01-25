import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class tests {
	static public AppiumDriver driver;
	//static private static AndroidDriver<WebElement> driver;
	static WebElement element;
	static File classpathRoot = new File(System.getProperty("user.dir"));
	static File appDir = new File(classpathRoot, "/Twitter");
	static File app = new File(appDir, "twitter.apk");
	
	
	@BeforeClass
	static public void setUp() throws MalformedURLException{

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, ""); //Name of mobile web browser to automate. Should be an empty string if automating an app instead.
		capabilities.setCapability("platformName", "Android");
		//capabilities.setCapability(CapabilityType.VERSION, "4.2.2");
		capabilities.setCapability("deviceName", "192.168.226.101:5555");
		//capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.twitter.android");
		capabilities.setCapability("appActivity", "com.twitter.android.LoginActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	
	@After
	public void aftertest() {
		driver.quit(); 
	}
	@Test
	public void test1() throws Exception {
		Thread.sleep(1000);
		List<WebElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
		textFieldsList.get(0).sendKeys("1234");
		textFieldsList.get(1).sendKeys("123456");
		driver.findElement(By.name("Log in")).click();		
		Thread.sleep(3000);
		
	}
	@Test
	public void test2() throws Exception {
		
		List<WebElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
		textFieldsList.get(0).clear();
		textFieldsList.get(0).sendKeys("aigulka095@gmail.com");
		textFieldsList.get(1).sendKeys("********");		
		driver.findElement(By.name("Log in")).click();
		Thread.sleep(9000);
	}
	@Test
	public void test3() throws Exception {
		driver.findElement(By.name("Search")).click();
		driver.findElement(By.name("Search Twitter")).sendKeys("@valeriemorphine");
		Thread.sleep(5000);
		driver.findElement(By.name("Валерия Волковая")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("Follow")).click();
		Thread.sleep(5000);	
		driver.findElement(By.id("com.twitter.android:id/action_button")).click();
		Thread.sleep(5000);	
		
	}
	
	@Test
	public void test4() throws Exception {
		driver.findElement(By.id("com.twitter.android:id/composer_write")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("com.twitter.android:id/tweet_text")).sendKeys("TestTweet");
		Thread.sleep(1000);
		
		driver.findElement(By.name("Tweet")).sendKeys("@valeriemorphine");
		Thread.sleep(5000);	
	}
	
	@Test
	public void test5() throws Exception
	{
		driver.findElement(By.id("com.twitter.android:id/drawer_icon")).click();	
		driver.findElement(By.name("Settings")).click();
		driver.findElement(By.name("Sign out")).click();
		driver.findElement(By.name("OK")).click();
	}
}
