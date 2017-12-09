package Appiumdemo;
/**
 * @author Hamza Mani
 * @date   29.11.2017
 *
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class appiumTest {
	
		private WebDriver driver = null;
		@Before
		public void setUp() throws Exception
		{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "Motorola");
		capabilities.setCapability("platformVersion", "4.4.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.yammer.v1");
		capabilities.setCapability("appActivity", "com.yammer.droid.ui.LauncherActivity");
		try
		{
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub "),capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Thread.sleep(10000);
		}
		catch(MalformedURLException e)
		{
		e.printStackTrace();
		}
		}

		@Test
		public void Login() throws Exception
		{
		driver.findElement(By.xpath("//*[@name='Log In']")).click();
		List<WebElement> textFieldsList = driver.findElements(By.className("android.widget.EditText"));
		textFieldsList.get(0).sendKeys("gopikannan@xyz.com"); //Give your account username
		textFieldsList.get(1).sendKeys("asdfghjkl"); //Give your account password
		driver.findElement(By.id("com.yammer.v1:id/login_button")).click();
		Thread.sleep(10000);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //Taking screenshot
		FileUtils.copyFile(scrFile, new File("c:\\Temp\\screenshotGK.png"));
		}

		@After
		public void tearDown()
		{
		driver.quit();
		}

}
