# Kotlin_Mobile_Test_Framework
This Framework for mobile testing using android and ios real devices.
I used:
1. Kotlin - programming language I want to learn
2. Maven - because I hate gradle, but one day I'll try to use gradle
3. Selenide - I think it is the best library with good implicit/explicit waits and understandable assertions
4. Guice - the library for quick page initialization (more beautiful than create page object in every test or do it by reflection)
5. Allure - for creating test execution reports that are clear to everyone in the team
6. TestNG - because Junit needs static methods for BeforeClass/AfterClass annotations and TestNG not (Kotlin does not have static)
7. Appium - driver for mobile testing

# How to execute tests:
Run in terminal(mac os)
1. appium start: appium --allow-insecure=get_server_logs - we need it for log generation
2. execute all tests: mvn clean test  
3. generate allure report: mvn allure:serve
4. execute 1 test - just to press the debug button near some test 

# Useful links:
1. About Kotlin: https://kotlinlang.org/
2. How to set up Allure: https://habr.com/ru/company/sberbank/blog/358836/
3. Guice: https://github.com/google/guice/wiki/GettingStarted
4. Selenide: https://selenide.org/
