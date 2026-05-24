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
public class DatabaoPage {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(DatabaoPage.class));
   // private final Logger LOG = LoggerFactory.getLogger(DatabaoPage.class);
    WebDriver driver;

    public DatabaoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[data-test='button'][href='/databao/get-in-touch/']")
    private WebElement bookademoButton;
    @FindBy(xpath = "//a[contains(@href,'how-databao-agent-ranked-1-spider-2-0-dbt')]")
    private WebElement rankLink;
    @FindBy(css = "[data-test='tag']")
    private WebElement jetBrainsForDataTag;


    public Boolean checkIfBookaademoButtonIsClickable() {
        LOG.infoWithScreenshot("Проверка активности кнопки загрузки");
        return bookademoButton.isEnabled();
    }
    public void clickBookADemoButton() {
        LOG.infoWithScreenshot("Клик по кнопке бронирования презентации");
        bookademoButton.click();
    }
    public Boolean checkIfRankLinkIsClickable() {
        LOG.infoWithScreenshot("Проверка активности ссылки достижений");
        return rankLink.isEnabled();
    }
    public void clickRankLink() {
        LOG.infoWithScreenshot("Клик по ссылке достижений");
        rankLink.click();
    }
    public void clickJetbrainsForDataTag() {
        LOG.infoWithScreenshot("Клик по тэгу 'Jetbrains for data'");
        jetBrainsForDataTag.click();
    }
}
