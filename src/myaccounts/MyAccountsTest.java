package myaccounts;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MyAccountsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    public void selectMyAccountOptions(String option)
    {
        //driver.findElement(By.xpath(menu)).click();
        clickOnElement(By.xpath(option));


    }
    @Before
    public void setUp()
    {
        openBrowser(baseUrl);

    }
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        mouseHoverAndClick(By.xpath("//div[@class='nav pull-right']/ul[1]/li[2]/a/span[1]"));
        Thread.sleep(3000);
        selectMyAccountOptions("//div[@class='nav pull-right']/ul[1]/li[2]/ul/li[1]/a");
        verifyText("Register Account",By.xpath("//div[@id='account-register']/div[1]/div[1]/h1"),"Register Account");

    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        mouseHoverAndClick(By.xpath("//div[@class='nav pull-right']/ul[1]/li[2]/a/span[1]"));
        Thread.sleep(3000);
        selectMyAccountOptions("//div[@class='nav pull-right']/ul[1]/li[2]/ul/li[2]/a");
        verifyText("Returning Customer",By.xpath("//div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div/h2"),"Returning Customer");

    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        mouseHoverAndClick(By.xpath("//div[@class='nav pull-right']/ul[1]/li[2]/a/span[1]"));
        Thread.sleep(3000);
        selectMyAccountOptions("//div[@class='nav pull-right']/ul[1]/li[2]/ul/li[1]/a");
        Thread.sleep(3000);
        sendTextToElement(By.xpath("//input[@id='input-firstname']"),"Divy");
        sendTextToElement(By.xpath("//input[@id='input-lastname']"),"Patel");
        sendTextToElement(By.xpath("//input[@id='input-email']"),"div12323567@gmail.com");
        sendTextToElement(By.xpath("//input[@id='input-telephone']"),"6574536578");
        sendTextToElement(By.xpath("//input[@id='input-password']"),";Div123");
        sendTextToElement(By.xpath("//input[@id='input-confirm']"),";Div123");
        Thread.sleep(3000);
        clickOnElement(By.xpath("//div[@class='form-group']/div/label[1]/input"));
        clickOnElement(By.xpath("//div[@class='pull-right']/input[1]"));
        clickOnElement(By.xpath("//div[@class='pull-right']/input[2]"));
        verifyText("Your Account Has Been Created!",By.xpath("//div[@id='common-success']/div[1]/div[1]/h1"),"Your Account Has Been Created!");
        Thread.sleep(3000);
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
        mouseHoverAndClick(By.xpath("//div[@class='nav pull-right']/ul[1]/li[2]/a/span[1]"));
        clickOnElement(By.xpath("//div[@id='top-links']/ul[1]/li[2]/ul/li[5]/a"));
        Thread.sleep(3000);
        verifyText("Account Logout",By.xpath("//div[@id='common-success']/div/div/h1"),"Account Logout");
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));

    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        mouseHoverAndClick(By.xpath("//div[@class='nav pull-right']/ul[1]/li[2]/a/span[1]"));
        Thread.sleep(3000);
        selectMyAccountOptions("//div[@class='nav pull-right']/ul[1]/li[2]/ul/li[2]/a");
        Thread.sleep(3000);
        sendTextToElement(By.xpath("//input[@id='input-email']"),"div12323567@gmail.com");
        sendTextToElement(By.xpath("//input[@id='input-password']"),";Div123");
        clickOnElement(By.xpath("//input[@class='btn btn-primary']"));
        verifyText("My Account",By.xpath("//div[@id='account-account']/div[1]/div/h2[1]"),"My Account");
        mouseHoverAndClick(By.xpath("//div[@class='nav pull-right']/ul[1]/li[2]/a/span[1]"));
        Thread.sleep(3000);
        selectMyAccountOptions("//div[@id='top-links']/ul[1]/li[2]/ul/li[5]/a");
        verifyText("Account Logout",By.xpath("//div[@id='common-success']/div[1]/div/h1"),"Account Logout");
        Thread.sleep(3000);
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));

    }
}
