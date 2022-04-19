package com.durgasoft.ecommerce.pageUI;

import static org.testng.Assert.assertEquals;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.durgasoft.ecommerce.basepage.BasePage;


public class CreateLoginAccount extends BasePage{
	
	public static final Logger log = Logger.getLogger(CreateLoginAccount.class.getName());
	
	@FindBy(linkText = "Sign in") WebElement linksignIN;
	@FindBy(id = "email_create") WebElement txtemailid;
	@FindBy(id = "SubmitCreat") WebElement btncreateanaccount;
	@FindBy(xpath = "//h1[text()='Create an account']") WebElement txtcreateanaccount;
	@FindBy(id = "id_gender1") WebElement radioMr;
	@FindBy(id = "customer_firstname") WebElement txtFirstName;
	@FindBy(id="customer_lastname") WebElement txtLastName;
	@FindBy(id="passwd") WebElement txtPassword;
	@FindBy(id="days") WebElement dropDownDays;
	@FindBy(id="months") WebElement dropDownMonth;
	@FindBy(id="years") WebElement dropDownYears;
	@FindBy(id="address1") WebElement txtAddress1;
	@FindBy(id="city")WebElement txtCity;
	@FindBy(id="id_state")WebElement dropdownState;
	@FindBy(id="postcode")WebElement txtZipCode;
	@FindBy(id="id_country")WebElement dropdownCountry;
	@FindBy(id="phone_mobile")WebElement txtMobile;
	@FindBy(id="alias")WebElement txtAliasAddress;
	@FindBy(id="submitAccount")WebElement btnRegister;
	@FindBy(xpath="//h1[text()='My account']")WebElement txtMyAccount;

	
	public CreateLoginAccount(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void createAccount() throws Exception{
		linksignIN.click();
		log.info("Clicked on signin button with object:"+linksignIN.toString());
		txtemailid.sendKeys(getData("firstname")+getData("lastname")+randomNumber()+getData("domainname"));
		log.info("Entering email id:"+txtemailid.getAttribute("value")+" using object "+txtemailid.toString());
		btncreateanaccount.click();
		log.info("Clicked on create an account:"+btncreateanaccount.toString());
		Thread.sleep(10000);
		assertEquals(txtcreateanaccount.getText(), "CREATE AN ACCOUNT");
		log.info("Verifying customer info page by using object:"+txtcreateanaccount.toString());
		radioMr.click();
		log.info("Clicking on Mr radio button by using object:"+radioMr.toString());
		txtFirstName.sendKeys("Mahesh");
		log.info("Entering first name by using object:"+txtFirstName.toString());
		txtLastName.sendKeys("D");
		log.info("Entering last name using object:"+txtLastName.toString());
		txtPassword.sendKeys("abc@123");
		log.info("Entering password by using object:"+txtPassword.toString());
		dropDownDays.sendKeys("3");
		dropDownMonth.sendKeys("January");
		dropDownYears.sendKeys("1990");
		txtAddress1.sendKeys(getData("address1"));
		txtCity.sendKeys("Mumbai");
		dropdownState.sendKeys("Alabama");
		txtZipCode.sendKeys("12345");
		dropdownCountry.sendKeys("United States");
		txtMobile.sendKeys("1236547890");
		txtAliasAddress.sendKeys("Vijayawada");
		btnRegister.click();
		assertEquals(txtMyAccount.getText(), "MY ACCOUNT");
	}
}
