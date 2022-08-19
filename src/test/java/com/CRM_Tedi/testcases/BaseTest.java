package com.CRM_Tedi.testcases;

import org.testng.annotations.AfterSuite;
import com.CRM_Tedi.base.Page;

public class BaseTest {

	@AfterSuite
	public void tearDown(){
		
		Page.quit();
		
	}

}
