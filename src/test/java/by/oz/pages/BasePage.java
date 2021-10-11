package by.oz.pages;

import by.oz.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {
    protected PropertyReader propertyReader = new PropertyReader("src/test/resources/configuration.properties");
    protected HomePage homePage;
    protected LoginPage loginPage;

    public abstract boolean isPageOpened();

    public boolean isExist(By locator) {
        try {
            return $(locator).should(exist).exists();
        } catch (NoSuchElementException exception) {
            exception.printStackTrace();
            return false;
        }
    }
}
