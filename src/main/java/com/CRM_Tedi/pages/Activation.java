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

public class Activation extends Page {
    Actions act = new Actions(driver);
    SoftAssert sa_All = new SoftAssert();

    @FindBy(xpath = "//span[text()='Activations']")
    WebElement Act_Tab_Spn;

    @FindBy(xpath = "//button[@data-id='ca_activation|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.ca_activation.NewRecord']")
    WebElement Act_New_Btn;
    @FindBy(xpath = "//input[@aria-label='Activation Quick find']")
    WebElement Act_Search_Ipt;
    @FindBy(xpath = "//button[@aria-label='Start search']")
    WebElement Act_Search_Btn;

    @FindBy(xpath="//input[@data-id='ca_name_activation.fieldControl-text-box-text']")
    WebElement Act_Name_Ipt;

    @FindBy(xpath = "//input[@data-id='ca_time.fieldControl-date-time-input']")
    WebElement Act_Time_Ipt;

    @FindBy(xpath = "//input[@data-id='ca_activationorganisationid.fieldControl-LookupResultsDropdown_ca_activationorganisationid_textInputBox_with_filter_new']")
    WebElement Act_OrgId_Ipt;
    @FindBy(xpath = "//div[@data-id='ca_activationorganisationid.fieldControl-LookupResultsDropdown_ca_activationorganisationid_tabContainer']")
    WebElement Act_OrgId_Div;
    @FindBy(xpath = "//div[@data-id='ca_activationorganisationid.fieldControl-LookupResultsDropdown_ca_activationorganisationid_selected_tag_text']")
    WebElement Act_OrgId_DivIpt;

    @FindBy(xpath = "//input[@data-id='ca_activationorganisationcontactid.fieldControl-LookupResultsDropdown_ca_activationorganisationcontactid_textInputBox_with_filter_new']")
    WebElement Act_Contact_Ipt;
    @FindBy(xpath = "//div[@data-id='ca_activationorganisationcontactid.fieldControl-LookupResultsDropdown_ca_activationorganisationcontactid_tabContainer']")
    WebElement Act_Contact_Div;
    @FindBy(xpath = "//div[@data-id='ca_activationorganisationcontactid.fieldControl-LookupResultsDropdown_ca_activationorganisationcontactid_selected_tag_text']")
    WebElement Act_Contact_DivIpt;

    @FindBy(xpath = "//textarea[@data-id='ca_toplinedescriptionofactivation.fieldControl-text-box-text']")
    WebElement Act_AddDetails_Ipt;

    @FindBy(xpath = "//select[@data-id='ca_powerrequirement.fieldControl-option-set-select']")
    WebElement Act_PowerReq_Select;
    @FindBy(xpath = "//select[@data-id='ca_securityrequirements.fieldControl-option-set-select']")
    WebElement Act_SecReq_Select;
    @FindBy(xpath = "//select[@data-id='ca_handoutsrequired.fieldControl-option-set-select']")
    WebElement Act_HandoutReq_Select;

    @FindBy(xpath = "//input[@data-id='ca_powerdetailselectricity.fieldControl-text-box-text']")
    WebElement Act_PowerReq_Details_Ipt;
    @FindBy(xpath = "//input[@data-id='ca_securityrequirementdetails.fieldControl-text-box-text']")
    WebElement Act_SecReq_Details_Ipt;
    @FindBy(xpath = "//input[@data-id='ca_handoutsgiveawaydetails.fieldControl-text-box-text']")
    WebElement Act_HandoutReq_Details_Ipt;
    @FindBy(xpath="//button[@data-id='ca_activation|NoRelationship|Form|Mscrm.Form.ca_activation.Save']")
    WebElement Act_Save_Btn;
    @FindBy(xpath = "//li[@aria-label='Activation Matches']")
    WebElement Act_ActMatch_Tab;

    @FindBy(xpath="//button[@data-id='ca_activationmatch|NoRelationship|SubGridStandard|Mscrm.SubGrid.ca_activationmatch.AddNewStandard']")
    WebElement ActMatch_New_Btn;

