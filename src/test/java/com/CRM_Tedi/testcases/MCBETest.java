package com.CRM_Tedi.testcases;

import com.CRM_Tedi.base.Page;
import com.CRM_Tedi.pages.Login;
import com.CRM_Tedi.pages.MCBE;
import org.testng.annotations.Test;

import java.awt.*;

public class MCBETest extends Page {
    MCBE mcbe = new MCBE();
    Login login = new Login();

    public MCBETest(){super();}

    @Test(priority = 1,description = "Tedi Login")
    public void verify_Login() throws InterruptedException{
        login.verify_Login(config.getProperty("emailId"),config.getProperty("password")
                ,config.getProperty("Loginfrm"));
    }

    @Test(priority = 2,description = "verify New or Exist MCBE",dependsOnMethods = "verify_Login")
    public void verify_NewOrExistMcbe() throws InterruptedException{
        mcbe.verifyNewOrExistMcbe(config.getProperty("IsNewMcbe"));
    }

    @Test(priority = 3,description = "verify submitting record MCBE",dependsOnMethods = "verify_NewOrExistMcbe")
    public void verifyMcbeRecord() throws InterruptedException{
        mcbe.verifyMcbeRecord(config.getProperty("MCBE_Title_Rec"),config.getProperty("MCBE_ExpDetails_Rec")
                            ,config.getProperty("MCBE_Type_Rec"));
    }

    @Test(priority = 4,description = "verify New or Exist MCBE Match",dependsOnMethods = "verifyMcbeRecord")
    public void verify_McbeMatchNewOrExist() throws InterruptedException {
        mcbe.verifyMcbeMatchNewOrExist(config.getProperty("IsNewMcbeMatch"));
    }

    @Test(priority = 5,description = "verify submitting record MCBE Match",dependsOnMethods = "verify_McbeMatchNewOrExist")
    public void verify_McbeMatchRecord() throws InterruptedException {
        mcbe.verifyMcbeMatchRecord(config.getProperty("McbeMatch_MatchId_Rec"), config.getProperty("McbeMatch_MatchDay_Rec")
                                , config.getProperty("McbeMatch_Time_Rec"));
    }

    @Test(priority = 6, description = "Start Approval Flow",dependsOnMethods = "verify_McbeMatchRecord")
    public void verify_McbeMatch_StartAppFlow() throws InterruptedException{
        mcbe.verifyMcbeMatch_StartAppFlow();
    }

    @Test(priority = 7, description = "Update Approval Status",dependsOnMethods = "verify_McbeMatch_StartAppFlow")
    public void verify_McbeMatch_UpdateAppStatus() throws InterruptedException, AWTException {
        mcbe.verifyMcbeMatch_UpdateAppStatus(config.getProperty("Comm_AppStatus_Rec"), config.getProperty("StateMgr_AppStatus_Rec")
                                            , config.getProperty("RiskMgr_AppStatus_Rec"), config.getProperty("SecMgr_AppStatus_Rec")
                                            , config.getProperty("EventDir_AppStatus_Rec"));
    }
}
