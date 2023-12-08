package homepage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LaptopAndNoteBooks extends Utility {

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
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        mouseHoverToElement(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li[2]/a"));
        selectMenu("//ul[@class='nav navbar-nav']/li[2]/div/a");
        Thread.sleep(3000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"),"Price (High > Low)");
        String actualText = getTextFromElement(By.xpath("//select[@id='input-sort']/option[5]"));
        String expectedText = "Price (High > Low)";
        Assert.assertEquals(expectedText,actualText);


    }
    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        mouseHoverToElement(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li[2]/a"));
        selectMenu("//ul[@class='nav navbar-nav']/li[2]/div/a");
        Thread.sleep(3000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"),"Price (High > Low)");
        String actualText = getTextFromElement(By.xpath("//select[@id='input-sort']/option[5]"));
        String expectedText = "Price (High > Low)";
        Assert.assertEquals(expectedText,actualText);

        clickOnElement(By.linkText("MacBook"));

        String actualText1 = getTextFromElement(By.linkText("MacBook"));
        String expectedText1 = "MacBook";
        Assert.assertEquals(expectedText1,actualText1);

        clickOnElement(By.xpath("//button[@id='button-cart']"));
        Thread.sleep(3000);

        clickOnElement(By.xpath("//div[@id='product-product']/div/a[2]"));

        //String actualText2 = getTextFromElement(By.linkText("Shopping Cart (0.00kg)"));
        //String expectedText2 = "Shopping Cart (0.00kg)";
        //Assert.assertEquals(expectedText2,actualText2);
        String actualText2 = getTextFromElement(By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[2]/a"));
        String expectedText2 = "MacBook";
        Assert.assertEquals(expectedText2,actualText2);
        Thread.sleep(3000);

        clearTextFromField(By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[4]/div/input"));
        sendTextToElement(By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[4]/div/input"),"2");
        Thread.sleep(3000);

        clickOnElement(By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[4]/div/span/button[1]"));

        String actualText4 = getTextFromElement(By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[6]"));
        String expectedText4 = "$1,204.00";
        Assert.assertEquals(expectedText4,actualText4);

        clickOnElement(By.xpath("//div[@class='buttons clearfix']/div[2]/a"));
        Thread.sleep(3000);

        //clickOnElement(By.xpath("//div[@class='panel-collapse collapse in']/div[1]/div[1]/div[1]"));
        clickOnElement(By.xpath("//div[@class='panel-collapse collapse in']/div[1]/div[1]/div[1]/div[2]/label/input"));
        clickOnElement(By.xpath("//input[@id='button-account']"));

        //String actualText5 = getTextFromElement(By.xpath("//div[@class='panel-collapse collapse in']/div[1]/div[1]/div[1]/h2"));
        //String expectedText5 = "New Customer";
        //Assert.assertEquals(expectedText5,actualText5);
        Thread.sleep(3000);
        sendTextToElement(By.xpath("//input[@id='input-payment-firstname']"),"Div");
        sendTextToElement(By.xpath("//input[@id='input-payment-lastname']"),"Patel");
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"),"div123@gmail.com");
        sendTextToElement(By.xpath("//input[@id='input-payment-telephone']"),"6476785467");
        sendTextToElement(By.xpath("//input[@id='input-payment-address-1']"),"242 cedar");
        sendTextToElement(By.xpath("//input[@id='input-payment-city']"),"Oshawa");
        sendTextToElement(By.xpath("//input[@id='input-payment-postcode']"),"L1G3S4");
        selectByValueFromDropdown(By.xpath("//select[@id='input-payment-country']"),"38");
        Thread.sleep(3000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-zone']"),"Ontario");
        clickOnElement(By.xpath("//input[@id='button-guest']"));
        Thread.sleep(3000);

        sendTextToElement(By.xpath("//div[@id='collapse-payment-method']/div[1]/p[2]/textarea"),"not good");
        Thread.sleep(3000);
        clickOnElement(By.xpath("//div[@id='collapse-payment-method']/div[1]/div[2]/div[1]/input[1]"));
        Thread.sleep(3000);
        clickOnElement(By.xpath("//div[@id='collapse-payment-method']/div[1]/div[2]/div[1]/input[2]"));

    }
}
