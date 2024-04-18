package PageFactory;

import java.awt.AWTException;

import java.awt.Robot;

import java.awt.event.KeyEvent;

import java.time.Duration;
 
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class S1PageFac {
static WebDriver driver;

public S1PageFac(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver,this);
}

public void ExplicitWait(WebElement webElement,int time){
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
}

@FindBy(xpath="//a[@href='https://www.makemytrip.com/hotels/']")
WebElement hotel;
@FindBy(xpath="//div[@class=\"hsw_inner\"]/child::div[@class=\"hsw_inputBox selectHtlCity\"]")
WebElement city;
@FindBy(xpath="//div[@class=\"react-autosuggest__container react-autosuggest__container--open\"]/child::div[@class=\"hw__searchInputWrapper\"]/input[@placeholder=\"Where do you want to stay?\"]")
WebElement inputLocation;
@FindBy(xpath = "//div[@class=\"DayPicker-Months\"]/child::div[@class=\"DayPicker-Month\"]/child::div[@class=\"DayPicker-Body\"]/child::div[@class=\"DayPicker-Week\"][4]/child::div[@aria-label=\"Wed Apr 24 2024\"]")
WebElement checkIn;
@FindBy(xpath = "//div[@class=\"DayPicker-Months\"]/child::div[@class=\"DayPicker-Month\"]/child::div[@class=\"DayPicker-Body\"]/child::div[@class=\"DayPicker-Week\"][4]/child::div[@aria-label=\"Thu Apr 25 2024\"]")
WebElement checkOut;
@FindBy(xpath = "//div[@class=\"rmsGst\"]/child::div[@class=\"rmsGst__footer\"]/child::button[@class=\"primaryBtn btnApplyNew pushRight capText\"]")
WebElement applybttn;
@FindBy(xpath="//button[@id=\"hsw_search_button\"]")
WebElement searchbttn;
@FindBy(xpath="//div[@id=\"STAR_CATEGORY\"]/child::ul/child::li[1]")
WebElement starCategory;
@FindBy(xpath="//div[@id=\"USER_RATING_MMT_BRAND\"]/child::ul/child::li[1]")
WebElement userRating;
@FindBy(xpath="//div[@id=\"MERGE_PROPERTY_TYPE\"]/child::ul/child::li[1]")
WebElement propertyType;
@FindBy(xpath="//div[@class=\"appendBottom15 bdrBottom\"]/child::div/child::span")
WebElement assertFilter;
@FindBy(xpath="//ul[@class=\"grpBkngOpt\"]/child::li[2]/span[1]")
WebElement groupDeal;
@FindBy(xpath="//ul[@class=\"react-autosuggest__suggestions-list\"]/child::li[1]")
WebElement cityDrop;
@FindBy(id="GROUP_HOTELS")
WebElement assertGrpDeal;
@FindBy(xpath="//li[@class=\"makeRelative\"]")
WebElement currencyDropDown;
@FindBy(xpath="//ul[@class=\"latoBold font18\"]/child::li[3]")
WebElement EuroDropDown;
@FindBy(xpath="(//p[contains(text(),\"EUR\")])[1]")
WebElement assertCurrency;
@FindBy(xpath="//ul[@class=\"react-autosuggest__suggestions-list\"]/child::li[1]")
WebElement assertCity;

public void  hotelClick() throws InterruptedException
{
	hotel.click();
}
public void enterLocation(String Location) throws InterruptedException, AWTException
{
	ExplicitWait(city,9);
	city.click();
	ExplicitWait(inputLocation,9);
	inputLocation.sendKeys(Location);
	cityDrop.click();
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_DOWN);
	r.keyPress(KeyEvent.VK_ENTER);
}
public void enterCheckin() throws InterruptedException
{
	ExplicitWait(checkIn,3);	
	checkIn.click();
} 
public void enterCheckout() throws InterruptedException
{
	ExplicitWait(checkOut,3);
	checkOut.click();
} 
public void applyClick() throws InterruptedException
{   
	ExplicitWait(applybttn,3);
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,200)");
	ExplicitWait(applybttn,3);
	applybttn.click();
}
public void searchClick()
{
	ExplicitWait(searchbttn,3);
	searchbttn.click();
}
public String result()
{
	return assertFilter.getText();
}
//------------------------------------------------Method for Scenario 2---------------------------------------------------------

public void applyFilter()
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,300)");
	ExplicitWait(starCategory,9);
	starCategory.click();
	ExplicitWait(userRating,9);
	userRating.click();
	ExplicitWait(propertyType,9);
	js.executeScript("window.scrollBy(0,600)");
	propertyType.click();	
}
//------------------------------------------------Method for Scenario 3---------------------------------------------------------

public void clickGroupDeals()
{
	ExplicitWait(groupDeal,9);
   groupDeal.click();	
}
public void enterDetails(String Location) throws AWTException
{
city.click();
ExplicitWait(inputLocation,9);
inputLocation.sendKeys(Location);
ExplicitWait(cityDrop,9);
cityDrop.click();
}
public void resultGrpDeal()
{
assert assertGrpDeal.isDisplayed();	
}
//------------------------------------------------Method for Scenario 4---------------------------------------------------------

public void clickCurrencyDropDown()
{
	ExplicitWait(currencyDropDown,9);
	currencyDropDown.click();	
}
public void clickEuroDropDown()
{
	ExplicitWait(EuroDropDown,9);
	EuroDropDown.click();	
}
public void resultCurrency()
{
	ExplicitWait(assertCurrency,9);
assert assertCurrency.isDisplayed();	
}
//------------------------------------------------Method for Scenario 5---------------------------------------------------------

public void clickSearchBar()
{
	ExplicitWait(city,9);
	city.click();
}
public void inputLocation()
{
	ExplicitWait(inputLocation,9);
	inputLocation.sendKeys("J");
}
public String resultCity()
{
	return assertCity.getText();
}
}
