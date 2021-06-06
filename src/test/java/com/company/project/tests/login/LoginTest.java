package com.company.project.tests.login;

import com.company.project.tests.baseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        homePage.clickLoginButton();
        homePage.switchToCredentialsTab();
        homePage.setUsernameField("vadimtrofimenkov97@gmail.com");
        homePage.setPassword("Pi34Ag");
        homePage.clickConfirmButton();
        WebElement element = homePage.getLoggedUserElement();
        Assert.assertTrue(element.isDisplayed(), "User is not logged");
    }
}
