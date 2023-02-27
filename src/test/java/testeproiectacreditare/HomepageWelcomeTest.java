package testeproiectacreditare;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomepageWelcomeTest {

    private WebDriver driver;

    @Before
    public void initialiseDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa1.fasttrackit.org:8008/");


    }

    @Test
    public void homepageWelcomeTxt() {
        WebElement hpagewelcometxt = driver.findElement(By.cssSelector("[role] article:nth-of-type(1) .entry-title [rel]"));
        String expectedText = "WELCOME";
        String actualText = hpagewelcometxt.getText();
        Assert.assertTrue(actualText.toLowerCase().contains(expectedText.toLowerCase()));

    }


    @After
    public void quit() {
        driver.close();
    }
}
