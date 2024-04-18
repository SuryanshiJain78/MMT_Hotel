package StepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
 
import DriverSetup.SetupDriver;
import PageFactory.S1PageFac;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class Search_StepDef {
    static WebDriver driver;
	S1PageFac page;
	
	@Given("user is on homepage of Make My Trip Website")
	public void user_is_on_homepage_of_make_my_trip_website() throws InterruptedException {
		driver=SetupDriver.chromeDriver();
		page=new S1PageFac(driver);
	}
 
	@When("user clicks on the hotels section")
	public void user_clicks_on_the_hotels_section() throws InterruptedException {
        page.hotelClick();
	}
 
	@And("User enters details {string}, {string}, {string} & {string}")
	public void user_enters_details(String Location, String Checkin , String Checkout , String Rooms_Guests) throws AWTException, InterruptedException {
		page.enterLocation(Location);
		page.enterCheckin();
		page.enterCheckout();
	}
 
	@And("click on Apply button")
	public void click_on_apply_button() throws InterruptedException {
         page.applyClick();
	}
 
	@And("click on Search button")
	public void click_on_search_button() throws InterruptedException {
	    page.searchClick();
	}
 
	@Then("relevant hotel options matching the search criteria are displayed")
	public void relevant_hotel_options_matching_the_search_criteria_are_displayed() {
		String actual=driver.getCurrentUrl();
		String expected="https://www.makemytrip.com/hotels/hotel-listing/?checkin=04242024&city=CTDEL&checkout=04252024&roomStayQualifier=2e0e&locusId=CTDEL&country=IN&locusType=city&searchText=Delhi&regionNearByExp=3&rsc=1e2e0e";
    	Assert.assertEquals(expected, actual);
		//String title=driver.getTitle();
		//Assert.assertTrue(title.contains(""));
	}
   /*------------------------------------------------------Scenario 2----------------------------------------------------------*/
	@When("user has preformed a hotel search")
	public void user_has_preformed_a_hotel_search() throws InterruptedException {
		Thread.sleep(3000);
		driver=SetupDriver.chromeDriver();
		page= new S1PageFac(driver);
	    driver.get("https://www.makemytrip.com/hotels/hotel-listing/?checkin=04242024&city=CTDEL&checkout=04252024&roomStayQualifier=2e0e&locusId=CTDEL&country=IN&locusType=city&searchText=Delhi&regionNearByExp=3&rsc=1e2e0e");	
	}

	@And("user applies filters such as user rating, star category, property type and room amenities etc.")
	public void user_applies_filters_such_as_user_rating_star_category_property_type_and_room_amenities_etc() throws InterruptedException {
	    page.applyFilter();
	}

	@Then("search results are updated to reflect the applied filters")
	public void search_results_are_updated_to_reflect_the_applied_filters() {
		String msg = page.result();
		Assert.assertTrue(msg.contains("Applied Filters"));
	}
   /*-------------------------------------------------------Scenario 3--------------------------------------------------------*/
	@When("user clicks on Group Deals")
	public void user_clicks_on_group_deals() {
	    page.clickGroupDeals();
	}
	@And("User enter details")
	public void user_enter_details(DataTable dataTable) throws AWTException, InterruptedException {
		List<Map<String,String>> details = dataTable.asMaps(String.class, String.class);     
		String lr = details .get(0).get("Location");
		page.enterDetails(lr);
		page.enterCheckin();
		page.enterCheckout();
	}

	@And("click on apply")
	public void click_on_apply() throws InterruptedException {
	   page.applyClick();
	}
	@And("click on Get Me Best Prices button")
	public void click_on_get_me_best_prices_button() throws InterruptedException {
	    page.searchClick();
	}

	@Then("relevant properties with group deals are displayed")
	public void relevant_properties_with_group_deals_are_displayed() {
	    page.resultGrpDeal();
	}
   /*-------------------------------------------------------Scenario 4--------------------------------------------------------*/
	@When("user has performed a hotel search")
	public void user_has_performed_a_hotel_search() throws InterruptedException {
		driver=SetupDriver.chromeDriver();
		page= new S1PageFac(driver);
	    driver.get("https://www.makemytrip.com/hotels/hotel-listing/?checkin=04242024&city=CTDEL&checkout=04252024&roomStayQualifier=2e0e&locusId=CTDEL&country=IN&locusType=city&searchText=Delhi&regionNearByExp=3&rsc=1e2e0e");	
	}

	@And("User clicks on currency dropdown")
	public void user_clicks_on_currency_dropdown() throws InterruptedException {
	    page.clickCurrencyDropDown();
	}

	@And("Selects the required currency")
	public void selects_the_required_currency() throws InterruptedException {
	   page.clickEuroDropDown();
	}

	@Then("The currency of the hotel price should change accordingly")
	public void the_currency_of_the_hotel_price_should_change_accordingly() throws InterruptedException {
	   page.resultCurrency();
	}
	/*-------------------------------------------------------Scenario 4--------------------------------------------------------*/
	@And("User clicks on location search bar")
	public void user_clicks_on_location_search_bar() throws InterruptedException {
	    page.clickSearchBar();
	}

	@And("Enter the initial letter of city")
	public void enter_the_initial_letter_of_city() throws InterruptedException {
		page.inputLocation();
	}

	@Then("It should display all the City names Starting with first letter")
	public void it_should_display_all_the_city_names_starting_with_first_letter() {
		String msg = page.result();
		Assert.assertTrue(msg.contains("Jaipur"));
	}
	@AfterStep
	public static void takeScreendown(Scenario scenerio) {
		   TakesScreenshot ts= (TakesScreenshot) driver;
		   final byte[] src = ts.getScreenshotAs(OutputType.BYTES);
		   scenerio.attach(src, "image/png",scenerio.getName());
	}
}