package com.CRM_Tedi.pages;

import com.CRM_Tedi.base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Issues extends Page {
    @FindBy(xpath = "//span[text()='Issues']")
    WebElement Iss_Tab_Span;

    @FindBy(xpath = "//button[@data-id='ca_issue|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.ca_issue.NewRecord']")
    WebElement Iss_New_Btn;

    @FindBy(xpath = "//input[@aria-label='Issue Quick find']")
    WebElement Iss_Search_Ipt;
    @FindBy(xpath = "//button[@aria-label='Start search']")
    WebElement Iss_Search_Btn;

    @FindBy(xpath = "//input[@data-id='ca_name_issue.fieldControl-text-box-text']")
    WebElement Iss_Title_Ipt;
    @FindBy(xpath = "//input[@data-id='ca_issueoccurredon.fieldControl-date-time-input']")
    WebElement Iss_Occured_Ipt;

    @FindBy(xpath = "//input[@data-id='ca_eventid.fieldControl-LookupResultsDropdown_ca_eventid_textInputBox_with_filter_new']")
    WebElement Iss_Event_Ipt;
    @FindBy(xpath = "//div[@data-id='ca_eventid.fieldControl-LookupResultsDropdown_ca_eventid_tabContainer']")
    WebElement Iss_Event_Div;
    @FindBy(xpath = "//div[@data-id='ca_eventid.fieldControl-LookupResultsDropdown_ca_eventid_selected_tag_text']")
    WebElement Iss_Event_DivIpt;

    @FindBy(xpath = "//input[@data-id='ca_issuecategoryid.fieldControl-LookupResultsDropdown_ca_issuecategoryid_textInputBox_with_filter_new']")
    WebElement Iss_Cat_Ipt;
    @FindBy(xpath = "//div[@data-id='ca_issuecategoryid.fieldControl-LookupResultsDropdown_ca_issuecategoryid_tabContainer']")
    WebElement Iss_Cat_Div;
    @FindBy(xpath = "//div[@data-id='ca_issuecategoryid.fieldControl-LookupResultsDropdown_ca_issuecategoryid_selected_tag_text']")
    WebElement Iss_Cat_DivIpt;

    @FindBy(xpath = "//select[@data-id='ca_issuetype.fieldControl-option-set-select']")
    WebElement Iss_Type_Select;
    @FindBy(xpath = "//select[@data-id='ca_issueragstatus.fieldControl-option-set-select']")
    WebElement Iss_RagStatus_Select;

    @FindBy(xpath = "//button[@data-id='ca_issue|NoRelationship|Form|Mscrm.Form.ca_issue.Save']")
    WebElement Iss_Save_Btn;
    @FindBy(xpath = "//button[@title='Archived Issues']")
    WebElement Iss_Archived_Btn;
    @FindBy(xpath = "// //button[@title='All Issues']")
    WebElement Iss_All_Btn;

    @FindBy(xpath = "//label[@title='Created On']")
    WebElement Iss_CreatedOn_Lbl;
    @FindBy(xpath = "//button[@aria-label='Sort newer to older']")
    WebElement Iss_SortNew_Btn;

    /*@FindBy(xpath = "")
    WebElement Iss_;*/
    @FindBy(xpath = "//button[@data-id='ca_issue|NoRelationship|Form|Mscrm.Form.ca_issue.Activate']")
    WebElement Iss_Activate_Btn;
    @FindBy(xpath = "//button[@data-id='ca_issue|NoRelationship|Form|Mscrm.Form.ca_issue.Deactivate']")
    WebElement Iss_Deactivate_Btn;
    @FindBy(xpath = "//button[@data-id='ok_id']")
    WebElement Iss_Ok_Btn;

    public Issues(){PageFactory.initElements(driver, this);}

    public void verifyNewOrExistIssue(String IsNewIssue) throws InterruptedException{
        Thread.sleep(2000);
        Iss_Tab_Span.click();
        Thread.sleep(2000);

        if(IsNewIssue.equalsIgnoreCase("new")){
            Iss_New_Btn.click();
        }
        else {
            Iss_Search_Ipt.click();
            Iss_Search_Ipt.sendKeys(IsNewIssue);
            Iss_Search_Btn.click();

            Thread.sleep(3000);

            String str_xpath = "//a[@aria-label='" + IsNewIssue + "']";
            WebElement IssueLink = driver.findElement(By.xpath(str_xpath));
            IssueLink.click();
        }
    }
    public void verifyMandatoryFields(String Iss_Title_Rec, String Iss_Occuredon_Rec, String Iss_Event_Rec
                                        , String Iss_Cat_Rec, String Iss_Type_Rec, String Iss_RagStatus_Rec )
                                         throws InterruptedException{
        if(Iss_Title_Ipt.getAttribute("value").equalsIgnoreCase("---")){
            Iss_Title_Ipt.click();
            Iss_Title_Ipt.sendKeys("");
            Iss_Title_Ipt.sendKeys(Iss_Title_Rec);
        }
        Thread.sleep(2000);

        if(Iss_Occured_Ipt.getAttribute("value").equalsIgnoreCase("")){
            List<WebElement> li_Calendar_Link = driver.findElements(By.xpath("//i[@data-icon-name='Calendar']"));
            li_Calendar_Link.get(0).click();
            Thread.sleep(2000);

            String[] str_Occured_Split = Iss_Occuredon_Rec.split(", ");
            String str_Month_xpath = "//button[@aria-label='" + str_Occured_Split[1] + "']";
            String str_Day_xpath = "//button[@aria-label='" + Iss_Occuredon_Rec + "']";

            WebElement Month_Btn = driver.findElement(By.xpath(str_Month_xpath));
            Month_Btn.click();
            Thread.sleep(2000);

            WebElement Day_Btn = driver.findElement(By.xpath(str_Day_xpath));
            Day_Btn.click();
        }
        Thread.sleep(2000);

        String str_Event = "";
        String str_Cat = "";
        try{
            str_Event = Iss_Event_DivIpt.getAttribute("title");
        }
        catch (Exception e){
            str_Event = Iss_Event_Ipt.getAttribute("value");
        }
        Thread.sleep(2000);

        if(str_Event.equalsIgnoreCase("---")){
            Thread.sleep(2000);
            Iss_Event_Ipt.click();
            Iss_Event_Ipt.sendKeys("");
            Iss_Event_Ipt.sendKeys(Iss_Event_Rec);
            Thread.sleep(6000);

            List<WebElement> Iss_Event_Lookup = Iss_Event_Div.findElements(By.tagName("li"));

            for (int i = 0; i < Iss_Event_Lookup.size(); i++) {
                String[] str_RefLookup = Iss_Event_Lookup.get(i).getAttribute("aria-label").split(", ");

                if (str_RefLookup[1].trim().equalsIgnoreCase(Iss_Event_Rec)) {
                    Iss_Event_Lookup.get(i).click();
                    Thread.sleep(3000);
                    break;
                }
            }
        }
        Thread.sleep(2000);

        try{
            str_Cat = Iss_Cat_DivIpt.getAttribute("title");
        }
        catch (Exception e){
            str_Cat = Iss_Cat_Ipt.getAttribute("value");
        }
        Thread.sleep(2000);

        if(str_Cat.equalsIgnoreCase("---")){
            Thread.sleep(2000);
            Iss_Cat_Ipt.click();
            Iss_Cat_Ipt.sendKeys("");
            Iss_Cat_Ipt.sendKeys(Iss_Cat_Rec);
            Thread.sleep(6000);

            List<WebElement> Iss_Cat_Lookup = Iss_Cat_Div.findElements(By.tagName("li"));

            for (int i = 0; i < Iss_Cat_Lookup.size(); i++) {
                if (Iss_Cat_Lookup.get(i).getAttribute("aria-label").equalsIgnoreCase(Iss_Cat_Rec)) {
                    Iss_Cat_Lookup.get(i).click();
                    Thread.sleep(3000);
                    break;
                }
            }
        }
        Thread.sleep(2000);

        if(Iss_Type_Select.getAttribute("title").equalsIgnoreCase("---")){
            Select se_Type = new Select(Iss_Type_Select);
            se_Type.selectByVisibleText(Iss_Type_Rec);
        }
        Thread.sleep(2000);

        if(Iss_RagStatus_Select.getAttribute("title").equalsIgnoreCase("---")){
            Select se_RagStatus = new Select(Iss_RagStatus_Select);
            se_RagStatus.selectByVisibleText(Iss_RagStatus_Rec);
        }
        Thread.sleep(2000);

        Iss_Save_Btn.click();
        Thread.sleep(2000);
    }

    public void verifyDeactivateIssue(boolean IsDeactivate, String Iss_Title_Rec) throws InterruptedException{
        if(IsDeactivate){
            Iss_Deactivate_Btn.click();
            Thread.sleep(2000);
            Iss_Ok_Btn.click();
            Thread.sleep(2000);
            verifyActivateIssue(false, Iss_Title_Rec);
        }
    }
    public void verifyActivateIssue(boolean IsActivate, String Iss_ActIssueName) throws InterruptedException{
        Thread.sleep(2000);
        Iss_Tab_Span.click();
        Thread.sleep(2000);
        List<WebElement> li_SysView = driver.findElements(By.xpath("//span[@data-automationid='splitbuttonprimary']"));
        li_SysView.get(0).click();
        Thread.sleep(2000);
        Iss_Archived_Btn.click();
        Thread.sleep(2000);

        Iss_CreatedOn_Lbl.click();
        Thread.sleep(2000);
        Iss_SortNew_Btn.click();
        Thread.sleep(2000);

        String str_xpath = "//span[text()='" + Iss_ActIssueName + "']";
        WebElement Iss_Span = driver.findElement(By.xpath(str_xpath));
        Iss_Span.click();
        Thread.sleep(2000);

        if(IsActivate){
            Iss_Activate_Btn.click();
            Thread.sleep(2000);
            Iss_Ok_Btn.click();
            Thread.sleep(2000);
            verifyNewOrExistIssue(Iss_ActIssueName);
        }

    }
}
