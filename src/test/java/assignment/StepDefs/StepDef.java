package assignment.StepDefs;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import assignment.core.WebDriverFactory;
import assignment.pageobjects.CmnPageObjects;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDef {
	
	private static final Logger log = LogManager.getLogger(StepDef.class);

	WebDriver driver;
    String base_url = "http://automationpractice.com";
    int implicit_wait_timeout_in_sec = 20;
    WebDriverWait webDriverWait;
    JavascriptExecutor js;
    Scenario scn;
    CmnPageObjects cmnPageObject;
    
    @Before
    public void setUp(Scenario scn) throws Exception{
    	this.scn = scn;
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
//        
//        driver.get(base_url);
        
        String browserName = WebDriverFactory.getBrowserName();
        driver = WebDriverFactory.getWebDriverForBrowser(browserName);
        log.info("Browser invoked.");
        
        cmnPageObject = new CmnPageObjects(driver, scn);
    }

    @After
    public void cleanUp(){
        driver.quit();
    }
    
    @Given("user open browser and nevigate to home application url")
    public void user_open_browser_and_nevigate_to_home_application_url() {
//    	driver = new ChromeDriver();
//    	driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
//		driver.get(base_url);
    	WebDriverFactory.navigateToTheUrl(base_url);
        scn.log("Browser navigated to URL: " + base_url);
    }


	@When("open browser and redirected to the given url")
	public void open_browser_and_redirected_to_the_given_url() {
		WebDriverFactory.navigateToTheUrl(base_url);
		scn.log("Browser navigate to home URL = "+base_url);
		log.info("Browser navigate to home URL = "+base_url);
	}

	//FOR SCENARIO 1: URL REDIRECTION VALIDATION
	@Then("validation of url {string}")
	public void validation_of_url(String actualUrl) throws InterruptedException {
		cmnPageObject.validationOfUrl(actualUrl);
		
	}

	//FOR SCENARIO 2: LANDING PAGE TITLE VALIDATION
	@Then("validation of title {string}")
	public void validation_of_title(String actualTitle) {
		cmnPageObject.validationOfTitle(actualTitle);
	}
	
	//FOR SCENARIO 3 : PRODUCT CATEGORY VALIDATION TEST
	@When("check for product category")
	public void check_for_product_category() {
		cmnPageObject.checkroductCategory();
	}

	@Then("category is displayed on landing page list is")
	public void category_is_displayed_on_landing_page_list_is(List<String> listSize) {
	    cmnPageObject.categoryDisplayed(listSize);
	}
	
	@Then("size of product category is {int}")
	public void size_of_product_category_is(Integer count) {
		cmnPageObject.categorySizeValidation(count);
	}

    //FOR SCENARIO 4 : LOGO IS DISPLAYED
    @When("check the logo is display on landing page")
    public void check_the_logo_is_display_on_landing_page() {
    	    	
    }

    @Then("Display logo on landing page")
    public void Display_logo_on_landing_page() {
    	cmnPageObject.displayLogoValidation();
    }
    
    //FOR SCENARIO 5 : CHECK LOGO WIDTH
    @When("logo is display on landing page")
    public void logo_is_display_on_landing_page() {
        
    }

    @Then("the logo width should be {string}")
    public void the_logo_width_should_be(String width) {
     	cmnPageObject.validationLogoWidth(width);
    }
    
    //FOR SCENARIO 6 : CHECK LOGO HEIGHT
    @Then("the logo height should be {string}")
    public void the_logo_height_should_be(String height) {
       	cmnPageObject.validationLogoHeight(height);
    }
    
    //FOR SCENARIO 7 : SIGN IN PAGE TITLE VALIDATION
    @When("user click on signin button")
    public void user_click_on_signin_button() {
       	cmnPageObject.clickOnSignIn();
    }

    @Then("open next page and title for next page {string}")
    public void open_next_page_and_title_for_next_page(String pageTitle) {
       	WebDriverFactory.switchBrowserToTab();
		cmnPageObject.SignInPageTitleVlaidation(pageTitle);
    }
    
    //FOR SCENARIO 8 : DROPDOWN LIST MATCHING WITH SEARCH PRODUCT NAME
    @When("user search for product {string} in search box")
    public void user_search_for_product_in_search_box(String proName) {
       	cmnPageObject.sendSearchKey(proName);    	
    }

    @Then("dropdown list should appear")
    public void dropdown_list_should_appear() {
       	cmnPageObject.validationDropdownDisplay();
    }
    
    @Then("Count the number of product matching with {string} as {int}")
    public void count_the_number_of_product_matching_with_as(String proName, Integer proCount) {
    	cmnPageObject.matchSearchProductCount(proName, proCount);    	
    }
   
    //FOR SCENARIO 9 : TWITTER SOCIAL MEDIA HANDLE
    @When("user click on twitter link from bottom of page")
    public void user_click_on_twitter_link_from_bottom_of_page() {
      	cmnPageObject.clickOnTwitter();    	
    }

    @Then("validate the twitter account name {string}")
    public void validate_the_twitter_account_name(String accName) {
    	WebDriverFactory.switchBrowserToTab();
		cmnPageObject.validationTwitAcc(accName);
    }    
    
   //FOR SCENARIO 10 : NEWS LETTER SUBSCRIPTION
    @When("send random user id in subscription textbox")
    public void send_random_user_id_in_subscription_textbox() {
    	cmnPageObject.sendUserId();       
    }

    @When("click on {string} button")
    public void click_on_button(String string) {
       	cmnPageObject.clickProc();
    }
    
    @Then("User get the {string} massage")
    public void User_get_the_massage(String ExpMsg) {
    	cmnPageObject.validationMessage(ExpMsg);
    }   
}
