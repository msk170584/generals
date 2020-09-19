package sbi.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class pageobjects {
	
	public WebDriver ldriver;
	
	public pageobjects(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	//Identifying the WebElements
	//login and home page
	@FindBy(xpath="//input[@name='loginId']")
	@CacheLookup
	WebElement txtloginid;
	@FindBy(xpath="//input[@name='password']")
	@CacheLookup
	WebElement txtpassword;
	@FindBy(xpath="//button[@name='btnSubmit']")
	@CacheLookup
	WebElement btnlogin;
	@FindBy(xpath="//td[@class='info_logout']")
	@CacheLookup
	WebElement lnklogout;
	//actions provided for the WebElements
	public void setloginid(String login)
	{
		txtloginid.sendKeys(login);
	}
	public void setpassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	public void clklogin()
	{
		btnlogin.click();
	}
	public void clklogout()
	{
		lnklogout.click();
	}
	//enrollment page
	@FindBy(xpath="//td[contains(text(),'Enrollment')]")
	@CacheLookup
	WebElement btnenroll;
	public void getenrollmenttab()
	{
		btnenroll.click();
	}
	//search agent record
	@FindBy(xpath="//input[@name='objSearchAgentDTO.firstName']")
	@CacheLookup
	WebElement txtfirstname;
	public void setfirstname(String agentfn)
	{
		txtfirstname.sendKeys(agentfn);
	}
	@FindBy(xpath="//input[@name='objSearchAgentDTO.lastName']")
	@CacheLookup
	WebElement txtlastname;
	public void setlastname(String agentln)
	{
		txtlastname.sendKeys(agentln);
	}
	@FindBy(xpath="//input[@name='objSearchAgentDTO.DOB']")
	@CacheLookup
	WebElement txtdob;
	public void setagentdob(String agentdob)
	{
		txtdob.sendKeys(agentdob);
	}
	@FindBy(xpath="//input[@name='objSearchAgentDTO.panNo']")
	@CacheLookup
	WebElement txtpan;
	public void setagentpan(String agentpan)
	{
		txtpan.sendKeys(agentpan);
	}
	@FindBy(xpath="//input[@name='ser']")
	@CacheLookup
	WebElement btnsearch;
	public void clksearch()
	{
		btnsearch.click();
	}
	//create agent
	@FindBy(xpath="//input[@name='createAgent']")
	@CacheLookup
	WebElement clkcreateagent;
	public void clkcreateagent()
	{
		clkcreateagent.click();
	}
	@FindBy(xpath="//select[@name='objSearchAgentDTO.agencyType']")
	@CacheLookup
	WebElement drpagenttype;
	public void setagenttype()
	{
		Select agentype=new Select(drpagenttype);
		agentype.selectByVisibleText("Insurance Advisor");
	}
	@FindBy(xpath="//select[@name='objSearchAgentDTO.selectType']")
	@CacheLookup
	WebElement drpenrollmenttype;
	public void setenrollmenttype()
	{
		Select enrollmenttype=new Select(drpenrollmenttype);
		enrollmenttype.selectByVisibleText("New");
	}
	@FindBy(xpath="//input[@value='Go']")
	@CacheLookup
	WebElement btngo;
	public void clkgo()
	{
		btngo.click();
	}
	//save Basic Details
	@FindBy(xpath="//input[@name='btnSaveDraft']")
	@CacheLookup
	WebElement clksave;
	public void clkbasicdetailssave()
	{
		clksave.click();//*[text()='Record has been inserted successfully.']
	}
	//Personal Information
	@FindBy(xpath="//td[@id='TD22']")
	@CacheLookup
	WebElement clkpersonal;
	public void clkpersonalinfo()
	{
		clkpersonal.click();
	}
	//save Personal Information
	@FindBy(xpath="//select[@name='objPersonalDetailsDTO.title']")
	@CacheLookup
	WebElement drpsuffix;
	public void settitle()
	{
		Select title=new Select(drpsuffix);
		title.selectByVisibleText("Mr");
	}
	@FindBy(xpath="//select[@name='objPersonalDetailsDTO.gender']")
	@CacheLookup
	WebElement drpgender;
	public void setgender()
	{
		Select gender=new Select(drpgender);
		gender.selectByVisibleText("Male");
	}
	@FindBy(xpath="//select[@name='objPersonalDetailsDTO.married']")
	@CacheLookup
	WebElement drpmarried;
	public void setmarried()
	{
		Select married=new Select(drpmarried);
		married.selectByVisibleText("Single");
	}
	@FindBy(xpath="//select[@name='objPersonalDetailsDTO.qualification']")
	@CacheLookup
	WebElement drpqualification;
	public void setqualification()
	{
		Select qualification=new Select(drpqualification);
		qualification.selectByVisibleText("Class X");
	}
	@FindBy(xpath="//input[@name='objPersonalDetailsDTO.rollNum']")
	@CacheLookup
	WebElement txtrollnumber;
	public void setrollnumber(String rollnum)
	{
		txtrollnumber.sendKeys(rollnum);
	}
	@FindBy(xpath="//input[@name='objPersonalDetailsDTO.boardName']")
	@CacheLookup
	WebElement txtboardname;
	public void setboardname(String boardname)
	{
		txtboardname.sendKeys(boardname);
	}
	@FindBy(xpath="//input[@name='objPersonalDetailsDTO.name']")
	@CacheLookup
	WebElement txtfathername;
	public void setfathername(String fathername)
	{
		txtfathername.sendKeys(fathername);
	}
	@FindBy(xpath="//select[@name='objPersonalDetailsDTO.agentRelation']")
	@CacheLookup
	WebElement drprelationwith;
	public void setrelationwith()
	{
		Select relation=new Select(drprelationwith);
		relation.selectByVisibleText("Father");
	}
	@FindBy(xpath="//select[@name='objPersonalDetailsDTO.proQualification']")
	@CacheLookup
	WebElement drpproqualification;
	public void setproqualification()
	{
		Select proq=new Select(drpproqualification);
		proq.selectByVisibleText("Graduate");
	}
	@FindBy(xpath="//select[@name='objPersonalDetailsDTO.castcategory']")
	@CacheLookup
	WebElement drpcategory;
	public void setcategory()
	{
		Select category=new Select(drpcategory);
		category.selectByVisibleText("GEN");
	}
	@FindBy(xpath="//input[@name='objPersonalDetailsDTO.yearOfPassing']//following::img[1]")
	@CacheLookup
	WebElement clkcalendarwidget;
	public void clkcalendar()
	{
		clkcalendarwidget.click();
	}
	@FindBy(xpath="//div[@class='todaysDate']")
	@CacheLookup
	WebElement clkcurrentdate;
	public void setyearofpassing()
	{
		clkcurrentdate.click();
	}
	@FindBy(xpath="//input[@name='objPersonalDetailsDTO.aadharNm']")
	@CacheLookup
	WebElement txtaadhaar;
	public void setaadhaar(String aadhaar)
	{
		txtaadhaar.sendKeys(aadhaar);
	}
	@FindBy(xpath="//input[@name='btnSaveDraft']")
	@CacheLookup
	WebElement clkpersonalinfosave;
	public void clkpersonalinfosave()
	{
		clkpersonalinfosave.click();
	}
}
