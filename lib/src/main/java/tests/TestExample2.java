package tests;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.components.ra.json.APIResponse;
import com.exception.FrameworkException;

import tests.config.BaseCustomizeTest;
import tests.pages.LoginPageWithAnnotation;
import tests.pages.LoginPageWithoutAnnotation;
import tests.services.TestService;

public class TestExample2 extends BaseCustomizeTest{
	
	@BeforeClass(alwaysRun=true)
	public void setupClass() {
		reporter.info("before class test 2");
	}
	
	@AfterClass(alwaysRun=true)
	public void cleanupClass() {
		reporter.info("after class test 2");
	}
	
	@BeforeMethod(alwaysRun=true)
	public void setup() throws Exception {
		TestService ts = new TestService(this.apiDriver);
		APIResponse res = ts.getTest();
		assertion.shouldBeEqual(200, res.getStatusCode());
		reporter.info("before method test 2");
	}
	
	@AfterMethod(alwaysRun=true)
	public void cleanup() {
		reporter.info("after method test 2");
	}
	
	@Test(groups="Example", enabled = true)
	public void UID1111_testExample2() throws FrameworkException {
		/**
		 * Example of page object using annotation
		 */
		LoginPageWithAnnotation pageWithAnno = new LoginPageWithAnnotation(driver);
		reporter.pass("Enter email info");
		pageWithAnno.email.setText("test@email.com");
		
		reporter.pass("Enter password");
		pageWithAnno.password.setText("password");

		assertion.shouldBeEqual(pageWithAnno.email.getText(), "test@email.com");
		/**
		 * Example of page object without using annotation
		 */
		LoginPageWithoutAnnotation pageWithoutAnno = new LoginPageWithoutAnnotation(driver);
		pageWithoutAnno.getEmail().clear();
		pageWithoutAnno.getEmail().setText("test2@email.com");
		pageWithoutAnno.getPassword().setText("password");
		assertion.shouldBeEqual(pageWithoutAnno.getEmail().getText(), "test2@email.com");

		
		// or create your method to group actions
		pageWithoutAnno.login("test3@email.com","password");
		assertion.shouldBeEqual(pageWithoutAnno.getEmail().getText(), "test3@email.com");
	}
	
	@Test(groups="Example", enabled = true)
	public void UID1112_testExample22() {
		reporter.pass("testExample22");
		reporter.pass("testExample22 22");
		reporter.pass("testExample22 23");
		reporter.pass("testExample22 24");
		assertion.shouldBeEqual(1, 2);
	}
}
