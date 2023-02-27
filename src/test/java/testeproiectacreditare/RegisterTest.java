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

public class RegisterTest {
    private WebDriver driver;

    @Before
    public void initialiseDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://qa1.fasttrackit.org:8008/");

    }

    @Test
    public void registerWithLoggedUser() {
        driver.findElement(By.cssSelector("li[id='menu-item-58'] a")).click();

        driver.findElement(By.cssSelector("#reg_email")).sendKeys("dani.ban112@yahoo.com");

        driver.findElement(By.cssSelector("#reg_password")).sendKeys("1ParolaPtTest1");
        WebElement goodPassword = driver.findElement(By.cssSelector("#reg_password"));
        goodPassword.sendKeys(Keys.RETURN);



        WebElement errorMessage = driver.findElement(By.cssSelector("div[id=\"primary\"] li:nth-child(1)"));
        String expectedText = "Error: An account is already registered with your email address. Please log in.";
        String actualText = errorMessage.getText();
        Assert.assertEquals(expectedText, actualText);

    }


    @Test
    public void registerWithWrongCreds() {
        driver.findElement(By.cssSelector("li[id='menu-item-58'] a")).click();

        driver.findElement(By.cssSelector("input#reg_email")).sendKeys("test@test");

        driver.findElement(By.cssSelector("input#reg_password")).sendKeys("TEstPassWord25");
        WebElement wrongPassword = driver.findElement(By.cssSelector("input#reg_password"));
        wrongPassword.sendKeys(Keys.RETURN);

        WebElement errormsg = driver.findElement(By.cssSelector("ul[role='alert']"));
        String expectedText = "Error: Please provide a valid email address.";
        String actualText = errormsg.getText();
        Assert.assertEquals(expectedText, actualText);

    }


    @After
    public void quit() {
        driver.close();
    }

}