    @FindBy(xpath="//input[@data-id='ca_matchid.fieldControl-LookupResultsDropdown_ca_matchid_textInputBox_with_filter_new']")
    WebElement ActMatch_MatchId_Ipt;
    @FindBy(xpath="//div[@data-id='ca_matchid.fieldControl-LookupResultsDropdown_ca_matchid_tabContainer']")
    WebElement ActMatch_MatchId_Div;
    @FindBy(xpath="//div[@data-id='ca_matchid.fieldControl-LookupResultsDropdown_ca_matchid_selected_tag_text']")
    WebElement ActMatch_MatchId_DivIpt;

    @FindBy(xpath="//input[@data-id='ca_matchday.fieldControl-LookupResultsDropdown_ca_matchday_textInputBox_with_filter_new']")
    WebElement ActMatch_MatchDay_Ipt;
    @FindBy(xpath="//div[@data-id='ca_matchday.fieldControl-LookupResultsDropdown_ca_matchday_tabContainer']")
    WebElement ActMatch_MatchDay_Div;
    @FindBy(xpath="//div[@data-id='ca_matchday.fieldControl-LookupResultsDropdown_ca_matchday_selected_tag_text']")
    WebElement ActMatch_MatchDay_DivIpt;

    @FindBy(xpath="//select[@data-id='ca_uploadcertificatessafetydocumentation.fieldControl-option-set-select']")
    WebElement ActMatch_CertiDoc_Select;
    @FindBy(xpath="//input[@data-id='ca_matchtime.fieldControl-date-time-input']")
    WebElement ActMatch_MatchTime_Ipt;
    @FindBy(xpath = "//textarea[@data-id='ca_decriptionofcollateral.fieldControl-text-box-text']")
    WebElement ActMatch_AddDetails_Ipt;

    @FindBy(xpath = "//input[@data-id='ca_agencyid.fieldControl-LookupResultsDropdown_ca_agencyid_textInputBox_with_filter_new']")
    WebElement ActMatch_AgencyId_Ipt;
    @FindBy(xpath = "//div[@data-id='ca_agencyid.fieldControl-LookupResultsDropdown_ca_agencyid_tabContainer']")
    WebElement ActMatch_AgencyId_Div;
    @FindBy(xpath = "//div[@data-id='ca_agencyid.fieldControl-LookupResultsDropdown_ca_agencyid_selected_tag_text']")
    WebElement ActMatch_AgencyId_DivIpt;

    @FindBy(xpath = "//input[@data-id='ca_agencycontactid.fieldControl-LookupResultsDropdown_ca_agencycontactid_textInputBox_with_filter_new']")
    WebElement ActMatch_AgencyContact_Ipt;
    @FindBy(xpath = "//div[@data-id='ca_agencycontactid.fieldControl-LookupResultsDropdown_ca_agencycontactid_tabContainer']")
    WebElement ActMatch_AgencyContact_Div;
    @FindBy(xpath = "//div[@data-id='ca_agencycontactid.fieldControl-LookupResultsDropdown_ca_agencycontactid_selected_tag_text']")
    WebElement ActMatch_AgencyContact_DivIpt;

    @FindBy(xpath = "//input[@data-id='ca_numberofparticipants.fieldControl-whole-number-text-input']")
    WebElement ActMatch_PartiNum_Ipt;
    @FindBy(xpath = "//input[@data-id='ca_numberofstaff.fieldControl-whole-number-text-input']")
    WebElement ActMatch_StaffNum_Ipt;
    @FindBy(xpath = "//input[@data-id='ca_security.fieldControl-text-box-text']")
    WebElement ActMatch_Security_Ipt;
    @FindBy(xpath = "//input[@data-id='ca_venueaccess.fieldControl-text-box-text']")
    WebElement ActMatch_VenueAcc_Ipt;

    @FindBy(xpath="//button[@data-id='ca_activationmatch|NoRelationship|Form|Mscrm.Form.ca_activationmatch.Save']")
    WebElement ActMatch_Save_Btn;
    @FindBy(xpath="//button[@data-id='ca_activationmatch|NoRelationship|Form|Mscrm.Form.ca_activationmatch.RefreshModernButton']")
    WebElement ActMatch_Refresh_Btn;

    @FindBy(xpath="//li[@aria-label='Approval']")
    WebElement ActMatch_AppTab_Li;

