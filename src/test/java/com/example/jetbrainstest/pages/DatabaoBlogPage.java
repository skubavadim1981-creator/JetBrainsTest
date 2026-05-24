package com.example.jetbrainstest.pages;

import com.example.jetbrainstest.AllureLogger;
import com.example.jetbrainstest.tests.DatabaoTest;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// page_url = https://www.jetbrains.com/databao/
public class DatabaoBlogPage {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(DatabaoBlogPage.class));
    // private final Logger LOG = LoggerFactory.getLogger(DatabaoPage.class);
    WebDriver driver;

    public DatabaoBlogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#major-updates")
    private WebElement rankHeading;


    public Boolean checkIfRankHeadingIsVisible() {
        LOG.infoWithScreenshot("Проверка видимости заголовка статьи достижений");
        return rankHeading.isDisplayed();
    }
    public String getRankHeadingText() {
        LOG.info("Получение текста заголовка статьи");
        return rankHeading.getText();
    }
}