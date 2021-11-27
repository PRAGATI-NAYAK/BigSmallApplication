package com.mindtree.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/mindtree/features/", glue = "com/mindtree/stepdefinitions/")
public class testrunnerCucumber extends AbstractTestNGCucumberTests {

}
