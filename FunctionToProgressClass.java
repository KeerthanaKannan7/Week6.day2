package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import week6.day2.ReadExcel;

public class FunctionToProgressClass extends CommonFunctionClass {
	
	@BeforeClass
	public void getFile()
	{
		fileName = "Assignment";
	}
	
	@Test(dataProvider = "getData")
	public void CreateLead(String cn, String fn, String ln, String fln, String dep, String desc, String phno, String email)
	throws InterruptedException
	{
		driver.findElement(By.linkText("Create Lead")).click();

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cn);

		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fn);

		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(ln);

		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys(fln);

		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys(dep);

		driver.findElement(By.id("createLeadForm_description")).sendKeys(desc);
		
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phno);

		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(email);

		WebElement dropdown = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select option = new Select(dropdown);
		option.selectByVisibleText("New York");

		driver.findElement(By.name("submitButton")).click();
	}

}
