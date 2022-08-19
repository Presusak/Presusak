package com.CRM_Tedi.pages;

import com.CRM_Tedi.base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class EventAttendance extends Page {

    @FindBy(xpath = "//li[@aria-label='Event Attendances']")
    WebElement EA_Tab_li;
    @FindBy(xpath = "//button[@data-id='ca_eventattendance|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.ca_eventattendance.NewRecord']")
    WebElement EA_New_Btn;

    @FindBy(xpath = "//input[@data-id='ca_match.fieldControl-LookupResultsDropdown_ca_match_textInputBox_with_filter_new']")
    WebElement EA_MatchId_Ipt;
    @FindBy(xpath = "//div[@data-id='ca_match.fieldControl-LookupResultsDropdown_ca_match_tabContainer']")
    WebElement EA_MatchId_Div;
    @FindBy(xpath = "//div[@data-id='ca_match.fieldControl-LookupResultsDropdown_ca_match_selected_tag_text']")
    WebElement EA_MatchId_DivIpt;

    @FindBy(xpath = "//input[@data-id='ca_eventid.fieldControl-LookupResultsDropdown_ca_eventid_textInputBox_with_filter_new']")
    WebElement EA_EventId_Ipt;
    @FindBy(xpath = "//div[@data-id='ca_eventid.fieldControl-LookupResultsDropdown_ca_eventid_tabContainer']")
    WebElement EA_EventId_Div;
    @FindBy(xpath = "//div[@data-id='ca_eventid.fieldControl-LookupResultsDropdown_ca_eventid_selected_tag_text']")
    WebElement EA_EventId_DivIpt;

    @FindBy(xpath = "//input[@data-id='ca_eventroleid.fieldControl-LookupResultsDropdown_ca_eventroleid_textInputBox_with_filter_new']")
    WebElement EA_EventRoleId_Ipt;
    @FindBy(xpath = "//div[@data-id='ca_eventroleid.fieldControl-LookupResultsDropdown_ca_eventroleid_tabContainer']")
    WebElement EA_EventRoleId_Div;
    @FindBy(xpath = "//div[@data-id='ca_eventroleid.fieldControl-LookupResultsDropdown_ca_eventroleid_selected_tag_text']")
    WebElement EA_EventRoleId_DivIpt;

    @FindBy(xpath = "//select[@data-id='ca_tedcateringrequired.fieldControl-option-set-select']")
    WebElement EA_CateringReqd_Select;

    @FindBy(xpath = "//button[@data-id='ca_eventattendance|NoRelationship|Form|Mscrm.Form.ca_eventattendance.Save']")
    WebElement EA_Save_Btn;

    public EventAttendance()  {
        PageFactory.initElements(driver, this);
    }

    public void verifyNewEventAtt() throws InterruptedException{
        Thread.sleep(2000);
        EA_Tab_li.click();
        Thread.sleep(2000);

        EA_New_Btn.click();
        Thread.sleep(2000);
    }

    public void verifyEventAttRecord(String EA_MatchId_Rec, String EA_EventId_Rec, String EA_EventRoleId_Rec
                                , String EA_CateringReqd_Rec) throws InterruptedException{
        Thread.sleep(2000);
        EA_MatchId_Ipt.click();
        EA_MatchId_Ipt.sendKeys("");
        EA_MatchId_Ipt.sendKeys(EA_MatchId_Rec);
        Thread.sleep(6000);

        List<WebElement> EA_MatchId_Lookup = EA_MatchId_Div.findElements(By.tagName("li"));

        for (int i = 0; i < EA_MatchId_Lookup.size(); i++) {
            String[] str_RefLookup = EA_MatchId_Lookup.get(i).getAttribute("aria-label").split(",");

            if (str_RefLookup[0].equalsIgnoreCase(EA_MatchId_Rec)) {
                EA_MatchId_Lookup.get(i).click();
                Thread.sleep(3000);
                break;
            }
        }

        Thread.sleep(2000);
        EA_EventId_Ipt.click();
        EA_EventId_Ipt.sendKeys("");
        EA_EventId_Ipt.sendKeys(EA_EventId_Rec);
        Thread.sleep(6000);

        List<WebElement> EA_EventId_Lookup = EA_EventId_Div.findElements(By.tagName("li"));

        for (int i = 0; i < EA_EventId_Lookup.size(); i++) {
            String[] str_RefLookup = EA_EventId_Lookup.get(i).getAttribute("aria-label").split(",");

            if (str_RefLookup[0].equalsIgnoreCase(EA_EventId_Rec)) {
                EA_EventId_Lookup.get(i).click();
                Thread.sleep(3000);
                break;
            }
        }

        Thread.sleep(2000);
        EA_EventRoleId_Ipt.click();
        EA_EventRoleId_Ipt.sendKeys("");
        EA_EventRoleId_Ipt.sendKeys(EA_EventRoleId_Rec);
        Thread.sleep(6000);

        List<WebElement> EA_EventRoleId_Lookup = EA_EventRoleId_Div.findElements(By.tagName("li"));

        for (int i = 0; i < EA_EventRoleId_Lookup.size(); i++) {
            String[] str_RefLookup = EA_EventRoleId_Lookup.get(i).getAttribute("aria-label").split(",");
            if (str_RefLookup[0].equalsIgnoreCase(EA_EventRoleId_Rec)) {
                EA_EventRoleId_Lookup.get(i).click();
                Thread.sleep(3000);
                break;
            }
        }

        Thread.sleep(2000);
        Select se_CateringReqd = new Select(EA_CateringReqd_Select);
        se_CateringReqd.selectByVisibleText(EA_CateringReqd_Rec);

        Thread.sleep(2000);
        EA_Save_Btn.click();
    }
}
