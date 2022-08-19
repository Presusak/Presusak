package com.CRM_Tedi.pages;

import com.CRM_Tedi.base.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends Page {
    @FindBy(id="i0116")
    WebElement Signin;
    @FindBy(id="idSIButton9")
    WebElement SBtn;
    @FindBy(id="i0118")
    WebElement PwdText;
    @FindBy(xpath="//div[@data-value='OneWaySMS']")
    WebElement MobTxt;
    @FindBy(xpath="//div[@data-value='TwoWayVoiceMobile']")
    WebElement Calling_login;
    @FindBy(id="idSubmit_SAOTCC_Continue")
    WebElement VerifyBtn;
    @FindBy(id="idSIButton9")
    WebElement SignedInBtn;

    public Login()  {
        PageFactory.initElements(driver, this);
    }

    public void verify_Login(String email,String pwd,String Loginfrm) throws InterruptedException{

        String str = driver.getWindowHandle();
        driver.switchTo().window(str);

        Thread.sleep(4000);
        Signin.sendKeys(email);
        SBtn.click();
        driver.switchTo().window(str);

        Thread.sleep(4000);
        PwdText.sendKeys(pwd);
        SBtn.click();

        if(Loginfrm.equalsIgnoreCase("call")){
            Calling_login.click();
            Thread.sleep(15000);
        }
        else {
            MobTxt.click();

            Thread.sleep(15000);
            VerifyBtn.click();
        }
        SignedInBtn.click();
    }

}
