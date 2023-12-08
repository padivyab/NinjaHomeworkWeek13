package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class DesktopsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    public void selectMenu(String menu)
    {
        //driver.findElement(By.xpath(menu)).click();
        clickOnElement(By.xpath(menu));
    }
    @Before
    public void setUp()
    {
        openBrowser(baseUrl);

    }
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        mouseHoverAndClick(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li[1]/a"));
        selectMenu("//ul[@class='nav navbar-nav']/li[1]/div[1]/a");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"),"Name (Z - A)");

        String actualText = getTextFromElement(By.xpath("//select[@id='input-sort']/option[3]"));
        String expectedText = "Name (Z - A)";
        Assert.assertEquals(expectedText,actualText);

    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        mouseHoverAndClick(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li[1]/a"));
        selectMenu("//ul[@class='nav navbar-nav']/li[1]/div[1]/a");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"),"Name (A - Z)");
        Thread.sleep(3000);
        //clickOnElement(By.xpath("//div[@id='content']/div[4]/div[3]/div[1]/div/div[1]/h4"));
        clickOnElement(By.linkText("HP LP3065"));
        Thread.sleep(3000);

        String actualText = getTextFromElement(By.linkText("HP LP3065"));
        String expectedText = "HP LP3065";
        Assert.assertEquals(expectedText,actualText);

        clearTextFromField(By.xpath("//div[@class='input-group date']/input"));
        sendTextToElement(By.xpath("//div[@class='input-group date']/input"),"2022-11-30");

        clearTextFromField(By.xpath("//div[@class='form-group']/input[1]"));
        sendTextToElement(By.xpath("//div[@class='form-group']/input[1]"),"1");

        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //String actualText1 = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']/a[2]"));
        //String expectedText1 = "shopping cart";
        //Assert.assertEquals(expectedText1,actualText1);
        Thread.sleep(3000);
        clickOnElement(By.xpath("//div[@id='product-product']/div/a[2]"));

        String actualText2 = getTextFromElement(By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[2]/a"));
        String expectedText2 = "HP LP3065";
        Assert.assertEquals(expectedText2,actualText2);

        String actualText3 = getTextFromElement(By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[3]"));
        String expectedText3 = "Product 21";
        Assert.assertEquals(expectedText3,actualText3);

        String actualText4 = getTextFromElement(By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[6]"));
        String expectedText4 = "$122.00";
        Assert.assertEquals(expectedText4,actualText4);

    }
    @After
    public void endTest()
    {
        //closeBrowser();

    }
}
