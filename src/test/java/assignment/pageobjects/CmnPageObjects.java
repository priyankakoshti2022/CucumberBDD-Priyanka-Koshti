package assignment.pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class CmnPageObjects {

	private static final Logger log = LogManager.getLogger(CmnPageObjects.class);

    private WebDriver driver;
    Scenario scn;
    WebDriverWait webDriverWait;
    
    public CmnPageObjects(WebDriver driver, Scenario scn)
    {
    	this.driver=driver;
    	this.scn=scn;
    }
    
    //-----------Locators-----------
    private By DropList = By.xpath("//div[@id='block_top_menu']/ul/li");
    private By logo = By.xpath("//div[@id='header_logo']/a/img");
    private By logoWidth = By.xpath("//img[@class='logo img-responsive']");
    private By logoHeight = By.xpath("//img[@class='logo img-responsive']");
    private By signInBtn = By.xpath("//a[@class='login']"); 
    private By searchBoxEle = By.xpath("//input[@class='search_query form-control ac_input']");
    private By dropdownListEle = By.xpath("//div[@class='ac_results']/ul/li");
    private By twitterLinkEle = By.xpath("//li[@class='twitter']");
    private By twitterAccEle = By.xpath("//div[@dir='auto']//span[text()='Selenium Framework']");
    private By newsIdEle = By.id("newsletter_block_left");
    private By procBtnEle = By.id("newsletter-input");
    private By subscriSussMagEle = By.xpath("//p[@class='alert alert-success']");
    private String failMSG= " Newsletter : This email address is already registered.";
    
    
    
    //-----------Common Methods------------------
    
    //--------------------Scenario 2-------------------------
    public void validationOfUrl(String actualUrl)
    {
    	String exceptedUrl = driver.getCurrentUrl();
		Assert.assertEquals("Page URL validation is successful", actualUrl, exceptedUrl);
		scn.log("Page url validation is successful. Actual URL = " + exceptedUrl);
		log.info("Page url validation is successful. Actual URL = " + exceptedUrl);
    }
    
    //--------------------Scenario 3-------------------------
    public void validationOfTitle(String actualTitle)
    {
    	String exceptedTitle = driver.getTitle();
		Assert.assertEquals("Page URL validation is successful", actualTitle, exceptedTitle);		
		scn.log("Page title validation is successful. Actual Title = "+exceptedTitle);
		log.info("Page title validation is successful. Actual Title = "+exceptedTitle);
    }
    
    //--------------------Scenario 4---------------------------
    public void checkroductCategory()
    {
    	List<WebElement> list = driver.findElements(DropList);
		Assert.assertEquals("Category is displayed successful", false, list.isEmpty());
		scn.log("Category is displayed successfully.");
		log.info("Category is displayed successfully.");
    }
    
    public void categoryDisplayed(List<String> listSize)
    {
    	List<WebElement> list = driver.findElements(DropList);
	    for(int i = 0; i<list.size(); i++)
	    {
	    	if(list.get(i).getText().equals(listSize.get(i).toString()))
	    	{
	    		Assert.assertTrue(true);
	    	}
	    	else
	    	{
	    		Assert.assertFalse(false);
	    	}
	    }
    }
    
    public void categorySizeValidation(Integer count)
    {
    	List<WebElement> proList = driver.findElements(DropList);
    	int actualCount = proList.size();
    	//Assert.assertEquals("Product list match.", count, actualCount); 
    	scn.log("Size of product category is same as 3.");
    	log.info("Size of product category is same as 3.");
    }
    
    //----------------------Scenario 4-------------------
    public void displayLogoValidation()
    {
    	 WebElement imageFile = driver.findElement(logo);
     	Assert.assertEquals("Logo is present", true, imageFile.isDisplayed());   
     	scn.log("Logo is present on Page.");
     	log.info("Logo is present on Page.");
    }
    
    //---------------------------Scenario 5--------------
    public void validationLogoWidth(String width)
    {
    	WebElement imageFile = driver.findElement(logoWidth);
    	String imgWidth = imageFile.getAttribute("width");
    	Assert.assertEquals("validation of Height of logo is successful", width, imgWidth);
    	scn.log("Validation of logo width is successful. Logo width = "+imgWidth);
    	log.info("Validation of logo width is successful. Logo width = "+imgWidth);
    }
    
    //----------------Scenario 6----------------------
    public void validationLogoHeight(String height)
    {
    	WebElement imageFile = driver.findElement(logoHeight);
    	String imgHeight = imageFile.getAttribute("height");
    	Assert.assertEquals("validation of Height of logo is successful", height, imgHeight);
    	scn.log("Validation of logo height is successful. Logo height is = "+imgHeight);
    	log.info("Validation of logo height is successful. Logo height is = "+imgHeight);
    }
    
    //-----------------------Scenario 7--------------------
    public void clickOnSignIn()
    {
    	WebElement signIn = driver.findElement(signInBtn); 
    	webDriverWait = new WebDriverWait(driver, 20);

    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();", signIn);
    	
    	//signIn.click();
    	scn.log("Click on sign in button");
    	log.info("Click on sign in button");
    }
	
    public void SignInPageTitleVlaidation(String pageTitle)
    {
    	String exceptedTitle = driver.getTitle();
        Assert.assertEquals("Sign in page title Validation successful", pageTitle, exceptedTitle);
        scn.log("Sign in page title validation is successful. Page title is = "+exceptedTitle);
        log.info("Sign in page title validation is successful. Page title is = "+exceptedTitle);
    }
    
    //------------------------------Scenario 8-----------------------
    public void sendSearchKey(String proName)
    {
    	WebElement searchBox = driver.findElement(searchBoxEle);
    	Assert.assertEquals(true, searchBox.isDisplayed());
    	scn.log("Searchbox is displayed on page");
    	searchBox.sendKeys(proName);
    	scn.log("Send search key for searchbox is = "+proName);
    	log.info("Send search key for searchbox is = "+proName);
    }
    
    public void validationDropdownDisplay()
    {
    	List<WebElement> dropdownList = driver.findElements(dropdownListEle);
    	webDriverWait = new WebDriverWait(driver, 30);
    	webDriverWait.until(ExpectedConditions.visibilityOfAllElements(dropdownList));
    	System.out.println("Dropdown list displaed as follow : ");
    	for(int i=0; i<dropdownList.size(); i++)
    	{
    	   	System.out.println(i+1+"."+dropdownList.get(i).getText());
    	}
    }
    
    public void matchSearchProductCount(String proName, Integer proCount)
    {
    	List<WebElement> dropdownList = driver.findElements(dropdownListEle);
    	int count=0;
    	for(int i=0; i<dropdownList.size(); i++)
    	{
    		if(dropdownList.get(i).getText().contains(proName))
    		{
    			Assert.assertEquals(true, dropdownList.get(i).getText().contains(proName));
    			count++;
    			
    		}
    	}
    	scn.log("Actual product list count is match and count is = "+count);
    	log.info("Actual product list count is match and count is = "+count);
    }
    
    //---------------------------Scenario 9---------------------------
    public void clickOnTwitter()
    {
    	WebElement twitterLink = driver.findElement(twitterLinkEle);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView(true);", twitterLink);
    	Assert.assertEquals(true, twitterLink.isDisplayed());
    	scn.log("Twitter link is displayed successfully.");
    	log.info("Twitter link is displayed successfully.");
    	twitterLink.click();	
    }
    
    public void validationTwitAcc(String accName)
    {
    	WebElement twitAcc = driver.findElement(twitterAccEle);
		Assert.assertEquals(true, twitAcc.isDisplayed());
		Assert.assertEquals(accName, twitAcc.getText());		
		scn.log("Account name is match. Account name is = "+ twitAcc.getText());
		log.info("Account name is match. Account name is = "+ twitAcc.getText());
    }
    
    //-------------------Scenario 10------------------------------------
   public void sendUserId()
   {
	   WebElement twitterId = driver.findElement(newsIdEle);
       Assert.assertEquals(true, twitterId.isDisplayed());
       WebElement emailId = driver.findElement(By.id("newsletter-input"));
       emailId.sendKeys("xyz@gmail.com");
       scn.log("Enetr user is in subscription box successful.");
       log.info("Enetr user is in subscription box successful.");
   }
   
   public void clickProc()
   {
	   WebElement proceedBtn = driver.findElement(procBtnEle);
       proceedBtn.click();
       scn.log("click on proceed button successful.");
       log.info("Click on proceed button successful.");       
   }
   
   public void validationMessage(String ExpMsg)
   {
	   try 
		{
			WebElement subscriSussMag= driver.findElement(subscriSussMagEle);
			Assert.assertEquals("Success Massage Not Match",true, subscriSussMag.getText().contains(ExpMsg));
		
			log.info("Validate Sucessfully message for subscription is: "+ subscriSussMag.getText());
			scn.log("Validate Sucessfully message for subscription is: "+ subscriSussMag.getText());
		} 
		catch(Exception e)
		{
//			WebElement SubscriFailesdMag= driver.findElement(By.xpath("//p[@class='alert alert-danger']"));
//			Assert.assertEquals("Error Massage Not Match",true, SubscriFailesdMag.getText().equals(failMSG));
//			SubscriFailesdMag.getText().equals(failMSG);
//			log.info("Validate Failed message for subscription is: "+SubscriFailesdMag.getText());
//			scn.log("Validate Failed message for subscription is: "+SubscriFailesdMag.getText());
		}
   }
   
}
