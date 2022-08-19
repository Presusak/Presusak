package com.CRM_Tedi.testcases;

import com.CRM_Tedi.base.Page;
import com.CRM_Tedi.pages.Login;
import com.CRM_Tedi.pages.Issues;
import com.CRM_Tedi.pages.MCBE;
import org.testng.annotations.Test;

public class IssuesTest extends Page {
    Issues issue = new Issues();
    Login login = new Login();

    boolean IsActivate = Boolean.parseBoolean(config.getProperty("Iss_IsActivate"));
    boolean IsDeactivate = Boolean.parseBoolean(config.getProperty("Iss_IsDeactivate"));

    public IssuesTest(){super();}

    @Test(priority = 1,description = "Tedi Login")
    public void verify_Login() throws InterruptedException{
        login.verify_Login(config.getProperty("emailId"),config.getProperty("password")
                ,config.getProperty("Loginfrm"));
    }

    @Test(priority = 2,description = "verify New or Exist MCBE",dependsOnMethods = "verify_Login")
    public void verify_NewOrExistIssue() throws InterruptedException{
        if(!IsActivate)
            issue.verifyNewOrExistIssue(config.getProperty("IsNewIssue"));
    }

    @Test(priority = 3,description = "verify submitting record",dependsOnMethods = "verify_NewOrExistIssue")
    public void verify_MandatoryFields() throws InterruptedException{
        if(!IsActivate)
            issue.verifyMandatoryFields(config.getProperty("Iss_Title_Rec"), config.getProperty("Iss_Occuredon_Rec")
                                        , config.getProperty("Iss_Event_Rec"), config.getProperty("Iss_Cat_Rec")
                                        , config.getProperty("Iss_Type_Rec"), config.getProperty("Iss_RagStatus_Rec"));
    }

    @Test(priority = 4,description = "Deactivate the record",dependsOnMethods = "verify_MandatoryFields")
    public void verify_GetDeactivateRecord() throws InterruptedException{
        if(!IsActivate)
            issue.verifyDeactivateIssue(IsDeactivate, config.getProperty("Iss_Title_Rec"));
    }

    @Test(priority = 5,description = "Activate the record",dependsOnMethods = "verify_MandatoryFields")
    public void verify_GetActivateRecord() throws InterruptedException{
        if(IsActivate)
            issue.verifyActivateIssue(IsActivate, config.getProperty("Iss_ActIssueName"));
    }
}
