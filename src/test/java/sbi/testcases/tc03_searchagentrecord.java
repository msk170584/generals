package sbi.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import sbi.pageobjectmodel.pageobjects;

public class tc03_searchagentrecord extends basetestcase{
	
	@Test()
	public void tc03_searchagent()
	{
		pageobjects pom=new pageobjects(driver);
		pom.setloginid(loginid);
		pom.setpassword(pwd);
		pom.clklogin();
		pom.getenrollmenttab();
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
		if(driver.findElement(By.xpath("//td[@class='record']")).getText().equals("No Records Found"))
		{
		   Assert.assertTrue(true);
		   logger.info("tc03-NoRecordFound for Search agent");
		}
		else
		{
			Assert.fail();
		}
		
	}

}
