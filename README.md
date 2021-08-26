# fita-automation-test

## Installation
1. Must enable appium server please find about how to install and setup [appium](https://appium.io/).
2. Must install [allure](http://allure.qatools.ru/) for test report.
3. Must have install [JDK](https://docs.oracle.com/javase/9/install/installation-jdk-and-jre-macos.htm#JSJIG-GUID-0071963E-D247-4D15-BF49-AD19C7260740).
4. Install IntellijIDEA or any other IDE
5. Install emulator or use cloud automation testing to run
6. Install Android SDK

## How To Run
1. If you use IDE IntellijIDEA please go to test/java/tests/runner.java and run the test case by click the green play button
2. Also you need to select in test/java/tests/TestSetup.java whether you want to use localURL or CloudURL
3. If you use localURL please open your emulator or real device and if you use :
    - emulator : 
      - find emulator name by typing "adb devices" on terminal
      - change name of emulator device in udid on config.properties files
    - real device :
      - please enable usb debugging first before process
      - find emulator name by typing "adb devices" on terminal
      - change name of emulator device in udid on config.properties files

4. After run please type allure serve allure-result to generate the test report
5. If you use CloudURL please signup for browserstack and login
6. Go to app automate and follow the instructions, you only need to change browserstact.user and browserstack.key in main/java/operation/BaseTest.java otherwise if you change the device type you can change it by following the browserstack app automate instruction
7. Go to test/java/tests/runner.java and run the test case by click the green play button
8. After run please type allure serve allure-result to generate the test report
