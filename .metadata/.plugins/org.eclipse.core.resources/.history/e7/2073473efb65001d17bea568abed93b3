Feature: Login Functionality
  
Scenario: Successful login with valid credentials
    Given User launch chrome browser
    When User navigate to URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F "
    Then User enters email as "admin@yourstore.com" and password as "admin"
    And  User click on login 
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on logout link
    Then Page title should be "Your store. Login"
    And  Close browser  

    
Scenario Outline: Login Data Driven
    Given User launch chrome browser
    When User navigate to URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F "
    Then User enters email as "<email>" and password as "<password>"
    And  User click on login 
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on logout link
    Then Page title should be "Your store. Login"
    And  Close browser  
    
    Examples: 
         | email | password |
         | admin@yourstore.com | admin |
         | admin@yourstore.com | 1234 |
    
    