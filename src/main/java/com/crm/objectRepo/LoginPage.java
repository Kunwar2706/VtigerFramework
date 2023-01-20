package com.crm.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//declaration
	@FindBy(name="user_name")
	private WebElement usernameEdit;
	
	@FindBy(name="user_password")
	private WebElement passwordnameEdit;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	//intialization
	public LoginPage(WebDriver driver)
			{
		PageFactory.initElements(driver, this);
			}
	//utilization

	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordnameEdit() {
		return passwordnameEdit;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	//bussinesslogic
	public void getLoginPage(String username, String password)
	{
		usernameEdit.sendKeys(username);
		passwordnameEdit.sendKeys(password);
		loginButton.click();
		
		
	}

}
