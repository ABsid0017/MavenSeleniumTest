
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;


public class seleniumTestHotelReservation {
    WebDriver driver;

    @Test
    public void LoginTest() {

        driver = new ChromeDriver();

        //maximize the browser
        driver.manage().window().maximize();

        //Implicit wait, wait for at least some time (10 sec) to identify an element, //if can't find the element with in 10

        //open the url or AUT
        driver.get("http://adactinhotelapp.com/HotelAppBuild2/index.php");

        //Click on the register link:
        driver.findElement(By.id("username")).sendKeys("SP19BSSE0017");

        driver.findElement(By.id("password")).sendKeys("111");

        driver.findElement(By.id("login")).click();

        String welcomeTag = driver.findElement(By.cssSelector("body:nth-child(2) table.content:nth-child(2) tbody:nth-child(1) tr:nth-child(1) > td.welcome_menu:nth-child(1)")).getText();
        Assert.assertEquals(welcomeTag,"Welcome to Adactin Group of Hotels");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.quit();
        driver=null;

    }
}
