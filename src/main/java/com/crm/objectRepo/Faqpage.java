package com.crm.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Faqpage {
//declaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createFaqlookup;
	
	//Initialization
	
		public Faqpage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}


		//utilization
		public WebElement getCreateFaqlookup() {
			return createFaqlookup;
		}
		
		//business logic
		public void clickOnCreateFaqlookUp()
		{
			createFaqlookup.click();
		}
		
}
