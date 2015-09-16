Google IO App UI Tests
---
#Set Up
- Please follow the instruction of root project to set up your environment locally
- Turn on "Developer Mode" on your Android device
- Connect your Google Account on the device
- Connect your Android device via USB to the PC(MAC)

#Test folder
- `src/androidTest/`
	- `com.google.samples.apps.iosched.po` - application screen objects
	- `SessionListUitTest.java` - uiautomator test
- `test_specs.md`
	notes of test scenarios
- `README.md`
    General introduction of using this project

#Run tests

	Gradle Command
	- `cd $PROJECT_DIR/android`
	- `./gradlew cC` or `gradle cC`

	Android Studio
	- Right click and run "SessionListUiTest.java"

	ADB Command