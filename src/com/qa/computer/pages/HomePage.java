package com.qa.computer.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "searchbox")
	WebElement computerSearchTextBox;
	
	@FindBy(id = "searchsubmit")
	WebElement filterSearchButton;
	
	@FindBy(id = "add")
	WebElement addComputerButton;
	
	@FindBy(xpath = "//h1/a")
	WebElement homePageHeaderLabel;
	
	@FindBy(xpath = "//a[contains(text(), 'Test computer name')]")
	WebElement openComputerForEdit;
	
	public void searchComputer(String computerName) {
		computerSearchTextBox.clear();
		computerSearchTextBox.sendKeys(computerName);
		filterSearchButton.click();
	}
	
	public void goToAddComputerPage() {
		addComputerButton.click();
	}
	
	public String getPageHeading() {
		return homePageHeaderLabel.getText();
	}
	
	public void openComputerFromSearchResult() {
		openComputerForEdit.click();	
	}
}
