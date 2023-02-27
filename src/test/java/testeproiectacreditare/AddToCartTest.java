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

public class AddToCartTest {

    private WebDriver driver;

    @Before
    public void initialiseDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa1.fasttrackit.org:8008/");
    }

    @Test
    public void addtoCartTest() {
        driver.findElement(By.cssSelector("li[id='menu-item-60'] a")).click();

        driver.findElement(By.cssSelector("[placeholder='Search …']")).sendKeys("hoodie pocket");
        WebElement searchForProducts = driver.findElement(By.cssSelector("[placeholder='Search …']"));
        searchForProducts.sendKeys(Keys.RETURN);

        WebElement productSearchedText = driver.findElement(By.cssSelector(".page-title > span"));
        String expectedproductSearchedText = "Hoodie POCKET";
        String actualproductSearchedText = productSearchedText.getText();
        Assert.assertTrue(actualproductSearchedText.toLowerCase().contains(expectedproductSearchedText.toLowerCase()));

        driver.findElement(By.cssSelector("a[rel='bookmark']")).click();
        driver.findElement(By.cssSelector("button[name='add-to-cart']")).click();

        WebElement productAddedtocardText1 = driver.findElement(By.cssSelector("main#main > div[role='alert']"));
        String expectedproductAddedtocardText1 = "“Hoodie with Pocket” has been added to your cart.";
        String actualproductAddedtocardText1 = productAddedtocardText1.getText();
        Assert.assertTrue(actualproductAddedtocardText1.toLowerCase().contains(expectedproductAddedtocardText1.toLowerCase()));

        driver.findElement(By.cssSelector(".button.wc-forward")).click();

    }

    @Test
    public void addtoCartTestRegress() {
        driver.findElement(By.cssSelector("li[id='menu-item-60'] a")).click();

        driver.findElement(By.cssSelector("[placeholder='Search …']")).sendKeys("hoodie pocket");
        WebElement searchForProducts = driver.findElement(By.cssSelector("[placeholder='Search …']"));
        searchForProducts.sendKeys(Keys.RETURN);

        WebElement productSearchedText = driver.findElement(By.cssSelector(".page-title > span"));
        String expectedproductSearchedText = "Hoodie POCKET";
        String actualproductSearchedText = productSearchedText.getText();
        Assert.assertTrue(actualproductSearchedText.toLowerCase().contains(expectedproductSearchedText.toLowerCase()));

        driver.findElement(By.cssSelector("a[rel='bookmark']")).click();
        driver.findElement(By.cssSelector("button[name='add-to-cart']")).click();

        WebElement productAddedtocardText1 = driver.findElement(By.cssSelector("main#main > div[role='alert']"));
        String expectedproductAddedtocardText1 = "“Hoodie with Pocket” has been added to your cart.";
        String actualproductAddedtocardText1 = productAddedtocardText1.getText();
        Assert.assertTrue(actualproductAddedtocardText1.toLowerCase().contains(expectedproductAddedtocardText1.toLowerCase()));

        driver.findElement(By.cssSelector(".button.wc-forward")).click();
        driver.navigate().back();
        driver.findElement(By.cssSelector(".button.wc-forward")).click();
        driver.navigate().back();
        driver.findElement(By.cssSelector(".button.wc-forward")).click();
        driver.navigate().back();
        driver.findElement(By.cssSelector(".button.wc-forward")).click();
    }


    @After
    public void quit() {
        driver.close();
    }
}
