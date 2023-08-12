package com.parabank.pom.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.pom.BaseParaBankTest;
import com.parabank.pom.page.CustomerLogin;
import com.parabank.pom.page.HomePage;

public class CustomerLoginTest extends BaseParaBankTest {
HomePage homepage;
CustomerLogin loginPage;
	public CustomerLoginTest() {
		super();
}
	
	@Test
	public void loginShouldSucceed() {
		homepage=new CustomerLogin()
		.fillusername(getUsername())
		.fillpassword(getPassword())
		.clickLoginBtn();
		Assert.assertTrue(homepage.islogoutLink());
			
}
@Test
public void loginWithUsernameShouldFail() {
	loginPage=new CustomerLogin()
			.fillusername(getUsername())
			.clicCustomerkLoginBtn();
	Assert.assertTrue(loginPage.hasError());
	
}
@Test
public void loginWithPasswordShouldFail() {
	loginPage=new CustomerLogin()
			.fillpassword(getPassword())
			.clicCustomerkLoginBtn();
	Assert.assertTrue(loginPage.hasError());
	
}
@Test
public void loginShouldFail() {
	loginPage=new CustomerLogin()	
			.clicCustomerkLoginBtn();
	Assert.assertTrue(loginPage.hasError());
}

@Test
public void loginWithinvalidPasswordShouldFail() {
	loginPage=new CustomerLogin()
			.fillusername(getUsername())
			.fillpassword("ghghbj")
			.clicCustomerkLoginBtn();
	Assert.assertTrue(loginPage.hasError());
}
}