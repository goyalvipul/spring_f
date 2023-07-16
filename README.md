

**Steps to Run the automation -**
1.	Git clone - https://github.com/goyalvipul/spring_financial_assignement
3.	cd spring_financial_assignement
4.	mvn install – This will install all the packages if not done already.
5.	mvn test - The above command will also run all the tests. But if you want to rerun, use this command.


**Automation Framework details:**

|---------------------------------------------------------------------------------------------------------------------------|
|  Framework Used      |  a. Contact US page being a form, Used Data Driven Framework which drives the exucution using Data |
|                      |  b. Data Providers are used to feed in Test Data to the tests.                                     |
|---------------------------------------------------------------------------------------------------------------------------|
|  Build Tools Used    |  Maven                                                                                             |

1. 	Framework Used:
   a. Contact Us page being a form,the  **“Data Drive framework”** fits best to this.
   b. **Data Providers** are used to feed Test Data to the tests and spearhead the execution.
3.	Build Tool:  Maven
5.	Testing Framework:  TestNG
7.	Reporting Tools:
   0	**TestNG** – for basic test reports
   0	**Surefire Plugin** – Used the Surefire plugin to generate an emailable report. This can be extended a lot in capabilities. 
9.	Design Patterns Used:
   0	Page Object Model
