package com.company.core.page_object.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BooksPage {
    private WebDriver driver;
    private List<WebElement> booksResults;
    private WebElement element;

    public BooksPage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchResultPage clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
        return new SearchResultPage(driver);
    }

    public List<WebElement> getBooksResults() {
        booksResults = driver.findElements(By.xpath("//*[@id='goods-table']//li"));
        return booksResults;
    }
}
