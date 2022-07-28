@ui @assignment
Feature: Assignment for sample site

Background:
Given user open browser and nevigate to home application url

  @Validation_Of_URL
  Scenario: url redirection test
  When open browser and redirected to the given url
  Then validation of url "http://automationpractice.com/index.php"

  @Validation_Of_Title
  Scenario: Landing page title validaation
  When open browser and redirected to the given url
  Then validation of title "My Store"

   @Validation_Of_Product_Category
   Scenario: Product category validation test
   When check for product category  
   Then category is displayed on landing page list is
   |WOMEN   |
   |DRESS   |
   |T-SHIRTS|
   And size of product category is 3 
      
   @Validation_Logo
   Scenario: Landing page application logo validation
   When check the logo is display on landing page
   Then Display logo on landing page
   
   @Validation_Of_Logo_Width
   Scenario: validation of application logo width
   When logo is display on landing page
   Then the logo width should be "350"
   
   @Validation_Of_Logo_Height
   Scenario: validation of application logo height
   When logo is display on landing page
   Then the logo height should be "99"
   
   @validation_Of_SignIn
   Scenario: sigin page title validation
   When user click on signin button
   Then open next page and title for next page "My Store"
   
   @validation_Of_DropdownList
   Scenario: Search by keywords and display dropdown list with matching search
   When user search for product "Dress" in search box
   Then dropdown list should appear 
   And Count the number of product matching with "Dress" as 3 
   
   @Validation_Of_Twitter
   Scenario: validate twitter socilal media handle
   When user click on twitter link from bottom of page
   Then validate the twitter account name "Selenium Framework"
   
   @validation_Of_NewsLetter
   Scenario: Newsletter subscription
   When send random user id in subscription textbox 
   And click on "proceed" button
   Then User get the "successfully subscribed" massage
   
   