    @FindBy(xpath="//button[@data-id='OverflowButton']")
    WebElement ActMatch_Overflow_Btn;
    @FindBy(xpath="//button[@data-id='ca_activationmatch|NoRelationship|Form|Mscrm.Form.ca_activationmatch.Flows.RefreshCommandBar']")
    WebElement ActMatch_Flow_Btn;
    @FindBy(xpath = "//*[contains(text(),'Start Approval')]")
    WebElement ActMatch_StartApp_Btn;
    @FindBy(xpath="//button[@data-id='confirmButton']")
    WebElement ActMatch_Confirm_Btn;

    @FindBy(xpath="//select[@data-id='ca_activationmatchapprovalstatus.fieldControl-option-set-select']")
    WebElement ActMatch_AppStatus;

    @FindBy(xpath="//select[@data-id='ca_commercialapprovalstatus.fieldControl-option-set-select']")
    WebElement ActMatch_AppStatus_CommMgr;
    @FindBy(xpath="//select[@data-id='ca_stateeventmanagerapprovalstatus.fieldControl-option-set-select']")
    WebElement ActMatch_AppStatus_StateMgr;
    @FindBy(xpath="//select[@data-id='ca_riskmanagerapprovalstatus.fieldControl-option-set-select']")
    WebElement ActMatch_AppStatus_RiskMgr;
    @FindBy(xpath="//select[@data-id='ca_securitymanagerapprovalstatus.fieldControl-option-set-select']")
    WebElement ActMatch_AppStatus_SecMgr;
    @FindBy(xpath="//select[@data-id='ca_eventdirectorapprovalstatus.fieldControl-option-set-select']")
    WebElement ActMatch_AppStatus_EventDir;

    public Activation(){PageFactory.initElements(driver, this);}

    public void verifyNewOrExistActivation(String IsNewActivation) throws InterruptedException{
        Thread.sleep(2000);
        Act_Tab_Spn.click();
        Thread.sleep(2000);
        if(IsNewActivation.equalsIgnoreCase("new")){
            Act_New_Btn.click();
            Thread.sleep(2000);
        }
        else {
            Act_Search_Ipt.click();
            Act_Search_Ipt.sendKeys(IsNewActivation);
            Act_Search_Btn.click();
            Thread.sleep(2000);

            String str_xpath = "//span[text()='" + IsNewActivation + "']";
            WebElement Act_Exist_Spn = driver.findElement(By.xpath(str_xpath));
            Act_Exist_Spn.click();
            Thread.sleep(2000);
        }
    }

    public void verifyMandatoryFields(String IsNewActivation, String Act_Title_Rec, String Act_Time_Rec
            , String Act_OrgId_Rec, String Act_Contact_Rec, String Act_AddDetails_Rec, String Act_PowerReq_Rec
            , String Act_SecReq_Rec, String Act_HandoutReq_Rec, String Act_PowerReq_Details_Rec
            , String Act_SecReq_Details_Rec, String Act_HandoutReq_Details_Rec) throws InterruptedException{
        if(Act_Name_Ipt.getAttribute("value").equalsIgnoreCase("---")){
            Act_Name_Ipt.click();
            Act_Name_Ipt.sendKeys("");
            Act_Name_Ipt.sendKeys(Act_Title_Rec);
        }
        Thread.sleep(2000);

        if(Act_Time_Ipt.getAttribute("value").equalsIgnoreCase("")){
            List<WebElement> DatePicker_i = driver.findElements(By.xpath("//i[@data-icon-name='Calendar']"));
            DatePicker_i.get(0).click();
            Thread.sleep(2000);
            String[] str_DateSplit = Act_Time_Rec.split(", ");

            String str_Month_xpath = "//button[@aria-label='"+ str_DateSplit[1] +"']";
            WebElement Month_Btn = driver.findElement(By.xpath(str_Month_xpath));
            Month_Btn.click();
            Thread.sleep(2000);

            String str_Date_xpath = "//button[@aria-label='"+ Act_Time_Rec +"']";
            WebElement Date_Btn = driver.findElement(By.xpath(str_Date_xpath));
            Date_Btn.click();
            Thread.sleep(2000);
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
                if(Date_Btn.get(i).getAttribute("aria-label").equalsIgnoreCase(Act_Time_Rec)){
                    Date_Btn.get(i).click();
                    break;
                }
            }*/

        }
        Thread.sleep(2000);

