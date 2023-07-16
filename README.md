

**Steps to Run the automation -**
1.	Git clone - https://github.com/goyalvipul/spring_financial_assignement
3.	cd spring_financial_assignement
4.	mvn install – This will install all the packages if not done already.
5.	mvn test - The above command will also run all the tests. But if you want to rerun, use this command.


**Automation Framework details:**
1. 	Framework Used:
    0	Contact Us page being a form,the  **“Data Drive framework”** fits best to this.
   	0 **Data Providers** are used to feed Test Data to the tests and spearhead the execution.
2.	Build Tool: **Maven**
3.	Testing Framework: **TestNG**
4.	Reporting Tools:
    0	**TestNG** – for basic test reports
    0	**Surefire Plugin** – Used the Surefire plugin to generate an emailable report. This can be extended a lot in capabilities. 
5.	Design Patterns Used:
    0	Page Object Model
