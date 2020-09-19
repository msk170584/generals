package sbi.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class reporting extends TestListenerAdapter{
	
		public ExtentSparkReporter htmlreporter;
		public ExtentReports extent;
		public ExtentTest status;
		
		public void onStart(ITestContext tr) 
		{
			String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String repname="Test-Report-"+timestamp+".html";
			htmlreporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repname);
			try {
				htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			extent=new ExtentReports();
			extent.attachReporter(htmlreporter);
			extent.setSystemInfo("Build", "CMS: 1.0.0.1");
			extent.setSystemInfo("Role", "SSA RA RA Branch");
			extent.setSystemInfo("Environment", "Test Environment");
			extent.setSystemInfo("ReporterName", "Sureshkumar");
			htmlreporter.config().setDocumentTitle("Automation Testing");
			htmlreporter.config().setReportName("SBI-Generals Automation Test Report");
			htmlreporter.config().setTheme(Theme.DARK);
		}
		public void onTestSuccess(ITestResult tr)
		{
			status=extent.createTest(tr.getName());
			status.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		}
		public void onTestFailure(ITestResult tr)
		{
			status=extent.createTest(tr.getName());
			status.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
			String screenshotpath=System.getProperty("user.dir")+"/screenshots/"+tr.getName()+".png";
			status.fail("Screenshot for failed case "+ status.addScreenCaptureFromPath(screenshotpath));
		}
		public void onTestSkipped(ITestResult tr)
		{
			status=extent.createTest(tr.getName());
			status.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		}
		public void onFinish(ITestContext tr)
		{
			extent.flush();
		}

}
