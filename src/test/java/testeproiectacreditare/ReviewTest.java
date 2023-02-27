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

public class ReviewTest {

    public WebDriver driver;

    @Before
    public void initialiseDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa1.fasttrackit.org:8008/");


    }

    @Test
    public void addReviewLoggedIn() {
        driver.findElement(By.cssSelector("li[id='menu-item-58'] a")).click();
        driver.findElement(By.cssSelector("#username")).sendKeys("dani.ban112@yahoo.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("1ParolaPtTest1");
        driver.findElement(By.cssSelector("button[value='Login']")).click();

        driver.findElement(By.cssSelector("li[id='menu-item-60'] a")).click();

        driver.findElement(By.cssSelector("[placeholder='Search …']")).sendKeys("hoodie pocket");
        WebElement searchForProducts = driver.findElement(By.cssSelector("[placeholder='Search …']"));
        searchForProducts.sendKeys(Keys.RETURN);

        WebElement productSearchedText = driver.findElement(By.cssSelector(".page-title > span"));
        String expectedText = "Hoodie POCKET";
        String actualText = productSearchedText.getText();
        Assert.assertTrue(actualText.toLowerCase().contains(expectedText.toLowerCase()));


        driver.findElement(By.cssSelector("a[rel='bookmark']")).click();
        driver.findElement(By.cssSelector("li#tab-title-reviews > a")).click();
        driver.findElement(By.cssSelector(".star-5")).click();


        driver.findElement(By.cssSelector("textarea#comment")).sendKeys("doouuoi");
        driver.findElement(By.cssSelector("input#submit")).click();


        WebElement reviewaddedText = driver.findElement(By.cssSelector("div#comments > .woocommerce-Reviews-title"));
        String expectedReviewText = "Reviews";
        String actualReviewText = reviewaddedText.getText();
        Assert.assertTrue(actualReviewText.toLowerCase().contains(expectedReviewText.toLowerCase()));

    }

    @Test
    public void addRevieWoutNameAndEmail() {

        driver.findElement(By.cssSelector("li[id='menu-item-60'] a")).click();

        driver.findElement(By.cssSelector("[placeholder='Search …']")).sendKeys("hoodie pocket");
        WebElement searchForProducts = driver.findElement(By.cssSelector("[placeholder='Search …']"));
        searchForProducts.sendKeys(Keys.RETURN);

        WebElement productSearchedText = driver.findElement(By.cssSelector(".page-title > span"));
        String expectedText = "Hoodie POCKET";
        String actualText = productSearchedText.getText();
        Assert.assertTrue(actualText.toLowerCase().contains(expectedText.toLowerCase()));


        driver.findElement(By.cssSelector("a[rel='bookmark']")).click();
        driver.findElement(By.cssSelector("li#tab-title-reviews > a")).click();
        driver.findElement(By.cssSelector(".star-5")).click();
        driver.findElement(By.cssSelector("textarea#comment")).sendKeys("Great fit");
        driver.findElement(By.cssSelector("input#submit")).click();


        WebElement nameAndMailErrorMsg = driver.findElement(By.cssSelector("body#error-page > p:nth-of-type(2)"));
        String expectednameAndMailErrorMsg = "ERROR: please fill the required fields (name, email).";
        String actualnameAndMailErrorMsg = nameAndMailErrorMsg.getText();
        Assert.assertTrue(actualnameAndMailErrorMsg.toLowerCase().contains(expectednameAndMailErrorMsg.toLowerCase()));


    }

    @Test
    public void addReviewWoutComment() {

        driver.findElement(By.cssSelector("li[id='menu-item-60'] a")).click();

        driver.findElement(By.cssSelector("[placeholder='Search …']")).sendKeys("hoodie pocket");
        WebElement searchForProducts = driver.findElement(By.cssSelector("[placeholder='Search …']"));
        searchForProducts.sendKeys(Keys.RETURN);

        WebElement productSearchedText = driver.findElement(By.cssSelector(".page-title > span"));
        String expectedText = "Hoodie POCKET";
        String actualText = productSearchedText.getText();
        Assert.assertTrue(actualText.toLowerCase().contains(expectedText.toLowerCase()));


        driver.findElement(By.cssSelector("a[rel='bookmark']")).click();
        driver.findElement(By.cssSelector("li#tab-title-reviews > a")).click();
        driver.findElement(By.cssSelector(".star-5")).click();
        driver.findElement(By.cssSelector("input#author")).sendKeys("my name my name");
        driver.findElement(By.cssSelector("input#email")).sendKeys("dani.ban112@yahoo.com");
        driver.findElement(By.cssSelector("input#submit")).click();


        WebElement commentErrorMsg = driver.findElement(By.cssSelector("body#error-page > p:nth-of-type(2)"));
        String expectedcommentErrorMsg = "ERROR: please type a comment.";
        String actualcommentErrorMsg = commentErrorMsg.getText();
        Assert.assertTrue(actualcommentErrorMsg.toLowerCase().contains(expectedcommentErrorMsg.toLowerCase()));


    }


    @After
    public void quit() {
        driver.close();
    }
}
