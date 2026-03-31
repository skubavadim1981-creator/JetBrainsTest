package com.example.jetbrainstest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


// page_url = https://www.jetbrains.com/databao/
public class DatabaoPage {

    WebDriver driver;

    @FindBy(css = "a[data-test='button'][href='/databao/get-in-touch/']")
    private WebElement bookademoButton;

    public Boolean checkIfBookaademoButtonIsClickable() {
        System.out.println("Проверка активности кнопки загрузки");
        return bookademoButton.isEnabled();
    }

    public DatabaoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (css ="form[data-test='wtform']")
    private WebElement demoRequestForm;

    public Boolean checkIfDemoRequestFormIsDisplayed () {
        System.out.println("Проверка видимости формы бронирования презентации продукта");
        return demoRequestForm.isDisplayed();
    }

    public void clickBookADemoButton() {
        System.out.println("Клик по кнопке бронирования презентации");
        bookademoButton.click();
    }
}
