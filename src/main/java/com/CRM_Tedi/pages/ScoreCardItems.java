package com.CRM_Tedi.pages;

import com.CRM_Tedi.base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.nio.file.WatchEvent;
import java.util.List;

public class ScoreCardItems extends Page {
    SoftAssert sa_All = new SoftAssert();
    @FindBy(xpath = "")
    WebElement sci_;

    @FindBy(xpath="//button[@data-id='sitemap-areaSwitcher-expand-btn']")
    WebElement TediSettingsTab;
    @FindBy(xpath = "//div[@id='__flyoutRootNode']")
    WebElement AdminDiv;

    @FindBy(xpath = "//span[text()='Functional Areas']")
    WebElement FA_FunctionalArea_Spn;
    @FindBy(xpath = "//input[@aria-label='Functional Area Quick find']")
    WebElement FA_QuickFind_Ipt;
    @FindBy(xpath = "//button[@aria-label='Start search']")
    WebElement FA_Search_Btn;

    @FindBy(xpath = "//button[@data-id='ca_scorecarditem|NoRelationship|SubGridStandard|Mscrm.SubGrid.ca_scorecarditem.AddNewStandard']")
    WebElement SCI_New_Btn;
    @FindBy(xpath = "//input[@data-id='ca_name.fieldControl-text-box-text']")
    WebElement SCI_Name_Ipt;
    @FindBy(xpath = "//button[@data-id='ca_scorecarditem|NoRelationship|Form|Mscrm.Form.ca_scorecarditem.Save']")
    WebElement SCI_Save_Btn;

    @FindBy(xpath = "//span[text()='Score Card Items']")
    WebElement SCI_Spn;
    @FindBy(xpath = "//div[@data-id='ca_functionalarea.fieldControl-LookupResultsDropdown_ca_functionalarea_selected_tag_text']")
    WebElement SCI_FA_Name_DivIpt;

    @FindBy(xpath = "//button[@data-id='ca_scorecarditem|NoRelationship|Form|Mscrm.Form.ca_scorecarditem.Deactivate']")
    WebElement SCI_Deactivate_Btn;
    @FindBy(xpath = "//button[@data-id='ca_scorecarditem|NoRelationship|Form|Mscrm.Form.ca_scorecarditem.Activate']")
    WebElement SCI_Activate_Btn;

    @FindBy(xpath = "//li[@title='Inactive Score Card Items']")
    WebElement SCI_InActive_Li;
    @FindBy(xpath = "//li[@title='Active Score Card Items']")
    WebElement SCI_Active_Li;
    @FindBy(xpath = "//button[@data-id='ok_id']")
    WebElement SCI_Ok_Btn;

    @FindBy(xpath = "//div[@data-id='ca_functionalarea.fieldControl-LookupResultsDropdown_ca_functionalarea_selected_tag_text']")
    WebElement SCI_FuncArea_DivIpt;

    public ScoreCardItems(){PageFactory.initElements(driver, this);}

    public void OpenTediSettings() throws InterruptedException{
        Thread.sleep(2000);
        TediSettingsTab.click();
        Thread.sleep(2000);

        List<WebElement> allDivTags = AdminDiv.findElements(By.tagName("span"));
        allDivTags.get(5).click();
        Thread.sleep(2000);
        /*System.out.println("allDivTags.size() : " + allDivTags.size());
        for(int i = 0;i<allDivTags.size();i++){
            System.out.println("allDivTags i -> " + i + " : " + allDivTags.get(i).getText());
            Thread.sleep(2000);
        }*/
    }
    public void verifyExistFunctionalArea(String FA_Name_Rec,boolean IsActivate) throws InterruptedException{
        OpenTediSettings();
        Thread.sleep(2000);

        if(!IsActivate) {
            FA_FunctionalArea_Spn.click();
            Thread.sleep(2000);
            FA_QuickFind_Ipt.click();
            FA_QuickFind_Ipt.sendKeys(FA_Name_Rec);
            FA_Search_Btn.click();
            Thread.sleep(2000);

            String str_xpath = "//span[text()='" + FA_Name_Rec + "']";
            WebElement FA_Name = driver.findElement(By.xpath(str_xpath));
            FA_Name.click();
            Thread.sleep(2000);
        }
    }

