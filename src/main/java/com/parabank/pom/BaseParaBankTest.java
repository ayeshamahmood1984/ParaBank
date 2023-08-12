package com.parabank.pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v107.runtime.model.WebDriverValue;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.parabank.pom.util.General;

public abstract class BaseParaBankTest {
	protected WebDriver driver ;
private Properties properties;
//protected static WebDriver driver;
public BaseParaBankTest() {
	try {
	String filePath=System.getProperty("user.dir")+"\\src\\main\\resources\\properties";
	properties=new Properties(); 

		FileInputStream fileInputStream=new FileInputStream(filePath);
		properties.load(fileInputStream);
	} catch (FileNotFoundException e) {
	
		e.printStackTrace();
	} catch (IOException e) {
		
		e.printStackTrace();
	}

}
public String getUsername() {
return properties.getProperty("username");

}
public String getPassword() {
return properties.getProperty("password");
}

@BeforeMethod
public void browserLaunch() {
String Browsername=properties.getProperty("Browsername");
if (Browsername.equals("Firefox")) {
	WebDriver driver=new FirefoxDriver();
}else if (Browsername.equals("chrome")) {
	WebDriver driver=new ChromeDriver();
}else if (Browsername.equals("headless")) {
//LOGIN DISABLE
	System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
	
	WebDriver driver=new FirefoxDriver();
	//WebDriverManager.firefoxdriver().setup();
	FirefoxOptions options=new FirefoxOptions();
	options.addArguments("-headless");
	driver=new FirefoxDriver(options);
}else {
	System.out.println("No Browser found");
}
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(General.WAIT_TIME));
driver.manage().window().maximize();
driver.get(properties.getProperty("baseUrl"));
}
@AfterMethod
public void tearDown() {
driver.quit();
}
}