package com.CRM_Tedi.testcases;

import com.CRM_Tedi.base.Page;
import com.CRM_Tedi.pages.Login;
import com.CRM_Tedi.pages.ScoreCardItems;
import org.testng.annotations.Test;

public class ScoreCardItemsTest extends Page {
    ScoreCardItems sci = new ScoreCardItems();
    Login login = new Login();

    boolean IsActivate = Boolean.parseBoolean(config.getProperty("SCI_IsActivate"));
    boolean IsDeactivate = Boolean.parseBoolean(config.getProperty("SCI_IsDeactivate"));

    public ScoreCardItemsTest(){super();}
    @Test(priority = 1,description = "Login Tedi")
    public void verify_Login() throws InterruptedException{
        login.verify_Login(config.getProperty("emailId"), config.getProperty("password")
                , config.getProperty("Loginfrm"));
    }

    @Test(priority = 2,description = "Exist Functional Area", dependsOnMethods = "verify_Login")
    public void verify_ExistFunctionalArea() throws InterruptedException{
        sci.verifyExistFunctionalArea(config.getProperty("FA_Name_Rec"),IsActivate);
    }

    @Test(priority = 3,description = "New or Exist Score Card Item", dependsOnMethods = "verify_ExistFunctionalArea")
    public void verify_NewOrExistCardItem() throws InterruptedException{
        if(!IsActivate)
            sci.verifyNewOrExistCardItem(config.getProperty("SCI_IsNew"));
    }

    @Test(priority = 4,description = "Enter and Save Mandatory fields", dependsOnMethods = "verify_NewOrExistCardItem")
    public void verify_SaveMandatoryFields() throws InterruptedException{
        if(!IsActivate)
            sci.verifySaveMandatoryFields(config.getProperty("SCI_Name_Rec"));
    }

    @Test(priority = 5,description = "Deactivate the record",dependsOnMethods = "verify_SaveMandatoryFields")
    public void verify_GetDeactivateRecord() throws InterruptedException{
        if(!IsActivate)
            sci.verifyGetDeactivateRecord(IsDeactivate, config.getProperty("SCI_Name_Rec"));
    }
    @Test(priority = 6,description = "Activate the record",dependsOnMethods = "verify_SaveMandatoryFields")
    public void verify_GetActivateRecord() throws InterruptedException{
        if(IsActivate)
            sci.verifyGetActivateRecord(IsActivate, config.getProperty("SCI_ActName_Rec"));
    }
}
