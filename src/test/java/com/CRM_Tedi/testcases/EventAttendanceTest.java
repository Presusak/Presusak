package com.CRM_Tedi.testcases;

import com.CRM_Tedi.base.Page;
import com.CRM_Tedi.pages.EventAttendance;
import com.CRM_Tedi.pages.Login;
import org.testng.annotations.Test;

public class EventAttendanceTest extends Page {
    EventAttendance EA = new EventAttendance();
    Login lg = new Login();

    public EventAttendanceTest(){super();}

    @Test(priority = 1,description = "Login Tedi CRM")
    public void verify_Login() throws InterruptedException{
        lg.verify_Login(config.getProperty("emailId"),config.getProperty("password")
                ,config.getProperty("Loginfrm"));
    }

    @Test(priority = 2,description = "New or Exist Event Attendance",dependsOnMethods = "verify_Login")
    public void verify_NewEventAtt() throws InterruptedException{
        EA.verifyNewEventAtt();
    }
    @Test(priority = 3,description = "Event Attendance Record",dependsOnMethods = "verify_NewEventAtt")
    public void verify_EventAttRecord() throws InterruptedException{
        EA.verifyEventAttRecord(config.getProperty("EA_MatchId_Rec"), config.getProperty("EA_EventId_Rec")
                                , config.getProperty("EA_EventRoleId_Rec"), config.getProperty("EA_CateringReqd_Rec"));
    }


}
