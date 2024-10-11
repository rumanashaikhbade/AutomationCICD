@tag
Feature:Purchase the order from Ecommerce Website
 I want to use this template for my feature file

Background:
Given I landed on Ecommerce page

@Regression
Scenario Outline:Positive test of submitting the order
Given Logged in with username <name> and pwd <password>
When I add product <productName> from cart
And CheckOut <productName> and submit the order
Then "THANKYOU FOR THE ORDER." msg is displayed 

Examples:
|name				 | password	|  productName |
|rumanas@gmail.com   | Abc@1234	|  ZARA COAT 3  |
