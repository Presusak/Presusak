package com.CRM_Tedi.testcases;

import com.CRM_Tedi.base.Page;
import com.CRM_Tedi.pages.Activation;
import com.CRM_Tedi.pages.Login;
import org.testng.annotations.Test;

import java.awt.*;

public class ActivationTest extends Page {
    Activation acti_app = new Activation();
    Login login = new Login();

    public ActivationTest(){super();}
    @Test(priority = 1,description = "Login Tedi")
    public void verify_Login() throws InterruptedException{
        login.verify_Login(config.getProperty("emailId"), config.getProperty("password")
                , config.getProperty("Loginfrm"));
    }

    @Test(priority = 2,description = "verify New or exist Activation",dependsOnMethods = "verify_Login")
    public void verify_NewOrExistActivation() throws InterruptedException{
        acti_app.verifyNewOrExistActivation(config.getProperty("IsNewActivation"));
    }

    @Test(priority = 3,description = "verify Mandatory Records",dependsOnMethods = "verify_NewOrExistActivation")
    public void verify_MandatoryFields() throws InterruptedException{
        acti_app.verifyMandatoryFields(config.getProperty("IsNewActivation"), config.getProperty("Act_Title_Rec")
                , config.getProperty("Act_Time_Rec"), config.getProperty("Act_OrgId_Rec")
                , config.getProperty("Act_Contact_Rec"), config.getProperty("Act_AddDetails_Rec")
                , config.getProperty("Act_PowerReq_Rec"), config.getProperty("Act_SecReq_Rec")
                , config.getProperty("Act_HandoutReq_Rec"), config.getProperty("Act_PowerReq_Details_Rec")
                , config.getProperty("Act_SecReq_Details_Rec"), config.getProperty("Act_HandoutReq_Details_Rec"));
    }

    @Test(priority = 4,description = "verify New or exist Activation Match",dependsOnMethods = "verify_MandatoryFields")
    public void verify_NewOrExistActMatch() throws InterruptedException{
        acti_app.verifyNewOrExistActMatch(config.getProperty("IsNewActMatch"));
    }

    @Test(priority = 5,description = "verify Activation Match Mandatory Records",dependsOnMethods = "verify_NewOrExistActMatch")
    public void verify_ActMatch_EnterAndSaveRecord() throws InterruptedException{
        acti_app.verifyActMatch_EnterAndSaveRecord(config.getProperty("IsNewActMatch")
                , config.getProperty("ActMatch_MatchId_Rec"), config.getProperty("ActMatch_Time_Rec")
                , config.getProperty("ActMatch_MatchDay_Rec"), config.getProperty("ActMatch_Desc_Rec")
                , config.getProperty("ActMatch_CertiDoc_Rec"), config.getProperty("ActMatch_AgencyId_Rec")
                , config.getProperty("ActMatch_AgencyContact_Rec"), config.getProperty("ActMatch_PartiNum_Rec")
                , config.getProperty("ActMatch_StaffNum_Rec"), config.getProperty("ActMatch_Security_Rec")
                , config.getProperty("ActMatch_VenueAcc_Rec"));
    }

    @Test(priority = 6,description = "verify Approval Process Start",dependsOnMethods = "verify_ActMatch_EnterAndSaveRecord")
    public void verify_ActMatch_StartAppProcess() throws InterruptedException{
        acti_app.verifyActMatch_StartAppProcess();
    }
    @Test(priority = 7,description = "verify Approval Status update",dependsOnMethods = "verify_ActMatch_StartAppProcess")
    public void verify_ActMatch_UpdateAppStatus() throws InterruptedException, AWTException {
        acti_app.verifyActMatch_UpdateAppStatus(config.getProperty("ActMatch_AppStatus_CommMgr_Rec")
                , config.getProperty("ActMatch_AppStatus_StateMgr_Rec")
                , config.getProperty("ActMatch_AppStatus_RiskMgr_Rec")
                , config.getProperty("ActMatch_AppStatus_SecMgr_Rec")
                , config.getProperty("ActMatch_AppStatus_EventDir_Rec"));
    }
}
