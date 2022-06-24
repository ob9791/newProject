package com.tsi.o.blidi.program.Selenium;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SeleniumTests {
    public static WebDriver driver;

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    @Order(1)
    void checkWebsiteConnection() {
        Assertions.assertDoesNotThrow(() -> {
            driver.get("http://localhost:3000/");
        });
    }

    @Test
    @Order(2)
    void goToFilmCategory() {
        driver.get("http://localhost:3000/Film/Categories");
        WebElement actionLink = (new WebDriverWait(driver, Duration.ofSeconds(120))).until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        actionLink.click();
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(120))).until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
        Assertions.assertTrue(element.isDisplayed());
    }

    @Test
    @Order(3)
    void areFilmsDisplayed() {
        driver.get("http://localhost:3000");
        WebElement actionLink = (new WebDriverWait(driver, Duration.ofSeconds(120))).until(ExpectedConditions.visibilityOfElementLocated(By.id("filmslink")));
        actionLink.click();
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(120))).until(ExpectedConditions.visibilityOfElementLocated(By.id("filmtitle")));
        Assertions.assertTrue(element.isDisplayed());
        System.out.println(element.isDisplayed());
    }
}

