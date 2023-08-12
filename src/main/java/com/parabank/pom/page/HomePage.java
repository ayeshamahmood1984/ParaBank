package com.parabank.pom.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.parabank.pom.BaseParaBankTest;

public class HomePage extends BaseParaBankTest{
@FindBy(linkText="Log Out")
WebElement logoutText;
public HomePage() {
	
	PageFactory.initElements(driver, this);


}
public boolean islogoutLink() {
return logoutText.isDisplayed();

}
}