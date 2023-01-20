package com.crm.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.libraries.WebDriverUtility;

public class HomePage {
	//declaration
	@FindBy(linkText="Leads")
	private WebElement leadLink;
	
	
	@FindBy(linkText="Organizations")
	private WebElement orgLink;;
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText="Vendors")
	private WebElement vendorsLink;
	
	@FindBy(linkText="Recycle Bin")
	private WebElement recylebinLink; 
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorLink; 
	
	@FindBy(linkText="Campaigns")
	private WebElement CampaignsLink; 
	
	@FindBy(linkText="FAQ")
	private WebElement fAQLink; 
	
	@FindBy(linkText="Sign Out")
	private WebElement signout;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	//intialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public void clickOnOrganisation()
	{
		orgLink.click();
	}
	 
	 
	public WebElement getLeadLink() {
		return leadLink;
	}


	public WebElement getOrgLink() {
		return orgLink;
	}


	public WebElement getProductLink() {
		return productLink;
	}


	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}


	public WebElement getContactsLink() {
		return contactsLink;
	}


	public WebElement getVendorsLink() {
		return vendorsLink;
	}


	public WebElement getRecylebinLink() {
		return recylebinLink;
	}


	public WebElement getAdministratorLink() {
		return administratorLink;
	}


	public WebElement getCampaignsLink() {
		return CampaignsLink;
	}


	public WebElement getfAQLink() {
		return fAQLink;
	}


	public WebElement getSignout() {
		return signout;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}
	 
//business logic


	public void clickOnContacts()
	{
		orgLink.click();
	}
	 
	public void clickOnLeads()
	{
		leadLink.click();
	}
	 
	public void clickOnProducts()
	{
		productLink.click();
	}
	 
	
	public void clickOnOpportunities()
	{
		opportunitiesLink.click();
	}
	 
	
	public void recyclebin()
	{
		recylebinLink.click();
	}
	 
	
	public void vendors()
	{
		vendorsLink.click();
		
	
	}
	public void more() {
		moreLink.click();
	}
	
	public void clicKOnFaq() {
		fAQLink.click();
	}
	
	public void signOut(WebDriverUtility wLib,WebDriver driver)
	{
		wLib.mousehover(driver, administratorLink);
		signout.click();	}
	 
	
}
