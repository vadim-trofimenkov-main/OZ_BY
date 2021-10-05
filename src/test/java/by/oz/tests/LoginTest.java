package by.oz.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        boolean isUserLogged =
                homePage
                        .openPage()
                        .clickLoginButton()
                        .logIn()
                        .getLoggedUserElement();
        Assert.assertTrue(isUserLogged, "User is not logged");
    }
}
