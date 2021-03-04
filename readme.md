API Compare Utility

Compare utility that compare the response of two requests from two files, then print if requests are equal / not equal.

Two files under file/ directory as file1.txt and file.txt contains the API's list. Currently it holds 12 requests which can be increased as required.

Utility can be used in below ways :

- Accessing APICompareUtility.java under src/test/java/com/dk/comparator/ 
  This is a java class and can simply run as java application to get the output.It takes 
  API's list from two files as input, compare response and then display results.


- Accessing APICompareUtilityTest.java under src/test/java/com/dk/comparator/
  This is a testng test class implemented to run the utility in parallel. It
  Takes 2 files as an input from TestData.java as a dataProvider class and then run
  Comparison in parallel using testng. The utility can be run in below ways :
  
   1 - Directly running the APICompareUtilityTest.java as an Testng Test
   
   2 - MVN run from pom.xml file
   
   3 - testng.xml run as an testng test

Test Utility is build over RestAssured,TestNG,JAVA,Maven 
