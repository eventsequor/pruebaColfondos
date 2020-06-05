package com.eder.pruebaColfondos;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;





@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, plugin = { "pretty",
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, 
tags = "@CasoBDD", features = "Features", glue = {
				"com.eder.pruebaColfondos.StepDefinitions" })

public class AppTest {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\extensión-config.xml"));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", System.getProperty("os.name"));
		Reporter.setSystemInfo("Selenium", "3.141.59");
		Reporter.setSystemInfo("Maven", "3.6.3");
		Reporter.setSystemInfo("Java Version", "1.8.0_151");
		Reporter.setSystemInfo("Autor", "Eder Carbonero");
		Reporter.assignAuthor("Eder Leandro Carbonero Baquero");
	}

	public static String getReportConfigPath() {
		Properties properties = new Properties();
		String rutaLocal = System.getProperty("user.dir");
		String rutaPropiedadesObjetos = rutaLocal + "/pruebaColfondos/src/test/resources/Configuration.properties";
		InputStream is = null;
		try {
			File file = new File(rutaPropiedadesObjetos);
			if (file.exists()) {
				is = new FileInputStream(rutaPropiedadesObjetos);
				properties.load(is);
				String reportConfigPath = properties.getProperty("reportConfigPath");
				if (reportConfigPath != null)
					return reportConfigPath;
				else
					throw new RuntimeException("No ha especificado la ruta");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;

	}

}
