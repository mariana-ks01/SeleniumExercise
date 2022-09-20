package com.qa.computer.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditComputerPage {
	WebDriver driver;

	public EditComputerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@value='Delete this computer']")
	WebElement deleteComputerButton;
	
	public void deleteComputer() {
		deleteComputerButton.click();
	}
}
