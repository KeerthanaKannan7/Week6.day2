package week6.day2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import week6.day2.ReadExcel;

public class CommonFunctionClass {

	public ChromeDriver driver;
	
	public String fileName;
	
	@Parameters({"url", "un", "pwd"})
	@BeforeMethod
	public void precondition(String url, String un, String pwd)
	{
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get(url);
	
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys(un);

		driver.findElement(By.id("password")).sendKeys(pwd);

		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();
	}
	
	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}
	
	@DataProvider(name = "getData")
	public String[][] fetchData() throws IOException
	{		
		return ReadExcel.readData(fileName);
		
	}
}
