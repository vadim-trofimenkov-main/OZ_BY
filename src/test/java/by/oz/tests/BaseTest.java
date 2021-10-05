package by.oz.tests;

import by.oz.pages.HomePage;
import by.oz.utils.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected PropertyReader propertyReader = new PropertyReader("src/test/resources/configuration.properties");
    protected final String link = propertyReader.getPropertyValueByKey("main_link");
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        // options.addArguments("--headless");
        driver = new ChromeDriver(options);
        //  setCookie();
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

    public void logIn() {
        homePage.clickLoginButton();
        homePage.switchToCredentialsTab();
        homePage.setUsernameField("vadimtrofimenkov97@gmail.com");
        homePage.setPassword("Pi34Ag");
        homePage.clickConfirmButton();
    }
}
