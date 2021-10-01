package application;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.io.IOException;


public class EntryPoint {

    private static ChromeDriverService service;

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver","src\\resources\\chromedriver.exe");
        WebDriver  driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            driver.get("https://google.by");
            driver.findElement(By.name("q")).sendKeys("iTechArt" + Keys.ENTER);

            //TASK 1
            WebElement firstResult = wait.until(presenceOfElementLocated(By.cssSelector("h3")));
            System.out.println(firstResult.getAttribute("textContent"));

            //TASK 2
            WebElement titleResult = wait.until(presenceOfElementLocated(By.cssSelector("title")));
            if(titleResult.getAttribute("textContent").matches(".*iTechArt.*"))
            {
                System.out.println("Title вкладки содержит: " + titleResult.getAttribute("textContent"));
            }

        } finally
        {
            driver.quit();
        }
    }
}
