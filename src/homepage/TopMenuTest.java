package homepage;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    public void selectMenu(String menu)
    {
        List<WebElement> topMenuName = driver.findElements(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul"));
        for (WebElement name: topMenuName)
        {
            if (name.getText().equalsIgnoreCase(menu));
            {
                name.click();
                break;

            }
        }
    }

    @Before
    public void setUp()
    {
        openBrowser(baseUrl);

    }
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        //driver.findElement(By.linkText("Desktops")).click();
        Thread.sleep(3000);
        mouseHoverAndClick(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li[1]/a"));
        Thread.sleep(3000);
        selectMenu("//ul[@class='nav navbar-nav']/li[1]/div[1]/a");
        //verifyText("Desktops",By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li[1]/a"),"Desktops");
        String actualText = driver.findElement(By.tagName("h2")).getText();
        String expectedText = "Desktops";
        Assert.assertEquals(actualText,expectedText);

    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() throws InterruptedException {
        //driver.findElement(By.linkText("Desktops")).click();
        Thread.sleep(3000);
        mouseHoverAndClick(By.linkText("Laptops & Notebooks"));
        Thread.sleep(3000);
        selectMenu("Show All Laptops & Notebooks");
        verifyText("Laptops & Notebooks",By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li[2]/a"),"Laptops & Notebooks");

    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() throws InterruptedException {
        //driver.findElement(By.linkText("Desktops")).click();
        Thread.sleep(3000);
        mouseHoverAndClick(By.linkText("Components"));
        Thread.sleep(3000);
        selectMenu("Show All Components");
        verifyText("Components",By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li[3]/a"),"Components");

    }
    @After
    public void endTest()
    {
        //closeBrowser();

    }
}
