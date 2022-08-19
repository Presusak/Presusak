package com.CRM_Tedi.testcases;

import com.CRM_Tedi.base.Page;
import com.CRM_Tedi.pages.Deliveries;
import com.CRM_Tedi.pages.Login;
import org.testng.annotations.Test;

import java.awt.*;

public class DeliveriesTest extends Page {
    Login lg = new Login();
    Deliveries del = new Deliveries();

    public DeliveriesTest(){super();}

    @Test(priority = 1,description = "Login Tedi CRM")
    public void Login() throws InterruptedException{
        lg.verify_Login(config.getProperty("emailId"),config.getProperty("password")
                ,config.getProperty("Loginfrm"));
    }

    @Test(priority = 2,description = "New Or Exist Delivery",dependsOnMethods = "Login")
    public void verify_NewOrExistDel() throws InterruptedException{
        del.verifyNewOrExistDel(config.getProperty("IsNewDel"));
    }

    @Test(priority = 3,description = "Save Mandatory fields",dependsOnMethods = "verify_NewOrExistDel")
    public void verify_SaveMandatoryFields() throws InterruptedException, AWTException {
        del.verifySaveMandatoryFields(config.getProperty("Del_Name_Rec"), config.getProperty("Del_MatchId_Rec")
                                    , config.getProperty("Del_MatchContact_Rec"), config.getProperty("Del_SenderComp_Rec")
                                    , config.getProperty("Del_Pallets_Rec"), config.getProperty("Del_Boxes_Rec")
                                    , config.getProperty("Del_PalletsNum_Rec"), config.getProperty("Del_Pickup_Rec")
                                    , config.getProperty("Del_StartDate_Rec"), config.getProperty("Del_Window_Rec"));
    }

    @Test(priority = 4,description = "Verify Mandatory Fields Error Message",dependsOnMethods = "verify_SaveMandatoryFields")
    public void verify_MandatoryErrorMsg() throws InterruptedException {
        del.verifyMandatoryErrorMsg();
    }
}
