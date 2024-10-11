@tag
Feature:Error Validations
 I want to use this template for my feature file

Background:
Given I landed on Ecommerce page

@ErrorValidation
Scenario Outline:Positive test of submitting the order
Given I landed on Ecommerce page
When Logged in with username <name> and pwd <password>
Then "Incorrect email  or password." Incorrect msg is displayed 

Examples:
|name				 | password	|  productName |
|rumanas@gmail.com   | Abc@123	|  ZARA COAT 3  |
