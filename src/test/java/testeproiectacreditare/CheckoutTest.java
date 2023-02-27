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

import static java.lang.Thread.*;

public class CheckoutTest {
    private WebDriver driver;

    @Before
    public void initialiseDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa1.fasttrackit.org:8008/");
    }

    @Test
    public void checkoutTest() throws InterruptedException {
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

        driver.findElement(By.cssSelector(".checkout-button")).click();

        driver.findElement(By.cssSelector("input#billing_first_name")).sendKeys("LIONEL");
        driver.findElement(By.cssSelector("input#billing_last_name")).sendKeys("MESSI");


        driver.findElement(By.cssSelector("[placeholder='House number and street name']")).sendKeys("Strada Mare");
        driver.findElement(By.cssSelector("input#billing_city")).sendKeys("Cluj-Napoca");
        driver.findElement(By.cssSelector("[data-priority='80'] [aria-haspopup]")).click();
        driver.findElement(By.cssSelector("input[role='combobox']")).sendKeys("Cluj");
        WebElement textCity = driver.findElement(By.cssSelector("input[role='combobox']"));
        textCity.sendKeys(Keys.RETURN);


        driver.findElement(By.cssSelector("input#billing_postcode")).sendKeys("400002");
        driver.findElement(By.cssSelector("input#billing_phone")).sendKeys("0742775662");
        driver.findElement(By.cssSelector("input#billing_email")).sendKeys("dani.ban112@yahoo.com");
        WebElement textMail = driver.findElement(By.cssSelector("input#billing_email"));
        textMail.sendKeys(Keys.RETURN);

        sleep(3000);


       WebElement orderReceivedText = driver.findElement(By.cssSelector(".entry-title"));
        String expectedorderReceivedText = "Order received";
        String actualorderReceivedText = orderReceivedText.getText();
        Assert.assertTrue(actualorderReceivedText.toLowerCase().contains(expectedorderReceivedText.toLowerCase()));


    }

    @After
    public void quit() {
        driver.close();
    }

}
