package com.eder.pruebaColfondos.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
/**
 * 
 * @author Eder Carbonero 
 *
 */
public class Driver {
	private WebDriver webDriver;
	private String pathDriver;

	public Driver() {
		
	}

	public boolean inicializarDriver(String navegador) {
		boolean retorno = false;
		pathDriver = System.getProperty("user.dir") + "//drivers//chromedriver.exe";
		navegador = navegador.toLowerCase();
		if (navegador.contains("google")) {
			navegador = "google";
		}
		if (navegador.contains("explore")) {
			navegador = "explore";
		}
		switch (navegador) {
		case "google":
			System.setProperty("webdriver.chrome.driver", pathDriver);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			webDriver = new ChromeDriver( options );
			retorno = true;
			break;
		case "explore":

			break;

		default:
			break;
		}

		return retorno;
	}
	
	public void establecerPagina(String url) {
		webDriver.get(url);
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public String getPathDriver() {
		return pathDriver;
	}

	public void setPathDriver(String pathDriver) {
		this.pathDriver = pathDriver;
	}

	public boolean cerrarDriver() {
		try {
			webDriver.close();
			webDriver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
