package by.oz.tests;

import by.oz.pages.HomePage;
import by.oz.utils.PropertyReader;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected PropertyReader propertyReader = new PropertyReader("src/test/resources/configuration.properties");
    protected HomePage homePage;
    protected String username = propertyReader.getPropertyValueByKey("username");
    protected String password = propertyReader.getPropertyValueByKey("password");

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.startMaximized = true;
        Configuration.headless = false;
        //Configuration.browser = "Chrome";
        homePage = new HomePage();
    }

    //    private void setCookie() {
//        Cookie cookie = new Cookie
//                .Builder("vadimtrofimenkov97@gmail.com", " Pi34Ag")
//                .domain(link)
//                .build();
//        driver.manage().addCookie(cookie);
//    }
}
