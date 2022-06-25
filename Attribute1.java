package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Attribute1 extends Attributes{

	@Test(enabled = false)
	public void deletingLead() {

		System.out.println("Deleting Leads");

		driver.findElement(By.xpath("//a[text() = 'Find Leads']")).click();

		driver.findElement(By.xpath("//span[text() = 'Phone']")).click();

		driver.findElement(By.xpath("//input[@name= 'phoneNumber']")).sendKeys("9095326910");

		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();

		driver.findElement(By.partialLinkText("Keerthana")).click();

		driver.findElement(By.xpath("//a[text() = 'Delete']")).click();

	}
	
	@Test(priority = 1)
	public void duplicatingLead() throws InterruptedException {
		
		System.out.println("Duplicating Leads");
		
		driver.findElement(By.xpath("//a[text() = 'Find Leads']")).click();

		driver.findElement(By.xpath("//span[text() = 'Email']")).click();

		driver.findElement(By.xpath("//input[@name = 'emailAddress']")).sendKeys("keerthanakannan15497@gmail.com");

		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
		
		Thread.sleep(3000);

		driver.findElement(By.partialLinkText("Keerthana")).click();

		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[text() = 'Duplicate Lead']")).click();
		
		Thread.sleep(3000);
	}

	@Test(priority = -1)
	public void creatingLead() {

		// Creating Leads

		System.out.println("Creating Leads");

		driver.findElement(By.linkText("Create Lead")).click();

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");

		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Keerthana");

		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("K");

		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("KK");

		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");

		driver.findElement(By.id("createLeadForm_description"))
				.sendKeys("Manual Testing and Automation Testing (Java Selenium)");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9095326910");

		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("keerthanakannan15497@gmail.com");

		WebElement dropdown = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select option = new Select(dropdown);
		option.selectByVisibleText("New York");

		driver.findElement(By.name("submitButton")).click();
	}

	@Test(dependsOnMethods = {"creatingLead"})
	public void editingLead() throws InterruptedException {
		// Editing leads

		System.out.println("Editing Leads");

		driver.findElement(By.xpath("//a[text() = 'Find Leads']")).click();

		driver.findElement(By.xpath("//span[text() = 'Phone']")).click();

		driver.findElement(By.xpath("//input[@name= 'phoneNumber']")).sendKeys("9095326910");

		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
		
		Thread.sleep(3000);

		driver.findElement(By.partialLinkText("Keerthana")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("updateLeadForm_description")).clear();
		Thread.sleep(3000);

		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Automation Testing: Selenimu Java ");

		driver.findElement(By.className("smallSubmit")).click();
	}

	@Test(invocationCount = 2)
	public void findingLead() {

		System.out.println("Finding Leads");

		driver.findElement(By.xpath("//a[text() = 'Find Leads']")).click();

		driver.findElement(By.xpath("//span[text() = 'Phone']")).click();

		driver.findElement(By.xpath("//input[@name= 'phoneNumber']")).sendKeys("9095326910");

		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();

		driver.findElement(By.partialLinkText("Keerthana")).click();
	}
	
	@Test(priority = 0)
	public void creatingContact()
	{
		driver.findElement(By.xpath("//a[text() = 'Contacts']")).click();

		driver.findElement(By.xpath("//a[text() = 'Create Contact']")).click();

		driver.findElement(By.id("firstNameField")).sendKeys("Keerthana");

		driver.findElement(By.id("lastNameField")).sendKeys("K");

		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("KK");

		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("K");

		driver.findElement(By.xpath("//input[@name = 'departmentName']")).sendKeys("Testing");

		driver.findElement(By.xpath("//textarea[@name = 'description']"))
				.sendKeys("Manual Testing and Automation Testing (Selenium Java)");

		driver.findElement(By.xpath("//input[@id = 'createContactForm_primaryEmail']"))
				.sendKeys("keerthanakannan15497@gmail.com");

		WebElement StateProvince = driver
				.findElement(By.xpath("//select[@id = 'createContactForm_generalStateProvinceGeoId']"));
		Select selectingStateProvince = new Select(StateProvince);
		selectingStateProvince.selectByVisibleText("Indiana");

		driver.findElement(By.xpath("//input[@name = 'submitButton']")).click();
	}
}
