package stepDefinition;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSteps {

	public static WebDriver driver;
	
	//This will run before every test. This is not a JUnit Before. it is Cucumber's
	@Before
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	//This will run after every test. This is not a JUnit After. it is Cucumber's
	@After
	public void afterTest() {
		driver.close();
	}
	
	//each method directly maps to the feature file
	@Given("^User is on Google Search Landing Page$")
	public void user_is_on_Google_Search_Landing_Page() throws Throwable {
		driver.get("https://www.google.co.uk/");
	}

	@When("^User enters a (.+)$")
	public void user_enters_a_search_string(String searchString) throws Throwable {
		driver.findElement(By.id("lst-ib")).sendKeys(searchString);
	}

	@When("^clicks on search button$")
	public void clicks_on_search_button() throws Throwable {
		driver.findElement(By.id("sblsbb")).click();
	}

	@Then("^(.+) is displayed$")
	public void search_result_is_displayed(String result) throws Throwable {
		assertTrue(driver.findElements(By.linkText(result)).size()>0);
	}
	
	@Given("^the following search strings:$")
	public void the_following_search_strings(DataTable table) throws Throwable {
		List<List<String>> args = table.raw();
		String searchString, result;
		
		for(List<String> d : args) {
			searchString = d.get(0);
			result = d.get(1);
			driver.get("https://www.google.co.uk/");
			driver.findElement(By.id("lst-ib")).sendKeys(searchString);
			driver.findElement(By.id("sblsbb")).click();
			assertTrue(driver.findElements(By.linkText(result)).size()>0);
		}
	}
}
