package com.eder.pruebaColfondos.PagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrincipalGoogle {
	private WebDriver webDriver;
	
	public PrincipalGoogle(WebDriver webDriver) {
		setWebDriver(webDriver);
		PageFactory.initElements(webDriver, this);
	}	
	
	public WebDriver getWebDriver() {
		return webDriver;
	}

	public void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	@FindBy(name = "q")
	private WebElement cajaTexto;
	
	
	public void ingresarValorEnCajaTexto(String valor) {
		cajaTexto.sendKeys(valor);
	}
	
	public void enviarCajaTexto() {
		cajaTexto.submit();
	}
}