        String str_OrgId = "";
        String str_Contact = "";

        if(IsNewActivation.equalsIgnoreCase("new")) {
            str_OrgId = "---";
            str_Contact = "---";
        }
        else{
            try{
                str_OrgId = Act_OrgId_DivIpt.getAttribute("title");
            }
            catch (Exception e){
                str_OrgId = Act_OrgId_Ipt.getAttribute("value");
            }
            try{
                str_OrgId = Act_Contact_DivIpt.getAttribute("title");
            }
            catch (Exception e){
                str_OrgId = Act_OrgId_Ipt.getAttribute("value");
            }
        }
        Thread.sleep(2000);

        if(str_OrgId.equalsIgnoreCase("---")){
            Act_OrgId_Ipt.click();
            Act_OrgId_Ipt.sendKeys("");
            Act_OrgId_Ipt.sendKeys(Act_OrgId_Rec);
            Thread.sleep(2000);

            List<WebElement> Act_OrgId_LookUp = Act_OrgId_Div.findElements(By.tagName("li"));
            for (int j = 0; j < Act_OrgId_LookUp.size(); j++) {
                String[] Act_OrgId_Lookup_Str = Act_OrgId_LookUp.get(j).getAttribute("aria-label").split(",");
                if (Act_OrgId_Lookup_Str[0].equalsIgnoreCase(Act_OrgId_Rec)) {
                    Act_OrgId_LookUp.get(j).click();
                    Thread.sleep(3000);
                    break;
                }
            }
        }

        Thread.sleep(2000);
        if(str_Contact.equalsIgnoreCase("---")){
            Act_Contact_Ipt.click();
            Act_Contact_Ipt.sendKeys("");
            Act_Contact_Ipt.sendKeys(Act_Contact_Rec);
            Thread.sleep(2000);

            List<WebElement> Act_Contact_LookUp = Act_Contact_Div.findElements(By.tagName("li"));
            for (int j = 0; j < Act_Contact_LookUp.size(); j++) {
                String[] Act_Contact_Lookup_Str = Act_Contact_LookUp.get(j).getAttribute("aria-label").split(",");
                if (Act_Contact_Lookup_Str[0].equalsIgnoreCase(Act_Contact_Rec)) {
                    Act_Contact_LookUp.get(j).click();
                    Thread.sleep(3000);
                    break;
                }
            }
        }

        Thread.sleep(2000);
        if(Act_AddDetails_Ipt.getAttribute("value").equalsIgnoreCase("---")){
            Act_AddDetails_Ipt.click();
            Act_AddDetails_Ipt.sendKeys("");
            Act_AddDetails_Ipt.sendKeys(Act_AddDetails_Rec);
        }

        Thread.sleep(2000);
        if(Act_PowerReq_Select.getAttribute("title").equalsIgnoreCase("---")){
            Select se_PowerReq = new Select(Act_PowerReq_Select);
            se_PowerReq.selectByVisibleText(Act_PowerReq_Rec);
        }
        Thread.sleep(2000);
        if(Act_PowerReq_Rec.equalsIgnoreCase("yes")) {
            if (Act_PowerReq_Details_Ipt.getAttribute("value").equalsIgnoreCase("---")) {
                Act_PowerReq_Details_Ipt.click();
                Act_PowerReq_Details_Ipt.sendKeys("");
                Act_PowerReq_Details_Ipt.sendKeys(Act_PowerReq_Details_Rec);
            }
        }

        Thread.sleep(2000);
        if(Act_SecReq_Select.getAttribute("title").equalsIgnoreCase("---")){
            Select se_SecReq = new Select(Act_SecReq_Select);
            se_SecReq.selectByVisibleText(Act_SecReq_Rec);
        }
        Thread.sleep(2000);
        if(Act_SecReq_Rec.equalsIgnoreCase("yes")) {
            if (Act_SecReq_Details_Ipt.getAttribute("value").equalsIgnoreCase("---")) {
                Act_SecReq_Details_Ipt.click();
                Act_SecReq_Details_Ipt.sendKeys("");
                Act_SecReq_Details_Ipt.sendKeys(Act_SecReq_Details_Rec);
            }
        }

