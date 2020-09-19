package sbi.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import sbi.pageobjectmodel.pageobjects;

public class tc02_enrollmentpg extends basetestcase {
	
	@Test()
	public void tc02_enrollmenttab() throws InterruptedException
	{
		pageobjects pom=new pageobjects(driver);
		pom.setloginid(loginid);
		pom.setpassword(pwd);
		pom.clklogin();
		Thread.sleep(5000);
		pom.getenrollmenttab();
		if(driver.findElement(By.xpath("//input[@name='clickPull']//following::td[1]")).getText().equals("Search Agent"))
		{
			Assert.assertTrue(true);
			logger.info("tc02-enrollmentpage");
		}
		else
		{
			Assert.fail();
		}
		
	}

}
