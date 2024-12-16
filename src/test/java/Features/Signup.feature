Feature: signup into LOMO

Scenario Outline: Signup into LOMO web application with valid data
  Given user launches browser and provide url
  When user enter valid "<firstname>" and "<lastname>" and email and "<password>"
  And user confirms "<cpassword>"
  And user click on creat and user button
  Then user logs in with same credentials
  
  
Examples:
|firstname|lastname|password|cpassword|
|LK|LK|Pravin@28|Pravin@28|