    public void verifyNewOrExistCardItem(String SCI_IsNew) throws InterruptedException{
        Thread.sleep(2000);
        if(SCI_IsNew.equalsIgnoreCase("new")){
            SCI_New_Btn.click();
            Thread.sleep(2000);
        }
        else{
            String str_xpath = "//span[text()='" + SCI_IsNew + "']";
            WebElement SCI_ExistItem = driver.findElement(By.xpath(str_xpath));
            SCI_ExistItem.click();
            Thread.sleep(2000);
        }
    }
    public void verifySaveMandatoryFields(String SCI_Name_Rec) throws InterruptedException{
        Thread.sleep(2000);
        if(SCI_Name_Ipt.getAttribute("value").equalsIgnoreCase("---")){
            SCI_Name_Ipt.click();
            SCI_Name_Ipt.sendKeys("");
            SCI_Name_Ipt.sendKeys(SCI_Name_Rec);
        }
        Thread.sleep(2000);
        SCI_Save_Btn.click();
    }

    public void verifyGetDeactivateRecord(boolean IsDeactivate, String SCI_Name_Rec) throws InterruptedException{
        if(IsDeactivate){
            String FA_Name = SCI_FA_Name_DivIpt.getAttribute("title");
            Thread.sleep(2000);
            SCI_Deactivate_Btn.click();
            Thread.sleep(2000);
            SCI_Ok_Btn.click();
            Thread.sleep(2000);

            verifyGetActivateRecord(false,SCI_Name_Rec);

            verifySCI_FunctionalArea(false,SCI_Name_Rec,FA_Name);
        }
    }
    public void verifySCI_FunctionalArea(boolean IsActivate, String SCI_Name_Rec, String FA_Name)
            throws InterruptedException{
        Thread.sleep(2000);
        FA_FunctionalArea_Spn.click();
        Thread.sleep(2000);

        String str_xpath = "//span[text()='" + FA_Name + "']";
        WebElement FA_Path = driver.findElement(By.xpath(str_xpath));
        FA_Path.click();
        Thread.sleep(2000);

        str_xpath = "//span[text()='" + SCI_Name_Rec + "']";
        try{
            WebElement SCI_Path = driver.findElement(By.xpath(str_xpath));
            SCI_Path.click();
            Thread.sleep(2000);
            sa_All.assertEquals(IsActivate,true,"Record activated successfully!!!");
        }
        catch(Exception e){
            sa_All.assertEquals(IsActivate,false,"Record deactivated successfully!!!");
        }
        sa_All.assertAll();
        Thread.sleep(2000);
    }
    public void verifyGetActivateRecord(boolean IsActivate, String SCI_ActName_Rec) throws InterruptedException{
        Thread.sleep(2000);
        SCI_Spn.click();
        Thread.sleep(2000);
        List<WebElement> li_SysView = driver.findElements(By.xpath("//span[@data-automationid='splitbuttonprimary']"));
        li_SysView.get(0).click();
        Thread.sleep(2000);
        SCI_InActive_Li.click();
        Thread.sleep(2000);

        String str_xpath = "//span[text()='" + SCI_ActName_Rec + "']";
        try {
            WebElement SCI_Name = driver.findElement(By.xpath(str_xpath));
            SCI_Name.click();
            Thread.sleep(2000);
        }
        catch (Exception e){
            sa_All.assertEquals(true,false,"Inactive Score card Item not find successfully");
        }

        if(IsActivate){
            String FA_Name = SCI_FA_Name_DivIpt.getAttribute("title");
            Thread.sleep(2000);
            SCI_Activate_Btn.click();
            Thread.sleep(2000);
            SCI_Ok_Btn.click();
            Thread.sleep(2000);
            SCI_Spn.click();
            Thread.sleep(2000);
            /*li_SysView.get(0).click();
            Thread.sleep(2000);
            SCI_Active_Li.click();*/

            str_xpath = "//span[text()='" + SCI_ActName_Rec + "']";
            try {
                WebElement SCI_Name = driver.findElement(By.xpath(str_xpath));
                SCI_Name.click();
                Thread.sleep(2000);
            }
            catch (Exception e){
                sa_All.assertEquals(true,false,"Active Score card Item not find successfully");
            }

            verifySCI_FunctionalArea(true,SCI_ActName_Rec,FA_Name);
        }
        sa_All.assertAll();
    }
}
