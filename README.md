# CIBAutomationAssessment
Web and API automation assessment in Java, Selenium and Rest Assured

## Java Selenium Cucumber Rest Assured Project

This project is a comprehensive testing framework that combines Selenium WebDriver, Cucumber, and Rest Assured to perform automated web and API testing. The project features two separate Cucumber test runner classes for web tests and API tests, enabling a smooth and organized execution of different types of tests.

## Table of Contents

1. [Project Overview](#project-overview)
2. [Prerequisites](#prerequisites)
3. [Installation and Setup](#installation-and-setup)
4. [Running Tests](#running-tests)
5. [Test Reports](#test-reports)

## Project Overview

This project is structured to efficiently manage and execute web and API tests. The following key components are included in the project:

- Selenium WebDriver: A browser automation framework for performing web tests.
- Cucumber: A BDD (Behavior-Driven Development) framework that uses Gherkin language to write test scenarios.
- Rest Assured: A Java library for testing and validating RESTful APIs.


## Prerequisites

To run this project, you need the following software and tools installed on your machine:

1. Java JDK 11 or higher
2. Apache Maven 3.6.0 or higher
3. Chrome browser (latest version recommended)
4. ChromeDriver (compatible with the installed Chrome browser version)
5. Git (optional)

## Installation and Setup

1. Clone the repository using the following command:

2. Open the project in your IDE preferrably IntelliJ.

3. Navigate to the project directory in the terminal and run the following command to download and install the required dependencies:
mvn clean install

## Running Tests

To run the tests, you can use the following Maven commands:

1. For web tests: 
run CucumberTestRunnerWeb class or
mvn test -Dtest=CucumberTestRunnerWeb
2. For API tests:
run CucumberTestRunnerApi class or
mvn test -Dtest=CucumberTestRunnerApi

## Test Reports

After the test execution, Cucumber generates HTML reports for both web and API tests. You can find the reports in the following directories:
target/cucumber-reports

