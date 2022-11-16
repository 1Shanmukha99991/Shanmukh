package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Loginpage;

public class Steps {
	
	public WebDriver driver;
	public Loginpage lp;
	
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
			System.setProperty("Webdriver.chrome.driver",System.getProperty("user.dir")+"//Driver/chromerdriver.exe");
			driver = new ChromeDriver();
			
			lp = new Loginpage(driver);
			
	}

	@When("User navigate to URL {string}")
	public void user_navigate_to_url(String url) {

	    driver.get(url);
	    driver.manage().window().maximize();
	}

	@Then("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String EmailId, String Password) throws InterruptedException {
		
		Thread.sleep(3000);
		lp.setUserName(EmailId);
		lp.setPassword(Password);
	}

	@And("User click on login")
	public void user_click_on_login() throws InterruptedException {
		lp.clickLogin();
		Thread.sleep(3000);
		
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {
		
		if(driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		}else {
			Assert.assertEquals(title, driver.getTitle());
		}
		Thread.sleep(3000);
	}
	
	@When("User click on logout link")
	public void user_click_on_logout_link() throws InterruptedException {
		
		lp.clickLogout();
		Thread.sleep(3000); 
	}
	

	@And("Close browser")
	public void close_browser() {
		
		driver.quit();
	}

}
