📌 Project Overview
This is a robust TestNG-based automation framework built for web UI testing using Selenium WebDriver. It supports features like:

Cross-browser testing

Parallel test execution

Logging and reporting (Allure & ExtentReports)

Config-driven test control

CI/CD integration (Azure, GitHub Actions, Docker)

🗂 Folder Structure
bash
Copy
Edit
src
│
├── main
│
├── test
│   ├── java
│   │   ├── baseClass           # Base setup class for browser, logs, config
│   │   ├── constants           # Constants used across the framework
│   │   ├── driverManager       # WebDriver initialization logic
│   │   ├── helper              # Utility methods (clicks, waits, etc.)
│   │   ├── listener            # TestNG listeners (for Extent/Allure reporting)
│   │   ├── pages               # Page Object Model classes
│   │   ├── testCases           # Actual TestNG test cases
│   │   └── utils               # Common reusable utilities
│   │
│   └── resources
│       ├── Config.properties   # Stores environment configs like URL
│       ├── extent.properties   # Extent report config
│       └── log4j2.xml          # Logging configuration
│
├── allure-report/             # Generated Allure report folder
├── allure-results/            # Allure raw results
├── log/                       # Log file output directory
├── target/                    # Compiled test classes and build output
├── test-output/               # TestNG default output
⚙️ Configuration
Config.properties
Contains environment-level properties like:

baseUrl
testng.xml
Test Suite configuration file

Includes:

Suite/Class definitions

<parameter> tags for username, password, browser

Other TestNG XMLs
testng_crossBrowser.xml – For running tests across different browsers

testng_Parallel.xml – For executing tests in parallel

testng_regression.xml – For regression suite execution

🚀 Running Tests
1. Using Command Line
mvn clean test -DsuiteXmlFile=testng.xml
2. Using IntelliJ/Eclipse
Right-click on testng.xml or any test class and run as TestNG Test

3. With Parameters
Edit in testng.xml:
<parameter name="browser" value="chrome" />
<parameter name="username" value="standard_user" />
<parameter name="password" value="secret_sauce" />
🧪 Test Execution Reports
✅ Allure Report
allure generate --clean
allure open allure-report

🧩 CI/CD Support
Available YAMLs:
azure-pipelines.yml – For Azure DevOps integration

github-actions.yml – For GitHub Actions CI

docker-compose.yml – Docker setup if needed

📄 Dependencies
Selenium WebDriver

TestNG

WebDriverManager

ExtentReports

Allure

Log4j2

Check pom.xml for full dependency list.

🙋‍♂️ Author
Ayyappan Gunasekaran
Automation Test Engineer

