package com.eder.pruebaColfondos.testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = "Features", glue = { "com.eder.pruebaColfondos.StepDefinitions" })

public class testrunner {
}