        Thread.sleep(2000);
        if(Act_HandoutReq_Select.getAttribute("title").equalsIgnoreCase("---")){
            Select se_HandoutReq = new Select(Act_HandoutReq_Select);
            se_HandoutReq.selectByVisibleText(Act_HandoutReq_Rec);
        }
        Thread.sleep(2000);
        if(Act_HandoutReq_Rec.equalsIgnoreCase("yes")) {
            if (Act_HandoutReq_Details_Ipt.getAttribute("value").equalsIgnoreCase("---")) {
                Act_HandoutReq_Details_Ipt.click();
                Act_HandoutReq_Details_Ipt.sendKeys("");
                Act_HandoutReq_Details_Ipt.sendKeys(Act_HandoutReq_Details_Rec);
            }
        }

        /*if(!Act_ExtCourse_Ipt.getAttribute("title").equalsIgnoreCase(Act_ExtCour_Rec)) {
            Act_ExtCourse_Ipt.click();
        }
        Thread.sleep(2000);

        if(!Act_InCourse_Ipt.getAttribute("title").equalsIgnoreCase(Act_IntCour_Rec)){
            Act_InCourse_Ipt.click();
        }
        Thread.sleep(2000);

        if(!Act_InBowl_Ipt.getAttribute("title").equalsIgnoreCase(Act_InBowl_Rec)){
            Act_InBowl_Ipt.click();
        }
        Thread.sleep(2000);

        if(!Act_GiveAway_Ipt.getAttribute("title").equalsIgnoreCase(Act_GiveAway_Rec)){
            Act_GiveAway_Ipt.click();
        }
        Thread.sleep(2000);

        if(!Act_OnField_Ipt.getAttribute("title").equalsIgnoreCase(Act_OnField_Rec)){
            Act_OnField_Ipt.click();
        }
        Thread.sleep(2000);*/

