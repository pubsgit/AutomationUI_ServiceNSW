# AutomationUI_ServiceNSW
Introduction:
This Automation Project is to Check if a Particular Service Center Location is present based on Suburb provided.

This Project Test case covers the below test Steps:

1. Navigate to https://www.service.nsw.gov.au/
2. Search for"Apply for a number plate"
   Validate the navigation to appropriate page
3. Clickon Locate us button
4. Enter suburb"Sydney 2000" -> Modify this in Data Properties files for a different suburb. 
5. It shoulduse service centre namedas "Marrickville Service Centre"  -> Mention center name for Suburn in Step 4
 
Ex: Like “Sydney Domestic Airport 2020” and it should be having “Rockdale Service Centre”.

This Project is Complete Maven Suite with all the required binaries and drivers packed into so no need to download any files or binaries.

All the path settings have been taken care of.
Page Object are used to modify elements in their respective pages.
You can choose to run Automation tests against  
    local browsers [ Chrome or Firefox or IE Edge ]
    selenium grid  [Provide the IP address of HUB ] 
    headless [Headless Chrome browser]
All the Test Data required is in the /src/main/java/resources.
Maven .pom files has all the required dependies that would be downloaded( from mvn repository) once the project is opened in Eclipse.


Pre-requiste:
JAVA Should be installed and JAVA_HOME path should be set.
Eclipse should be Installed in system.


How to run the Suite:
1)  Clone the repository to your desktop:
    
    git clone https://github.com/pubsgit/AutomationUI_ServiceNSW.git
    
    This would results in pulling all the files needed to required to run the tests
    
2)  Opne the folder in Eclipse:
    
    You can trigget the tests using the below methods.
    
    TestNG Suite:   
    testng.xml -> Right Click -> Run As -> TestNG Suite
    
    TestNG test:    
    /src/test/java/revolutionit/NswLocationSearch.java    -> right click - > Run As -> TestNG test.
    
Finally Enjoy!
    
    
