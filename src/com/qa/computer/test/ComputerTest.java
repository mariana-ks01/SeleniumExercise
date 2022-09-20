package com.qa.computer.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.computer.pages.AddComputerPage;
import com.qa.computer.pages.EditComputerPage;
import com.qa.computer.pages.HomePage;

public class ComputerTest {
	
	WebDriver driver;
	HomePage homePage;
	AddComputerPage addComputerPage;
	EditComputerPage editComputerPage;
	
	@BeforeTest
	public void initiateBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mniko\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://computer-database.herokuapp.com/computers");
	}
		
	@Test(priority = 1)
	public void createComputerTest() {
		homePage = new HomePage(driver);
		homePage.goToAddComputerPage();
		addComputerPage= new AddComputerPage(driver);
		addComputerPage.addComputer("Test computer name");
	}
	
	@Test(priority = 2, dependsOnMethods = "createComputerTest")
	public void searchComputerTest() {
		homePage.searchComputer("Test computer name");
	}
	
	@Test(priority = 3, dependsOnMethods = "createComputerTest")
	public void deleteComputerTest() {
		homePage.searchComputer("Test computer name");
		homePage.openComputerFromSearchResult();
		editComputerPage = new EditComputerPage(driver);
		editComputerPage.deleteComputer();
	}
}

