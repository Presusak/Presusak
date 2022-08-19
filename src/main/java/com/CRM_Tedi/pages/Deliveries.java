package com.CRM_Tedi.pages;

import com.CRM_Tedi.base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class Deliveries extends Page {
    Actions act = new Actions(driver);
    SoftAssert sa_All = new SoftAssert();

    @FindBy(xpath ="//li[@aria-label='Deliveries']")
    WebElement Del_Tab_Li;

    @FindBy(xpath ="//button[@data-id='ca_venuedeliveryschedule|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.ca_venuedeliveryschedule.NewRecord']")
    WebElement Del_New_Btn;
    @FindBy(xpath ="//input[@aria-label='Delivery Quick find']")
    WebElement Del_Search_Ipt;
    @FindBy(xpath ="//button[@aria-label='Start search']")
    WebElement Del_Search_Btn;

    @FindBy(xpath ="//input[@data-id='ca_name_venuedeliveryschedule.fieldControl-text-box-text']")
    WebElement Del_Name_Ipt;

    @FindBy(xpath ="//input[@data-id='ca_matchid.fieldControl-LookupResultsDropdown_ca_matchid_textInputBox_with_filter_new']")
    WebElement Del_MatchId_Ipt;
    @FindBy(xpath ="//div[@data-id='ca_matchid.fieldControl-LookupResultsDropdown_ca_matchid_tabContainer']")
    WebElement Del_MatchId_Div;
    @FindBy(xpath ="//div[@data-id='ca_matchid.fieldControl-LookupResultsDropdown_ca_matchid_selected_tag_text']")
    WebElement Del_MatchId_DivIpt;

    @FindBy(xpath ="//input[@data-id='ca_atmatchcontact.fieldControl-LookupResultsDropdown_ca_atmatchcontact_textInputBox_with_filter_new']")
    WebElement Del_MatchContact_Ipt;
    @FindBy(xpath ="//div[@data-id='ca_atmatchcontact.fieldControl-LookupResultsDropdown_ca_atmatchcontact_tabContainer']")
    WebElement Del_MatchContact_Div;
    @FindBy(xpath ="//div[@data-id='ca_atmatchcontact.fieldControl-LookupResultsDropdown_ca_atmatchcontact_selected_tag_text']")
    WebElement Del_MatchContact_DivIpt;

    @FindBy(xpath ="//input[@data-id='ca_sendercompany.fieldControl-LookupResultsDropdown_ca_sendercompany_textInputBox_with_filter_new']")
    WebElement Del_SenderComp_Ipt;
    @FindBy(xpath ="//div[@data-id='ca_sendercompany.fieldControl-LookupResultsDropdown_ca_sendercompany_tabContainer']")
    WebElement Del_SenderComp_Div;
    @FindBy(xpath ="//div[@data-id='ca_sendercompany.fieldControl-LookupResultsDropdown_ca_sendercompany_selected_tag_text']")
    WebElement Del_SenderComp_DivIpt;

    @FindBy(xpath ="//input[@data-id='ca_deliverywindowid.fieldControl-LookupResultsDropdown_ca_deliverywindowid_textInputBox_with_filter_new']")
    WebElement Del_Window_Ipt;
    @FindBy(xpath ="//div[@data-id='ca_deliverywindowid.fieldControl-LookupResultsDropdown_ca_deliverywindowid_tabContainer']")
    WebElement Del_Window_Div;
    @FindBy(xpath ="//div[@data-id='ca_deliverywindowid.fieldControl-LookupResultsDropdown_ca_deliverywindowid_selected_tag_text']")
    WebElement Del_Window_DivIpt;

    @FindBy(xpath ="//button[contains(@aria-label,'Pallets: Required: ')]")
    WebElement Del_Pallets_Btn;
    @FindBy(xpath ="//button[contains(@aria-label,'Boxes: Required: ')]")
    WebElement Del_boxes_Btn;
    @FindBy(xpath ="//input[@data-id='ca_numberofpallets.fieldControl-whole-number-text-input']")
    WebElement Del_PalletsNum_Ipt;

    @FindBy(xpath ="//button[@data-id='ca_venuedeliveryschedule|NoRelationship|Form|Mscrm.Form.ca_venuedeliveryschedule.Save']")
    WebElement Del_Save_Btn;

    @FindBy(xpath ="//span[@data-id='ca_name_venuedeliveryschedule-error-message']")
    WebElement Del_Name_ErrSpn;
    @FindBy(xpath ="//span[@data-id='ca_matchid-error-message']")
    WebElement Del_MatchId_ErrSpn;
    @FindBy(xpath ="//span[@data-id='ca_atmatchcontact-error-message']")
    WebElement Del_MatchCont_ErrSpn;
    @FindBy(xpath ="//span[@data-id='ca_sendercompany-error-message']")
    WebElement Del_SenderComp_ErrSpn;
    @FindBy(xpath ="//span[@data-id='ca_pallets-error-message']")
    WebElement Del_Pallets_ErrSpn;
    @FindBy(xpath ="//span[@data-id='ca_numberofpallets-error-message']")
    WebElement Del_PalletsNum_ErrSpn;

    @FindBy(xpath ="//select[@data-id='ca_pickup.fieldControl-option-set-select']")
    WebElement Del_PickUp_Select;
    @FindBy(xpath ="//input[@data-id='ca_deliverystartdate.fieldControl-date-time-input']")
    WebElement Del_StartDate_Ipt;
    /*@FindBy(xpath ="")
    WebElement Del_;*/

    public Deliveries(){PageFactory.initElements(driver, this);}
    public void verifyNewOrExistDel(String IsNewDel) throws InterruptedException{
        Thread.sleep(2000);
        Del_Tab_Li.click();
        Thread.sleep(2000);
        if(IsNewDel.equalsIgnoreCase("new")){
            Del_New_Btn.click();
            Thread.sleep(2000);
        }
        else{
            Del_Search_Ipt.click();
            Del_Search_Ipt.sendKeys(IsNewDel);
            Del_Search_Btn.click();
            Thread.sleep(2000);

            String str_xpath = "//span[text()='" + IsNewDel + "']";
            WebElement Del_Exist = driver.findElement(By.xpath(str_xpath));
            //Del_Exist.click();
            act.moveToElement(Del_Exist).click().doubleClick().build().perform();
        }
    }

    public void verifySaveMandatoryFields(String Del_Name_Rec, String Del_MatchId_Rec, String Del_MatchContact_Rec
                                    , String Del_SenderComp_Rec, String Del_Pallets_Rec, String Del_Boxes_Rec
                                    , String Del_PalletsNum_Rec, String Del_Pickup_Rec, String Del_StartDate_Rec
                                    , String Del_Window_Rec) throws InterruptedException, AWTException {
        Robot robot = new Robot();
        Thread.sleep(2000);
        if(Del_Name_Ipt.getAttribute("value").equalsIgnoreCase("---")){
            Del_Name_Ipt.click();
            Del_Name_Ipt.sendKeys("");
            Del_Name_Ipt.sendKeys(Del_Name_Rec);
        }
        Thread.sleep(2000);

        String str_Del_MatchId = "";
        String str_Del_MatchCont = "";
        String str_Del_SenderComp = "";
        String str_Del_Window = "";

        try{
            str_Del_MatchId = Del_MatchId_DivIpt.getAttribute("title");
        } catch (Exception e){
            str_Del_MatchId = Del_MatchId_Ipt.getAttribute("value");
        }
        Thread.sleep(2000);
        if(str_Del_MatchId.equalsIgnoreCase("---")){
            Thread.sleep(2000);
            Del_MatchId_Ipt.click();
            Del_MatchId_Ipt.sendKeys("");
            Del_MatchId_Ipt.sendKeys(Del_MatchId_Rec);
            Thread.sleep(6000);

            List<WebElement> Del_MatchId_Lookup = Del_MatchId_Div.findElements(By.tagName("li"));

            for (int i = 0; i < Del_MatchId_Lookup.size(); i++) {
                String[] str_RefLookup = Del_MatchId_Lookup.get(i).getAttribute("aria-label").split(",");

                if (str_RefLookup[0].equalsIgnoreCase(Del_MatchId_Rec)) {
                    Del_MatchId_Lookup.get(i).click();
                    Thread.sleep(3000);
                    break;
                }
            }

        }
        Thread.sleep(2000);

        try{
            str_Del_MatchCont = Del_MatchContact_DivIpt.getAttribute("title");
        } catch (Exception e){
            str_Del_MatchCont = Del_MatchContact_Ipt.getAttribute("value");
        }
        Thread.sleep(2000);
        if(str_Del_MatchCont.equalsIgnoreCase("---")){
            Thread.sleep(2000);
            Del_MatchContact_Ipt.click();
            Del_MatchContact_Ipt.sendKeys("");
            Del_MatchContact_Ipt.sendKeys(Del_MatchContact_Rec);
            Thread.sleep(6000);

            List<WebElement> Del_MatchCont_Lookup = Del_MatchContact_Div.findElements(By.tagName("li"));

            for (int i = 0; i < Del_MatchCont_Lookup.size(); i++) {
                String[] str_RefLookup = Del_MatchCont_Lookup.get(i).getAttribute("aria-label").split(",");

                if (str_RefLookup[0].equalsIgnoreCase(Del_MatchContact_Rec)) {
                    Del_MatchCont_Lookup.get(i).click();
                    Thread.sleep(3000);
                    break;
                }
            }

        }
        Thread.sleep(2000);

        try{
            str_Del_SenderComp = Del_SenderComp_DivIpt.getAttribute("title");
        } catch (Exception e){
            str_Del_SenderComp = Del_SenderComp_Ipt.getAttribute("value");
        }
        Thread.sleep(2000);
        if(str_Del_SenderComp.equalsIgnoreCase("---")){
            Thread.sleep(2000);
            Del_SenderComp_Ipt.click();
            Del_SenderComp_Ipt.sendKeys("");
            Del_SenderComp_Ipt.sendKeys(Del_SenderComp_Rec);
            Thread.sleep(6000);

            List<WebElement> Del_SenderComp_Lookup = Del_SenderComp_Div.findElements(By.tagName("li"));

            for (int i = 0; i < Del_SenderComp_Lookup.size(); i++) {
                String[] str_RefLookup = Del_SenderComp_Lookup.get(i).getAttribute("aria-label").split(",");

                if (str_RefLookup[0].equalsIgnoreCase(Del_SenderComp_Rec)) {
                    Del_SenderComp_Lookup.get(i).click();
                    Thread.sleep(3000);
                    break;
                }
            }

        }

        try{
            str_Del_Window = Del_Window_DivIpt.getAttribute("title");
        } catch (Exception e){
            str_Del_Window = Del_Window_Ipt.getAttribute("value");
        }
        Thread.sleep(2000);
        if(str_Del_Window.equalsIgnoreCase("---"))      {
            Thread.sleep(2000);
            Del_Window_Ipt.click();
            Del_Window_Ipt.sendKeys("");
            Del_Window_Ipt.sendKeys(Del_Window_Rec);
            Thread.sleep(6000);

            List<WebElement> Del_Window_Lookup = Del_Window_Div.findElements(By.tagName("li"));

            for (int i = 0; i < Del_Window_Lookup.size(); i++) {
                String[] str_RefLookup = Del_Window_Lookup.get(i).getAttribute("aria-label").split(",");

                if (str_RefLookup[0].equalsIgnoreCase(Del_Window_Rec)) {
                    Del_Window_Lookup.get(i).click();
                    Thread.sleep(3000);
                    break;
                }
            }

        }

        Thread.sleep(2000);
        if(Del_PickUp_Select.getAttribute("title").equalsIgnoreCase("---")){
            Select se_Del_PickUp = new Select(Del_PickUp_Select);
            se_Del_PickUp.selectByVisibleText(Del_Pickup_Rec);
        }
        //div[contains(@class,'monthPickerWrapper')]
        //button[contains(@class,'dayButton-')]

        Thread.sleep(2000);
        if(Del_PickUp_Select.getAttribute("title").equalsIgnoreCase("yes")) {
            if (Del_StartDate_Ipt.getAttribute("value").equalsIgnoreCase("")) {
                List<WebElement> DatePicker_i = driver.findElements(By.xpath("//i[@data-icon-name='Calendar']"));
                DatePicker_i.get(0).click();
                Thread.sleep(2000);
                String[] str_DateSplit = Del_StartDate_Rec.split(", ");

                String str_MonthPath = "//button[@aria-label='" + str_DateSplit[1] + "']";
                String str_DayPath = "//button[@aria-label='" + Del_StartDate_Rec + "']";

                WebElement Month_Element = driver.findElement(By.xpath(str_MonthPath));
                Month_Element.click();
                Thread.sleep(2000);

                WebElement Day_Element = driver.findElement(By.xpath(str_DayPath));
                Day_Element.click();
                /*List<WebElement> Month_Btn = driver.findElements(By.xpath("//button[contains(@class,'itemButton-')]"));
                for (int i = 0; i < Month_Btn.size(); i++) {
                    if (Month_Btn.get(i).getAttribute("aria-label").equalsIgnoreCase(str_DateSplit[1])) {
                        Month_Btn.get(i).click();
                        break;
                    }
                    Thread.sleep(2000);
                }

                List<WebElement> Date_Btn = driver.findElements(By.xpath("//button[contains(@class,'dayButton-')]"));
                for (int i = 0; i < Date_Btn.size(); i++) {
                    if (Date_Btn.get(i).getAttribute("aria-label").equalsIgnoreCase(Del_StartDate_Rec)) {
                        Date_Btn.get(i).click();
                        break;
                    }
                }*/
            }
        }
        Thread.sleep(2000);

        for(int i=0; i<4;i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(2000);
        }

        if(Del_Pallets_Rec.equalsIgnoreCase("yes") &&
            Del_Pallets_Btn.getAttribute("aria-checked").equalsIgnoreCase("false")){
                Del_Pallets_Btn.click();
        }
        else if(Del_Pallets_Rec.equalsIgnoreCase("no") &&
                Del_Pallets_Btn.getAttribute("aria-checked").equalsIgnoreCase("true")){
            Del_Pallets_Btn.click();
        }
        Thread.sleep(2000);

        if(Del_Boxes_Rec.equalsIgnoreCase("yes") &&
                Del_boxes_Btn.getAttribute("aria-checked").equalsIgnoreCase("false")){
            Del_boxes_Btn.click();
        }
        else if(Del_Boxes_Rec.equalsIgnoreCase("no") &&
                Del_boxes_Btn.getAttribute("aria-checked").equalsIgnoreCase("true")){
            Del_boxes_Btn.click();
        }
        Thread.sleep(2000);

        if(Del_PalletsNum_Ipt.getAttribute("value").equalsIgnoreCase("---")){
            Del_PalletsNum_Ipt.click();
            Del_PalletsNum_Ipt.sendKeys("");
            Del_PalletsNum_Ipt.sendKeys(Del_PalletsNum_Rec);
        }
        Thread.sleep(2000);
        Del_Save_Btn.click();
    }

    public void verifyMandatoryErrorMsg(){
        sa_All.assertEquals(Del_Name_ErrSpn.isDisplayed(),false,"Delivery Name field is mandatory");
        sa_All.assertEquals(Del_MatchId_ErrSpn.isDisplayed(),false,"Match Id field is mandatory");
        sa_All.assertEquals(Del_MatchCont_ErrSpn.isDisplayed(),false,"At Match Contact field is mandatory");
        sa_All.assertEquals(Del_SenderComp_ErrSpn.isDisplayed(),false,"Sender Company field is mandatory");
        sa_All.assertEquals(Del_Pallets_ErrSpn.isDisplayed(),false,"Pallets or boxes field is mandatory");
        sa_All.assertEquals(Del_PalletsNum_ErrSpn.isDisplayed(),false,"Pallets Number field is mandatory");

        sa_All.assertAll();
    }
}
