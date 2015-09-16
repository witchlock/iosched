Google IO App UI Tests
---
#Set Up
- Please follow the instruction of root project to set up your environment locally
- Turn on "Developer Mode" on your Android device
- Connect your Google Account on the device
- Connect your Android device via USB to the PC(MAC)

#Test folder
- `src/androidTest/`
	- `po` - application screen objects
	- `runner` - uiautomator tests
- `test_specs.md`
	notes of test scenarios
- `README.md`
    General introduction of using this project

#Run tests

	Gradle Command
	- `./gradlew cC`

	Android Studio
	- Right click and run "SessionListUiTest.java"

	ADB Command