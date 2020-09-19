package sbi.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import sbi.pageobjectmodel.pageobjects;

public class tc01_logintest extends basetestcase{
	
	@Test(priority=1)
	public void tc01_login()
	{
		pageobjects pom=new pageobjects(driver);
		pom.setloginid(loginid);
		pom.setpassword(pwd);
		pom.clklogin();
		if(driver.getTitle().equals("Ebix CMS"))
		{
			Assert.assertTrue(true);
			logger.info("tc01_login passed");
		}
		else
		{
			Assert.fail();
			logger.info("tc01_login failed");
		}
	}
	//Enrollment Screen
	@Test(dependsOnMethods={"tc01_login"})
	public void tc02_enrollmenttab() throws InterruptedException
	{
		pageobjects pom=new pageobjects(driver);
		pom.getenrollmenttab();
		if(driver.findElement(By.xpath("//input[@name='clickPull']//following::td[1]")).getText().equals("Search Agent"))
		{
			Assert.assertTrue(true);
			logger.info("tc02_enrollmenttab passed");
		}
		else
		{
			Assert.fail();
			logger.info("tc02_enrollmenttab failed");
		}
	}
	/*
	//SearchAgent
	@Test(dependsOnMethods= {"tc02_enrollmenttab"})
	public void tc03_searchagent() throws InterruptedException
	{
		pageobjects pom=new pageobjects(driver);
		String fn="sbi_automate_fn_tc"+randomnumeric();
		pom.setfirstname(fn);
		System.out.println(fn);
		String ln="sbi_automate_ln_tc"+randomnumeric();
		pom.setlastname(ln);
		System.out.println(ln);
		pom.setagentdob("29/05/1988");
		String pan="sbitc"+randomnumeric()+"a";
		pom.setagentpan(pan);
		System.out.println(pan);
		pom.clksearch();
		driver.switchTo().frame("SearchAgentDshbrd");//as he element present inside frame so we are switching to frame.
		if(driver.findElement(By.xpath("//td[@colspan='10' and @class='record']")).getText().equals("No Records Found"))
		{
		   Assert.assertTrue(true);
		   logger.info("tc03_searchagent passed");
		}
		else
		{
			Assert.fail();
			logger.info("tc03_searchagent failed");
		}
		driver.switchTo().defaultContent();// to come out of the frame and proceed with page.
	}
	//CreateAgentoptions
	@Test(dependsOnMethods= {"tc03_searchagent"})
	public void tc04_createagentoptions()
	{
		pageobjects pom=new pageobjects(driver);
		pom.clkcreateagent();
		if(driver.findElement(By.xpath("//td[@class='page_title' and contains(text(),'Create Prospect')]")).getText().equals("Create Prospect"))
		{
			Assert.assertTrue(true);
			logger.info("tc04_createagentoptions passed");
		}
		else
		{
			Assert.fail();
			logger.info("tc04_createagentoptions failed");
		}
	}
	//CreateAgent
	@Test(dependsOnMethods= {"tc04_createagentoptions"})
	public void tc05_createagent()
	{
		pageobjects pom=new pageobjects(driver);
		pom.setagenttype();
		pom.setenrollmenttype();
		pom.clkgo();
		if(driver.findElement(By.xpath("//*[text()='Basic Details']")).getText().equals("Basic Details"))
		{
			Assert.assertTrue(true);
			logger.info("tc05_createagent passed");
		}
		else
		{
			Assert.fail();
			logger.info("tc05_createagent failed");
		}
	}
	//SaveBasicDetails
	@Test(dependsOnMethods= {"tc05_createagent"})
	public void tc06_savebasicdetails()
	{
		pageobjects pom=new pageobjects(driver);
		pom.clkbasicdetailssave();
		if(driver.findElement(By.xpath("//td[@class='errorblue']")).getText().equals("Record has been inserted successfully."))
		{
			Assert.assertTrue(true);
			logger.info("tc06_savebasicdetails passed");
		}
		else
		{
			Assert.fail();
			logger.info("tc06_savebasicdetails failed");
		}
	}
	//PersonalInformation
	@Test(dependsOnMethods= {"tc06_savebasicdetails"})
	public void tc07_personalinformation()
	{
		pageobjects pom=new pageobjects(driver);
		pom.clkpersonalinfo();
		if(driver.findElement(By.xpath("//*[text()='Personal Information']")).getText().equals("Personal Information"))
		{
			Assert.assertTrue(true);
			logger.info("tc07_personalinformation passed");
		}
		else
		{
			Assert.fail();
			logger.info("tc07_personalinformation failed");
		}
	}
	//save Personal Information
	@Test(dependsOnMethods= {"tc07_personalinformation"})
	public void tc08_savepersonalinformation()
	{
		pageobjects pom=new pageobjects(driver);
		pom.settitle();
		pom.setgender();
		pom.setmarried();
		pom.setqualification();
		String rollnum=randomnumericforrollandaadhaar();
		pom.setrollnumber(rollnum);
		pom.setboardname("SSLC");
		pom.setfathername("JohnSmith");
		pom.setrelationwith();
		pom.setproqualification();
		pom.clkcalendar();
		pom.setyearofpassing();
		pom.setcategory();
		String aadhaar=randomnumericforrollandaadhaar();
		pom.setaadhaar(aadhaar);
		pom.clkpersonalinfosave();
		if(driver.findElement(By.xpath("//td[@class='errorblue']")).getText().equals("Record has been updated successfully."))
		{
			Assert.assertTrue(true);
			logger.info("tc08_savepersonalinformation passed");
		}
		else
		{
			Assert.fail();
			logger.info("tc08_savepersonalinformation failed");
		}
	}*/
}
