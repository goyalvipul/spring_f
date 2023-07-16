

<b>Steps to Run the automation – </b><br><br>
1.	Git clone - https://github.com/goyalvipul/spring_financial_assignement<br>
2.	cd spring_financial_assignement<br>
3.	mvn install – This will install all the packages if not done already.<br>
4.	mvn test - The above command will also run all the tests. But if you want to rerun, use this command.<br>


<br><br><br>

<b>Automation Framework details:</b>
<br><br>
•	Framework Used:<br>
o	Contact Us page being a form, “Data Drive framework” fits best to this. So used Data Providers to feed Test Data to the tests and spearhead the execution.<br>
•	Build Tool: Maven<br>
•	Testing Framework: TestNG<br>
•	Reporting Tools: <br>
o	TestNG – for basic test reports<br>
o	Surefire Plugin – Used the Surefire plugin to generate an emailable report. This can be extended a lot in capabilities. <br>
•	Design Patterns Used:<br>
o	Page Object Model<br>
