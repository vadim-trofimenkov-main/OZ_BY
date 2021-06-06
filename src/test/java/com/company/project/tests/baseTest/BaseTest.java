package com.company.project.tests.baseTest;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.company.core.page_object.pages.HomePage;

public class BaseTest {
    private WebDriver driver;
    private String link = "https://oz.by";
    public HomePage homePage;

    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        goHome();
      //  setCookie();
        homePage = new HomePage(driver);
        logIn();
    }

    @BeforeMethod
    public void goHome() {
        driver.get(link);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    private void setCookie() {
        Cookie cookie = new Cookie
                .Builder("vadimtrofimenkov97@gmail.com", " Pi34Ag")
                .domain(link)
                .build();
        driver.manage().addCookie(cookie);
    }

    public void logIn(){
        homePage.clickLoginButton();
        homePage.switchToCredentialsTab();
        homePage.setUsernameField("vadimtrofimenkov97@gmail.com");
        homePage.setPassword("Pi34Ag");
        homePage.clickConfirmButton();
    }
}
