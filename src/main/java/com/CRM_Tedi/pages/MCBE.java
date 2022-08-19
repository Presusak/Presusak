package com.CRM_Tedi.pages;

import com.CRM_Tedi.base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class MCBE extends Page {
    Actions act = new Actions(driver);
    SoftAssert sa_All = new SoftAssert();

    @FindBy(xpath = "//span[text()='MCBE']")
    WebElement Mcbe_Tab_Span;

    @FindBy(xpath = "//button[@data-id='ca_mcbe|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.ca_mcbe.NewRecord']")
    WebElement Mcbe_New_Btn;
    @FindBy(xpath = "//input[@aria-label='MCBE Quick find']")
    WebElement Mcbe_Search_Ipt;
    @FindBy(xpath = "//button[@aria-label='Start search']")
    WebElement Mcbe_Search_Btn;
    @FindBy(xpath = "//input[@data-id='ca_name_mcbe.fieldControl-text-box-text']")
    WebElement Mcbe_Title_Ipt;
    @FindBy(xpath = "//textarea[@data-id='ca_experiencedetail.fieldControl-text-box-text']")
    WebElement Mcbe_ExpDetails_Ipt;

    @FindBy(xpath = "//select[@data-id='ca_mcbetype.fieldControl-option-set-select']")
    WebElement Mcbe_Type_Select;
    /*
    @FindBy(xpath = "//input[@data-id='ca_mcbeowner.fieldControl-LookupResultsDropdown_ca_mcbeowner_textInputBox_with_filter_new']")
    WebElement Mcbe_Owner_Ipt;
    @FindBy(xpath = "//div[@data-id='ca_mcbeowner.fieldControl-LookupResultsDropdown_ca_mcbeowner_tabContainer']")
    WebElement Mcbe_Owner_Div;
    @FindBy(xpath = "//div[@data-id='ca_mcbeowner.fieldControl-LookupResultsDropdown_ca_mcbeowner_selected_tag_text']")
    WebElement Mcbe_Owner_DivIpt;
    */
    @FindBy(xpath = "//button[@data-id='ca_mcbe|NoRelationship|Form|Mscrm.Form.ca_mcbe.Save']")
    WebElement Mcbe_Save_Btn;

    @FindBy(xpath = "//li[@title='MCBE Matches']")
    WebElement McbeMatch_Tab;
    @FindBy(xpath = "//button[@data-id='ca_mcbematch|NoRelationship|SubGridStandard|Mscrm.SubGrid.ca_mcbematch.AddNewStandard']")
    WebElement McbeMatch_New_Btn;

    @FindBy(xpath = "//input[@data-id='ca_matchid.fieldControl-LookupResultsDropdown_ca_matchid_textInputBox_with_filter_new']")
    WebElement McbeMatch_MatchId_Ipt;
    @FindBy(xpath = "//div[@data-id='ca_matchid.fieldControl-LookupResultsDropdown_ca_matchid_tabContainer']")
    WebElement McbeMatch_MatchId_Div;
    @FindBy(xpath = "//div[@data-id='ca_matchid.fieldControl-LookupResultsDropdown_ca_matchid_selected_tag_text']")
    WebElement McbeMatch_MatchId_DivIpt;

    @FindBy(xpath = "//input[@data-id='ca_matchday.fieldControl-LookupResultsDropdown_ca_matchday_textInputBox_with_filter_new']")
    WebElement McbeMatch_MatchDay_Ipt;
    @FindBy(xpath = "//div[@data-id='ca_matchday.fieldControl-LookupResultsDropdown_ca_matchday_tabContainer']")
    WebElement McbeMatch_MatchDay_Div;
    @FindBy(xpath = "//div[@data-id='ca_matchday.fieldControl-LookupResultsDropdown_ca_matchday_selected_tag_text']")
    WebElement McbeMatch_MatchDay_DivIpt;

    @FindBy(xpath = "//input[@data-id='ca_matchtime.fieldControl-date-time-input']")
    WebElement McbeMatch_MatchTime_Ipt;
    @FindBy(xpath = "//button[@data-id='ca_mcbematch|NoRelationship|Form|Mscrm.Form.ca_mcbematch.Save']")
    WebElement McbeMatch_Save_Btn;

    @FindBy(xpath = "//button[@data-id='OverflowButton']")
    WebElement McbeMatch_OverFlow_Btn;
    @FindBy(xpath = "//button[@data-id='ca_mcbematch|NoRelationship|Form|Mscrm.Form.ca_mcbematch.Flows.RefreshCommandBar']")
    WebElement McbeMatch_Flow_Btn;
    @FindBy(xpath = "//*[contains(text(),'Start Approval')]")
    WebElement McbeMatch_StartApp_Btn;
    @FindBy(xpath = "//button[@data-id='confirmButton']")
    WebElement McbeMatch_Confirm_Btn;

    @FindBy(xpath = "//button[@data-id='ca_mcbematch|NoRelationship|Form|Mscrm.Form.ca_mcbematch.RefreshModernButton']")
    WebElement McbeMatch_Refresh_Btn;

    @FindBy(xpath = "//select[@data-id='ca_mcbematchapprovalstatus.fieldControl-option-set-select']")
    WebElement McbeMatch_AppStatus;

    @FindBy(xpath = "//select[@data-id='ca_commercialapprovalstatus.fieldControl-option-set-select']")
    WebElement McbeMatch_AppStatus_Comm;
    @FindBy(xpath = "//select[@data-id='ca_stateeventmanagerapprovalstatus.fieldControl-option-set-select']")
    WebElement McbeMatch_AppStatus_StateMgr;
    @FindBy(xpath = "//select[@data-id='ca_riskmanagerapprovalstatus.fieldControl-option-set-select']")
    WebElement McbeMatch_AppStatus_RiskMgr;
    @FindBy(xpath = "//select[@data-id='ca_securitymanagerapprovalstatus.fieldControl-option-set-select']")
    WebElement McbeMatch_AppStatus_SecMgr;
    @FindBy(xpath = "//select[@data-id='ca_eventdirectorapprovalstatus.fieldControl-option-set-select']")
    WebElement McbeMatch_AppStatus_EventDir;

    public MCBE(){PageFactory.initElements(driver, this);}

    public void verifyNewOrExistMcbe(String IsNewMcbe) throws InterruptedException{
        Thread.sleep(2000);
        Mcbe_Tab_Span.click();
        Thread.sleep(2000);

        if(IsNewMcbe.equalsIgnoreCase("new")){
            Mcbe_New_Btn.click();
        }
        else {
            Mcbe_Search_Ipt.click();
            Mcbe_Search_Ipt.sendKeys(IsNewMcbe);
            Mcbe_Search_Btn.click();

            Thread.sleep(3000);

            String str_xpath = "//a[@aria-label='" + IsNewMcbe + "']";
            WebElement McbeLink = driver.findElement(By.xpath(str_xpath));
            McbeLink.click();
        }
    }

    public void verifyMcbeRecord(String MCBE_Title_Rec, String MCBE_ExpDetails_Rec
                                    , String MCBE_Type_Rec) throws InterruptedException{
        Thread.sleep(2000);
        if(Mcbe_Title_Ipt.getAttribute("value").equalsIgnoreCase("---")){
            Mcbe_Title_Ipt.click();
            Mcbe_Title_Ipt.sendKeys("");
            Mcbe_Title_Ipt.sendKeys(MCBE_Title_Rec);
        }

        Thread.sleep(2000);
       if(Mcbe_Type_Select.getAttribute("title").equalsIgnoreCase("---")){
            Select se_McbeType = new Select(Mcbe_Type_Select);
            se_McbeType.selectByVisibleText(MCBE_Type_Rec);
        }
        Thread.sleep(2000);
                /* String str_McbeOwner = "";
                try {
                    str_McbeOwner = Mcbe_Owner_DivIpt.getAttribute("title");
                }
                catch (Exception e){
                    str_McbeOwner = Mcbe_Owner_Ipt.getAttribute("value");
                }
                if(str_McbeOwner.equalsIgnoreCase("---")){
                    Thread.sleep(2000);
                    Mcbe_Owner_Ipt.click();
                    Mcbe_Owner_Ipt.sendKeys("");
                    Mcbe_Owner_Ipt.sendKeys(MCBE_Owner_Rec);
                    Thread.sleep(6000);

                    List<WebElement> Mcbe_Owner_LookUp = Mcbe_Owner_Div.findElements(By.tagName("li"));

                    for (int j = 0; j < Mcbe_Owner_LookUp.size(); j++) {
                        String[] str_OwnerLookup = Mcbe_Owner_LookUp.get(j).getAttribute("aria-label").split(",");
                        if (str_OwnerLookup[0].equalsIgnoreCase(MCBE_Owner_Rec)) {
                            Mcbe_Owner_LookUp.get(j).click();
                            Thread.sleep(3000);
                            break;
                        }
                    }
                }
                Thread.sleep(2000);*/
        if(Mcbe_ExpDetails_Ipt.getAttribute("value").equalsIgnoreCase("---")){
            Mcbe_ExpDetails_Ipt.click();
            Mcbe_ExpDetails_Ipt.sendKeys("");
            Mcbe_ExpDetails_Ipt.sendKeys(MCBE_ExpDetails_Rec);
        }
        Mcbe_Save_Btn.click();
        Thread.sleep(2000);
    }

    public void verifyMcbeMatchNewOrExist(String IsNewMcbeMatch) throws InterruptedException{
        Thread.sleep(2000);
        /*McbeMatch_Tab.click();
        Thread.sleep(2000);*/

        if(IsNewMcbeMatch.equalsIgnoreCase("new")){
            McbeMatch_New_Btn.click();
            Thread.sleep(2000);
        }
        else{
            int k = Integer.parseInt(IsNewMcbeMatch);
            List<WebElement> McbeMatch_Exist = driver.findElements(By.xpath("//div[@col-id='ca_matchtime']"));
            //McbeMatch_Exist.get(k).click();
            act.moveToElement(McbeMatch_Exist.get(k)).doubleClick().build().perform();
            Thread.sleep(2000);
        }
    }
    public void verifyMcbeMatchRecord(String McbeMatch_MatchId_Rec, String McbeMatch_MatchDay_Rec
                                    , String McbeMatch_Time_Rec) throws InterruptedException{
        Thread.sleep(2000);
        String str_MatchId = "";
        try{
            str_MatchId = McbeMatch_MatchId_DivIpt.getAttribute("title");
        }
        catch (Exception e){
            str_MatchId = McbeMatch_MatchId_Ipt.getAttribute("value");
        }
        if(str_MatchId.equalsIgnoreCase("---")){
            Thread.sleep(2000);
            McbeMatch_MatchId_Ipt.click();
            McbeMatch_MatchId_Ipt.sendKeys("");
            McbeMatch_MatchId_Ipt.sendKeys(McbeMatch_MatchId_Rec);
            Thread.sleep(6000);

            List<WebElement> McbeMatch_MatchId_Lookup = McbeMatch_MatchId_Div.findElements(By.tagName("li"));

            for (int i = 0; i < McbeMatch_MatchId_Lookup.size(); i++) {
                String[] str_RefLookup = McbeMatch_MatchId_Lookup.get(i).getAttribute("aria-label").split(",");

                if (str_RefLookup[0].equalsIgnoreCase(McbeMatch_MatchId_Rec)) {
                    McbeMatch_MatchId_Lookup.get(i).click();
                    Thread.sleep(3000);
                    break;
                }
            }
        }

        Thread.sleep(2000);
        String str_MatchDay = "";
        try{
            str_MatchDay = McbeMatch_MatchDay_DivIpt.getAttribute("title");
        }
        catch (Exception e){
            str_MatchDay = McbeMatch_MatchDay_Ipt.getAttribute("value");
        }
        if(str_MatchDay.equalsIgnoreCase("---")){
            Thread.sleep(2000);
            McbeMatch_MatchDay_Ipt.click();
            McbeMatch_MatchDay_Ipt.sendKeys("");
            McbeMatch_MatchDay_Ipt.sendKeys(McbeMatch_MatchDay_Rec);
            Thread.sleep(6000);

            List<WebElement> McbeMatch_MatchDay_Lookup = McbeMatch_MatchDay_Div.findElements(By.tagName("li"));

            for (int i = 0; i < McbeMatch_MatchDay_Lookup.size(); i++) {
                String[] str_RefLookup = McbeMatch_MatchDay_Lookup.get(i).getAttribute("aria-label").split(",");

                if (str_RefLookup[0].equalsIgnoreCase(McbeMatch_MatchDay_Rec)) {
                    McbeMatch_MatchDay_Lookup.get(i).click();
                    Thread.sleep(3000);
                    break;
                }
            }
        }

        Thread.sleep(2000);
        if(McbeMatch_MatchTime_Ipt.getAttribute("value").equalsIgnoreCase("")){
            List<WebElement> DatePicker_i = driver.findElements(By.xpath("//i[@data-icon-name='Calendar']"));
            DatePicker_i.get(0).click();
            Thread.sleep(2000);
            String[] str_DateSplit = McbeMatch_Time_Rec.split(", ");

            String str_MonthPath = "//button[@aria-label='" + str_DateSplit[1] + "']";
            String str_DayPath = "//button[@aria-label='" + McbeMatch_Time_Rec + "']";

            WebElement Month_Element = driver.findElement(By.xpath(str_MonthPath));
            Month_Element.click();
            Thread.sleep(2000);

            WebElement Day_Element = driver.findElement(By.xpath(str_DayPath));
            Day_Element.click();
            /*List<WebElement> Month_Btn = driver.findElements(By.xpath("//button[contains(@class,'itemButton-')]"));
            for(int i=0;i<Month_Btn.size();i++){
                if(Month_Btn.get(i).getAttribute("aria-label").equalsIgnoreCase(str_DateSplit[1])){
                    Month_Btn.get(i).click();
                    break;
                }
                Thread.sleep(2000);
            }

            List<WebElement> Date_Btn = driver.findElements(By.xpath("//button[contains(@class,'dayButton-')]"));
            for(int i=0;i<Date_Btn.size();i++){
                if(Date_Btn.get(i).getAttribute("aria-label").equalsIgnoreCase(McbeMatch_Time_Rec)){
                    Date_Btn.get(i).click();
                    break;
                }
            }*/
        }

        Thread.sleep(2000);
        McbeMatch_Save_Btn.click();
    }

    public void verifyMcbeMatch_StartAppFlow() throws InterruptedException{
        if(McbeMatch_AppStatus.getAttribute("title").equalsIgnoreCase("Not Started")) {
            Thread.sleep(2000);
            McbeMatch_OverFlow_Btn.click();
            Thread.sleep(2000);
            McbeMatch_Flow_Btn.click();
            Thread.sleep(6000);

            McbeMatch_StartApp_Btn.click();
            Thread.sleep(2000);
            McbeMatch_Confirm_Btn.click();
            Thread.sleep(4000);

            McbeMatch_Refresh_Btn.click();
            Thread.sleep(4000);

            sa_All.assertEquals(McbeMatch_AppStatus.getAttribute("title").trim(), "Pending Approval", "Approval Not Started Successfully!!!");
            sa_All.assertAll();
        }
    }
    public void verifyMcbeMatch_UpdateAppStatus(String Comm_AppStatus_Rec, String StateMgr_AppStatus_Rec
                                                , String RiskMgr_AppStatus_Rec, String SecMgr_AppStatus_Rec
                                                , String EventDir_AppStatus_Rec) throws InterruptedException, AWTException {
        Robot robot = new Robot();
        Thread.sleep(2000);
        if(McbeMatch_AppStatus_Comm.getAttribute("title").equalsIgnoreCase("Pending Approval")
            && !Comm_AppStatus_Rec.equalsIgnoreCase("NA")){
            Select AppStatus_Comm = new Select(McbeMatch_AppStatus_Comm);
            AppStatus_Comm.selectByVisibleText(Comm_AppStatus_Rec);
        }

        for(int i=0; i<4;i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(2000);
        }
        Thread.sleep(2000);
        if(McbeMatch_AppStatus_StateMgr.getAttribute("title").equalsIgnoreCase("Pending Approval")
                && !StateMgr_AppStatus_Rec.equalsIgnoreCase("NA")){
            Select AppStatus_StateMgr = new Select(McbeMatch_AppStatus_StateMgr);
            AppStatus_StateMgr.selectByVisibleText(StateMgr_AppStatus_Rec);
        }

        for(int i=0; i<4;i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(2000);
        }
        Thread.sleep(2000);
        if(McbeMatch_AppStatus_RiskMgr.getAttribute("title").equalsIgnoreCase("Pending Approval")
                && !RiskMgr_AppStatus_Rec.equalsIgnoreCase("NA")){
            Select AppStatus_RiskMgr = new Select(McbeMatch_AppStatus_RiskMgr);
            AppStatus_RiskMgr.selectByVisibleText(RiskMgr_AppStatus_Rec);
        }

        for(int i=0; i<4;i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(2000);
        }
        Thread.sleep(2000);
        if(McbeMatch_AppStatus_SecMgr.getAttribute("title").equalsIgnoreCase("Pending Approval")
                && !SecMgr_AppStatus_Rec.equalsIgnoreCase("NA")){
            Select AppStatus_SecMgr = new Select(McbeMatch_AppStatus_SecMgr);
            AppStatus_SecMgr.selectByVisibleText(SecMgr_AppStatus_Rec);
        }

        for(int i=0; i<4;i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(2000);
        }
        Thread.sleep(2000);
        if(McbeMatch_AppStatus_EventDir.getAttribute("title").equalsIgnoreCase("Pending Approval")
                && !EventDir_AppStatus_Rec.equalsIgnoreCase("NA")){
            Select AppStatus_EventDir = new Select(McbeMatch_AppStatus_EventDir);
            AppStatus_EventDir.selectByVisibleText(EventDir_AppStatus_Rec);
        }

        Thread.sleep(2000);
        McbeMatch_Save_Btn.click();

    }
}