        Thread.sleep(2000);
        Act_Save_Btn.click();
        Thread.sleep(2000);
    }

    public void verifyNewOrExistActMatch(String IsNewActMatch) throws InterruptedException{
        Thread.sleep(2000);

        if(IsNewActMatch.equalsIgnoreCase("new")){
            ActMatch_New_Btn.click();
            Thread.sleep(2000);
        }
        else{
            int k = Integer.parseInt(IsNewActMatch);
            List<WebElement> li_ColRowIndex = driver.findElements(By.xpath("//div[@col-id='ca_activationmatchapprovalstatus']"));
            //li_ColRowIndex.get(k).click();
            act.moveToElement(li_ColRowIndex.get(k)).doubleClick().build().perform();
            Thread.sleep(2000);
        }
    }
    public void verifyActMatch_EnterAndSaveRecord(String IsNewActMatch, String ActMatch_MatchId_Rec
            , String ActMatch_Time_Rec, String ActMatch_MatchDay_Rec, String ActMatch_Desc_Rec
            , String ActMatch_CertiDoc_Rec, String ActMatch_AgencyId_Rec, String ActMatch_AgencyContact_Rec
            , String ActMatch_PartiNum_Rec, String ActMatch_StaffNum_Rec, String ActMatch_Security_Rec
            , String ActMatch_VenueAcc_Rec) throws InterruptedException{
        String str_MatchId = "---";
        String str_MatchDay = "---";
        String str_AgencyId = "---";
        String str_AgencyContact = "---";
        if(!IsNewActMatch.equalsIgnoreCase("new")){
            try {
                str_MatchId = ActMatch_MatchId_DivIpt.getAttribute("title");
            } catch (Exception e) {
                str_MatchId = ActMatch_MatchId_Ipt.getAttribute("value");
            }
            Thread.sleep(2000);
            try {
                str_MatchDay = ActMatch_MatchDay_DivIpt.getAttribute("title");
            } catch (Exception e) {
                str_MatchDay = ActMatch_MatchDay_Ipt.getAttribute("value");
            }
            Thread.sleep(2000);
        }
        Thread.sleep(2000);
        try{
            str_AgencyId = ActMatch_AgencyContact_DivIpt.getAttribute("title");
        } catch (Exception e){
            str_AgencyId = ActMatch_AgencyContact_DivIpt.getAttribute("value");
        }
        Thread.sleep(2000);
        try{
            str_AgencyContact = ActMatch_AgencyId_DivIpt.getAttribute("title");
        } catch (Exception e){
            str_AgencyContact = ActMatch_AgencyContact_Ipt.getAttribute("value");
        }
        Thread.sleep(2000);

        if(str_MatchId.equalsIgnoreCase("---")){
            ActMatch_MatchId_Ipt.click();
            ActMatch_MatchId_Ipt.sendKeys("");
            ActMatch_MatchId_Ipt.sendKeys(ActMatch_MatchId_Rec);
            Thread.sleep(2000);

            List<WebElement> ActMatch_MatchId_LookUp = ActMatch_MatchId_Div.findElements(By.tagName("li"));
            for (int j = 0; j < ActMatch_MatchId_LookUp.size(); j++) {
                String[] ActMatch_MatchIdLookup = ActMatch_MatchId_LookUp.get(j).getAttribute("aria-label").split(",");
                if (ActMatch_MatchIdLookup[0].equalsIgnoreCase(ActMatch_MatchId_Rec)) {
                    ActMatch_MatchId_LookUp.get(j).click();
                    Thread.sleep(3000);
                    break;
                }
            }
        }
        Thread.sleep(2000);

        if(str_MatchDay.equalsIgnoreCase("---")){
            ActMatch_MatchDay_Ipt.click();
            ActMatch_MatchDay_Ipt.sendKeys("");
            ActMatch_MatchDay_Ipt.sendKeys(ActMatch_MatchDay_Rec);
            Thread.sleep(2000);

            List<WebElement> ActMatch_MatchDay_LookUp = ActMatch_MatchDay_Div.findElements(By.tagName("li"));
            for (int j = 0; j < ActMatch_MatchDay_LookUp.size(); j++) {
                String[] ActMatch_MatchDayLookup = ActMatch_MatchDay_LookUp.get(j).getAttribute("aria-label").split(",");
                if (ActMatch_MatchDayLookup[0].equalsIgnoreCase(ActMatch_MatchDay_Rec)) {
                    ActMatch_MatchDay_LookUp.get(j).click();
                    Thread.sleep(3000);
                    break;
                }
            }
        }
        Thread.sleep(2000);

        if(str_AgencyId.equalsIgnoreCase("---")){
            ActMatch_AgencyId_Ipt.click();
            ActMatch_AgencyId_Ipt.sendKeys("");
            ActMatch_AgencyId_Ipt.sendKeys(ActMatch_AgencyId_Rec);
            Thread.sleep(2000);

            List<WebElement> ActMatch_AgencyId_LookUp = ActMatch_AgencyId_Div.findElements(By.tagName("li"));
            for (int j = 0; j < ActMatch_AgencyId_LookUp.size(); j++) {
                String[] ActMatch_AgencyId_Lookup_Str = ActMatch_AgencyId_LookUp.get(j).getAttribute("aria-label").split(",");
                if (ActMatch_AgencyId_Lookup_Str[0].equalsIgnoreCase(ActMatch_AgencyId_Rec)) {
                    ActMatch_AgencyId_LookUp.get(j).click();
                    Thread.sleep(3000);
                    break;
                }
            }
        }
        Thread.sleep(2000);

        if(str_AgencyContact.equalsIgnoreCase("---")){
            ActMatch_AgencyContact_Ipt.click();
            ActMatch_AgencyContact_Ipt.sendKeys("");
            ActMatch_AgencyContact_Ipt.sendKeys(ActMatch_AgencyContact_Rec);
            Thread.sleep(2000);

            List<WebElement> ActMatch_AgencyContact_LookUp = ActMatch_AgencyContact_Div.findElements(By.tagName("li"));
            for (int j = 0; j < ActMatch_AgencyContact_LookUp.size(); j++) {
                String[] ActMatch_AgencyContact_Lookup_str = ActMatch_AgencyContact_LookUp.get(j).getAttribute("aria-label").split(",");
                if (ActMatch_AgencyContact_Lookup_str[0].equalsIgnoreCase(ActMatch_AgencyContact_Rec)) {
                    ActMatch_AgencyContact_LookUp.get(j).click();
                    Thread.sleep(3000);
                    break;
                }
            }
        }
        Thread.sleep(2000);

        if(ActMatch_MatchTime_Ipt.getAttribute("value").equalsIgnoreCase("")){
            List<WebElement> DatePicker_i = driver.findElements(By.xpath("//i[@data-icon-name='Calendar']"));
            DatePicker_i.get(0).click();
            Thread.sleep(2000);
            String[] str_DateSplit = ActMatch_Time_Rec.split(", ");

            List<WebElement> Month_Btn = driver.findElements(By.xpath("//button[contains(@class,'itemButton-')]"));
            for(int i=0;i<Month_Btn.size();i++){
                if(Month_Btn.get(i).getAttribute("aria-label").equalsIgnoreCase(str_DateSplit[1])){
                    Month_Btn.get(i).click();
                    break;
                }
                Thread.sleep(2000);
            }

            List<WebElement> Date_Btn = driver.findElements(By.xpath("//button[contains(@class,'dayButton-')]"));
            for(int i=0;i<Date_Btn.size();i++){
                if(Date_Btn.get(i).getAttribute("aria-label").equalsIgnoreCase(ActMatch_Time_Rec)){
                    Date_Btn.get(i).click();
                    break;
                }
            }

        }
        Thread.sleep(2000);

        if(ActMatch_PartiNum_Ipt.getAttribute("value").equalsIgnoreCase("---")){
            ActMatch_PartiNum_Ipt.click();
            ActMatch_PartiNum_Ipt.sendKeys("");
            ActMatch_PartiNum_Ipt.sendKeys(ActMatch_PartiNum_Rec);
        }
        Thread.sleep(2000);

        if(ActMatch_StaffNum_Ipt.getAttribute("value").equalsIgnoreCase("---")){
            ActMatch_StaffNum_Ipt.click();
            ActMatch_StaffNum_Ipt.sendKeys("");
            ActMatch_StaffNum_Ipt.sendKeys(ActMatch_StaffNum_Rec);
        }
        Thread.sleep(2000);

        if(ActMatch_CertiDoc_Select.getAttribute("title").equalsIgnoreCase("---")){
            Select se_CertiDoc = new Select(ActMatch_CertiDoc_Select);
            se_CertiDoc.selectByVisibleText(ActMatch_CertiDoc_Rec);
        }
        Thread.sleep(2000);

        if(ActMatch_Security_Ipt.getAttribute("value").equalsIgnoreCase("---")){
            ActMatch_Security_Ipt.click();
            ActMatch_Security_Ipt.sendKeys("");
            ActMatch_Security_Ipt.sendKeys(ActMatch_Security_Rec);
        }
        Thread.sleep(2000);

        if(ActMatch_AddDetails_Ipt.getAttribute("value").equalsIgnoreCase("---")){
            ActMatch_AddDetails_Ipt.click();
            ActMatch_AddDetails_Ipt.sendKeys("");
            ActMatch_AddDetails_Ipt.sendKeys(ActMatch_Desc_Rec);
        }
        Thread.sleep(2000);

        if(ActMatch_VenueAcc_Ipt.getAttribute("value").equalsIgnoreCase("---")){
            ActMatch_VenueAcc_Ipt.click();
            ActMatch_VenueAcc_Ipt.sendKeys("");
            ActMatch_VenueAcc_Ipt.sendKeys(ActMatch_VenueAcc_Rec);
        }
        Thread.sleep(2000);

        ActMatch_Save_Btn.click();
        Thread.sleep(2000);
    }

    public void verifyActMatch_StartAppProcess() throws InterruptedException{
        Thread.sleep(6000);
        /*ActMatch_AppTab_Li.click();
        Thread.sleep(2000);*/

        if(ActMatch_AppStatus.getAttribute("title").equalsIgnoreCase("Not Started")) {
            ActMatch_Overflow_Btn.click();
            Thread.sleep(6000);

            ActMatch_Flow_Btn.click();
            Thread.sleep(10000);
            ActMatch_StartApp_Btn.click();
            Thread.sleep(2000);
            ActMatch_Confirm_Btn.click();
            Thread.sleep(4000);

            ActMatch_Refresh_Btn.click();
            Thread.sleep(6000);
            ActMatch_Refresh_Btn.click();
            Thread.sleep(6000);
            ActMatch_Refresh_Btn.click();
            Thread.sleep(6000);

            /*ActMatch_AppTab_Li.click();
            Thread.sleep(2000);*/
            sa_All.assertEquals(ActMatch_AppStatus.getAttribute("title").trim(), "Pending Approval", "Approval Not Started Successfully!!!");
            sa_All.assertAll();
        }
    }

    public void verifyActMatch_UpdateAppStatus(String ActMatch_AppStatus_CommMgr_Rec
            , String ActMatch_AppStatus_StateMgr_Rec, String ActMatch_AppStatus_RiskMgr_Rec
            , String ActMatch_AppStatus_SecMgr_Rec, String ActMatch_AppStatus_EventDir_Rec)
            throws InterruptedException, AWTException {
        Robot robot = new Robot();
        Thread.sleep(2000);
        if(ActMatch_AppStatus.getAttribute("title").equalsIgnoreCase("Approved")) {
            ActMatch_AddDetails_Ipt.click();
            ActMatch_AddDetails_Ipt.sendKeys("");
            for(int i=0; i<5;i++) {
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);
                Thread.sleep(2000);
            }
        }
        if(ActMatch_AppStatus_CommMgr.getAttribute("title").equalsIgnoreCase("Pending Approval")
                && !ActMatch_AppStatus_CommMgr_Rec.equalsIgnoreCase("NA")){
            Select AppStatus_Match = new Select(ActMatch_AppStatus_CommMgr);
            AppStatus_Match.selectByVisibleText(ActMatch_AppStatus_CommMgr_Rec);
        }

        for(int i=0; i<8;i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(2000);
        }

        Thread.sleep(2000);
        if(ActMatch_AppStatus_StateMgr.getAttribute("title").equalsIgnoreCase("Pending Approval")
                && !ActMatch_AppStatus_StateMgr_Rec.equalsIgnoreCase("NA")){
            Select AppStatus_State = new Select(ActMatch_AppStatus_StateMgr);
            AppStatus_State.selectByVisibleText(ActMatch_AppStatus_StateMgr_Rec);
        }

        for(int i=0; i<4;i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(2000);
        }

        Thread.sleep(2000);
        if(ActMatch_AppStatus_RiskMgr.getAttribute("title").equalsIgnoreCase("Pending Approval")
                && !ActMatch_AppStatus_RiskMgr_Rec.equalsIgnoreCase("NA")){
            Select AppStatus_Risk = new Select(ActMatch_AppStatus_RiskMgr);
            AppStatus_Risk.selectByVisibleText(ActMatch_AppStatus_RiskMgr_Rec);
        }

        for(int i=0; i<4;i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(2000);
        }

        Thread.sleep(2000);
        if(ActMatch_AppStatus_SecMgr.getAttribute("title").equalsIgnoreCase("Pending Approval")
                && !ActMatch_AppStatus_SecMgr_Rec.equalsIgnoreCase("NA")){
            Select AppStatus_SecMgr = new Select(ActMatch_AppStatus_SecMgr);
            AppStatus_SecMgr.selectByVisibleText(ActMatch_AppStatus_SecMgr_Rec);
        }

        for(int i=0; i<4;i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(2000);
        }

        Thread.sleep(2000);
        if(ActMatch_AppStatus_EventDir.getAttribute("title").equalsIgnoreCase("Pending Approval")
                && !ActMatch_AppStatus_EventDir_Rec.equalsIgnoreCase("NA")){
            Select AppStatus_EventDir = new Select(ActMatch_AppStatus_EventDir);
            AppStatus_EventDir.selectByVisibleText(ActMatch_AppStatus_EventDir_Rec);
        }

        Thread.sleep(2000);
        ActMatch_Save_Btn.click();
        Thread.sleep(2000);
    }
}
