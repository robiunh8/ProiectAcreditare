package testeproiectacreditare;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {


    private WebDriver driver;

    @Before
    public void initialiseDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://qa1.fasttrackit.org:8008/");
    }

    @Test
    public void logIntoAccountValid() {

        driver.findElement(By.cssSelector("li[id='menu-item-58'] a")).click();
        driver.findElement(By.cssSelector("#username")).sendKeys("dani.ban112@yahoo.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("1ParolaPtTest1");
        driver.findElement(By.cssSelector("button[value='Login']")).click();


        WebElement welcomeText = driver.findElement(By.cssSelector("p:nth-child(1)"));
        String expectedText = "Hello dani.ban112 (not dani.ban112? Log out)";
        String actualText = welcomeText.getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void logIntoAccountWithWrongPassword() {

        driver.findElement(By.cssSelector("li[id='menu-item-58'] a")).click();

        driver.findElement(By.cssSelector("#username")).sendKeys("dani.ban112@yahoo.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("WrongPass");
        driver.findElement(By.cssSelector("button[value='Login']")).click();


        WebElement welcomeText = driver.findElement(By.cssSelector("ul[role='alert'] > li"));
        String expectedText = "ERROR: The password you entered for the email address dani.ban112@yahoo.com is incorrect. Lost your password?";
        String actualText = welcomeText.getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void logIntoAccountWithWrongEmail() {

        driver.findElement(By.cssSelector("li[id='menu-item-58'] a")).click();

        driver.findElement(By.cssSelector("#username")).sendKeys("WrongEmail");
        driver.findElement(By.cssSelector("#password")).sendKeys("1ParolaPtTest1");
        driver.findElement(By.cssSelector("button[value='Login']")).click();


        WebElement welcomeText = driver.findElement(By.cssSelector("ul[role='alert'] > li"));
        String expectedText = "ERROR: Invalid username. Lost your password?";
        String actualText = welcomeText.getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void logIntoAccountWithBlankkKeys() {

        driver.findElement(By.cssSelector("li[id='menu-item-58'] a")).click();

        driver.findElement(By.cssSelector("#username")).sendKeys(" ");
        driver.findElement(By.cssSelector("#password")).sendKeys(" ");
        driver.findElement(By.cssSelector("button[value='Login']")).click();


        WebElement welcomeText = driver.findElement(By.cssSelector("ul[role='alert'] > li"));
        String expectedText = "Error: Username is required.";
        String actualText = welcomeText.getText();
        Assert.assertEquals(expectedText, actualText);
    }


    @After
    public void quit() {
        driver.close();
    }
}

