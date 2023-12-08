package homepage;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class Top extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp()
    {
        openBrowser(baseUrl);

    }
    public void selectMenu(String menu)
    {
        List<WebElement> topMenu = driver.findElements(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul"));//li
        for (WebElement name : topMenu)
        {
            if(name.getText().equalsIgnoreCase(menu))
            {
                name.click();
                break;

            }
        }
    }
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //selectMenu("Desktops");
        //verifyText("Desktops",By.xpath("//ul[@class='nav navbar-nav']/li[1]/div[1]/a"),"Desktops");
        //driver.findElement(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li[1]/a")).click();
        //driver.findElement(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li[1]/div/a")).click();
        //selectMenu("Show AllDesktops");
        //verifyText("Desktops",By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li[1]/a"),"Desktops");


    }
    @Test
    public void m2() throws InterruptedException {
        //driver.findElement(By.xpath(""))
        //mouseHoverAndClick(By.xpath("//ul[@class='nav navbar-nav']/li[2]/div/a"));
        //mouseHoverToElementAndClick(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li[2]/a"));
        //clickOnElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/div/a"));
        selectMenu("//ul[@class='nav navbar-nav']/li[2]/div/a");
        verifyText("Laptops & Notebooks",By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li[2]/a"),"Laptops & Notebooks");
    }

}
