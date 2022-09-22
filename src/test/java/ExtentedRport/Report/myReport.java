package ExtentedRport.Report;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class myReport {
	
	ExtentReports extent ;
	
	@BeforeTest
	public void reportTest()
	{
		File file = new File(System.getProperty("user.dir")+"\\reports\\index.html");
		ExtentSparkReporter ny =new ExtentSparkReporter(file);
		ny.config().setReportName("Automation Test");
		ny.config().setDocumentTitle("MainTest");
		
		
	 extent = new ExtentReports(); 
	 extent.attachReporter(ny);
	 extent.setSystemInfo("Tester", "Balamurugan");
	}
	@Test
	public void mainTest()
	{
		extent.createTest("bala f report");
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.iitm.ac.in/");
		System.out.println(driver.getTitle());
		driver.close();
		extent.flush();
	
		
	}

}
