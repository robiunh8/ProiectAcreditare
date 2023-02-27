package testeproiectacreditare;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTest {

    private WebDriver driver;

    @Before
    public void initialiseDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa1.fasttrackit.org:8008/");
    }

    @Test
    public void searchForProduct() {
        driver.findElement(By.cssSelector("[placeholder='Search …']")).sendKeys("hoodie pocket");
        WebElement searchForProducts = driver.findElement(By.cssSelector("[placeholder='Search …']"));
        searchForProducts.sendKeys(Keys.RETURN);


        WebElement productSearchedText = driver.findElement(By.cssSelector(".page-title > span"));
        String expectedText = "Hoodie POCKET";
        String actualText = productSearchedText.getText();
        Assert.assertTrue(actualText.toLowerCase().contains(expectedText.toLowerCase()));

        driver.findElement(By.cssSelector("[role] article:nth-child(2) [rel]")).click();

    }

    @After
    public void quit() {
        driver.close();
    }
}
