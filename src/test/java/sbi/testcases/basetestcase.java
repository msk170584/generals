package sbi.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.apache.commons.lang3.*;

import sbi.utilities.readconfig;

public class basetestcase{
	
	public static WebDriver driver;
	public static Logger logger;
	
	readconfig rd=new readconfig();
	
	public String browserpath=rd.getbrowser();
	public String baseurl=rd.getapplicationurl();
	public String loginid=rd.getloginid();
	public String pwd=rd.getpassword();
	
	@BeforeClass
	public void setup()
	{
		logger=Logger.getLogger(getClass());
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Invoke Browser");
		System.setProperty("webdriver.ie.driver", browserpath);
		driver=new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		logger.info("Invoke URL");
		driver.get(baseurl);
	}
	@AfterClass
	public void closebrowser()
	{
		logger.info("Close Browser");
		driver.close();
	}
	@AfterMethod
	public void capturescreenshot(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			TakesScreenshot ts=(TakesScreenshot) driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			File target= new File(System.getProperty("user.dir")+"/screenshots/"+result.getName()+".png");
			try {
				FileUtils.copyFile(source, target);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static String randomstring()
	{
		String getrandomstring1=RandomStringUtils.randomAlphabetic(4);
		return getrandomstring1;
	}
	public static String randomnumeric()
	{
		String getrandomstring2=RandomStringUtils.randomNumeric(4);
		return getrandomstring2;
	}
	public static String randomnumericforrollandaadhaar()
	{
		String rollnum=RandomStringUtils.randomNumeric(12);
		return rollnum;
	}
}
